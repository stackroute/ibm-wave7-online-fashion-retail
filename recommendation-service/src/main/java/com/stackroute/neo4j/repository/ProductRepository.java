package com.stackroute.neo4j.repository;

import com.stackroute.neo4j.entity.Product;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ProductRepository extends Neo4jRepository<Product,String> {
}
