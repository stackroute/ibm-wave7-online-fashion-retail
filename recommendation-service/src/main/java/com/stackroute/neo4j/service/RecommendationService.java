package com.stackroute.neo4j.service;

import com.stackroute.neo4j.entity.*;

import java.util.List;

public interface RecommendationService {

  List<Product> getProducts(String id);
  ConsumerOrder createProduct(ConsumerOrder consumerOrder);
  public List<Manufacturer> getManufacturers();
  public List<Supplier> getSuppliers();
  public Manufacturer createManufacturer(Manufacturer manufacturer);
  public Supplier createSupplier(Supplier supplier);
}
