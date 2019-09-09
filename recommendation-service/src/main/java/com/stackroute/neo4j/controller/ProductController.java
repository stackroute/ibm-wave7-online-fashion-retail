package com.stackroute.neo4j.controller;

import com.stackroute.neo4j.entity.Product;
import com.stackroute.neo4j.service.ProductService;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product)
    {
        return  new ResponseEntity<Product>(productService.createProduct(product), HttpStatus.OK);
    }
    @GetMapping("/product")
    public ResponseEntity<Iterable<Product>> getProducts()
    {
        return new ResponseEntity<Iterable<Product>>(productService.getProducts(),HttpStatus.OK);
    }
    @PutMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product)
    {
        product.setPrice(product.getPrice());
        product.setRating(product.getRating());
        return new ResponseEntity<Product>(productService.updateProduct(product),HttpStatus.OK);
    }
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable String id)
    {
        productService.deleteProduct(id);
    }



}
