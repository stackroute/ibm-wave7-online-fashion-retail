package com.stackroute.designerdashboard.model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@NodeEntity
public class Designer
{
    @Id
    private String id;
    private String name;
    private String city;
    private float rating;
    private String email;
    private long contactNumber;

    @Relationship(type = "has_ordered")
    private List<DesignerOrder> orderList;

    public List<DesignerOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<DesignerOrder> orderList) {
        this.orderList = orderList;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Designer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", rating=" + rating +
                ", email='" + email + '\'' +
                ", contactNumber=" + contactNumber +
                ", orderList=" + orderList +
                '}';
    }
}
