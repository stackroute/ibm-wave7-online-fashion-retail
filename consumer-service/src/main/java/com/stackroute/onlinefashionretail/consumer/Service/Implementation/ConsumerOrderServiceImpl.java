package com.stackroute.onlinefashionretail.consumer.Service.Implementation;

import com.mongodb.MongoSocketOpenException;
import com.stackroute.onlinefashionretail.consumer.Domain.Address;
import com.stackroute.onlinefashionretail.consumer.Domain.ConsumerOrder;
import com.stackroute.onlinefashionretail.consumer.Exception.ConsumerOrder.ConsumerOrderAlreadyExistsException;
import com.stackroute.onlinefashionretail.consumer.Exception.ConsumerOrder.ConsumerOrderNotFoundException;
import com.stackroute.onlinefashionretail.consumer.Repository.ConsumerOrderRepository;
import com.stackroute.onlinefashionretail.consumer.Service.Interface.ConsumerOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Service Class contains the business logic
@Service
public class ConsumerOrderServiceImpl implements ConsumerOrderService {

    //ConsumerOrderRepository object to perform database operations
    private final ConsumerOrderRepository consumerOrderRepository;

    private final Logger logger = LoggerFactory.getLogger(ConsumerOrderServiceImpl.class);

    @Autowired
    public ConsumerOrderServiceImpl(ConsumerOrderRepository consumerOrderRepository) {
        this.consumerOrderRepository = consumerOrderRepository;
    }

    //method to save an order
    @Override
    public ConsumerOrder placeOrder(ConsumerOrder consumerOrder) throws ConsumerOrderAlreadyExistsException {
        try {
            if (consumerOrderRepository.existsById(consumerOrder.getId()))
                throw new ConsumerOrderAlreadyExistsException("An order with this id already exists!");
            return consumerOrderRepository.save(consumerOrder);
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    //method to cancel an order
    @Override
    public ConsumerOrder cancelOrder(ConsumerOrder consumerOrder) throws ConsumerOrderNotFoundException {
        try {
            if (!consumerOrderRepository.existsById(consumerOrder.getId()))
                throw new ConsumerOrderNotFoundException("Consumer order with given id not found!");
            consumerOrder.setStatus("cancelled");
            return consumerOrderRepository.save(consumerOrder);
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    //method to edit the shipping address of an order
    @Override
    public ConsumerOrder editShippingAddress(String consumerOrderId, Address address) throws ConsumerOrderNotFoundException {
        try {
            ConsumerOrder consumerOrder = consumerOrderRepository.findById(consumerOrderId).orElseThrow(() -> new ConsumerOrderNotFoundException("Consumer order with given id not found!"));
            consumerOrder.setShippingAddress(address);
            return consumerOrderRepository.save(consumerOrder);
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    //method to edit the status of an order
    @Override
    public ConsumerOrder editStatus(String consumerOrderId, String status) throws ConsumerOrderNotFoundException {
        try {
            ConsumerOrder consumerOrder = consumerOrderRepository.findById(consumerOrderId).orElseThrow(() -> new ConsumerOrderNotFoundException("Consumer order with given id not found!"));
            consumerOrder.setStatus(status);
            return consumerOrderRepository.save(consumerOrder);
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    //method to get all orders
    @Override
    public List<ConsumerOrder> getAllOrders() {
        try {
            return consumerOrderRepository.findAll();
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    //method to get an order by id
    @Override
    public ConsumerOrder getOrderById(String id) throws ConsumerOrderNotFoundException {
        try {
            return consumerOrderRepository.findById(id).orElseThrow(() -> new ConsumerOrderNotFoundException("Consumer order with given id not found!"));
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    @Override
    public Integer getProductCount() {
        try {
            int count = 0;
            List<ConsumerOrder> orders = consumerOrderRepository.findAll();
            for (ConsumerOrder order :
                    orders) {
                count += order.getProducts().size();
            }
            return count;
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }
}
