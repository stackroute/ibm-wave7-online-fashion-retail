package com.stackroute.onlinefashionretail.consumer.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//to mark it as a document in mongoDb
@Document
public class Product {

    @Id
    private String id;
    private String name;
    private String category;
    private Designer designer;
    private double price;
    private double discount;
    private float rating;
    private String image;

    //no args constructor
    public Product() {
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

    //toString method
    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", designerName='" + designer + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", rating=" + rating +
                ", image='" + image + '\'' +
                '}';
    }

    public boolean equals(Object o) {
        if (!(o instanceof Product)) {
            return false;
        }
        Product other = (Product) o;
        return name.equals(other.name) && id.equals(other.id) && designer.getName().equals(other.designer.getName());
    }

    public int hashCode() {
        return id.hashCode();
    }
}
