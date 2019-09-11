package com.stackroute.designerdashboard.controller;

import com.stackroute.designerdashboard.model.DesignerOrder;
import com.stackroute.designerdashboard.service.DesignerOrderService;
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
    private DesignerOrderService designerOrderService;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC= "Kafka_Example1";

    public OrderController(DesignerOrderService designerOrderService) {
        this.designerOrderService = designerOrderService;
    }
    ResponseEntity responseEntity;

    @PostMapping("/designs")
    public ResponseEntity<?> saveDesigns(@RequestBody DesignerOrder designer){
        try {
            DesignerOrder designer1= designerOrderService.saveDesigns(designer);
            System.out.println(designer1);
            String id= designer1.getId();
            kafkaTemplate.send(TOPIC,id);
            responseEntity = new ResponseEntity<DesignerOrder>(designer1, HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("/designs")
    public ResponseEntity<?> updateDesigns(@RequestBody DesignerOrder designer, @RequestParam String id){
        try {
            DesignerOrder designer1= designerOrderService.updateDesigns(designer,id);
            responseEntity = new ResponseEntity<DesignerOrder>(designer1, HttpStatus.CREATED);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/designs")
    public ResponseEntity<?> getDesigns(){
        List<DesignerOrder> designerList = designerOrderService.getDesigns();
        responseEntity=new ResponseEntity<List<DesignerOrder>>(designerList,HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/designs/{id}")
    public ResponseEntity<?> deleteDesign(@PathVariable String id){
        Optional<DesignerOrder> track1= designerOrderService.deleteDesigns(id);
        return new ResponseEntity<Optional<DesignerOrder>>(track1, HttpStatus.OK);
    }

    @GetMapping("/designs/{id}")
    public ResponseEntity<?> getDesignById(@PathVariable String id)
    {
        return new ResponseEntity<Optional<DesignerOrder>>(designerOrderService.getOrderById(id),HttpStatus.OK);
    }

}
