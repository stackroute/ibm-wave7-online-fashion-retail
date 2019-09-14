package com.stackroute.neo4j.service;

import com.stackroute.neo4j.entity.*;
import com.stackroute.neo4j.repository.ConsumerOrderRepository;
import com.stackroute.neo4j.repository.DesignerRepository;
import com.stackroute.neo4j.repository.ManufacturerRepository;
import com.stackroute.neo4j.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecommendateServiceImpl implements RecommendationService {
  private ManufacturerRepository manufacturerRepository;
  private SupplierRepository supplierRepository;
  private DesignerRepository designerRepository;
  private ConsumerOrderRepository consumerOrderRepository;

  public RecommendateServiceImpl(ManufacturerRepository manufacturerRepository, SupplierRepository supplierRepository, DesignerRepository designerRepository, ConsumerOrderRepository consumerOrderRepository) {
    this.manufacturerRepository = manufacturerRepository;
    this.supplierRepository = supplierRepository;
    this.designerRepository = designerRepository;
    this.consumerOrderRepository = consumerOrderRepository;
  }

  @Override
  public List<Product> getProducts(String id) {
    return consumerOrderRepository.getProducts(id);

  }

  @Override
  public ConsumerOrder createProduct(ConsumerOrder consumerOrder) {
    consumerOrderRepository.save(consumerOrder);
    return consumerOrder;
  }
  @Override
  public List<Manufacturer> getManufacturers() {
    return designerRepository.getManufacturers();
  }

  @Override
  public List<Supplier> getSuppliers() {
    return designerRepository.getSuppliers();
  }

  public Manufacturer createManufacturer(Manufacturer manufacturer)
  {
    return manufacturerRepository.save(manufacturer);
  }

  public Supplier createSupplier(Supplier supplier)
  {
    return supplierRepository.save(supplier);
  }
}
