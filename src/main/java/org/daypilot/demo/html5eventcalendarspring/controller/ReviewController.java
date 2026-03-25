package org.daypilot.demo.html5eventcalendarspring.controller;

import java.util.List;

import org.daypilot.demo.html5eventcalendarspring.Entity.Review;
import org.daypilot.demo.html5eventcalendarspring.dto.RequestDTO.UserRequestDTO;
import org.daypilot.demo.html5eventcalendarspring.dto.ResponseDTO.UserResponseDTO;
import org.daypilot.demo.html5eventcalendarspring.service.ReviewService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review newReview = reviewService.createReview(review);        
        return new ResponseEntity<>(newReview, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Review> getUserById(@PathVariable int id) {
    Review review = reviewService.getReviewById(id);
    return ResponseEntity.ok()
    .header("Authorization", "Bearer ")
    .body(review);
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
    List<Review> reviews = reviewService.getAllReviews();
    return ResponseEntity.ok(reviews);
}

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateReview(
        @PathVariable int id, 
        @Valid   @RequestBody Review user){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteReview(@PathVariable int id) {
        reviewService.deleteReview(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/approve")
    public ResponseEntity<Review> approveReview(@PathVariable int id) {
        return ResponseEntity.ok(reviewService.approve(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/reject")
    public ResponseEntity<Review> rejectReview(@PathVariable int id) {
        return ResponseEntity.ok(reviewService.reject(id));
    }

}
