package com.stackroute.Baseprice.domain;

import javax.persistence.Id;

public class Baseprice
{
    public Baseprice(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Id
    private int id;
    private String name;
    private int price;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
