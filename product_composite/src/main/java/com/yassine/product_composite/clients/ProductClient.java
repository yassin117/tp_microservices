package com.yassine.product_composite.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yassine.product_composite.model.Product;

@FeignClient(name = "product",fallback = ProductClientFallback.class)
public interface ProductClient {
    @GetMapping("/products/{productId}")
    Product getProductById(@PathVariable long productId);
}