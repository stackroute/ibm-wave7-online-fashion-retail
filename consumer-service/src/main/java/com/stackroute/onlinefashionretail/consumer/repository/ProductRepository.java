package com.stackroute.onlinefashionretail.consumer.repository;

import com.stackroute.onlinefashionretail.consumer.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

//Repository class used to perform database operations on Product Document, extends MongoRepository
public interface ProductRepository extends MongoRepository<Product,String> {
    List<Product> findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(String name, String category);
}
