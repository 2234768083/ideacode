package com.example.demo.service;

import com. example. demo.model.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    void deleteProduct(String productId);
    Product updateProduct(Product product);
    Product getProductById(String productId);

    List<Product> getAllProducts();
}