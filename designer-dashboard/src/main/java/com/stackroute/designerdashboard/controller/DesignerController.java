package com.stackroute.designerdashboard.controller;

import com.stackroute.designerdashboard.model.Designer;
import com.stackroute.designerdashboard.service.DesignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
//@RequestMapping(value="api/v1")
public class DesignerController {

    DesignerService designerService;
    Designer designer = new Designer();

    @Autowired
    public DesignerController(DesignerService designerService) {
        this.designerService = designerService;
    }

//    @Autowired
//    private KafkaTemplate<String, Designer> kafkaTemplate;
//
//    private static final String TOPIC = "Kafka_Example";
//
//    @PostMapping("publish")
//    public String post() {
//        kafkaTemplate.send(TOPIC, new Designer(designer.getId(), designer.getName(), designer.getEmail());
//        return "Published successfully";
//    }

    //Post mapping to save the user details
    @PostMapping("designer")
    public ResponseEntity<?> saveDesigner(@RequestBody Designer designer) {
        ResponseEntity responseEntity;
        try {
            designerService.saveDesigner(designer);
            responseEntity = new ResponseEntity<String>("successfully Created", HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("designer/{id}")
    public ResponseEntity<?> getDesigner(@PathVariable int id) {
        ResponseEntity responseEntity;

        try {
            responseEntity = new ResponseEntity<>(designerService.getDesigner(id), HttpStatus.OK);
        } catch (Exception exception) {

            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("designer")
    public ResponseEntity<?> getAllDesigners() {
        ResponseEntity responseEntity;

        try {
            responseEntity = new ResponseEntity<List<Designer>>(designerService.getAllDesigners(), HttpStatus.OK);
        } catch (Exception exception) {

            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("designer/{id}")
    public ResponseEntity<?> deleteDesigner(@PathVariable int id) {
        ResponseEntity responseEntity;
        try {
            designerService.deleteDesigner(id);
            responseEntity = new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("designer/{id}")
    public ResponseEntity<?> updateDesigner(@RequestBody Designer designer, @PathVariable int id) {
        ResponseEntity responseEntity;
        try {
            designerService.updateDesigner(designer,id);
            responseEntity = new ResponseEntity<>(designerService.getDesigner(id), HttpStatus.CREATED);
        } catch (Exception exception1) {
            responseEntity = new ResponseEntity<String>(exception1.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
