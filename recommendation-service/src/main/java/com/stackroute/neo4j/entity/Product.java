package com.stackroute.neo4j.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("category")
    private String category;
    @JsonProperty("designer")
    private Designer designer;
    @JsonProperty("price")
    private double price;
    @JsonProperty("discount")
    private double discount;
    @JsonProperty("rating")
    private float rating;
    @JsonProperty("image")
    private String image;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

  public Designer getDesigner() {
    return designer;
  }

  public void setDesigner(Designer designer) {
    this.designer = designer;
  }

  public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", designer=" + designer +
                ", price=" + price +
                ", discount=" + discount +
                ", rating=" + rating +
                ", image='" + image + '\'' +
                '}';
    }
}
