package com.yassine.Review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.yassine.Review.dto.ReviewRequest;
import com.yassine.Review.dto.ReviewResponse;
import com.yassine.Review.model.Review;
import com.yassine.Review.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createReview(@RequestBody ReviewRequest reviewRequest) {
        reviewService.createReview(reviewRequest);
        return "Review created";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ReviewResponse> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateReview(@PathVariable Long id, @RequestBody ReviewRequest reviewRequest) {
        reviewService.updateReview(id, reviewRequest);
        return "Review updated";
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }

      @GetMapping("/product/{productId}")
    public List<Review> getReviewsByProductId(@PathVariable long productId) {
        return reviewService.findReviewsByProductId(productId);
    }
}
