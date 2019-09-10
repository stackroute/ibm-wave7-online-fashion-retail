package com.stackroute.neo4j.listener;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.stackroute.neo4j.entity.Manufacturer;
import com.stackroute.neo4j.repository.DesignerRepository;
import com.stackroute.neo4j.repository.ManufacturerRepository;
import com.stackroute.neo4j.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class Consumer {

    @Autowired
    ManufacturerRepository manufacturerRepository;
    @Autowired
    DesignerRepository designerRepository;
    @Autowired
    SupplierRepository supplierRepository;

    @KafkaListener(topics="Kafka_Example",groupId = "group_id")
    public void consumeDonor(String user) throws IOException {
        Manufacturer obj=new ObjectMapper().readValue(user,Manufacturer.class);
        System.out.println(user);
        manufacturerRepository.save(obj);
    }
}
