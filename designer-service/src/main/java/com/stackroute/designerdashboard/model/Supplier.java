package com.stackroute.designerdashboard.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Supplier {
    @Id
    private String id;
    private String name;
    private String email;
    private String city;
    private float rating;
    private List<SupplierOrder> supplierOrderList;

    public Supplier() {
    }

    public Supplier(String id, String name, String email, String city, float rating, List<SupplierOrder> supplierOrderList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.city = city;
        this.rating = rating;
        this.supplierOrderList = supplierOrderList;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<SupplierOrder> getSupplierOrderList() {
        return supplierOrderList;
    }

    public void setSupplierOrderList(List<SupplierOrder> supplierOrderList) {
        this.supplierOrderList = supplierOrderList;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", rating=" + rating +
                ", supplierOrderList=" + supplierOrderList +
                '}';
    }
}
