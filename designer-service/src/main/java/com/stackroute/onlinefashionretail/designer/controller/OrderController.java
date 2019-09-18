package com.stackroute.onlinefashionretail.designer.controller;

import com.stackroute.onlinefashionretail.designer.model.DesignerOrder;
import com.stackroute.onlinefashionretail.designer.service.DesignerOrderService;
import com.stackroute.onlinefashionretail.designer.service.DesignerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping(value = "api/v1")
@RestController
public class OrderController {
    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    private DesignerOrderService designerOrderService;
    private DesignerService designerService;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC= "Kafka_Example1";

    public OrderController(DesignerOrderService designerOrderService, DesignerService designerService) {
        this.designerOrderService = designerOrderService;
        this.designerService = designerService;
    }
    ResponseEntity responseEntity;

    @PostMapping("/designs/{id}")
    public ResponseEntity<?> saveDesigns(@RequestBody DesignerOrder designer, @PathVariable String id){
        ResponseEntity responseEntity;
        logger.info("Entered into saveOrder method in OrderController");
        try {
            responseEntity = new ResponseEntity<>(designerService.saveOrder(designer,id), HttpStatus.CREATED);
        } catch (Exception exception1) {
            responseEntity = new ResponseEntity<String>(exception1.toString(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("/designs/{id}")
    public ResponseEntity<?> updateDesigns(@RequestBody DesignerOrder designer, @PathVariable String id){
        ResponseEntity responseEntity;
        logger.info("Entered into updateDesign method in OrderController");
        try {
            responseEntity = new ResponseEntity<>(designerService.updateOrder(designer,id), HttpStatus.OK);
        } catch (Exception exception1) {
            responseEntity = new ResponseEntity<String>(exception1.toString(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("/designs/{id}")
    public ResponseEntity<?> getDesignByDesignerId(@PathVariable String id)
    {
        logger.info("Enter into getDesignByDesignerId in orderController");
        return new ResponseEntity<>(designerService.getAllOrders(id),HttpStatus.OK);
    }

    @GetMapping("/designs")
    public ResponseEntity<?> getDesigns(){
        List<DesignerOrder> designerList = designerOrderService.getDesigns();
        logger.info("Entered into getDesigns in orderController");
        responseEntity=new ResponseEntity<List<DesignerOrder>>(designerList,HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/designs/{id}")
    public ResponseEntity<?> deleteDesign(@PathVariable String id){
        Optional<DesignerOrder> track1= designerOrderService.deleteDesigns(id);
        logger.info("Enter intodeleteDesigns in orderController");
        return new ResponseEntity<Optional<DesignerOrder>>(track1, HttpStatus.OK);
    }



}
