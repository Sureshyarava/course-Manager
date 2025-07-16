package com.example.courseManager.repositories;

import com.example.courseManager.dtos.reviewDto.ReviewResponseDto;
import com.example.courseManager.models.Course;
import com.example.courseManager.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
