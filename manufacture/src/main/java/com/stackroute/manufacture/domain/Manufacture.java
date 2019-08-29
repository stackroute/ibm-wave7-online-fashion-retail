package com.stackroute.manufacture.domain;

import org.springframework.data.annotation.Id;


public class Manufacture {

    @Id
    private int id;
    private String name;
    private String email;
    private int price;
    private String specifications;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }


    public Manufacture() {
    }

    public Manufacture(int id, String name, String email, int price, String specifications) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.price = price;
        this.specifications = specifications;
    }



}