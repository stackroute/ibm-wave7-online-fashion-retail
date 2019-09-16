package com.stackroute.neo4j.repository;

import com.stackroute.neo4j.entity.Manufacturer;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ManufacturerRepository extends Neo4jRepository<Manufacturer,String> {
}
