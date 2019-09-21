package com.stackroute.neo4j.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;


@NodeEntity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class SupplierOrder
{
    @Id
    @JsonProperty("id")
    private String id;
    @JsonProperty("designerName")
    private String designerName;
    @JsonProperty("material")
    private Material material;
    @JsonProperty("quantity")
    private double quantity;
    @JsonProperty("orderStatus")
    private String orderStatus;
    @JsonProperty("tagId")
    private String tagId;



}
