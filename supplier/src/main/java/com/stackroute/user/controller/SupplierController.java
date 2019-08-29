package com.stackroute.user.controller;

import com.stackroute.user.domain.Supplier;
import com.stackroute.user.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="api/v1")
public class SupplierController {

    SupplierService supplierService;
    Supplier supplier = new Supplier();

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @Autowired
    private KafkaTemplate<String, Supplier> kafkaTemplate1;

    private static final String TOPIC = "Kafka_Example";

    @PostMapping("publish")
    public String post() {
        kafkaTemplate1.send(TOPIC, new Supplier(supplier.getId(), supplier.getName() , supplier.getEmail(), supplier.getCity() , supplier.getRating()));
        return "Published successfully";
    }

    //Post mapping to save the user details
    @PostMapping("supplier")
    public ResponseEntity<?> saveSupplier(@RequestBody Supplier supplier) {
        ResponseEntity responseEntity;
        try {
            supplierService.saveSupplier(supplier);
            responseEntity = new ResponseEntity<String>("successfully Created", HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("supplier")
    public ResponseEntity<?> getAllSuppliers() {
        ResponseEntity responseEntity;

        try {
            responseEntity = new ResponseEntity<List<Supplier>>(supplierService.getAllSuppliers(), HttpStatus.OK);
        } catch (Exception exception) {

            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("supplier/{id}")
    public ResponseEntity<?> deleteSupplier(@PathVariable int id) {
        ResponseEntity responseEntity;
        try {
            supplierService.deleteSupplier(id);
            responseEntity = new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("supplier/{id}")
    public ResponseEntity<?> updateSupplier(@RequestBody Supplier supplier, @PathVariable int id) {
        ResponseEntity responseEntity;
        try {
            supplierService.updateSupplier(supplier,id);
            responseEntity = new ResponseEntity<List<Supplier>>(supplierService.getAllSuppliers(), HttpStatus.CREATED);
        } catch (Exception exception1) {
            responseEntity = new ResponseEntity<String>(exception1.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
