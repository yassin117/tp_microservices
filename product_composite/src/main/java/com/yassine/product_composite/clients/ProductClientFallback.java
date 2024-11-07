package com.yassine.product_composite.clients;

import org.springframework.stereotype.Component;

import com.yassine.product_composite.model.Product;

@Component
public class ProductClientFallback implements ProductClient {
    @Override
    public Product getProductById(long productId) {
        return new Product();  // Return an empty Product
    }
}