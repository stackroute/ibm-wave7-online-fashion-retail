package com.stackroute.neo4j.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.neo4j.ogm.annotation.Id;

import java.util.List;
import java.util.Map;


public class DesignerOrder {
    @Id
    @JsonProperty("id")
    private String id;
    @JsonProperty("designOrder")
    private Design designOrder;
    @JsonProperty("supplierList")
    private List<Map<String,Double>> supplierList;
    @JsonProperty("manufacturer")
    private Manufacturer manufacturer;
    @JsonProperty("designer")
    private Designer designer;
    @JsonProperty("tagId")
    private String tagId;


    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Design getDesignOrder() {
        return designOrder;
    }

    public void setDesignOrder(Design designOrder) {
        this.designOrder = designOrder;
    }

  public List<Map<String, Double>> getSupplierList() {
    return supplierList;
  }

  public void setSupplierList(List<Map<String, Double>> supplierList) {
    this.supplierList = supplierList;
  }

  public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Designer getDesigner() {
        return designer;
    }

    public void setDesigner(Designer designer) {
        this.designer = designer;
    }

    @Override
    public String toString() {
        return "Dorder{" +
                "id='" + id + '\'' +
                ", designOrder=" + designOrder +
                ", supplierList=" + supplierList +
                ", manufacturer=" + manufacturer +
                ", designer=" + designer +
                '}';
    }
}
