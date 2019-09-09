package com.stackroute.designerdashboard.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Mapping {

    @Id
    private String id;
    private double Quantity;
    private double price;
    private String unit;
    private Material material;
    private Supplier supplier;

    public Mapping() {
    }

    public Mapping(String id, double quantity, double price, String unit, Material material, Supplier supplier) {
        this.id = id;
        Quantity = quantity;
        this.price = price;
        this.unit = unit;
        this.material = material;
        this.supplier = supplier;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getQuantity() {
        return Quantity;
    }

    public void setQuantity(double quantity) {
        Quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Mapping{" +
                "id='" + id + '\'' +
                ", Quantity=" + Quantity +
                ", price=" + price +
                ", unit='" + unit + '\'' +
                ", material=" + material +
                ", supplier=" + supplier +
                '}';
    }
}
