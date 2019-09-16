package com.stackroute.neo4j.repository;

import com.stackroute.neo4j.entity.ConsumerOrder;
import com.stackroute.neo4j.entity.Product;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConsumerOrderRepository extends Neo4jRepository<ConsumerOrder,String> {
  @Query("MATCH (c:ConsumerOrder {consumerId:{id}})-[r1:PRODUCTS]->(p:Product)\n" +
    "    RETURN p")
  List<Product> getProducts(@Param("id") String id);

}
