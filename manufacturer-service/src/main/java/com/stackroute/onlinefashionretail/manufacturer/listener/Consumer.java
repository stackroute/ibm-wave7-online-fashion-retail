package com.stackroute.onlinefashionretail.manufacturer.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.onlinefashionretail.manufacturer.domain.Manufacturer;
import com.stackroute.onlinefashionretail.manufacturer.repository.ManufactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

  @Service
  public class Consumer {
    @Autowired
    ManufactureRepository manufactureRepository;

    @KafkaListener(topics="Kafka_Example2",groupId = "group_id")
    public void consumeDonor(String user) throws IOException {
      Manufacturer obj=new ObjectMapper().readValue(user, Manufacturer.class);
      System.out.println(user);
      manufactureRepository.save(obj);

    }

  }
