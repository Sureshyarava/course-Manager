package com.example.courseManager.dtos.courseDto;


import jakarta.validation.constraints.NotBlank;

public record CourseRequestDto (@NotBlank(message = "Course Name is Mandatory") String name) {}
