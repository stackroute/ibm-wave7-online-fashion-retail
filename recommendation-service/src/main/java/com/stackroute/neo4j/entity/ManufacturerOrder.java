package com.stackroute.neo4j.entity;

import org.neo4j.ogm.annotation.Id;

public class ManufacturerOrder
{
    @Id
    private String id;
    private String tagId;
    private String designerName;
    private String designImage;
    private int quantityOfDesign;
    private String orderStatus;

    public ManufacturerOrder(String id, String tagId, String designerName, String designImage, int quantityOfDesign, String orderStatus) {
        this.id = id;
        this.tagId = tagId;
        this.designerName = designerName;
        this.designImage = designImage;
        this.quantityOfDesign = quantityOfDesign;
        this.orderStatus = orderStatus;
    }

    public ManufacturerOrder() {
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

    public String getDesignerName() {
        return designerName;
    }

    public void setDesignerName(String designerName) {
        this.designerName = designerName;
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
}
