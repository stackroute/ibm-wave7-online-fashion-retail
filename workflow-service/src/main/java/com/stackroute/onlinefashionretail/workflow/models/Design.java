package com.stackroute.onlinefashionretail.workflow.models;

public class Design {
    private String id;
    private String name;
    private String design_img;
    private float price;
    private float profitPercent;
    private float discountPercent;
    private int quantityOfDesign;
    private  String orderStatus;

    public Design() {
    }

    public Design(String id,
                  String name,
                  String design_img,
                  float price,
                  float profitPercent,
                  float discountPercent,
                  int quantityOfDesign,
                  String orderStatus) {
        this.id = id;
        this.name = name;
        this.design_img = design_img;
        this.price = price;
        this.profitPercent = profitPercent;
        this.discountPercent = discountPercent;
        this.quantityOfDesign = quantityOfDesign;
        this.orderStatus = orderStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesign_img() {
        return design_img;
    }

    public void setDesign_img(String design_img) {
        this.design_img = design_img;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getProfitPercent() {
        return profitPercent;
    }

    public void setProfitPercent(float profitPercent) {
        this.profitPercent = profitPercent;
    }

    public float getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(float discountPercent) {
        this.discountPercent = discountPercent;
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
        return "Design{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", design_img='" + design_img + '\'' +
                ", price=" + price +
                ", profitPercent=" + profitPercent +
                ", discountPercent=" + discountPercent +
                ", quantityOfDesign=" + quantityOfDesign +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
