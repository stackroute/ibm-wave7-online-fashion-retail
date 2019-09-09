package com.stackroute.designerdashboard.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class ManufacturerOrder {

    @Id
    private String id;
    private  String tagId;
    private  String desinerName;
    private String design_img;
    private  int quantity;

    public ManufacturerOrder() {
    }

    public ManufacturerOrder(String id, String tagId,String desinerName, String design_img, int quantity) {
        this.id = id;
        this.tagId = tagId;
        this.design_img = design_img;
        this.quantity = quantity;
        this.desinerName = desinerName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getDesinerName() {
        return desinerName;
    }

    public void setDesinerName(String desinerName) {
        this.desinerName = desinerName;
    }

    public String getDesign_img() {
        return design_img;
    }

    public void setDesign_img(String design_img) {
        this.design_img = design_img;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ManufacturerOrder{" +
                "id='" + id + '\'' +
                ", tagId='" + tagId + '\'' +
                ", desinerName='" + desinerName + '\'' +
                ", design_img='" + design_img + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
