//package com.stackroute.login1.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.login1.dao.UserDao;
import com.stackroute.login1.model.DAOUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//@Service
//public class Consumer {
//    @Autowired
//    UserDao userDao;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @KafkaListener(topics = "Kafka_Example", groupId = "group_id")
//    public void consumeDonor(String daoUser) throws IOException {
//        System.out.println("consumed data is "+daoUser);
//        DAOUser obj=new ObjectMapper().readValue(daoUser, DAOUser.class);
//        System.out.println(passwordEncoder.encode(obj.getPassword()));
//        obj.setPassword(passwordEncoder.encode(obj.getPassword()));
//        userDao.save(obj);
//    }

//    @KafkaListener(topics = "RecipientRegistration", groupId = "group_id")
//    public void consumeRecipient(String daoUser) throws IOException {
//        DAOUser obj = new ObjectMapper().readValue(daoUser, DAOUser.class);
//        System.out.println(passwordEncoder.encode(obj.getPassword()));
//        obj.setPassword(passwordEncoder.encode(obj.getPassword()));
//        userDao.save(obj);
//    }

//}