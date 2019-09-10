package com.stackroute.neo4j.controller;

import com.stackroute.neo4j.entity.Consumer;
import com.stackroute.neo4j.entity.Designer;
import com.stackroute.neo4j.entity.Product;
import com.stackroute.neo4j.service.ConsumerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ConsumerController
{
    private ConsumerService consumerService;

    public ConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }
    @PostMapping("/consumer")
    public ResponseEntity<Consumer> createConsumer(@RequestBody Consumer consumer)
    {
        return  new ResponseEntity<Consumer>(consumerService.createConsumer(consumer), HttpStatus.OK);
    }
    @GetMapping("/consumer")
    public ResponseEntity<Iterable<Consumer>> getCustomers()
    {
        return new ResponseEntity<Iterable<Consumer>>(consumerService.getConsumers(),HttpStatus.OK);
    }
    @PutMapping("/consumer")
    public ResponseEntity<Consumer> updateConsumer(@RequestBody Consumer consumer)
    {

        consumer.setAddresses(consumer.getAddresses());
        return new ResponseEntity<Consumer>(consumerService.updateConsumer(consumer),HttpStatus.OK);
    }
    @DeleteMapping("/consumer/{id}")
    public void deleteConsumer(@PathVariable String id)
    {
       consumerService.deleteConsumer(id);
    }
    @GetMapping("/getmatch/{name}")
    public ResponseEntity<?> getProducts(@PathVariable String name)
    {
        return new ResponseEntity<List<Product>>(consumerService.getProducts(name),HttpStatus.OK);
    }

}
