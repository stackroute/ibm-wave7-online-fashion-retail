package com.stackroute.neo4j.repository;

import com.stackroute.neo4j.entity.ConsumerOrder;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ConsumerOrderRepository extends Neo4jRepository<ConsumerOrder,String> {
}
