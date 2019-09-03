package com.stackroute.designerdashboard.model;

public class Dorder {
//    private  static  int count=0;
//    private int id;
    private Order designOrder;
    private Mapping[] mapping;
    private Manufacturer manufacturer;
    private Designer designer;

    public Dorder() {
//        id = ++count;
    }

    public Dorder(Order designOrder, Mapping[] mapping, Manufacturer manufacturer,Designer designer) {
        this.designOrder = designOrder;
        this.mapping = mapping;
        this.manufacturer = manufacturer;
        this.designer =designer;
    }

    public Order getDesignOrder() {
        return designOrder;
    }

    public void setDesignOrder(Order designOrder) {
        this.designOrder = designOrder;
    }

    public Mapping[] getMaterial() {
        return mapping;
    }

    public void setMaterial(Material[] material) {
        this.mapping = mapping;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Designer getDesigner() {
        return designer;
    }

    public void setDesigner(Designer designer) {
        this.designer = designer;
    }
}
