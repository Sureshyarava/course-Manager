package com.example.courseManager.dtos.reviewDto;

import com.example.courseManager.dtos.userDto.UserResponseDto;
import com.example.courseManager.models.Course;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ReviewResponseDto {
    public Long id;

    public Integer rating;

    public UserResponseDto user;

    public Course course;
}
