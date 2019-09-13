package com.stackroute.onlinefashionretail.consumer.controller;

import com.stackroute.onlinefashionretail.consumer.domain.Address;
import com.stackroute.onlinefashionretail.consumer.domain.Consumer;
import com.stackroute.onlinefashionretail.consumer.domain.ConsumerOrder;
import com.stackroute.onlinefashionretail.consumer.domain.Product;
import com.stackroute.onlinefashionretail.consumer.exception.Consumer.ConsumerAlreadyExistsException;
import com.stackroute.onlinefashionretail.consumer.exception.Consumer.ConsumerNotFoundException;
import com.stackroute.onlinefashionretail.consumer.service.interfaces.ConsumerOrderService;
import com.stackroute.onlinefashionretail.consumer.service.interfaces.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("api/v1")
public class ConsumerController {
    private final ConsumerService consumerService;
    private final Logger logger = LoggerFactory.getLogger(ConsumerController.class);
    private final String TOPIC = "PRODUCTS_BOUGHT";
    private final KafkaTemplate<String ,Integer> kafkaTemplate;
    private final ConsumerOrderService consumerOrderService;

    @Autowired
    public ConsumerController(ConsumerService consumerService, KafkaTemplate<String, Integer> kafkaTemplate, ConsumerOrderService consumerOrderService) {
        this.consumerService = consumerService;
        this.kafkaTemplate = kafkaTemplate;
        this.consumerOrderService = consumerOrderService;
    }

    @PostMapping("consumer")
    public ResponseEntity<?> addConsumer(@RequestBody Consumer consumer) throws ConsumerAlreadyExistsException {
        logger.info("Entered into addConsumer method in ConsumerController");
        return new ResponseEntity<>(consumerService.addConsumer(consumer), HttpStatus.CREATED);
    }

    @DeleteMapping("consumer")
    public ResponseEntity<?> removeConsumer(@RequestBody Consumer consumer) throws ConsumerNotFoundException {
        logger.info("Entered into removeConsumer method in ConsumerController");
        return new ResponseEntity<>(consumerService.removeConsumer(consumer), HttpStatus.OK);
    }

    @GetMapping("consumer")
    public ResponseEntity<?> getAllConsumers() {
        logger.info("Entered into getAllConsumers method in ConsumerController");
        return new ResponseEntity<>(consumerService.getAllConsumers(), HttpStatus.OK);
    }

    @GetMapping("consumer/{id}")
    public ResponseEntity<?> getConsumerById(@PathVariable String id) throws ConsumerNotFoundException {
        logger.info("Entered into getConsumerbyId method in ConsumerController");
        return new ResponseEntity<>(consumerService.getConsumerById(id), HttpStatus.OK);
    }

    @GetMapping("consumer/email")
    public ResponseEntity<?> getConsumerByEmail(@RequestBody Map<String,Object> body) throws ConsumerNotFoundException {
        logger.info("Entered into getConsumerByEmail method in ConsumerController");
        return new ResponseEntity<>(consumerService.getConsumerByEmail(body.get("email").toString()), HttpStatus.OK);
    }

    @PutMapping("consumer")
    public ResponseEntity<?> editConsumer(@RequestBody Consumer consumer) throws ConsumerNotFoundException {
        logger.info("Entered into editConsumer method in ConsumerController");
        return new ResponseEntity<>(consumerService.editConsumer(consumer), HttpStatus.OK);
    }

    @PutMapping("consumer/{id}/address")
    public ResponseEntity<?> addAddress(@PathVariable String id, @RequestBody Address address) throws ConsumerNotFoundException {
        logger.info("Entered into addAddress method in ConsumerController");
        return new ResponseEntity<>(consumerService.addOrEditAddress(id,address), HttpStatus.OK);
    }

    @DeleteMapping("consumer/{id}/address")
    public ResponseEntity<?> removeAddress(@PathVariable String id, @RequestBody Address address) throws ConsumerNotFoundException {
        logger.info("Entered into removeAddress method in ConsumerController");
        return new ResponseEntity<>(consumerService.removeAddress(id,address), HttpStatus.OK);
    }

    @GetMapping("consumer/{id}/addresses")
    public ResponseEntity<?> getAllAddresses(@PathVariable String id) throws ConsumerNotFoundException {
        logger.info("Entered into getAllAddress method in ConsumerController");
        return new ResponseEntity<>(consumerService.getAllAddresses(id), HttpStatus.OK);
    }

    @GetMapping("consumer/{id}/address/{addressId}")
    public ResponseEntity<?> getAddressById(@PathVariable String id, @PathVariable String addressId) throws ConsumerNotFoundException {
        logger.info("Entered into getAddressbyId method in ConsumerController");
        return new ResponseEntity<>(consumerService.getAddressById(id,addressId), HttpStatus.OK);
    }

    @PostMapping("consumer/order")
    public ResponseEntity<?> placeOrder(@RequestBody ConsumerOrder consumerOrder) throws ConsumerNotFoundException {
        logger.info("Entered into placeOrder method in ConsumerController");
        ConsumerOrder order = consumerService.placeOrder(consumerOrder);
        kafkaTemplate.send(TOPIC,consumerOrderService.getProductCount());
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @PutMapping("consumer/{id}/order/{orderId}")
    public ResponseEntity<?> cancelOrder(@PathVariable String id, @PathVariable String orderId) throws ConsumerNotFoundException {
        logger.info("Entered into cancelOrder method in ConsumerController");
        return new ResponseEntity<>(consumerService.cancelOrder(id,orderId), HttpStatus.OK);
    }

    @GetMapping("consumer/{id}/order")
    public ResponseEntity<?> getAllOrders(@PathVariable String id) throws ConsumerNotFoundException {
        logger.info("Entered into getAllOrders method in ConsumerController");
        return new ResponseEntity<>(consumerService.getAllOrders(id), HttpStatus.OK);
    }

    @PutMapping("consumer/{id}/order/{orderId}/edit-address")
    public ResponseEntity<?> editShippingAddress(@PathVariable String id, @PathVariable String orderId,@RequestBody Address address) throws ConsumerNotFoundException {
        logger.info("Entered into editShippingAddress method in ConsumerController");
        return new ResponseEntity<>(consumerService.editShippingAddress(id,orderId,address), HttpStatus.OK);
    }

    @PostMapping("consumer/{id}/cart")
    public ResponseEntity<?> addToCart(@PathVariable String id, @RequestBody Product product) throws ConsumerNotFoundException {
        logger.info("Entered into addToCart method in ConsumerController");
        return new ResponseEntity<>(consumerService.addToCart(id,product), HttpStatus.CREATED);
    }

    @DeleteMapping("consumer/{id}/cart")
    public ResponseEntity<?> removeFromCart(@PathVariable String id, @RequestBody Product product) throws ConsumerNotFoundException {
        logger.info("Entered into removeFromCart method in ConsumerController");
        return new ResponseEntity<>(consumerService.removeFromCart(id,product), HttpStatus.OK);
    }

    @GetMapping("consumer/{id}/cart")
    public ResponseEntity<?> viewCart(@PathVariable String id) throws ConsumerNotFoundException {
        logger.info("Entered into viewCart method in ConsumerController");
        return new ResponseEntity<>(consumerService.viewCart(id), HttpStatus.OK);
    }
}
