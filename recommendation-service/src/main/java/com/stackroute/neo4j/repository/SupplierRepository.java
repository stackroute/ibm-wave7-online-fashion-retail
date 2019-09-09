package com.stackroute.neo4j.repository;

import com.stackroute.neo4j.entity.Supplier;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface SupplierRepository extends Neo4jRepository<Supplier,Long> {
}
