package com.stackroute.onlinefashionretail.manufacturer.services;

import com.stackroute.onlinefashionretail.manufacturer.domain.BasePrice;
import com.stackroute.onlinefashionretail.manufacturer.domain.Manufacturer;
import com.stackroute.onlinefashionretail.manufacturer.domain.ManufacturerOrder;
import com.stackroute.onlinefashionretail.manufacturer.repository.ManufactureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManufactureServiceImpl implements ManufactureService {
    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    ManufactureRepository manufactureRepository;

    private final KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "ORDER_STATUS";

    @Autowired
    public ManufactureServiceImpl(ManufactureRepository manufactureRepository, KafkaTemplate<String, String> kafkaTemplate)
    {
        this.manufactureRepository = manufactureRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public Manufacturer saveManufacture(Manufacturer manufacturer) {
        Manufacturer savedManufacturer = manufactureRepository.save(manufacturer);
        return savedManufacturer;
    }

    @Override
    public Optional<Manufacturer> getManufacture(String id) {
        logger.info("inside getManufacturer in ManufactureServiceimpl");
        logger.info("find by id: "+manufactureRepository.findById(id).orElse(null));
        return manufactureRepository.findById(id);
    }

    @Override
    public List<Manufacturer> getAllManufactures() {
        logger.info("inside getAllManufacturer in ManufactureServiceimpl");
        return manufactureRepository.findAll();
    }

    @Override
    public boolean deleteManufacture(String id ){
        try {
            logger.info("inside deleteManufacturer try block in ManufactureServiceimpl");
            manufactureRepository.deleteById(id);
            return true;
        }
        catch (Exception exception)
        {
            logger.info("inside deleteManufacturer in ManufactureServiceimpl");
            return false;
        }
    }
    @Override
    public Manufacturer updateManufacture(Manufacturer manufacturer, String id)
    {
        logger.info("inside updateManufacturer in ManufactureServiceimpl");
        Optional<Manufacturer> user1 = manufactureRepository.findById(id);
        String name = user1.get().getName();
        String email=user1.get().getEmail();
        String specifications= user1.get().getSpecifications();

        manufacturer.setId(id);
        manufacturer.setName(name);
        manufacturer.setEmail(email);
        manufacturer.setCity(manufacturer.getCity());
        manufacturer.setSpecifications(specifications);
        manufacturer.setContact_number(manufacturer.getContact_number());
        Manufacturer savedManufacturer = manufactureRepository.save(manufacturer);
        return savedManufacturer;
    }

    @Override
    public ManufacturerOrder saveOrder(String id, ManufacturerOrder manufacturerOrder) throws Exception {
        System.out.println("in order repo save");
        Manufacturer save =manufactureRepository.findById(id).orElseThrow(() -> new Exception("null value no id"));
        if (save.getManufacturerOrders() == null)
            save.setManufacturerOrders(new ArrayList<>());
        save.getManufacturerOrders().add(manufacturerOrder);
        manufactureRepository.save(save);
        System.out.println("manufacturer order:"+manufacturerOrder);
        return manufacturerOrder;
    }
    @Override
    public List<ManufacturerOrder> getAllOrders(String id) {
        Manufacturer save =manufactureRepository.findById(id).orElse(null);
        System.out.println(save);
        System.out.println(save.getManufacturerOrders());
        return save.getManufacturerOrders();
    }
    @Override
    public boolean deleteOrder(String id) {
        try {
            manufactureRepository.deleteById(id);
            return true;
        }
        catch (Exception exception)
        {
            return false;
        }
    }
    @Override
    public ManufacturerOrder updateOrder(ManufacturerOrder manufacturerOrder, String id) {
        Manufacturer manufacturer = manufactureRepository.findById(id).orElse(null);
        ManufacturerOrder manufacturerOrder1 = null;
        for (ManufacturerOrder sup:
                manufacturer.getManufacturerOrders()) {
            if (sup.getId().equals(manufacturerOrder.getId()))
            {
                System.out.println("inside");
                sup.setOrderStatus(manufacturerOrder.getOrderStatus());
                manufactureRepository.save(manufacturer);
                manufacturerOrder1 =  sup;
            }
        }
        boolean inProgress = false;
        boolean rejected = false;
        for (ManufacturerOrder sup:
                manufacturer.getManufacturerOrders()) {
            if (sup.getTagId().equals(manufacturerOrder.getTagId()) && sup.getOrderStatus().equals("in-progress")){
                inProgress = true;
            }
            if (sup.getTagId().equals(manufacturerOrder.getTagId()) && sup.getOrderStatus().equals("rejected")){
                rejected = true;
            }
        }
        if (!inProgress && rejected){
            //send Kafka message to update order status to rejected
            kafkaTemplate.send(TOPIC,manufacturerOrder.getTagId()+"-manufacturer_rejected");
            logger.info("sending manufacturer_rejected message on TOPIC: "+TOPIC);
        }
        else if (!inProgress){
            //send Kafka message to update order status to accepted
            kafkaTemplate.send(TOPIC,manufacturerOrder.getTagId()+"-manufacturer_accepted");
            logger.info("sending manufacturer_accepted message on TOPIC: "+TOPIC);
        }
        boolean allCompleted = true;
        for (ManufacturerOrder sup : manufacturer.getManufacturerOrders()) {
            if (sup.getTagId().equals(manufacturerOrder.getTagId()) && !sup.getOrderStatus().equals("completed")){
                allCompleted = false;
            }
        }
        if (allCompleted && !(inProgress || rejected)){
            //send Kafka message to update order status to rejected
            kafkaTemplate.send(TOPIC,manufacturerOrder.getTagId()+"-manufacturer_completed");
            logger.info("sending manufacturer_completed message on TOPIC: "+TOPIC);
        }
        return manufacturerOrder1;
    }

    @Override
    public BasePrice saveBaseprice(BasePrice baseprice, String id) {
        Manufacturer manufacturer = manufactureRepository.findById(id).orElse(null);
        if (manufacturer == null)
            return null;
        if (manufacturer.getBasePrices() == null)
            manufacturer.setBasePrices(new ArrayList<>());
        manufacturer.getBasePrices().add(baseprice);
        manufactureRepository.save(manufacturer);
        return baseprice;
    }

    @Override
    public List<BasePrice> getAllBaseprice(String id) {
        Manufacturer manufacturer = manufactureRepository.findById(id).orElse(null);
        if (manufacturer == null)
            return null;
        if (manufacturer.getBasePrices() == null)
            manufacturer.setBasePrices(new ArrayList<>());
        return manufacturer.getBasePrices();
    }

}
