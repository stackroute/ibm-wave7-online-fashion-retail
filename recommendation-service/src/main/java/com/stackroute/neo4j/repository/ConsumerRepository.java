package com.stackroute.neo4j.repository;

import com.stackroute.neo4j.entity.Consumer;
import com.stackroute.neo4j.entity.ConsumerOrder;
import com.stackroute.neo4j.entity.Designer;
import com.stackroute.neo4j.entity.Product;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ConsumerRepository extends Neo4jRepository<Consumer,String> {


}
