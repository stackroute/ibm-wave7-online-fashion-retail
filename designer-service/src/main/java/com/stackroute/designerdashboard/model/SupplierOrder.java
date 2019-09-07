package com.stackroute.designerdashboard.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class SupplierOrder {

    @Id
    private  String id;
    private  String designerName;
    private  Material material;
    private  double quantity;
    private  String orderStatus;
    private  String tagId;

    public SupplierOrder() {
    }

    public SupplierOrder(String id, String designerName, Material material, double quantity, String orderStatus, String tagId) {
        this.id = id;
        this.material = material;
        this.quantity = quantity;
        this.orderStatus = orderStatus;
        this.tagId = tagId;
        this.designerName = designerName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
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

    @Override
    public String toString() {
        return "SupplierOrder{" +
                "id='" + id + '\'' +
                ", designerName='" + designerName + '\'' +
                ", material=" + material +
                ", quantity=" + quantity +
                ", orderStatus='" + orderStatus + '\'' +
                ", tagId='" + tagId + '\'' +
                '}';
    }
}
