package com.stackroute.onlinefashionretail.consumer.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

//to mark it as a document in mongoDb
@Document
public class Consumer {
    @Id
    private String id;
    private String userName;

    //@indexed(unique=true) used to mark field as unique, unique fields do not exist without being indexed in mongo
    @Indexed(unique=true)
    private String email;
    private String firstName;
    private String lastName;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addresses=" + addresses +
                ", consumerOrders=" + consumerOrders +
                ", cart=" + cart +
                '}';
    }
}
