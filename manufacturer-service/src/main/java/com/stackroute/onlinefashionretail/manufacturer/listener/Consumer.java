package com.stackroute.onlinefashionretail.manufacturer.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.onlinefashionretail.manufacturer.domain.Manufacturer;
import com.stackroute.onlinefashionretail.manufacturer.domain.User;
import com.stackroute.onlinefashionretail.manufacturer.repository.ManufactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

  @Service
  public class Consumer {
    @Autowired
    ManufactureRepository manufactureRepository;

    @KafkaListener(topics="Kafka_Example",groupId = "manufacturer")
    public void consumeManufacturer(String user) throws IOException {
      System.out.println("inside consumer");
      User user1 = new ObjectMapper().readValue(user, User.class);
      if(user1.getDesignation().equalsIgnoreCase("Manufacturer")) {
        System.out.println("consumed data is " + user);
        Manufacturer designerobject = new ObjectMapper().readValue(user, Manufacturer.class);

        manufactureRepository.save(designerobject);
      }

    }

  }
