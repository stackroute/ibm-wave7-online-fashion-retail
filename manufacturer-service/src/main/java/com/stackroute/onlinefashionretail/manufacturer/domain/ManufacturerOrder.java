package com.stackroute.onlinefashionretail.manufacturer.domain;

import org.springframework.data.annotation.Id;

public class ManufacturerOrder {
  @Id
  private String id;
  private String tagId;
  private Designer designer;
  private String designImage;
  private int qunatityOfDesign;
  private String orderStatus;

  public ManufacturerOrder(String id, String tagId, Designer designer, String designImage, int qunatityOfDesign, String orderStatus) {
    this.id = id;
    this.tagId = tagId;
    this.designer = designer;
    this.designImage = designImage;
    this.qunatityOfDesign = qunatityOfDesign;
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

  public int getQunatityOfDesign() {
    return qunatityOfDesign;
  }

  public void setQunatityOfDesign(int qunatityOfDesign) {
    this.qunatityOfDesign = qunatityOfDesign;
  }

  public String getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(String orderStatus) {
    this.orderStatus = orderStatus;
  }
}
