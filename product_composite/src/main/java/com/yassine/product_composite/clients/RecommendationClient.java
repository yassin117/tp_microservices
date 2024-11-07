package com.yassine.product_composite.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yassine.product_composite.model.Recommendation;

@FeignClient(name = "recommendation")
public interface RecommendationClient {
    @GetMapping("/recommendations/product/{productId}")
    List<Recommendation> getRecommendationsByProductId(@PathVariable long productId);
}