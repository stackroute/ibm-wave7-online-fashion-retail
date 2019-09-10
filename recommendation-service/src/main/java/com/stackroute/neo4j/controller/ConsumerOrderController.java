package com.stackroute.neo4j.controller;

import com.stackroute.neo4j.entity.ConsumerOrder;
import com.stackroute.neo4j.service.ConsumerOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ConsumerOrderController
{
    private ConsumerOrderService consumerOrderService;

    public ConsumerOrderController(ConsumerOrderService consumerOrderService) {
        this.consumerOrderService = consumerOrderService;
    }

    @PostMapping("/consumerorder")
    public ResponseEntity<ConsumerOrder> createConsumerOrder(@RequestBody ConsumerOrder consumerOrder)
    {
        return  new ResponseEntity<ConsumerOrder>(consumerOrderService.createOrder(consumerOrder), HttpStatus.OK);
    }
    @GetMapping("/consumerorder")
    public ResponseEntity<Iterable<ConsumerOrder>> getConsumerOrders()
    {
        return new ResponseEntity<Iterable<ConsumerOrder>>(consumerOrderService.getOrders(),HttpStatus.OK);
    }
    @PutMapping("/consumerorder")
    public ResponseEntity<ConsumerOrder> updateOrder(@RequestBody ConsumerOrder consumerorder)
    {

        return new ResponseEntity<ConsumerOrder>(consumerOrderService.updateOrder(consumerorder),HttpStatus.OK);
    }
    @DeleteMapping("/consumerorder/{id}")
    public void deleteOrder(@PathVariable String id)
    {
        consumerOrderService.deleteOrder(id);
    }

}
