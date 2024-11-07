package com.yassine.Review.repository;

import com.yassine.Review.model.Review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByProductId(long productId);

}
