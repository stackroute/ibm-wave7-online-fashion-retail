package com.stackroute.workflow.models;

import java.util.List;

public class Designer {
    private String id;
    private String name;
    private String city;
    private float rating;
    private String email;
    private long contactNumber;
    private List<DesignerOrder> orderList;


    //no args constructor
    public Designer() {
    }

    //getters and setters
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public List<DesignerOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<DesignerOrder> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "Designer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", rating=" + rating +
                ", email='" + email + '\'' +
                ", contactNumber=" + contactNumber +
                ", orderList=" + orderList +
                '}';
    }
}
