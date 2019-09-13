package com.stackroute.onlinefashionretail.consumer.controller;

import com.stackroute.onlinefashionretail.consumer.domain.Address;
import com.stackroute.onlinefashionretail.consumer.domain.ConsumerOrder;
import com.stackroute.onlinefashionretail.consumer.exception.ConsumerOrder.ConsumerOrderAlreadyExistsException;
import com.stackroute.onlinefashionretail.consumer.exception.ConsumerOrder.ConsumerOrderNotFoundException;
import com.stackroute.onlinefashionretail.consumer.service.interfaces.ConsumerOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("api/v1")
public class ConsumerOrderController {
    private final ConsumerOrderService consumerOrderService;
    private final Logger logger = LoggerFactory.getLogger(ConsumerOrderController.class);

    @Autowired
    public ConsumerOrderController(ConsumerOrderService consumerOrderService) {
        this.consumerOrderService = consumerOrderService;
    }

    @PostMapping("order")
    public ResponseEntity<?> placeOrder(@RequestBody ConsumerOrder consumerOrder) throws ConsumerOrderAlreadyExistsException{
        logger.info("Entered into placeOrder into ConsumerOrderController");
        return new ResponseEntity<>(consumerOrderService.placeOrder(consumerOrder), HttpStatus.CREATED);
    }

    @PutMapping("cancel-order")
    public ResponseEntity<?> cancelOrder(@RequestBody ConsumerOrder consumerOrder) throws ConsumerOrderNotFoundException {
        logger.info("Entered into cancelOrder into ConsumerOrderController");
        return new ResponseEntity<>(consumerOrderService.cancelOrder(consumerOrder), HttpStatus.OK);
    }

    @PutMapping("order/{id}/shipping-address")
    public ResponseEntity<?> editShippingAddress(@PathVariable String id, @RequestBody Address address) throws ConsumerOrderNotFoundException {
        logger.info("Entered into ediShippingAddress into ConsumerOrderController");
        return new ResponseEntity<>(consumerOrderService.editShippingAddress(id,address), HttpStatus.OK);
    }

    @PutMapping("order/{id}/status")
    public ResponseEntity<?> editStatus(@PathVariable String id, @RequestBody Map<String,Object> body) throws ConsumerOrderNotFoundException {
        logger.info("Entered into editStatus into ConsumerOrderController");
        return new ResponseEntity<>(consumerOrderService.editStatus(id, body.get("status").toString()), HttpStatus.OK);
    }

    @GetMapping("order")
    public ResponseEntity<?> getAllOrders() {
        logger.info("Entered into getAllOrders into ConsumerOrderController");
        return new ResponseEntity<>(consumerOrderService.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping("order/{id}")
    public ResponseEntity<?> getProductById(@PathVariable String id) throws ConsumerOrderNotFoundException {
        logger.info("Entered into getProductById into ConsumerOrderController");
        return new ResponseEntity<>(consumerOrderService.getOrderById(id), HttpStatus.OK);
    }
}
