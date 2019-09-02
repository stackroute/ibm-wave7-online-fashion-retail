package com.stackroute.manufacture.domain;

import org.springframework.data.annotation.Id;


public class Manufacture {

    @Id
    private int id;
    private String name;
    private String email;
    private String city;
    private String specifications;
    private int rating;
    private int contact_number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getContact_number() {
        return contact_number;
    }

    public void setContact_number(int contact_number) {
        this.contact_number = contact_number;
    }

    public Manufacture() {
    }

    public Manufacture(int id, String name, String email, String city, String specifications, int rating, int contact_number) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.city = city;
        this.specifications = specifications;
        this.rating = rating;
        this.contact_number = contact_number;
    }
}