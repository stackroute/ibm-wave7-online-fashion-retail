package com.stackroute.neo4j.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@NodeEntity
public class Manufacturer {
    @Id
    private String id;
    private String name;
    private String email;
    private String city;
    private String specifications;
    private float rating;
    private long contact_number;
    private List<ManufacturerOrder> manufacturerOrders;
    private List<BasePrice> basePrices;

    public List<BasePrice> getBasePrices() {
        return basePrices;
    }

    public void setBasePrices(List<BasePrice> basePrices) {
        this.basePrices = basePrices;
    }

    public List<ManufacturerOrder> getManufacturerOrders() {
        return manufacturerOrders;
    }

    public void setManufacturerOrders(List<ManufacturerOrder> manufacturerOrders) {
        this.manufacturerOrders = manufacturerOrders;
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

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public long getContact_number() {
        return contact_number;
    }

    public void setContact_number(long contact_number) {
        this.contact_number = contact_number;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", specifications='" + specifications + '\'' +
                ", rating=" + rating +
                ", contact_number=" + contact_number +
                ", manufacturerOrders=" + manufacturerOrders +
                ", basePrices=" + basePrices +
                '}';
    }
}
