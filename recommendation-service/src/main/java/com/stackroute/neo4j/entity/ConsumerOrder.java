package com.stackroute.neo4j.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@NodeEntity
public class ConsumerOrder
{
    @Id
    private String id;
    private String consumerId;
    private List<Product> products;
    private double totalAmount;
    private Address shippingAddress;
    private String status;
    @JsonFormat(pattern = "dd/MM/yyyy-HH:mm:ss")
    private Date date;

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

    @Override
    public String toString() {
        return "ConsumerOrder{" +
                "id='" + id + '\'' +
                ", consumerId='" + consumerId + '\'' +
                ", products=" + products +
                ", totalAmount=" + totalAmount +
                ", shippingAddress=" + shippingAddress +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
