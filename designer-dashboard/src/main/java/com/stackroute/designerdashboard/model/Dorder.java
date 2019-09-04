package com.stackroute.designerdashboard.model;

import org.springframework.data.annotation.Id;

public class Dorder {
//    private  static  int count=0;
    @Id
    private String _id;
    private Order designOrder;
    private Mapping[] mapping;
    private Manufacturer manufacturer;
    private Designer designer;

    public Dorder() {
//        id = ++count;
    }

    public Dorder(String id,Order designOrder, Mapping[] mapping, Manufacturer manufacturer,Designer designer) {
        this._id = id;
        this.designOrder = designOrder;
        this.mapping = mapping;
        this.manufacturer = manufacturer;
        this.designer =designer;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public Order getDesignOrder() {
        return designOrder;
    }

    public void setDesignOrder(Order designOrder) {
        this.designOrder = designOrder;
    }

    public Mapping[] getMapping() {
        return mapping;
    }

    public void setMapping(Material[] material) {
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
