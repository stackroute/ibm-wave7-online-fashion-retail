package com.stackroute.onlinefashionretail.consumer.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.onlinefashionretail.consumer.domain.Consumer;
import com.stackroute.onlinefashionretail.consumer.domain.User;
import com.stackroute.onlinefashionretail.consumer.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.io.IOException;

public class Consumers {
    @Autowired
    ConsumerRepository consumerRepository;


    @KafkaListener(topics = "Kafka_Example", groupId = "customer")
    public void consumeManufacturer(String user) throws IOException {
        System.out.println("inside consumer");
        User user1 = new ObjectMapper().readValue(user, User.class);
        if(user1.getDesignation().equals("Consumer")) {
            System.out.println("consumed data is " + user);
            Consumer consumerObject = new ObjectMapper().readValue(user, Consumer.class);
            consumerRepository.save(consumerObject);
        }
    }
}
