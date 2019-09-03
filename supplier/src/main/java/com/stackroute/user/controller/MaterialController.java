package com.stackroute.user.controller;

import com.stackroute.user.domain.Material;
import com.stackroute.user.domain.Supplier;
import com.stackroute.user.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="api/v2")
public class MaterialController {

    MaterialService materialService;
    Material material = new Material();


  @Autowired
  public MaterialController(MaterialService materialService) {
    this.materialService = materialService;
  }

  @Autowired
  private KafkaTemplate<String, Material> kafkaTemplate2;

  private static final String TOPIC = "Kafka_Example";


  //Post mapping to save the user details
  @PostMapping("material")
  public ResponseEntity<?> saveMaterial(@RequestBody Material material) {
    ResponseEntity responseEntity;
    try {
      materialService.saveMaterial(material);
      kafkaTemplate2.send(TOPIC,material);
      responseEntity = new ResponseEntity<String>("successfully Created", HttpStatus.CREATED);
    } catch (Exception ex) {
      responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
    }
    return responseEntity;
  }

  @GetMapping("material")
  public ResponseEntity<?> getAllMaterials() {
    ResponseEntity responseEntity;

    try {
      responseEntity = new ResponseEntity<List<Material>>(materialService.getAllMaterials(), HttpStatus.OK);
    } catch (Exception exception) {

      responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
    }
    return responseEntity;
  }

  @DeleteMapping("material/{id}")
  public ResponseEntity<?> deleteMaterial(@PathVariable int id) {
    ResponseEntity responseEntity;
    try {
      materialService.deleteMaterial(id);
      responseEntity = new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
    } catch (Exception exception) {
      responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
    }
    return responseEntity;
  }

  @PutMapping("material/{id}")
  public ResponseEntity<?> updateMaterial(@RequestBody Material material, @PathVariable int id) {
    ResponseEntity responseEntity;
    try {
      materialService.updateMaterial(material,id);
      responseEntity = new ResponseEntity<List<Material>>(materialService.getAllMaterials(), HttpStatus.CREATED);
    } catch (Exception exception1) {
      responseEntity = new ResponseEntity<String>(exception1.getMessage(), HttpStatus.CONFLICT);
    }
    return responseEntity;
  }
}
