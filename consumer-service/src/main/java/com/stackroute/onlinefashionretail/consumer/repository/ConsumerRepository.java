package com.stackroute.onlinefashionretail.consumer.repository;

import com.stackroute.onlinefashionretail.consumer.domain.Consumer;
import org.springframework.data.mongodb.repository.MongoRepository;

//Repository class used to perform database operations on Consumer Document, extends MongoRepository
public interface ConsumerRepository extends MongoRepository<Consumer, String> {
    Consumer findConsumerByEmail(String email);
}
