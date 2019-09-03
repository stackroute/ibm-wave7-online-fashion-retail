package com.stackroute.designerdashboard.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



public class Designer {

    @Id
    private int id;
    private long contact;
    private String name;
    private String location;
    private String email;
    private int rating;


    public Designer(int id,long contact, String name, String location, String email, int rating) {
        this.id=id;
        this.contact = contact;
        this.name = name;
        this.location = location;
        this.email = email;
        this.rating = rating;
    }


    public Designer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getContact() { return contact; }

    public void setContact(long contact) { this.contact = contact; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
