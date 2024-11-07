package com.yassine.Review.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yassine.Review.dto.ReviewRequest;
import com.yassine.Review.dto.ReviewResponse;
import com.yassine.Review.model.Review;
import com.yassine.Review.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewServiceImp implements ReviewService {

    private final ReviewRepository reviewRepository;

    public void createReview(ReviewRequest reviewRequest){
        Review review = new Review();
        review.setProductId(reviewRequest.getProductId());
        review.setAuthor(reviewRequest.getAuthor());
        review.setContent(reviewRequest.getContent());
        review.setRate(reviewRequest.getRate());
        
        reviewRepository.save(review);
        log.info("Review {} is saved", review.getId());
    }

    public List<ReviewResponse> getAllReviews(){
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().map(this::mapToReviewResponse).toList();
    }

    private ReviewResponse mapToReviewResponse(Review review){
        return ReviewResponse.builder()
                .id(review.getId())
                .productId(review.getProductId())
                .author(review.getAuthor())
                .content(review.getContent())
                .rate(review.getRate())
                .build();
    }

    public void updateReview(Long id, ReviewRequest reviewRequest) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review with id " + id + " not found"));

        review.setAuthor(reviewRequest.getAuthor());
        review.setContent(reviewRequest.getContent());
        review.setRate(reviewRequest.getRate());

        reviewRepository.save(review);
        log.info("Review {} is updated", review.getId());
    }

    public void deleteReview(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review with id " + id + " not found"));

        reviewRepository.delete(review);
        log.info("Review {} is deleted", review.getId());
    }

    public List<Review> findReviewsByProductId(long productId) {
        return reviewRepository.findByProductId(productId);
    }
}