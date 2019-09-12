package com.stackroute.user.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.user.domain.Mapping;
import com.stackroute.user.domain.Supplier;
import com.stackroute.user.repository.MappingRepository;
import com.stackroute.user.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConsumerListener {

   Supplier supplier=new Supplier();

  @Autowired
  MappingRepository mappingRepository;

  @KafkaListener(topics = "Login", groupId = "group_id")
  public void consumeDonor(String user) throws IOException {
    Mapping obj = new ObjectMapper().readValue(user, Mapping.class);
    System.out.println(user);
    mappingRepository.save(obj);
  }
}
