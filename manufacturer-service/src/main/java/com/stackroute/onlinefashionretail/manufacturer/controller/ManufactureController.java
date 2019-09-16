package com.stackroute.onlinefashionretail.manufacturer.controller;

import com.stackroute.onlinefashionretail.manufacturer.domain.Manufacturer;
import com.stackroute.onlinefashionretail.manufacturer.domain.ManufacturerOrder;
import com.stackroute.onlinefashionretail.manufacturer.services.ManufactureService;
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
public class ManufactureController {

    ManufactureService manufactureService;
    Manufacturer savedManufacturer;
    Manufacturer manufacturer = new Manufacturer();
    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ManufactureController(ManufactureService manufactureService) {
        this.manufactureService = manufactureService;
    }

    @Autowired
    private KafkaTemplate<String, Manufacturer> kafkaTemplate;
    private static final String TOPIC = "Kafka_Example";

    @GetMapping("test")
    public String test() {
        return "HI Service is up";    
    }

    //Post mapping to save the user details
    @PostMapping("manufacture")
    public ResponseEntity<?> save(@RequestBody Manufacturer manufacturer) {
        ResponseEntity responseEntity;
        try {
            logger.info("Inside save method try block in ManufacturerController");
            savedManufacturer =manufactureService.saveManufacture(manufacturer);
            kafkaTemplate.send(TOPIC, savedManufacturer);
            responseEntity = new ResponseEntity<String>("successfully Created", HttpStatus.CREATED);
        } catch (Exception ex) {
            logger.info("Inside save method catch block in ManufacturerController");
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("manufacture")
    public ResponseEntity<?> getAllManufactureDetails() {
        ResponseEntity responseEntity;
        try {
            logger.info("Inside getAllManufacturerDetails method try block in ManufacturerController");
            responseEntity = new ResponseEntity<List<Manufacturer>>(manufactureService.getAllManufactures(), HttpStatus.OK);
        } catch (Exception exception) {
            logger.info("Inside getAllManufacturerDetails method catch block in ManufacturerController");
            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("manufacture/{id}")
    public ResponseEntity<?> getManufacturer(@PathVariable String id) {
        ResponseEntity responseEntity;
        try {
            logger.info("Inside getDesigner method try block in ManufacturerController");
            responseEntity = new ResponseEntity<>(manufactureService.getManufacture(id), HttpStatus.OK);
        } catch (Exception exception) {
            logger.info("Inside getDesigner method catch block in ManufacturerController");
            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("manufacture/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        ResponseEntity responseEntity;
        try {
            logger.info("Inside delete method try block in ManufacturerController");
            manufactureService.deleteManufacture(id);
            responseEntity = new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
        } catch (Exception exception) {
            logger.info("Inside delete method catch block in ManufacturerController");
            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("manufacture/{id}")
    public ResponseEntity<?> updatedetails(@RequestBody Manufacturer manufacturer, @PathVariable String id) {
        ResponseEntity responseEntity;
        try {
            logger.info("Inside updateDetails method try block in ManufacturerController");
            manufactureService.updateManufacture(manufacturer,id);
            responseEntity = new ResponseEntity<List<Manufacturer>>(manufactureService.getAllManufactures(), HttpStatus.CREATED);
        } catch (Exception exception1) {
            logger.info("Inside updateDetails method catch block in ManufacturerController");
            responseEntity = new ResponseEntity<String>(exception1.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PostMapping("manufactureOrder")
    public ResponseEntity<?> saveOrder(@RequestBody ManufacturerOrder manufacturerOrder, @RequestParam String id) {
        ResponseEntity responseEntity;
        try {
            System.out.println("In try order");
            manufactureService.saveOrder(id,manufacturerOrder);
            responseEntity = new ResponseEntity<String>("successfully Created", HttpStatus.CREATED);
        } catch (Exception ex) {
            System.out.println("in exception order");
            System.out.println(ex);
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("manufactureOrder/{id}")
    public ResponseEntity<?> getAllOrders(@PathVariable String id) {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<List<ManufacturerOrder>>(manufactureService.getAllOrders(id), HttpStatus.OK);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity<String>(exception.toString(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @DeleteMapping("manufactureOrder/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable String id) {
        ResponseEntity responseEntity;
        try {
            manufactureService.deleteOrder(id);
            responseEntity = new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @PutMapping("manufactureOrder/{id}")
    public ResponseEntity<?> updateOrder(@RequestBody ManufacturerOrder manufacturerOrder, @PathVariable String id) {
        ResponseEntity responseEntity;
        System.out.println(manufacturerOrder);
        try {
            responseEntity = new ResponseEntity(manufactureService.updateOrder(manufacturerOrder,id), HttpStatus.OK);
            System.out.println(responseEntity);
        } catch (Exception exception1) {
            responseEntity = new ResponseEntity<String>(exception1.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
