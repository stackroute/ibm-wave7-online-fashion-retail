package com.stackroute.designerdashboard.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;
import java.util.Map;

@Document
public class DesignerOrder {

    @Id
    private String id;
    private Design designOrder;
    private List<Map<String,Double>> supplierList;
    private Manufacturer manufacturer;
    private String tagId;

    public DesignerOrder() {
    }

    public DesignerOrder(String id, Design designOrder, List<Map<String, Double>> supplierList, Manufacturer manufacturer, String tagId) {
        this.id = id;
        this.designOrder = designOrder;
        this.supplierList = supplierList;
        this.manufacturer = manufacturer;
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

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "DesignerOrder{" +
                "id='" + id + '\'' +
                ", designOrder=" + designOrder +
                ", supplierList=" + supplierList +
                ", manufacturer=" + manufacturer +
                ", tagId='" + tagId + '\'' +
                '}';
    }
}
