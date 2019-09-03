package com.stackroute.neo4j.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NoArgsConstructor
@AllArgsConstructor
@NodeEntity
public class Order
{
    @Id
    @GeneratedValue
    private Long orderId;
    private String name;
    private Designer designer;
    private double price;
    private double profit;
    private double discount;
    private Manufacturer manufacturer;
    private Mapping mapping;
    private String orderStatus;
    public int quantityOfDesign;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getQuantityOfDesign() {
        return quantityOfDesign;
    }

    public void setQuantityOfDesign(int quantityOfDesign) {
        this.quantityOfDesign = quantityOfDesign;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Designer getDesigner() {
        return designer;
    }

    public void setDesigner(Designer designer) {
        this.designer = designer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Mapping getMapping() {
        return mapping;
    }

    public void setMapping(Mapping mapping) {
        this.mapping = mapping;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", name='" + name + '\'' +
                ", designer=" + designer +
                ", price=" + price +
                ", profit=" + profit +
                ", discount=" + discount +
                ", manufacturer=" + manufacturer +
                ", mapping=" + mapping +
                ", orderStatus='" + orderStatus + '\'' +
                ", quantityOfDesign=" + quantityOfDesign +
                '}';
    }
}
