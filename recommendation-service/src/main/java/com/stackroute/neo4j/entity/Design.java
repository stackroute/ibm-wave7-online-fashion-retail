package com.stackroute.neo4j.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

import java.util.List;

public class Design {

    @Id
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("design_img")
    private String design_img;
    @JsonProperty("price")
    private float price;
    @JsonProperty("profitPercent")
    private float profitPercent;
    @JsonProperty("discountPercent")
    private float discountPercent;
    @JsonProperty("quantityOfDesign")
    private int quantityOfDesign;
    @JsonProperty("orderStatus")
    private  String orderStatus;

    public Design(String id, String name, String design_img, float price, float profitPercent, float discountPercent, int quantityOfDesign, String orderStatus) {
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
        return "DesignerOrder{" +
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
