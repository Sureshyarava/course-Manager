package com.example.courseManager.services;

import com.example.courseManager.dtos.reviewDto.ReviewRequestDto;
import com.example.courseManager.dtos.reviewDto.ReviewResponseDto;
import com.example.courseManager.mapper.ReviewerMapper;
import com.example.courseManager.models.Review;
import com.example.courseManager.repositories.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReviewService {
    private  ReviewRepository reviewRepository;
    private  CourseService courseService;
    private  UserService userService;
    private  ReviewerMapper reviewerMapper;

    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    public ReviewResponseDto createReview(Long id, ReviewRequestDto reviewRequestDto) {
        Review review = reviewerMapper.toReview(reviewRequestDto);
        review.setCourse(courseService.getCourseById(id));
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        review.setUser(userService.getUserByUsername(userName));
        return reviewerMapper.toReviewResponseDto(reviewRepository.save(review));
    }

}
