package com.stackroute.onlinefashionretail.manufacturer.domain;

import org.springframework.data.annotation.Id;

public class SupplierOrder
{
    @Id
    private String id;
    private Designer designer;
    private Material material;
    private double quantity;
    private String orderStatus;
    private String tagId;

  public SupplierOrder() {
  }

  public SupplierOrder(String id, Designer designer, Material material, double quantity, String orderStatus, String tagId) {
    this.id = id;
    this.designer = designer;
    this.material = material;
    this.quantity = quantity;
    this.orderStatus = orderStatus;
    this.tagId = tagId;
  }

  public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Designer getDesigner() {
        return designer;
    }

    public void setDesigner(Designer designer) {
        this.designer = designer;
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
    @Override
    public String toString() {
        return "SupplierOrder{" +
                "id='" + id + '\'' +
                ", designer=" + designer +
                ", material=" + material +
                ", quantity=" + quantity +
                ", orderStatus='" + orderStatus + '\'' +
                ", tagId='" + tagId + '\'' +
                '}';
    }
}
