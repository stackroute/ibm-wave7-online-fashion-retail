package com.stackroute.neo4j.repository;

import com.stackroute.neo4j.entity.Designer;
import com.stackroute.neo4j.entity.Manufacturer;
import com.stackroute.neo4j.entity.Order;
import com.stackroute.neo4j.entity.Supplier;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DesignerRepository extends Neo4jRepository<Designer,Long> {

    @Query("MATCH(s:Supplier) RETURN s ORDER BY s.rating DESC limit 2")
    List<Supplier> match1();

    @Query("MATCH(m:Manufacturer) RETURN m ORDER BY m.rating DESC limit 2")
    List<Manufacturer> match2();

    @Query("MATCH (d:Designer {name: {name}})-[r1:has_ordered]->(o:Order)\n" +
            "MATCH (o:Order)-[r2:MANUFACTURER]->(ma:Manufacturer)\n" +
            "MATCH (o:Order)-[r3:MAPPING]->(m:Mapping)\n" +
            "MATCH (m:Mapping)-[r4:SUPPLIER]->(s:Supplier)  \n" +
            "RETURN d, m, ma, o, s, r1 ,r2 ,r3, r4")
    List<Order> match3(@Param("name") String name);
}
