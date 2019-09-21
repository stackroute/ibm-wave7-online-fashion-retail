package com.stackroute.neo4j.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@AllArgsConstructor
@NoArgsConstructor
public class Address
{
        @Id
        @JsonProperty("id")
        private String id;
        @JsonProperty("firstName")
        private String firstName;
        @JsonProperty("lastName")
        private String lastName;
        @JsonProperty("firstLine")
        private String firstLine;
        @JsonProperty("secondLine")
        private String secondLine;
        @JsonProperty("thirdLine")
        private String thirdLine;
        @JsonProperty("state")
        private String state;
        @JsonProperty("city")
        private String city;
        @JsonProperty("pinCode")
        private String pinCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }

    public String getSecondLine() {
        return secondLine;
    }

    public void setSecondLine(String secondLine) {
        this.secondLine = secondLine;
    }

    public String getThirdLine() {
        return thirdLine;
    }

    public void setThirdLine(String thirdLine) {
        this.thirdLine = thirdLine;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstLine='" + firstLine + '\'' +
                ", secondLine='" + secondLine + '\'' +
                ", thirdLine='" + thirdLine + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", pinCode='" + pinCode + '\'' +
                '}';
    }
}
