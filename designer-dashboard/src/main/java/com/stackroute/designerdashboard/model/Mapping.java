package com.stackroute.designerdashboard.model;

public class Mapping {
    private int id;
    private String Quantity;
    private  String designerEnterQuantity;
    private int price;
    private Material material;
    private Supplier supplier;

    public Mapping() {
    }

    public Mapping(int id, String quantity, int price, Material material, Supplier supplier,String designerEnterQuantity) {
        this.id = id;
        this.Quantity = quantity;
        this.price = price;
        this.material = material;
        this.supplier = supplier;
        this.designerEnterQuantity = designerEnterQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public String getDesignerEnterQuantity() {
        return designerEnterQuantity;
    }

    public void setDesignerEnterQuantity(String designerEnterQuantity) {
        this.designerEnterQuantity = designerEnterQuantity;
    }
}
