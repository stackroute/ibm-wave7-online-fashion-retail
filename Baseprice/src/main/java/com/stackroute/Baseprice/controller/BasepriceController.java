package com.stackroute.Baseprice.controller;

import com.stackroute.Baseprice.domain.Baseprice;
import com.stackroute.Baseprice.service.BasepriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
//@RequestMapping(value="api/v1")
public class BasepriceController
{
    BasepriceService basepriceService;
//        Baseprice baseprice = new Baseprice();

        @Autowired
        public BasepriceController(BasepriceService basepriceService) {
            this.basepriceService = basepriceService;
        }

        @Autowired
        private KafkaTemplate<String, Baseprice> kafkaTemplate;

        private static final String TOPIC = "Kafka_Example";


        //Post mapping to save the user details
        @PostMapping("baseprice")
        public ResponseEntity<?> save(@RequestBody Baseprice baseprice) {
            ResponseEntity responseEntity;
            try {
                basepriceService.saveBaseprice(baseprice);
                responseEntity = new ResponseEntity<String>("successfully Created", HttpStatus.CREATED);
            } catch (Exception ex) {
                responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
            }
            return responseEntity;
        }

        @GetMapping("baseprice")
        public ResponseEntity<?> getAllBasepriceDetails() {
            ResponseEntity responseEntity;

            try {
                responseEntity = new ResponseEntity<List<Baseprice>>(basepriceService.getAllBaseprice(), HttpStatus.OK);
            } catch (Exception exception) {

                responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
            }
            return responseEntity;
        }

        @DeleteMapping("baseprice/{id}")
        public ResponseEntity<?> delete(@PathVariable int id) {
            ResponseEntity responseEntity;
            try {
                basepriceService.deleteBaseprice(id);
                responseEntity = new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
            } catch (Exception exception) {
                responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
            }
            return responseEntity;
        }

        @PutMapping("baseprice/{id}")
        public ResponseEntity<?> updatedetails(@RequestBody Baseprice baseprice, @PathVariable int id) {
            ResponseEntity responseEntity;
            try {
                basepriceService.updateBaseprice(baseprice,id);
                responseEntity = new ResponseEntity<List<Baseprice>>(basepriceService.getAllBaseprice(), HttpStatus.CREATED);
            } catch (Exception exception1) {
                responseEntity = new ResponseEntity<String>(exception1.getMessage(), HttpStatus.CONFLICT);
            }
            return responseEntity;
        }
}
