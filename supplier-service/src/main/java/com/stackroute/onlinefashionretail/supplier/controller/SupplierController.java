package com.stackroute.onlinefashionretail.supplier.controller;

import com.stackroute.onlinefashionretail.supplier.domain.Supplier;
import com.stackroute.onlinefashionretail.supplier.domain.SupplierOrder;
import com.stackroute.onlinefashionretail.supplier.services.SupplierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Supplier savedSupplier;
    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @Autowired
    private KafkaTemplate<String, Supplier> kafkaTemplate;

    private static final String TOPIC = "Login";

    //Post mapping to save the user details
    @PostMapping("supplier")
    public ResponseEntity<?> saveSupplier(@RequestBody Supplier supplier) {
        logger.info("Inside the saveSupplier");
        ResponseEntity responseEntity;
        try {
            savedSupplier=supplierService.saveSupplier(supplier);
             kafkaTemplate.send(TOPIC,savedSupplier);
             logger.info("Entered into saveSupplier try block in SupplierController");
            responseEntity = new ResponseEntity<Supplier>(savedSupplier, HttpStatus.CREATED);
        } catch (Exception ex) {
            logger.info("Entered into saveSupplier catch block in SupplierController");
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("supplier")
    public ResponseEntity<?> getAllSuppliers() {
        ResponseEntity responseEntity;
        logger.info("inside getAllSupplier");
        try {
            logger.info("Entered into getAllSupplier try block in SupplierController");
            responseEntity = new ResponseEntity<List<Supplier>>(supplierService.getAllSuppliers(), HttpStatus.OK);
        } catch (Exception exception) {
            logger.info("Entered into getAllSupplier catch block in SupplierController");
            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }



    @DeleteMapping("supplier/{id}")
    public ResponseEntity<?> deleteSupplier(@PathVariable String id) {
        ResponseEntity responseEntity;
        logger.info("Inside deleteSupplier");
        try {
            supplierService.deleteSupplier(id);
            logger.info("Entered into deleteSupplier try block in SupplierController");
            responseEntity = new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
        } catch (Exception exception) {
            logger.info("Entered into deleteSupplier catch block in SupplierController");
            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("supplier/{id}")
    public ResponseEntity<?> updateSupplier(@RequestBody Supplier supplier, @PathVariable String id) {
        ResponseEntity responseEntity;
        logger.info("inside updateSupplier");
        try {
            logger.info("Entered into updateSupplier try block in SupplierController");
            supplierService.updateSupplier(supplier,id);
            responseEntity = new ResponseEntity<List<Supplier>>(supplierService.getAllSuppliers(), HttpStatus.CREATED);
        } catch (Exception exception1) {
            logger.info("Entered into updateSupplier catch block in SupplierController");
            responseEntity = new ResponseEntity<String>(exception1.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

  @PostMapping("order")
  public ResponseEntity<?> saveOrder(@RequestBody SupplierOrder supplierOrder, @RequestParam String id) {
    ResponseEntity responseEntity;
    logger.info("inside saveOrder");
    try {
        supplierService.saveOrder(id,supplierOrder);
        logger.info("Entered into saveOrder try block in SupplierController");
        responseEntity = new ResponseEntity<String>("successfully Created", HttpStatus.CREATED);
    } catch (Exception ex) {
        logger.info("Entered into saveOrder catch block in SupplierController");
      responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
    }
    return responseEntity;
  }

  @GetMapping("order/{id}")
  public ResponseEntity<?> getAllOrders(@PathVariable String id) {
    ResponseEntity responseEntity;
    logger.info("Inside getAllOrders");
    try {
        logger.info("Entered into getAllOrders try block in SupplierController");
      responseEntity = new ResponseEntity<List<SupplierOrder>>(supplierService.getAllOrders(id), HttpStatus.OK);
    } catch (Exception exception) {
        logger.info("Entered into getAllOrders catch block in SupplierController");
      responseEntity = new ResponseEntity<String>(exception.toString(), HttpStatus.CONFLICT);
    }
    return responseEntity;
  }

  @DeleteMapping("order/{id}")
  public ResponseEntity<?> deleteOrder(@PathVariable String id) {
        logger.info("Inside deleteOrder");
    ResponseEntity responseEntity;
    try {
      supplierService.deleteOrder(id);
        logger.info("Entered into deleteOrders catch block in SupplierController");
      responseEntity = new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
    } catch (Exception exception) {
        logger.info("Entered into deleteOrders catch block in SupplierController");
      responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
    }
    return responseEntity;
  }

  @PutMapping("order/{id}")
  public ResponseEntity<?> updateOrder(@RequestBody SupplierOrder supplierOrder, @PathVariable String id) {
    ResponseEntity responseEntity;
    logger.info("Inside updateOrder");
    try {
        logger.info("Entered into updateOrders try block in SupplierController");
      responseEntity = new ResponseEntity(supplierService.updateOrder(supplierOrder,id), HttpStatus.OK);
    } catch (Exception exception1) {
        logger.info("Entered into updateOrders catch block in SupplierController");
      responseEntity = new ResponseEntity<String>(exception1.getMessage(), HttpStatus.CONFLICT);
    }
    return responseEntity;
  }

    @GetMapping("supplier/{id}")
    public ResponseEntity<?> getSupplierById(@PathVariable String id)
    {
        ResponseEntity responseEntity;
        logger.info("Inside getSupplier By Id");
        try {
            logger.info("Entered into getSupplierById try block in SupplierController"+supplierService.getSupplierById(id));
            responseEntity = new ResponseEntity<Supplier>(supplierService.getSupplierById(id), HttpStatus.OK);
        } catch (Exception exception) {
            logger.info("Entered into getSupplierById catch block in SupplierController");
            responseEntity = new ResponseEntity<String>(exception.toString(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
