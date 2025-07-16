package com.example.courseManager.dtos.reviewDto;

import jakarta.validation.constraints.PositiveOrZero;


public record ReviewRequestDto (@PositiveOrZero(message = "Rating cannot be negative") Integer rating){}
