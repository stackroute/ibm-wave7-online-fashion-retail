package com.stackroute.designerdashboard.model;

import java.util.List;

public class Order {

//    private static int count=0;
    private String id;
    private String name;
    private String design_img;
    private int price;
    private int profit;
    private int discount;
    private int QuantityOfDesign;
    private  String OrderStatus;



    public Order() {
//        id=++count;
    }


    public Order(String id, String name, String design_img,int price,int profit,int discount,int QantityOfDesign, String OrderStatus) {
        this.id = id;
        this.name = name;
        this.design_img = design_img;
        this.price = price;
        this.profit = profit;
        this.discount = discount;
        this.QuantityOfDesign = QantityOfDesign;
        this.OrderStatus = OrderStatus;
    }

    public String getId() { return id; }

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


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getQuantityOfDesign() {
        return QuantityOfDesign;
    }

    public void setQuantityOfDesign(int quantityOfDesign) {
        QuantityOfDesign = quantityOfDesign;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        OrderStatus = orderStatus;
    }
}
