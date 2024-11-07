package com.yassine.product_composite.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yassine.product_composite.dto.ProductDetails;
import com.yassine.product_composite.service.ProductAggregationService;


@RestController
@RequestMapping("/product-details")
public class ProductAggregationController {
    @Autowired
    private final ProductAggregationService aggregationService;

    public ProductAggregationController(ProductAggregationService aggregationService) {
        this.aggregationService = aggregationService;
    }

    @GetMapping("/{productId}")
    public ProductDetails getProductDetails(@PathVariable long productId) {
        return aggregationService.getProductDetails(productId);
    }
}