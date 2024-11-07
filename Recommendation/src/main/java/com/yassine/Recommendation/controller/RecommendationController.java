package com.yassine.Recommendation.controller;

import com.yassine.Recommendation.dto.RecommendationRequest;
import com.yassine.Recommendation.dto.RecommendationResponse;
import com.yassine.Recommendation.model.Recommendation;
import com.yassine.Recommendation.service.RecommendationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createRecommendation(@RequestBody RecommendationRequest recommendationRequest) {
        recommendationService.createRecommendation(recommendationRequest);
        return "Recommendation created";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RecommendationResponse> getAllRecommendations() {
        return recommendationService.getAllRecommendations();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateRecommendation(@PathVariable Long id, @RequestBody RecommendationRequest recommendationRequest) {
        recommendationService.updateRecommendation(id, recommendationRequest);
        return "Recommendation updated";
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecommendation(@PathVariable Long id) {
        recommendationService.deleteRecommendation(id);
    }
    
     @GetMapping("/product/{productId}")
    public List<Recommendation> getRecommendationsByProductId(@PathVariable long productId) {
        return recommendationService.findRecommendationsByProductId(productId);
    }
}