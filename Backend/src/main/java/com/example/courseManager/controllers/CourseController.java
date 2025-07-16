package com.example.courseManager.controllers;

import com.example.courseManager.dtos.courseDto.CourseRequestDto;
import com.example.courseManager.dtos.courseDto.CourseResponseDto;
import com.example.courseManager.services.CourseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class CourseController {
    private CourseService courseService;


    @GetMapping("/courses")
    public List<CourseResponseDto> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/courses/{courseId}")
    public CourseResponseDto getCourseById(@PathVariable Long courseId) {
        return courseService.getCourse(courseId);
    }

    @PostMapping("/courses")
    public CourseResponseDto createCourse(@Valid @RequestBody CourseRequestDto courseRequestDto) {
        return courseService.createCourse(courseRequestDto);
    }
}
