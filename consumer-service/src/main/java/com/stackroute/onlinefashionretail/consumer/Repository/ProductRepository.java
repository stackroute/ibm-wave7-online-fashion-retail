package com.stackroute.onlinefashionretail.consumer.Repository;

import com.stackroute.onlinefashionretail.consumer.Domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

//Repository class used to perform database operations on Product Document, extends MongoRepository
public interface ProductRepository extends MongoRepository<Product,String> {
}
