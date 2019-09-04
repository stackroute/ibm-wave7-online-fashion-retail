package com.stackroute.onlinefashionretail.consumer.Repository;

import com.stackroute.onlinefashionretail.consumer.Domain.Consumer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

//Repository class used to perform database operations on Consumer Document, extends MongoRepository
public interface ConsumerRepository extends MongoRepository<Consumer, String> {
    Consumer findConsumerByEmail(String email);
}
