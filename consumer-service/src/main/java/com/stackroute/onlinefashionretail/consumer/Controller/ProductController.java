package com.stackroute.onlinefashionretail.consumer.Controller;

import com.stackroute.onlinefashionretail.consumer.Domain.Product;
import com.stackroute.onlinefashionretail.consumer.Exception.Product.ProductAlreadyExistsException;
import com.stackroute.onlinefashionretail.consumer.Exception.Product.ProductNotFoundException;
import com.stackroute.onlinefashionretail.consumer.Service.Interface.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("api/v1")
public class ProductController {
    private final ProductService productService;
    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("product")
    public ResponseEntity<?> addProduct(@RequestBody Product product) throws ProductAlreadyExistsException {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping("product")
    public ResponseEntity<?> removeProduct(@RequestBody Product product) throws ProductNotFoundException {
        return new ResponseEntity<>(productService.removeProduct(product), HttpStatus.OK);
    }

    @PutMapping("product/image/{id}")
    public ResponseEntity<?> editImage(@PathVariable String id, @RequestBody Map<String,Object> body) throws ProductNotFoundException {
        return new ResponseEntity<>(productService.editImage(id, body.get("image").toString()), HttpStatus.OK);
    }

    @PutMapping("product/price/{id}")
    public ResponseEntity<?> editPrice(@PathVariable String id, @RequestBody Map<String,Object> body) throws ProductNotFoundException {
        return new ResponseEntity<>(productService.editPrice(id, Double.parseDouble(body.get("price").toString())), HttpStatus.OK);
    }

    @PutMapping("product/rating/{id}")
    public ResponseEntity<?> editRating(@PathVariable String id, @RequestBody Map<String,Object> body) throws ProductNotFoundException {
        return new ResponseEntity<>(productService.editRating(id, Float.parseFloat(body.get("rating").toString())), HttpStatus.OK);
    }

    @PutMapping("product/discount/{id}")
    public ResponseEntity<?> editDiscount(@PathVariable String id, @RequestBody Map<String,Object> body) throws ProductNotFoundException {
        return new ResponseEntity<>(productService.editDiscount(id, Double.parseDouble(body.get("discount").toString())), HttpStatus.OK);
    }

    @GetMapping("product")
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("product/{id}")
    public ResponseEntity<?> getProductById(@PathVariable String id) throws ProductNotFoundException {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }
}
