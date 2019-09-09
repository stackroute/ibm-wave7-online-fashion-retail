package com.stackroute.user.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SupplierOrder
{
    @Id
    private String id;
    private String designerName;
    private Material material;
    private double quantity;
    private String orderStatus;
    private String tagId;



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

  public String getDesignerName() {
    return designerName;
  }

  public void setDesignerName(String designerName) {
    this.designerName = designerName;
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
      ", designerName='" + designerName + '\'' +
      ", material=" + material +
      ", quantity=" + quantity +
      ", orderStatus='" + orderStatus + '\'' +
      ", tagId='" + tagId + '\'' +
      '}';
  }
}
