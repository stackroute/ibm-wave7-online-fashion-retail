package com.stackroute.onlinefashionretail.consumer.service.implementations;

import com.mongodb.MongoSocketOpenException;
import com.stackroute.onlinefashionretail.consumer.domain.Product;
import com.stackroute.onlinefashionretail.consumer.exception.Product.ProductAlreadyExistsException;
import com.stackroute.onlinefashionretail.consumer.exception.Product.ProductNotFoundException;
import com.stackroute.onlinefashionretail.consumer.repository.ProductRepository;
import com.stackroute.onlinefashionretail.consumer.service.interfaces.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Service Class contains the business logic
@Service
public class ProductServiceImpl implements ProductService {

    //ProductRepository object to perform database operations
    private final
    ProductRepository productRepository;

    private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    //method to add a product
    @Override
    public Product addProduct(Product product) throws ProductAlreadyExistsException {
        try{
            if (!productRepository.existsById(product.getId())){
                return productRepository.save(product);
            }
            else {
                throw new ProductAlreadyExistsException("Product already exists!");
            }
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    //method to remove a product
    @Override
    public Product removeProduct(Product product) throws ProductNotFoundException {
        try{
            if (productRepository.existsById(product.getId())){
                productRepository.delete(product);
                return product;
            }
            else {
                throw new ProductNotFoundException("Product not found!");
            }
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    //method to edit the image of a product
    @Override
    public Product editImage(String id, String image) throws ProductNotFoundException {
        try{
            Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with the specified id not found!"));
            product.setImage(image);
            return productRepository.save(product);
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    //method to edit the price of a product
    @Override
    public Product editPrice(String id, double price) throws ProductNotFoundException {
        try{
            Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with the specified id not found!"));
            product.setPrice(price);
            return productRepository.save(product);
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    //method to edit the rating of a product
    @Override
    public Product editRating(String id, float rating) throws ProductNotFoundException {
        try{
            Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with the specified id not found!"));
            product.setRating(rating);
            return productRepository.save(product);
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    //method to edit the discount of a product
    @Override
    public Product editDiscount(String id, double discount) throws ProductNotFoundException {
        try{
            Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with the specified id not found!"));
            product.setDiscount(discount);
            return productRepository.save(product);
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    //method to get all products
    @Override
    public List<Product> getAllProducts() {
        try{
            return productRepository.findAll();
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }

    //method to get a product by id
    @Override
    public Product getProductById(String id) throws ProductNotFoundException {
        try{
            return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with the specified id not found!"));
        }
        catch (MongoSocketOpenException exception){
            logger.error("Error connecting to database: ",exception);
            return null;
        }
    }
}
