package com.stackroute.onlinefashionretail.workflow.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

//to mark it as a document in mongoDb
public class ConsumerOrder {
    private String id;
    private String consumerId;
    private List<Product> products;
    private double totalAmount;
    private Address shippingAddress;
    private String status;
    @JsonFormat(pattern="dd/MM/yyyy-HH:mm:ss")
    private Date date;

    //no args constructor
    public ConsumerOrder() {
    }

    //getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //toString methods

    @Override
    public String toString() {
        return "ConsumerOrder{" +
                "id='" + id + '\'' +
                ", ConsumerId='" + consumerId + '\'' +
                ", products=" + products +
                ", totalAmount=" + totalAmount +
                ", shippingAddress=" + shippingAddress +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
