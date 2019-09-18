package com.stackroute.onlinefashionretail.designer.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.onlinefashionretail.designer.model.Designer;
import com.stackroute.onlinefashionretail.designer.model.User;
import com.stackroute.onlinefashionretail.designer.model.DesignerOrder;
import com.stackroute.onlinefashionretail.designer.repository.DesignerRepository;
import com.stackroute.onlinefashionretail.designer.service.DesignerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {
    private final DesignerRepository designerRepository;

    private final DesignerService designerService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Consumer(DesignerRepository designerRepository, DesignerService designerService) {
        this.designerRepository = designerRepository;
        this.designerService = designerService;
    }

    @KafkaListener(topics = "Kafka_Example", groupId = "designer")
    public void consumeDesigner(String user) throws IOException {
        System.out.println("inside consumer");
        User user1 = new ObjectMapper().readValue(user, User.class);
        if (user1.getDesignation().equals("Designer")) {
            System.out.println("consumed data is " + user);
            Designer designerobject = new ObjectMapper().readValue(user, Designer.class);
            designerobject.setName(user1.getName());

            designerRepository.save(designerobject);
        }
    }

    @KafkaListener(topics = "ORDER_STATUS", groupId = "designer_order_status")
    public void consumeDesignerOrderStatus(String status) throws IOException {
        logger.info("got status on topic ORDER_STATUS: "+status);
        String[] data = status.split("-");
        logger.info("length of split data is: "+data.length);
        logger.info("split data is: "+data[0]+"   "+data[1]+"   "+data[2]);

        String designerId = data[0];
        String designerOrderId = data[1];
        String orderStatus = data[2];
        Designer designer = designerRepository.findById(designerId).orElse(null);
        logger.info("searched for designer by id: "+designerId+" got: "+designer);
        if (designer != null){
            for (DesignerOrder designerOrder:
                    designer.getOrderList()) {
                logger.info("searching for order with id: "+designerOrderId);
                if (designerOrder.getId().equals(designerOrderId)){
                    String currentStatus = designerOrder.getDesignOrder().getOrderStatus();
                    logger.info("found! current status is <"+currentStatus+">");
                    designerOrder.getDesignOrder().setOrderStatus(currentStatus+orderStatus);
                    logger.info("after changing status is <"+designerOrder.getDesignOrder().getOrderStatus()+">");
                    break;
                }
            }
            designerRepository.save(designer);
        }
    }
}
