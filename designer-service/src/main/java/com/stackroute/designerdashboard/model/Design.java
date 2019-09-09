package com.stackroute.designerdashboard.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Design {

    @Id
    private String id;
    private String name;
    private String design_img;
    private float price;
    private float profitPercentage;
    private float discountPercentage;
    private int QuantityOfDesign;
    private  String OrderStatus;



    public Design() {
    }

    public Design(String id, String name, String design_img, float price, float profitPercentage, float discountPercentage, int quantityOfDesign, String orderStatus) {
        this.id = id;
        this.name = name;
        this.design_img = design_img;
        this.price = price;
        this.profitPercentage = profitPercentage;
        this.discountPercentage = discountPercentage;
        this.QuantityOfDesign = quantityOfDesign;
        this.OrderStatus = orderStatus;
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

    public float getProfitPercentage() {
        return profitPercentage;
    }

    public void setProfitPercentage(float profitPercentage) {
        this.profitPercentage = profitPercentage;
    }

    public float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public int getQuantityOfDesign() {
        return QuantityOfDesign;
    }

    public void setQuantityOfDesign(int quantityOfDesign) {
        this.QuantityOfDesign = quantityOfDesign;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.OrderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Design{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", design_img='" + design_img + '\'' +
                ", price=" + price +
                ", profitPercentage=" + profitPercentage +
                ", discountPercentage=" + discountPercentage +
                ", QuantityOfDesign=" + QuantityOfDesign +
                ", OrderStatus='" + OrderStatus + '\'' +
                '}';
    }
}
