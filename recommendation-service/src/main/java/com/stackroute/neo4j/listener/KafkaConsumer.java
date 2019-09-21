package com.stackroute.neo4j.listener;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.stackroute.neo4j.entity.Consumer;
import com.stackroute.neo4j.entity.ConsumerOrder;
import com.stackroute.neo4j.entity.Manufacturer;
import com.stackroute.neo4j.entity.Supplier;
import com.stackroute.neo4j.repository.ConsumerOrderRepository;
import com.stackroute.neo4j.repository.ConsumerRepository;
import com.stackroute.neo4j.repository.ManufacturerRepository;
import com.stackroute.neo4j.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class KafkaConsumer {

    @Autowired
    ManufacturerRepository manufacturerRepository;
    @Autowired
    ConsumerOrderRepository consumerRepository;
    @Autowired
    SupplierRepository supplierRepository;

    @KafkaListener(topics="recommendationManufacturer",groupId = "recommendmanufacturer")
    public void consumeManufacturer(String manufacturer) throws IOException {
        System.out.println(manufacturer);
        System.out.println(manufacturerRepository);
        Manufacturer manufacturer1=new ObjectMapper().readValue(manufacturer, Manufacturer.class);
        manufacturerRepository.save(manufacturer1);
    }
    @KafkaListener(topics="recommendationConsumer",groupId = "recommendconsumer")
    public void consumeConsumer(String consumer) throws IOException {
        System.out.println(consumer);
        System.out.println(manufacturerRepository);
        ConsumerOrder consumer1=new ObjectMapper().readValue(consumer, ConsumerOrder.class);
        consumerRepository.save(consumer1);
    }
    @KafkaListener(topics="recommendationSupplier",groupId = "recommendsupplier")
    public void consumeSupplier(String supplier) throws IOException {
        System.out.println(supplier);
        System.out.println(supplierRepository);
        Supplier supplier1=new ObjectMapper().readValue(supplier, Supplier.class);
        supplierRepository.save(supplier1);
    }
}
