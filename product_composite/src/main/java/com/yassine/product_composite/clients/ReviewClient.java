package com.yassine.product_composite.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yassine.product_composite.model.Review;

@FeignClient(name = "review")
public interface ReviewClient {
    @GetMapping("/reviews/product/{productId}")
    List<Review> getReviewsByProductId(@PathVariable long productId);

}