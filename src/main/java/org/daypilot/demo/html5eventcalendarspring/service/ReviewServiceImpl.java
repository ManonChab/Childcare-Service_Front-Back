package org.daypilot.demo.html5eventcalendarspring.service;

import java.util.List;

import org.daypilot.demo.html5eventcalendarspring.Entity.Review;
import org.daypilot.demo.html5eventcalendarspring.repository.ReviewRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review getReviewById(int id) {
        return reviewRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("The child does not exist"));
    }

    @Override
    public List<Review> getAllReviews() {
    List<Review> reviews = reviewRepository.findAll(Sort.by("id"));
    if (reviews.isEmpty()) {
    throw new RuntimeException("No reviews found");
    }
    return reviews;
    }

    @Override
    public void updateReview(int id, Review review) {
        Review updatedReview = getReviewById(id);
        reviewRepository.save(updatedReview);

    }

    @Override
    public void deleteReview(int id) {
        Review review = getReviewById(id);
        reviewRepository.delete(review);
    }

    @Override
        public Review approve(int id) {
        Review review = getReviewById(id);
        review.setShow(true);
        return reviewRepository.save(review);
    }

    @Override
    public Review reject(int id) {
        Review review = getReviewById(id);
        review.setShow(false);
        return reviewRepository.save(review);
    }


}
