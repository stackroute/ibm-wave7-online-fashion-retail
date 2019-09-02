package com.stackroute.manufacture.controller;

import com.stackroute.manufacture.domain.Manufacture;
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
    Manufacture savedManufacture;
    Manufacture manufacture = new Manufacture();

    @Autowired
    public ManufactureController(ManufactureService manufactureService) {
        this.manufactureService = manufactureService;
    }

    @Autowired
    private KafkaTemplate<String, Manufacture> kafkaTemplate;

    private static final String TOPIC = "Kafka_Example";

    //Post mapping to save the user details
    @PostMapping("manufacture")
    public ResponseEntity<?> save(@RequestBody Manufacture manufacture) {
        ResponseEntity responseEntity;
        try {
            savedManufacture=manufactureService.saveManufacture(manufacture);
            kafkaTemplate.send(TOPIC,savedManufacture);
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
            responseEntity = new ResponseEntity<List<Manufacture>>(manufactureService.getAllManufactures(), HttpStatus.OK);
        } catch (Exception exception) {

            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("manufacture/{id}")
    public ResponseEntity<?> getDesigner(@PathVariable int id) {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<>(manufactureService.getManufacture(id), HttpStatus.OK);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("manufacture/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
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
    public ResponseEntity<?> updatedetails(@RequestBody Manufacture manufacture, @PathVariable int id) {
        ResponseEntity responseEntity;
        try {
            manufactureService.updateManufacture(manufacture,id);
            responseEntity = new ResponseEntity<List<Manufacture>>(manufactureService.getAllManufactures(), HttpStatus.CREATED);
        } catch (Exception exception1) {
            responseEntity = new ResponseEntity<String>(exception1.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
