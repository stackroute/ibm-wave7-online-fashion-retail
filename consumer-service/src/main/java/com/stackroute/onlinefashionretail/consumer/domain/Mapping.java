package com.stackroute.onlinefashionretail.consumer.domain;

public class Mapping {

    private String id;
    private double price;
    private double quantity;
    private Material material;
    private Supplier supplier;
    private String unit;

    public Mapping() {
    }

    public Mapping(String id, double price, double quantity, Material material, Supplier supplier, String unit) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.material = material;
        this.supplier = supplier;
        this.unit = unit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Mapping{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", material=" + material +
                ", supplier=" + supplier +
                ", unit='" + unit + '\'' +
                '}';
    }
}
