package com.stackroute.onlinefashionretail.supplier.controller;

import com.stackroute.onlinefashionretail.supplier.services.MappingService;
import com.stackroute.onlinefashionretail.supplier.domain.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="api/v1")
public class MappingController {

  private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
  
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

  @PostMapping("material")
  public ResponseEntity<?> saveMaterial(@RequestBody Mapping mapping) {
    logger.info("Inside saveMaterial");
    logger.info(mapping.toString());
    ResponseEntity responseEntity;
    try {
      logger.info(" Entered into saveMaterial method In try block (MappingController)");
      savedMapping = mappingService.saveMapping(mapping);
      logger.info(savedMapping.toString());
      kafkaTemplate.send(TOPIC,savedMapping);
      responseEntity = new ResponseEntity<Mapping>(savedMapping, HttpStatus.CREATED);
    } catch (Exception ex) {
      logger.info("Entered intos aveMaterial method In exception block(MappingController)");
      logger.info(ex.toString());
      responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
    }
    return responseEntity;
  }

  @GetMapping("material")
  public ResponseEntity<?> getAllMaterials(@RequestParam String email) {
    logger.info("Inside saveMterial");
    ResponseEntity responseEntity;
    try {
      logger.info("Entered into getAllMterial in mapping controller");
      responseEntity = new ResponseEntity<>(mappingService.getAllMappings(email), HttpStatus.OK);
    } catch (Exception exception) {
      logger.info("Entered into getAllMaterial catch in mapping controller");

      responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
    }
    return responseEntity;
  }

  @GetMapping("materials")
  public ResponseEntity<?> getMaterials() {
    logger.info("Inside getMaterial");
    ResponseEntity responseEntity;
    try {
      logger.info("Entered into getMaterial in mapping controller");
      responseEntity = new ResponseEntity<>(mappingService.getMappings(), HttpStatus.OK);
    } catch (Exception exception) {
      logger.info(" Entered into getMaterial  catch in mapping controller");

      responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
    }
    return responseEntity;
  }

  @DeleteMapping("material/{id}")
  public ResponseEntity<?> deleteMaterial(@PathVariable String id) {
    logger.info("inside the deleteMaterial");
    ResponseEntity responseEntity;
    try {
      mappingService.deleteMapping(id);
      logger.info("Entered into deleteMaterial try block in MappingController ");
      responseEntity = new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
    } catch (Exception exception) {
      logger.info(" Entered into deleteMaterial  catch in mapping controller");
      responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
    }
    return responseEntity;
  }

  @PutMapping("material/{id}")
  public ResponseEntity<?> updateMaterial(@RequestBody Mapping mapping, @PathVariable String id) {
    logger.info("Inside the updateMteial");
    ResponseEntity responseEntity;
    try {
      logger.info(" Entered into updateMaterial try block in mapping controller");
      responseEntity = new ResponseEntity<>(mappingService.updateMapping(mapping,id), HttpStatus.OK);
    } catch (Exception exception1) {
      logger.info(" Entered into updateMaterial  catch in mapping controller");
      responseEntity = new ResponseEntity<String>(exception1.getMessage(), HttpStatus.CONFLICT);
    }
    return responseEntity;
  }
}
