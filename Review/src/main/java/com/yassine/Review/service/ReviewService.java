package com.yassine.Review.service;
import java.util.List;

import com.yassine.Review.dto.ReviewRequest;
import com.yassine.Review.dto.ReviewResponse;
import com.yassine.Review.model.Review;

public interface ReviewService {

    void createReview(ReviewRequest reviewRequest);

    List<ReviewResponse> getAllReviews();

    void updateReview(Long id, ReviewRequest reviewRequest);

    void deleteReview(Long id);
    public List<Review> findReviewsByProductId(long productId) ;
}
