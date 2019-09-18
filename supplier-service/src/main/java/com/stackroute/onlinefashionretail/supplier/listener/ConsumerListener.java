package com.stackroute.onlinefashionretail.supplier.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.onlinefashionretail.supplier.domain.User;
import com.stackroute.onlinefashionretail.supplier.repository.SupplierRepository;
import com.stackroute.onlinefashionretail.supplier.domain.Mapping;
import com.stackroute.onlinefashionretail.supplier.domain.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConsumerListener {

   Supplier supplier=new Supplier();

  @Autowired
  SupplierRepository supplierRepository;

  @KafkaListener(topics = "Kafka_Example", groupId = "supplier")
  public void consumeSupplier(String user) throws IOException {
    System.out.println(user);
    System.out.println("inside consumer");
    User user1 = new ObjectMapper().readValue(user, User.class);
    if(user1.getDesignation().equalsIgnoreCase("Supplier")) {
      System.out.println("consumed data is " + user);
      Supplier designerobject = new ObjectMapper().readValue(user, Supplier.class);

      supplierRepository.save(designerobject);
    }
  }

}
