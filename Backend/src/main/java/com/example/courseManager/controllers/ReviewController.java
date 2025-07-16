package com.example.courseManager.controllers;

import com.example.courseManager.dtos.reviewDto.ReviewRequestDto;
import com.example.courseManager.dtos.reviewDto.ReviewResponseDto;
import com.example.courseManager.models.Review;
import com.example.courseManager.services.ReviewService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class ReviewController {
    private ReviewService reviewService;

    @PostMapping("/courses/{courseId}/reviews")
    public ReviewResponseDto createReview(@PathVariable Long courseId, @Valid @RequestBody ReviewRequestDto reviewRequestDto) {
        return reviewService.createReview(courseId, reviewRequestDto);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public void deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
    }
}
