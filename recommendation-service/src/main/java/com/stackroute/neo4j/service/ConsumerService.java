package com.stackroute.neo4j.service;

import com.stackroute.neo4j.entity.Consumer;
import com.stackroute.neo4j.entity.Designer;
import com.stackroute.neo4j.entity.Product;
import com.stackroute.neo4j.repository.ConsumerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerService
{
    private ConsumerRepository consumerRepository;

    public ConsumerService(ConsumerRepository consumerRepository) {
        this.consumerRepository = consumerRepository;
    }

    public Consumer createConsumer(Consumer consumer)
    {
        return consumerRepository.save(consumer);
    }
    public void deleteConsumer(String id)
    {
        consumerRepository.deleteById(id);
    }
    public Iterable<Consumer> getConsumers()
    {
        return consumerRepository.findAll();
    }
    public Consumer updateConsumer(Consumer consumer)
    {
        consumer.setUserName(consumer.getUserName());
        consumer.setAddresses(consumer.getAddresses());
        return consumerRepository.save(consumer);
    }
    public List<Product> getProducts(String name)
    {
        return consumerRepository.getProducts(name);
    }
}
