package com.stackroute.onlinefashionretail.designer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;
import java.util.Map;

@Document
public class DesignerOrder {

    @Id
    private String id;
    private String designer_id;
    private Design design;
    private List<Map<String,Double>> supplierList;
    private Manufacturer manufacturer;
    private String tagId;

    public DesignerOrder() {
    }

    public DesignerOrder(String id, String designer_id, Design design, List<Map<String, Double>> supplierList, Manufacturer manufacturer, String tagId) {
        this.id = id;
        this.designer_id = designer_id;
        this.design = design;
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

    public String getDesigner_id() {
        return designer_id;
    }

    public void setDesigner_id(String designer_id) {
        this.designer_id = designer_id;
    }

    public Design getDesign() {
        return design;
    }

    public void setDesign(Design design) {
        this.design = design;
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
                ", designer_id='" + designer_id + '\'' +
                ", design=" + design +
                ", supplierList=" + supplierList +
                ", manufacturer=" + manufacturer +
                ", tagId='" + tagId + '\'' +
                '}';
    }
}
