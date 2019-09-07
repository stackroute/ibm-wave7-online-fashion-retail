package com.stackroute.onlinefashionretail.consumer.Repository;

import com.stackroute.onlinefashionretail.consumer.Domain.ConsumerOrder;
import org.springframework.data.mongodb.repository.MongoRepository;

//Repository class used to perform database operations on ConsumerOrder Document, extends MongoRepository
public interface ConsumerOrderRepository extends MongoRepository<ConsumerOrder,String> {
}
