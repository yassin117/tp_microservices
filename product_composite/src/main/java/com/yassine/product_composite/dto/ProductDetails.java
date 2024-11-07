package com.yassine.product_composite.dto;

import java.util.List;

import com.yassine.product_composite.model.Product;
import com.yassine.product_composite.model.Recommendation;
import com.yassine.product_composite.model.Review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDetails {
    private Product product;
    private List<Review> reviews;
    private List<Recommendation> recommendations;

    // Getters and setters
}
