package com.example.designerdashboard.model;

public class Dorder {
//    private  static  int count=0;
//    private int id;
    private Order designOrder;
    private Material[] material;
    private Manufacturer manufacturer;

    public Dorder() {
//        id = ++count;
    }

    public Dorder(Order designOrder, Material[] material, Manufacturer manufacturer) {
        this.designOrder = designOrder;
        this.material = material;
        this.manufacturer = manufacturer;
    }

    public Order getDesignOrder() {
        return designOrder;
    }

    public void setDesignOrder(Order designOrder) {
        this.designOrder = designOrder;
    }

    public Material[] getMaterial() {
        return material;
    }

    public void setMaterial(Material[] material) {
        this.material = material;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
