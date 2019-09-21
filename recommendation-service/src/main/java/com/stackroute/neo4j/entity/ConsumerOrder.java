package com.stackroute.neo4j.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.Date;
import java.util.List;


@NodeEntity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class ConsumerOrder
{
    @Id
    private String id;
    private String consumerId;
    @JsonProperty("products")
    private List<Product> products;
    private double totalAmount;
    @JsonProperty("shippingAddress")
    private Address shippingAddress;
    private String status;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date date;

    //no args constructor

}
