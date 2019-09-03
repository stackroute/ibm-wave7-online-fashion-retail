package com.example.designerdashboard.repository;

import com.example.designerdashboard.model.Dorder;
import com.example.designerdashboard.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Dorder,Integer> {

}
