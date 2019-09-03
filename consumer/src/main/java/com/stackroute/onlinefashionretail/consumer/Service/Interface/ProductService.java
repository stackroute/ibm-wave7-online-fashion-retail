package com.stackroute.onlinefashionretail.consumer.Service.Interface;

import com.stackroute.onlinefashionretail.consumer.Domain.Product;
import com.stackroute.onlinefashionretail.consumer.Exception.Product.ProductAlreadyExistsException;
import com.stackroute.onlinefashionretail.consumer.Exception.Product.ProductNotFoundException;

import java.util.List;

//interface for the Product service class
public interface ProductService {
    //method to add a product
    Product addProduct(Product product) throws ProductAlreadyExistsException;

    //method to remove a product
    Product removeProduct(Product product) throws ProductNotFoundException;

    //method to edit a product image
    Product editImage(String id, String image) throws ProductNotFoundException;

    //method to edit a product price
    Product editPrice(String id, double price) throws ProductNotFoundException;

    //method to edit a product rating
    Product editRating(String id, float rating) throws ProductNotFoundException;

    //method to edit a product discount
    Product editDiscount(String id, double discount) throws ProductNotFoundException;

    //method to get all products
    List<Product> getAllProducts();

    //method to get a product by id
    Product getProductById(String id) throws ProductNotFoundException;
}
