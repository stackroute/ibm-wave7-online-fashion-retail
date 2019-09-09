package com.stackroute.manufacture.controller;

import com.stackroute.manufacture.domain.BasePrice;
import com.stackroute.manufacture.services.BasepriceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
//@RequestMapping(value="api/v1")
public class BasepriceController
{
    BasepriceService basepriceService;

        public BasepriceController(BasepriceService basepriceService) {
            this.basepriceService = basepriceService;
        }


        //Post mapping to save the user details
        @PostMapping("baseprice")
        public ResponseEntity<?> save(@RequestBody BasePrice baseprice) {
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
                responseEntity = new ResponseEntity<List<BasePrice>>(basepriceService.getAllBaseprice(), HttpStatus.OK);
            } catch (Exception exception) {

                responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
            }
            return responseEntity;
        }

        @DeleteMapping("baseprice/{id}")
        public ResponseEntity<?> delete(@PathVariable String id) {
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
        public ResponseEntity<?> updatedetails(@RequestBody BasePrice baseprice, @PathVariable String id) {
            ResponseEntity responseEntity;
            try {
                basepriceService.updateBaseprice(baseprice,id);
                responseEntity = new ResponseEntity<List<BasePrice>>(basepriceService.getAllBaseprice(), HttpStatus.CREATED);
            } catch (Exception exception1) {
                responseEntity = new ResponseEntity<String>(exception1.getMessage(), HttpStatus.CONFLICT);
            }
            return responseEntity;
        }
}
