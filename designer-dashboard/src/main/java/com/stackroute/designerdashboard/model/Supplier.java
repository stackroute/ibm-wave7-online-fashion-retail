package com.stackroute.designerdashboard.model;

public class Supplier {
    private int id;
    private String name;
    private String Email;
    private String city;
    private int rating;

    public Supplier() {
    }

    public Supplier(int id, String name, String email, String city, int rating) {
        this.id = id;
        this.name = name;
        Email = email;
        this.city = city;
        this.rating = rating;
    }

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
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
