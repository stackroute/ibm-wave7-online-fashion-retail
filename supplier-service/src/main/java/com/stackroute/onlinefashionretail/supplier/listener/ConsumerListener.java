package com.stackroute.onlinefashionretail.supplier.listener;

import com.stackroute.onlinefashionretail.supplier.repository.MappingRepository;
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
  MappingRepository mappingRepository;

  @KafkaListener(topics = "Login", groupId = "group_id")
  public void consumeDonor(Mapping user) throws IOException {
//    Mapping obj = new ObjectMapper().readValue(user, Mapping.class);
    System.out.println(user);
    mappingRepository.save(user);
  }
}
