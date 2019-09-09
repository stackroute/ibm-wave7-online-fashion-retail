package com.stackroute.manufacture.controller;

import com.stackroute.manufacture.domain.Manufacturer;
import com.stackroute.manufacture.services.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
//@RequestMapping(value="api/v1")
public class ManufactureController {

    ManufactureService manufactureService;
    Manufacturer savedManufacturer;
    Manufacturer manufacturer = new Manufacturer();

    @Autowired
    public ManufactureController(ManufactureService manufactureService) {
        this.manufactureService = manufactureService;
    }

    @Autowired
    private KafkaTemplate<String, Manufacturer> kafkaTemplate;
    private static final String TOPIC = "Kafka_Example";


    //Post mapping to save the user details
    @PostMapping("manufacture")
    public ResponseEntity<?> save(@RequestBody Manufacturer manufacturer) {
        ResponseEntity responseEntity;
        try {
            savedManufacturer =manufactureService.saveManufacture(manufacturer);
            kafkaTemplate.send(TOPIC, savedManufacturer);
            responseEntity = new ResponseEntity<String>("successfully Created", HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("manufacture")
    public ResponseEntity<?> getAllManufactureDetails() {
        ResponseEntity responseEntity;

        try {
            responseEntity = new ResponseEntity<List<Manufacturer>>(manufactureService.getAllManufactures(), HttpStatus.OK);
        } catch (Exception exception) {

            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("manufacture/{id}")
    public ResponseEntity<?> getDesigner(@PathVariable String id) {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<>(manufactureService.getManufacture(id), HttpStatus.OK);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("manufacture/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        ResponseEntity responseEntity;
        try {
            manufactureService.deleteManufacture(id);
            responseEntity = new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("manufacture/{id}")
    public ResponseEntity<?> updatedetails(@RequestBody Manufacturer manufacturer, @PathVariable String id) {
        ResponseEntity responseEntity;
        try {
            manufactureService.updateManufacture(manufacturer,id);
            responseEntity = new ResponseEntity<List<Manufacturer>>(manufactureService.getAllManufactures(), HttpStatus.CREATED);
        } catch (Exception exception1) {
            responseEntity = new ResponseEntity<String>(exception1.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
