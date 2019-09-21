package com.stackroute.neo4j.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Properties;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.stereotype.Indexed;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@NodeEntity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Consumer {
    @Id
    private String id;
    private String userName;

    //@indexed(unique=true) used to mark field as unique, unique fields do not exist without being indexed in mongo
    private String email;
    private Map<String,Address> addresses;
    private Map<String,ConsumerOrder> consumerOrders;
    private List<Product> cart;

    //no args constructor

}
