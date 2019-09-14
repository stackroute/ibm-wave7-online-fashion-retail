package com.stackroute.neo4j.controller;

import com.stackroute.neo4j.entity.ConsumerOrder;
import com.stackroute.neo4j.entity.Manufacturer;
import com.stackroute.neo4j.entity.Product;
import com.stackroute.neo4j.entity.Supplier;
import com.stackroute.neo4j.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class RecommendationController {
  @Autowired
  private RecommendationService recommendationService;

  public RecommendationController(RecommendationService recommendationService) {
    this.recommendationService = recommendationService;
  }

  @PostMapping("manufacturer")
  public Manufacturer createManufacturer(@RequestBody Manufacturer manufacturer)
  {
    return recommendationService.createManufacturer(manufacturer);
  }
  @PostMapping("supplier")
  public Supplier createSupplier(@RequestBody Supplier supplier)
  {
    return recommendationService.createSupplier(supplier);
  }
  @GetMapping("product/{id}")
  public ResponseEntity<List<Product>> getProducts(@PathVariable String id)
  {
    return new ResponseEntity<List<Product>>(recommendationService.getProducts(id), HttpStatus.OK);
  }
  @PostMapping("consumerorder")
  public ResponseEntity<ConsumerOrder> createOrder(@RequestBody ConsumerOrder consumerOrder)
  {
    return new ResponseEntity<>(recommendationService.createProduct(consumerOrder),HttpStatus.OK);
  }
  @GetMapping("getmanufacturers")
  public ResponseEntity<List<Manufacturer>> getManufacturers()
  {
    return new ResponseEntity<List<Manufacturer>>(recommendationService.getManufacturers(),HttpStatus.OK);
  }
  @GetMapping("getsuppliers")
  public ResponseEntity<List<Supplier>> getSuppliers()
  {
    return new ResponseEntity<List<Supplier>>(recommendationService.getSuppliers(),HttpStatus.OK);
  }
}
