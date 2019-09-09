package com.stackroute.workflow.models;

import java.util.List;
import java.util.Map;

public class Consumer {
    private String id;
    private String userName;
    private String email;
    private Map<String,Address> addresses;
    private Map<String,ConsumerOrder> consumerOrders;
    private List<Product> cart;

    //no args constructor
    public Consumer() {
    }

    //getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Map<String,Address> addresses) {
        this.addresses = addresses;
    }

    public Map<String, ConsumerOrder> getConsumerOrders() {
        return consumerOrders;
    }

    public void setConsumerOrders(Map<String, ConsumerOrder> consumerOrders) {
        this.consumerOrders = consumerOrders;
    }

    public List<Product> getCart() {
        return cart;
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
    }

    //toString method
    @Override
    public String toString() {
        return "Consumer{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", addresses=" + addresses +
                ", consumerOrders=" + consumerOrders +
                ", cart=" + cart +
                '}';
    }
}
