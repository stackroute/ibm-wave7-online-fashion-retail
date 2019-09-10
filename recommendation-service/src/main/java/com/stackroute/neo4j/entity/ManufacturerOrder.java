package com.stackroute.neo4j.entity;

import org.neo4j.ogm.annotation.Id;

public class ManufacturerOrder
{
    @Id
    private String id;
    private String tagId;
    private Designer designer;
    private String designImage;
    private int quantityOfDesign;
    private String orderStatus;

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

    public Designer getDesigner() {
        return designer;
    }

    public void setDesigner(Designer designer) {
        this.designer = designer;
    }

    public String getDesignImage() {
        return designImage;
    }

    public void setDesignImage(String designImage) {
        this.designImage = designImage;
    }

    public int getQuantityOfDesign() {
        return quantityOfDesign;
    }

    public void setQuantityOfDesign(int quantityOfDesign) {
        this.quantityOfDesign = quantityOfDesign;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "ManufacturerOrder{" +
                "id='" + id + '\'' +
                ", tagId='" + tagId + '\'' +
                ", designer=" + designer +
                ", designImage='" + designImage + '\'' +
                ", quantityOfDesign=" + quantityOfDesign +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
