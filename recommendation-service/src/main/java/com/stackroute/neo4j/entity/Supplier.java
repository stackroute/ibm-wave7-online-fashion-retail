package com.stackroute.neo4j.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.List;
@NodeEntity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Supplier
{
    @Id
    @JsonProperty("userId")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("city")
    private String city;
    @JsonProperty("rating")
    private float rating;
    @JsonProperty("email")
    private String email;
    @JsonProperty("supplierOrders")
    private List<SupplierOrder> supplierOrders;


}
