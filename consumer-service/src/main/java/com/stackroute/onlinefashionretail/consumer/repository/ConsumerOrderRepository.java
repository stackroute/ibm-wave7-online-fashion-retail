package com.stackroute.onlinefashionretail.consumer.repository;

import com.stackroute.onlinefashionretail.consumer.domain.ConsumerOrder;
import org.springframework.data.mongodb.repository.MongoRepository;

//Repository class used to perform database operations on ConsumerOrder Document, extends MongoRepository
public interface ConsumerOrderRepository extends MongoRepository<ConsumerOrder,String> {
}
