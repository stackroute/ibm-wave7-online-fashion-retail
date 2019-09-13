package com.stackroute.onlinefashionretail.manufacturer.domain;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Map;
public class DesignerOrder {
    @Id
    private String id;
    private Design designOrder;
    private List<Map<String,Double>> supplierList;
    private Manufacturer manufacturer;
    private Designer designer;
    private String tagId;

  public DesignerOrder() {
  }

  public DesignerOrder(String id, Design designOrder, List<Map<String, Double>> supplierList, Manufacturer manufacturer, Designer designer, String tagId) {
    this.id = id;
    this.designOrder = designOrder;
    this.supplierList = supplierList;
    this.manufacturer = manufacturer;
    this.designer = designer;
    this.tagId = tagId;
  }

  public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Design getDesignOrder() {
        return designOrder;
    }

    public void setDesignOrder(Design designOrder) {
        this.designOrder = designOrder;
    }

  public List<Map<String, Double>> getSupplierList() {
    return supplierList;
  }

  public void setSupplierList(List<Map<String, Double>> supplierList) {
    this.supplierList = supplierList;
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

    @Override
    public String toString() {
        return "Dorder{" +
                "id='" + id + '\'' +
                ", designOrder=" + designOrder +
                ", supplierList=" + supplierList +
                ", manufacturer=" + manufacturer +
                ", designer=" + designer +
                '}';
    }
}
