package com.stackroute.onlinefashionretail.consumer.controller;

import com.stackroute.onlinefashionretail.consumer.domain.Product;
import com.stackroute.onlinefashionretail.consumer.exception.Product.ProductAlreadyExistsException;
import com.stackroute.onlinefashionretail.consumer.exception.Product.ProductNotFoundException;
import com.stackroute.onlinefashionretail.consumer.service.interfaces.ProductService;
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
        logger.info("Entered into addProduct method in ProductController");
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping("product")
    public ResponseEntity<?> removeProduct(@RequestBody Product product) throws ProductNotFoundException {
        logger.info("Entered into removeProduct method in ProductController");
        return new ResponseEntity<>(productService.removeProduct(product), HttpStatus.OK);
    }

    @PutMapping("product/image/{id}")
    public ResponseEntity<?> editImage(@PathVariable String id, @RequestBody Map<String,Object> body) throws ProductNotFoundException {
        logger.info("Entered into editImage method in ProductController");
        return new ResponseEntity<>(productService.editImage(id, body.get("image").toString()), HttpStatus.OK);
    }

    @PutMapping("product/price/{id}")
    public ResponseEntity<?> editPrice(@PathVariable String id, @RequestBody Map<String,Object> body) throws ProductNotFoundException {
        logger.info("Entered into editPrice method in ProductController");
        return new ResponseEntity<>(productService.editPrice(id, Double.parseDouble(body.get("price").toString())), HttpStatus.OK);
    }

    @PutMapping("product/rating/{id}")
    public ResponseEntity<?> editRating(@PathVariable String id, @RequestBody Map<String,Object> body) throws ProductNotFoundException {
        logger.info("Entered into editRating method in ProductController");
        return new ResponseEntity<>(productService.editRating(id, Float.parseFloat(body.get("rating").toString())), HttpStatus.OK);
    }

    @PutMapping("product/discount/{id}")
    public ResponseEntity<?> editDiscount(@PathVariable String id, @RequestBody Map<String,Object> body) throws ProductNotFoundException {
        logger.info("Entered into editDiscount method in ProductController");
        return new ResponseEntity<>(productService.editDiscount(id, Double.parseDouble(body.get("discount").toString())), HttpStatus.OK);
    }

    @GetMapping("product")
    public ResponseEntity<?> getAllProducts() {
        logger.info("Entered into getAllProducts method in ProductController");
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("product/{id}")
    public ResponseEntity<?> getProductById(@PathVariable String id) throws ProductNotFoundException {
        logger.info("Entered into getProductByid method in ProductController");
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @GetMapping("product/search")
    public ResponseEntity<?> searchProduct(@RequestParam String searchText){
        logger.info("Entered into searchProduct method in ProductController");
        return new ResponseEntity<>(productService.searchProduct(searchText), HttpStatus.OK);
    }
}
