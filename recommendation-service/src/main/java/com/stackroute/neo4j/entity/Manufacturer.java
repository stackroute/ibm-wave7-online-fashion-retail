package com.stackroute.neo4j.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import javax.persistence.Column;
import java.util.List;

@NodeEntity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Manufacturer {
    @Id
    @JsonProperty("userId")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    private String city;
    private String specifications;
    private float rating;
    private long contact_number;
    private List<ManufacturerOrder> manufacturerOrders;
    private List<BasePrice> basePrices;
}
