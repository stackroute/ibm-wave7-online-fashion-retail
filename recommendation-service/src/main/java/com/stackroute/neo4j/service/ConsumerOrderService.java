package com.stackroute.neo4j.service;

import com.stackroute.neo4j.entity.Consumer;
import com.stackroute.neo4j.entity.ConsumerOrder;
import com.stackroute.neo4j.repository.ConsumerOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class ConsumerOrderService
{
    private ConsumerOrderRepository consumerOrderRepository;

    public ConsumerOrderService(ConsumerOrderRepository consumerOrderRepository) {
        this.consumerOrderRepository = consumerOrderRepository;
    }

    public ConsumerOrder createOrder(ConsumerOrder consumerOrder)
    {
        return consumerOrderRepository.save(consumerOrder);
    }
    public void deleteOrder(String id)
    {
        consumerOrderRepository.deleteById(id);
    }
    public Iterable<ConsumerOrder> getOrders()
    {
        return consumerOrderRepository.findAll();
    }
    public ConsumerOrder updateOrder(ConsumerOrder consumerOrder)
    {
        consumerOrder.setShippingAddress(consumerOrder.getShippingAddress());
        consumerOrder.setStatus(consumerOrder.getStatus());
        return consumerOrderRepository.save(consumerOrder);
    }

}
