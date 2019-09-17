package com.stackroute.onlinefashionretail.consumer.service.implementations;

import com.mongodb.MongoSocketOpenException;
import com.stackroute.onlinefashionretail.consumer.domain.Address;
import com.stackroute.onlinefashionretail.consumer.domain.Consumer;
import com.stackroute.onlinefashionretail.consumer.domain.ConsumerOrder;
import com.stackroute.onlinefashionretail.consumer.domain.Product;
import com.stackroute.onlinefashionretail.consumer.exception.Consumer.ConsumerAlreadyExistsException;
import com.stackroute.onlinefashionretail.consumer.exception.Consumer.ConsumerNotFoundException;
import com.stackroute.onlinefashionretail.consumer.exception.ConsumerOrder.ConsumerOrderAlreadyExistsException;
import com.stackroute.onlinefashionretail.consumer.exception.ConsumerOrder.ConsumerOrderNotFoundException;
import com.stackroute.onlinefashionretail.consumer.repository.ConsumerRepository;
import com.stackroute.onlinefashionretail.consumer.service.interfaces.ConsumerOrderService;
import com.stackroute.onlinefashionretail.consumer.service.interfaces.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

//Service Class contains the business logic
@Service
public class ConsumerServiceImpl implements ConsumerService {

    //ConsumerRepository object to perform database operations
    private final ConsumerRepository consumerRepository;

    private final ConsumerOrderService consumerOrderService;

    private final Logger logger = LoggerFactory.getLogger(ConsumerServiceImpl.class);

    @Autowired
    public ConsumerServiceImpl(ConsumerRepository consumerRepository, ConsumerOrderService consumerOrderService) {
        this.consumerRepository = consumerRepository;
        this.consumerOrderService = consumerOrderService;
    }

    //method to add a consumer
    @Override
    public Consumer addConsumer(Consumer consumer) throws ConsumerAlreadyExistsException {
        logger.info("Entered into addconsumer method in ConsumerSericeImpl");
        try {
            if (consumerRepository.findConsumerByEmail(consumer.getEmail()) != null)
                throw new ConsumerAlreadyExistsException("Consumer already exists!");
            return consumerRepository.save(consumer);
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    //method to remove a consumer
    @Override
    public Consumer removeConsumer(Consumer consumer) throws ConsumerNotFoundException {
        logger.info("Entered into removeConsumer method in ConsumerSericeImpl");
        try {
            if (consumerRepository.findConsumerByEmail(consumer.getEmail()) == null)
                throw new ConsumerNotFoundException("Consumer not found!");
            consumerRepository.delete(consumer);
            return consumer;
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    //method to get all consumers
    @Override
    public List<Consumer> getAllConsumers() {
        logger.info("Entered into getAllConsumer method in ConsumerSericeImpl");
        try {
            return consumerRepository.findAll();
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    //method to get a consumer by id
    @Override
    public Consumer getConsumerById(String id) throws ConsumerNotFoundException {
        logger.info("Entered into getConsumerById method in ConsumerSericeImpl");
        try {
            return consumerRepository.findById(id).orElseThrow(() -> new ConsumerNotFoundException("Consumer with given id not found!"));
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    //method to get a consumer by email
    @Override
    public Consumer getConsumerByEmail(String email) throws ConsumerNotFoundException {
        logger.info("Entered into getConsumerByEmail method in ConsumerSericeImpl");
        try {
            Consumer consumer = consumerRepository.findConsumerByEmail(email);
            if (consumer == null) {
                throw new ConsumerNotFoundException("consumer with given email id not found");
            }
            return consumer;
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    //method to add or edit a consumer
    @Override
    public Consumer editConsumer(Consumer consumer) throws ConsumerNotFoundException {
        logger.info("Entered into editConsumer method in ConsumerSericeImpl");
        try {
            if (consumerRepository.findConsumerByEmail(consumer.getEmail()) == null)
                throw new ConsumerNotFoundException("Consumer with given email not found!");
            return consumerRepository.save(consumer);
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    //method to add or edit an address
    @Override
    public Address addOrEditAddress(String consumerId, Address address) throws ConsumerNotFoundException {
        logger.info("Entered into addOrEditAddress method in ConsumerSericeImpl");
        try {
            Consumer consumer = consumerRepository.findById(consumerId).orElseThrow(() -> new ConsumerNotFoundException("Consumer with given id not found!"));
            consumer.getAddresses().put(address.getId(),address);
            consumerRepository.save(consumer);
            return address;
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    //method to remove an address
    @Override
    public Address removeAddress(String consumerId, Address address) throws ConsumerNotFoundException {
        logger.info("Entered into removeAddress method in ConsumerSericeImpl");
        try {
            Consumer consumer = consumerRepository.findById(consumerId).orElseThrow(() -> new ConsumerNotFoundException("Consumer with given id not found!"));
            consumer.getAddresses().remove(address.getId());
            consumerRepository.save(consumer);
            return address;
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    //method to get all addresses
    @Override
    public Map<String,Address> getAllAddresses(String consumerId) throws ConsumerNotFoundException {
        logger.info("Entered into getAllAddresses method in ConsumerSericeImpl");
        try {
            Consumer consumer = consumerRepository.findById(consumerId).orElseThrow(() -> new ConsumerNotFoundException("Consumer with given id not found!"));
            return consumer.getAddresses();
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    //method to get an address by id
    @Override
    public Address getAddressById(String consumerId, String id) throws ConsumerNotFoundException {
        logger.info("Entered into getAddressById method in ConsumerSericeImpl");
        try {
            Consumer consumer = consumerRepository.findById(consumerId).orElseThrow(() -> new ConsumerNotFoundException("Consumer with given id not found!"));
            return consumer.getAddresses().get(id);
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    //method to place an order
    @Override
    public ConsumerOrder placeOrder(ConsumerOrder consumerOrder) throws ConsumerNotFoundException {
        logger.info("Entered into placeOrder method in ConsumerSericeImpl");
        try {
            Consumer consumer = consumerRepository.findById(consumerOrder.getConsumerId()).orElseThrow(() -> new ConsumerNotFoundException("Consumer with given id not found!"));

            //set status as placed
            consumerOrder.setStatus("placed");
            logger.info("getting orders of consumer "+consumer.getUserName()+": "+consumer.getConsumerOrders());
            consumer.getConsumerOrders().put(consumerOrder.getId(),consumerOrder);
            logger.info("getting orders of consumer "+consumer.getUserName()+" after saving: "+consumer.getConsumerOrders());

            //clear the cart because all product in the cart are now bought as an order
            consumer.getCart().clear();

            //save to the consumer repository as well as the consumer orders repository
            consumerRepository.save(consumer);

            try {
                return consumerOrderService.placeOrder(consumerOrder);
            } catch (ConsumerOrderAlreadyExistsException e) {
                e.printStackTrace();
                return null;
            }


        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    //method to cancel an order
    @Override
    public ConsumerOrder cancelOrder(String consumerId, String orderId) throws ConsumerNotFoundException {
        try {
            Consumer consumer = consumerRepository.findById(consumerId).orElseThrow(() -> new ConsumerNotFoundException("Consumer with given id not found!"));

            //change status to cancelled
            consumer.getConsumerOrders().get(orderId).setStatus("cancelled");

            //save to the consumer repository as well as the consumer orders repository
            consumerRepository.save(consumer);
            try {
                return consumerOrderService.cancelOrder(consumer.getConsumerOrders().get(orderId));
            } catch (ConsumerOrderNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    //method to edit the shipping address of an order
    @Override
    public ConsumerOrder editShippingAddress(String consumerId, String orderId, Address address) throws ConsumerNotFoundException {
        try {
            Consumer consumer = consumerRepository.findById(consumerId).orElseThrow(() -> new ConsumerNotFoundException("Consumer with given id not found!"));
            consumer.getConsumerOrders().get(orderId).setShippingAddress(address);
            consumerRepository.save(consumer);
            try {
                return consumerOrderService.editShippingAddress(orderId,address);
            } catch (ConsumerOrderNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    //method to get all orders of a consumer
    @Override
    public Map<String, ConsumerOrder> getAllOrders(String consumerId) throws ConsumerNotFoundException{
        try {
            Consumer consumer = consumerRepository.findById(consumerId).orElseThrow(() -> new ConsumerNotFoundException("Consumer with given id not found!"));
            return consumer.getConsumerOrders();
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    @Override
    public Product addToCart(String consumerId, Product product) throws ConsumerNotFoundException {
        try {
            Consumer consumer = consumerRepository.findById(consumerId).orElseThrow(() -> new ConsumerNotFoundException("Consumer with given id not found!"));
            //add product to cart
            consumer.getCart().add(product);
            //save to the consumer repository
            consumerRepository.save(consumer);
            return product;
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    @Override
    public Product removeFromCart(String consumerId, Product product) throws ConsumerNotFoundException {
        try {
            logger.info("Entered into removefromCart method in ConsumerSericeImpl");
            Consumer consumer = consumerRepository.findById(consumerId).orElseThrow(() -> new ConsumerNotFoundException("Consumer with given id not found!"));
            //add product to cart
            logger.info("cart before deleting product: "+consumer.getCart());
            logger.info("product to delete: "+product.toString());
            logger.info("cart contains product? "+consumer.getCart().contains(product)+"");
            consumer.getCart().remove(product);
            logger.info("cart after deleting product: "+consumer.getCart().toString());
            //save to the consumer repository
            consumerRepository.save(consumer);
            return product;
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    @Override
    public List<Product> viewCart(String consumerId) throws ConsumerNotFoundException {
        try {
            logger.info("Entered into viewCart method in ConsumerSericeImpl");
            Consumer consumer = consumerRepository.findById(consumerId).orElseThrow(() -> new ConsumerNotFoundException("Consumer with given id not found!"));
            return consumer.getCart();
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }
}
