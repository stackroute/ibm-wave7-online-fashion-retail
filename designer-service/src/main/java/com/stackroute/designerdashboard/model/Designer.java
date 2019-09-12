package com.stackroute.designerdashboard.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class Designer {

    @Id
    private String id;
    private String name;
    private long contactNumber;
    private String city;
    private float rating;
    private String email;
    private long contactNumber;

    private List<DesignerOrder> orderList;


    public Designer() {
    }

    public Designer(String id, long contactNumber, String name, String city, String email, float rating, List<DesignerOrder> orderList) {
        this.id = id;
        this.contactNumber = contactNumber;
        this.name = name;
        this.city = city;
        this.email = email;
        this.rating = rating;
        this.orderList = orderList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
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
                ", contactNumber=" + contactNumber +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", rating=" + rating +
                ", orderList=" + orderList +
                '}';
    }
}
