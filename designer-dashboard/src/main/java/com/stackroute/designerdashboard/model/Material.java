package com.stackroute.designerdashboard.model;

import org.springframework.data.annotation.Id;

import java.awt.*;

public class Material {
    @Id
    private int id;
    private String category;
    private String name;
    private String image;

    public Material() {
    }

    public Material(String name, String image, String category) {
        this.name = name;
        this.image = image;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        category = category;
    }
}
