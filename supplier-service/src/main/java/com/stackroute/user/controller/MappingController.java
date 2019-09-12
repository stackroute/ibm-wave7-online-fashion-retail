package com.stackroute.user.controller;

import com.stackroute.user.services.MappingService;
import com.stackroute.user.domain.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value="api/v2")
public class MappingController {


  private MappingService mappingService;
  Mapping savedMapping;

  @Autowired
  private KafkaTemplate<String, Mapping> kafkaTemplate;

  private static final String TOPIC = "Login";

  @Autowired
  public MappingController(MappingService mappingService, KafkaTemplate<String, Mapping> kafkaTemplate2) {
    this.mappingService = mappingService;
    this.kafkaTemplate = kafkaTemplate2;
  }

  //@PostMapping("publish")
//  private String post(Mapping mapping) {
//    kafkaTemplate2.send(TOPIC,mapping);
//    return "Published successfully";
//  }

  //Post mapping to save the user details
  @PostMapping("material")
  public ResponseEntity<?> saveMaterial(@RequestBody Mapping mapping) {
    System.out.println("in here");
    System.out.println(mapping.toString());
    ResponseEntity responseEntity;
    try {
      System.out.println("In try block");
      savedMapping = mappingService.saveMapping(mapping);
      System.out.println(savedMapping);
      kafkaTemplate.send(TOPIC,savedMapping);
      responseEntity = new ResponseEntity<String>("successfully Created", HttpStatus.CREATED);
    } catch (Exception ex) {
      System.out.println("In exception block");
      System.out.println(ex.toString());
      responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
    }
    return responseEntity;
  }

  @GetMapping("material")
  public ResponseEntity<?> getAllMaterials(@RequestParam String email) {
    ResponseEntity responseEntity;

    try {
      System.out.println("in get all in mapping controller");
      responseEntity = new ResponseEntity<>(mappingService.getAllMappings(email), HttpStatus.OK);
    } catch (Exception exception) {
      System.out.println("in catch in mapping controller");

      responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
    }
    return responseEntity;
  }

  @GetMapping("materials")
  public ResponseEntity<?> getMaterials() {
    ResponseEntity responseEntity;

    try {
      System.out.println("in get all in mapping controller");
      responseEntity = new ResponseEntity<>(mappingService.getMappings(), HttpStatus.OK);
    } catch (Exception exception) {
      System.out.println("in catch in mapping controller");

      responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
    }
    return responseEntity;
  }

  @DeleteMapping("material/{id}")
  public ResponseEntity<?> deleteMaterial(@PathVariable String id) {
    ResponseEntity responseEntity;
    try {
      mappingService.deleteMapping(id);
      responseEntity = new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
    } catch (Exception exception) {
      responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
    }
    return responseEntity;
  }

  @PutMapping("material/{id}")
  public ResponseEntity<?> updateMaterial(@RequestBody Mapping mapping, @PathVariable String id) {
    ResponseEntity responseEntity;
    try {

      responseEntity = new ResponseEntity<>(mappingService.updateMapping(mapping,id), HttpStatus.OK);
    } catch (Exception exception1) {
      responseEntity = new ResponseEntity<String>(exception1.getMessage(), HttpStatus.CONFLICT);
    }
    return responseEntity;
  }
}
