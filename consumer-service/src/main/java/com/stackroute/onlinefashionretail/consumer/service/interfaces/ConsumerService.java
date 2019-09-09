package com.stackroute.onlinefashionretail.consumer.service.interfaces;

import com.stackroute.onlinefashionretail.consumer.domain.Address;
import com.stackroute.onlinefashionretail.consumer.domain.Consumer;
import com.stackroute.onlinefashionretail.consumer.domain.ConsumerOrder;
import com.stackroute.onlinefashionretail.consumer.domain.Product;
import com.stackroute.onlinefashionretail.consumer.exception.Consumer.ConsumerAlreadyExistsException;
import com.stackroute.onlinefashionretail.consumer.exception.Consumer.ConsumerNotFoundException;

import java.util.List;
import java.util.Map;

//interface for the Consumer service class
public interface ConsumerService {
    /*     Methods that will be used only by the system     */
    //method to add a consumer
    Consumer addConsumer(Consumer consumer) throws ConsumerAlreadyExistsException;

    //method to remove a consumer
    Consumer removeConsumer(Consumer consumer) throws ConsumerNotFoundException;

    //method to get all consumers
    List<Consumer> getAllConsumers();

    //method to get a consumer by id
    Consumer getConsumerById(String id) throws ConsumerNotFoundException;

    /*     Methods that will be used by the users too      */
    //method to get a consumer by email
    Consumer getConsumerByEmail(String email) throws ConsumerNotFoundException;

    //edit consumer will be used to edit the profile
    //method to edit a consumer
    Consumer editConsumer(Consumer consumer) throws ConsumerNotFoundException;

    //method to add or edit an Address
    Address addOrEditAddress(String consumerId, Address address) throws ConsumerNotFoundException;

    //method to remove an Address
    Address removeAddress(String consumerId, Address address) throws ConsumerNotFoundException;

    //method to get all Addresses
    Map<String, Address> getAllAddresses(String consumerId) throws ConsumerNotFoundException;

    //method to get an Address by id
    Address getAddressById(String consumerId, String id) throws ConsumerNotFoundException;

    //method to place an consumerOrder
    ConsumerOrder placeOrder(ConsumerOrder consumerOrder) throws ConsumerNotFoundException;

    //method to cancel an consumerOrder
    ConsumerOrder cancelOrder(String consumerId, String orderId) throws ConsumerNotFoundException;

    //method to edit shipping address
    ConsumerOrder editShippingAddress(String consumerId, String orderId, Address address) throws ConsumerNotFoundException;

    //method to get all orders
    Map<String, ConsumerOrder> getAllOrders(String consumerId) throws ConsumerNotFoundException;

    //method to add a product to cart
    Product addToCart(String consumerId, Product product) throws ConsumerNotFoundException;

    //method to remove a product from cart
    Product removeFromCart(String consumerId, Product product) throws ConsumerNotFoundException;

    //method to get all products in cart
    List<Product> viewCart(String consumerId) throws ConsumerNotFoundException;
}
