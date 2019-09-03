package com.stackroute.designerdashboard.controller;

import com.stackroute.designerdashboard.model.Dorder;
import com.stackroute.designerdashboard.service.OderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class OrderController {
    private OderService oderService;

    @Autowired
    private KafkaTemplate<String, Dorder> kafkaTemplate;

    private static final String TOPIC= "Kafka_Example1";

    public OrderController(OderService oderService) {
        this.oderService = oderService;
    }
    ResponseEntity responseEntity;

    @PostMapping("/designs")
    public ResponseEntity<?> saveDesigns(@RequestBody Dorder designer){

        try {
            Dorder designer1= oderService.saveDesigns(designer);
            kafkaTemplate.send(TOPIC,designer1);
            responseEntity = new ResponseEntity<Dorder>(designer1, HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/designs")
    public ResponseEntity<?> getDesigns(){
        List<Dorder> designerList = oderService.getDesigns();
        responseEntity=new ResponseEntity<List<Dorder>>(designerList,HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/designs/{id}")
    public ResponseEntity<?> deleteDesign(@PathVariable int id){
        Optional<Dorder> track1=oderService.deleteDesigns(id);
        return new ResponseEntity<Optional<Dorder>>(track1, HttpStatus.OK);
    }

}
