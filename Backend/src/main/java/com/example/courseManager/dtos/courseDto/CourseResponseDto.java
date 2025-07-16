package com.example.courseManager.dtos.courseDto;

import com.example.courseManager.models.Review;

import java.util.List;

public record CourseResponseDto (Long id, String name, List<Review> reviews){}
