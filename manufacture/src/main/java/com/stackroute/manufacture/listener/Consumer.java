//package com.stackroute.manufacture.listener;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.manufacture.domain.Manufacturer;
//import com.stackroute.manufacture.repository.ManufactureRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//
//  @Service
//  public class Consumer {
//    @Autowired
//    ManufactureRepository manufactureRepository;
//
//    @KafkaListener(topics="Kafka_Example",groupId = "group_id")
//    public void consumeDonor(String user) throws IOException {
//      Manufacturer obj=new ObjectMapper().readValue(user, Manufacturer.class);
//      System.out.println(user);
//      manufactureRepository.save(obj);
//
//    }
//
//  }
