package com.yassine.product_composite.service;
import java.util.List;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yassine.product_composite.clients.ProductClient;
import com.yassine.product_composite.clients.RecommendationClient;
import com.yassine.product_composite.clients.ReviewClient;
import com.yassine.product_composite.dto.ProductDetails;
import com.yassine.product_composite.model.Product;
import com.yassine.product_composite.model.Recommendation;
import com.yassine.product_composite.model.Review;


@Service
public class ProductAggregationService {

    private final ProductClient productClient;
    private final ReviewClient reviewClient;
    private final RecommendationClient recommendationClient;

    public ProductAggregationService(@Qualifier("com.yassine.product_composite.clients.ProductClient") ProductClient productClient, ReviewClient reviewClient, RecommendationClient recommendationClient) {
        this.productClient = productClient;
        this.reviewClient = reviewClient;
        this.recommendationClient = recommendationClient;
    }

    public ProductDetails getProductDetails(long productId) {
        Product product = productClient.getProductById(productId);
        List<Review> reviews = reviewClient.getReviewsByProductId(productId);
        List<Recommendation> recommendations = recommendationClient.getRecommendationsByProductId(productId);

        ProductDetails productDetails = new ProductDetails();
        productDetails.setProduct(product);
        productDetails.setReviews(reviews);
        productDetails.setRecommendations(recommendations);

        return productDetails;
    }

    public Product getProductById(long productId) {
        return productClient.getProductById(productId);
    }

    public List<Review> getReviewsByProductId(long productId) {
        return reviewClient.getReviewsByProductId(productId);
    }

    public List<Recommendation> getRecommendationsByProductId(long productId) {
        return recommendationClient.getRecommendationsByProductId(productId);
    }

}