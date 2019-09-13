package com.stackroute.onlinefashionretail.manufacturer.controller;

import com.stackroute.onlinefashionretail.manufacturer.domain.BasePrice;
import com.stackroute.onlinefashionretail.manufacturer.services.BasepriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="api/v1")
public class BasepriceController {

    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    BasepriceService basepriceService;

    public BasepriceController(BasepriceService basepriceService) {
            this.basepriceService = basepriceService;
        }

        //Post mapping to save the user details
        @PostMapping("baseprice")
        public ResponseEntity<?> save(@RequestBody BasePrice baseprice) {
        logger.info("Inside save");
            ResponseEntity responseEntity;
            try {
                logger.info("Inside save method try block in BasePriceController");
                basepriceService.saveBaseprice(baseprice);
                responseEntity = new ResponseEntity<String>("successfully Created", HttpStatus.CREATED);
            } catch (Exception ex) {
                logger.info("Inside save method catch block in BasePriceController");
                responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
            }
            return responseEntity;
        }

        @GetMapping("baseprice")
        public ResponseEntity<?> getAllBasepriceDetails() {
            ResponseEntity responseEntity;

            try {
                logger.info("Inside getAllBasepricedetails method try block in BasePriceController");
                responseEntity = new ResponseEntity<List<BasePrice>>(basepriceService.getAllBaseprice(), HttpStatus.OK);
            } catch (Exception exception) {
                logger.info("Inside getAllBasepriceDetails method catch block in BasePriceController");
                responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
            }
            return responseEntity;
        }

        @DeleteMapping("baseprice/{id}")
        public ResponseEntity<?> delete(@PathVariable String id) {
            ResponseEntity responseEntity;
            try {
                logger.info("Inside delete method try block in BasePriceController");
                basepriceService.deleteBaseprice(id);
                responseEntity = new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
            } catch (Exception exception) {
                logger.info("Inside delete method catch block in BasePriceController");
                responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
            }
            return responseEntity;
        }

        @PutMapping("baseprice/{id}")
        public ResponseEntity<?> updateDetails(@RequestBody BasePrice baseprice, @PathVariable String id) {
            ResponseEntity responseEntity;
            try {
                logger.info("Inside updateDatils method try block in BasePriceController");
                basepriceService.updateBaseprice(baseprice,id);
                responseEntity = new ResponseEntity<List<BasePrice>>(basepriceService.getAllBaseprice(), HttpStatus.CREATED);
            } catch (Exception exception1) {
                logger.info("Inside updateDatils method catch block in BasePriceController");
                responseEntity = new ResponseEntity<String>(exception1.getMessage(), HttpStatus.CONFLICT);
            }
            return responseEntity;
        }
}
