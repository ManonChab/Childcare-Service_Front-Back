package org.daypilot.demo.html5eventcalendarspring.service;
import java.util.List;

import org.daypilot.demo.html5eventcalendarspring.Entity.Review;

public interface ReviewService {
    
    public Review createReview(Review review);

    public Review getReviewById (int id);

    public List<Review> getAllReviews();

    public void updateReview (int id, Review review);

    public void deleteReview(int id);

    public Review approve(int id);

    public Review reject(int id);

}
