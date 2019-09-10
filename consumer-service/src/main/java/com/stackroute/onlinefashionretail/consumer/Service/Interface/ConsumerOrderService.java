package com.stackroute.onlinefashionretail.consumer.Service.Interface;

import com.stackroute.onlinefashionretail.consumer.Domain.Address;
import com.stackroute.onlinefashionretail.consumer.Domain.ConsumerOrder;
import com.stackroute.onlinefashionretail.consumer.Exception.ConsumerOrder.ConsumerOrderAlreadyExistsException;
import com.stackroute.onlinefashionretail.consumer.Exception.ConsumerOrder.ConsumerOrderNotFoundException;

import java.util.List;

//interface for the ConsumerOrder service class
public interface ConsumerOrderService {
    //method to place an consumerOrder, i.e. add an consumerOrder
    ConsumerOrder placeOrder(ConsumerOrder consumerOrder) throws ConsumerOrderAlreadyExistsException;

    //method to cancel an consumerOrder
    ConsumerOrder cancelOrder(ConsumerOrder consumerOrder) throws ConsumerOrderNotFoundException;

    //method to edit shipping address
    ConsumerOrder editShippingAddress(String consumerOrderId, Address address) throws ConsumerOrderNotFoundException;

    //method to edit status
    ConsumerOrder editStatus(String consumerOrderId, String status) throws ConsumerOrderNotFoundException;

    //method to get all orders
    List<ConsumerOrder> getAllOrders();

    //method to get an order by id
    ConsumerOrder getOrderById(String id) throws ConsumerOrderNotFoundException;

    //method to get product count
    Integer getProductCount();
}
