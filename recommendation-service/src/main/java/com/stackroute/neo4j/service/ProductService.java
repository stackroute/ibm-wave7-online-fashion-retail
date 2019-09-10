package com.stackroute.neo4j.service;

import com.stackroute.neo4j.entity.Product;
import com.stackroute.neo4j.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService
{
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product createProduct(Product product)
    {
       return  productRepository.save(product);
    }
    public void deleteProduct(String id)
    {
        productRepository.deleteById(id);
    }
    public Iterable<Product> getProducts()
    {
       return productRepository.findAll();
    }
    public Product updateProduct(Product product)
    {
        product.setDiscount(product.getDiscount());
        product.setPrice(product.getPrice());
        product.setImage(product.getImage());
        product.setRating(product.getRating());
        return productRepository.save(product);

    }
}
