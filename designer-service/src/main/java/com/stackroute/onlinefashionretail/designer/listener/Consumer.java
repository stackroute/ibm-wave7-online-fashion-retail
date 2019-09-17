package com.stackroute.onlinefashionretail.designer.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.onlinefashionretail.designer.model.Designer;
import com.stackroute.onlinefashionretail.designer.model.User;
import com.stackroute.onlinefashionretail.designer.repository.DesignerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class Consumer {
    @Autowired
    DesignerRepository designerRepository;


    @KafkaListener(topics = "Kafka_Example", groupId = "designer")
    public void consumeDesigner(String user) throws IOException {
        System.out.println("inside consumer");
      User user1 = new ObjectMapper().readValue(user, User.class);
          if(user1.getDesignation().equals("Designer")) {
               System.out.println("consumed data is " + user);
            Designer designerobject = new ObjectMapper().readValue(user, Designer.class);

            designerRepository.save(designerobject);
      }
    }
    }