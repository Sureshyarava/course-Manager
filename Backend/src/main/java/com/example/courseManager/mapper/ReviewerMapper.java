package com.example.courseManager.mapper;


import com.example.courseManager.dtos.reviewDto.ReviewRequestDto;
import com.example.courseManager.dtos.reviewDto.ReviewResponseDto;
import com.example.courseManager.models.Review;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewerMapper {
    Review toReview(ReviewRequestDto reviewRequestDto);
    ReviewResponseDto toReviewResponseDto(Review review);
}
