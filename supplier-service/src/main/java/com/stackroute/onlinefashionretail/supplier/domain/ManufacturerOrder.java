package com.stackroute.onlinefashionretail.supplier.domain;



public class ManufacturerOrder
{

    private String id;
    private String tagId;
    private String designerName;
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

  @Override
  public String toString() {
    return "ManufacturerOrder{" +
      "id='" + id + '\'' +
      ", tagId='" + tagId + '\'' +
      ", designerName='" + designerName + '\'' +
      ", designImage='" + designImage + '\'' +
      ", quantityOfDesign=" + quantityOfDesign +
      ", orderStatus='" + orderStatus + '\'' +
      '}';
  }
}
