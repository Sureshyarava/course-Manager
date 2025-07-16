package com.example.courseManager.services;

import com.example.courseManager.dtos.courseDto.CourseRequestDto;
import com.example.courseManager.dtos.courseDto.CourseResponseDto;
import com.example.courseManager.exception.CourseNotFoundException;
import com.example.courseManager.mapper.CourseMapper;
import com.example.courseManager.models.Course;
import com.example.courseManager.repositories.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseService {

    private CourseRepository courseRepository;
    private CourseMapper courseMapper;

    public CourseResponseDto getCourse(Long id){
        return courseMapper.toCourseResponseDto(courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course not Found")));
    }

    public List<CourseResponseDto> getAllCourses(){
        return courseRepository.findAll().stream().map(courseMapper::toCourseResponseDto).collect(Collectors.toList());
    }

    public Course getCourseById(Long id){
        return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course not Found"));
    }

    public CourseResponseDto createCourse(CourseRequestDto courseRequestDto){
        return courseMapper.toCourseResponseDto(courseRepository.save(courseMapper.toCourse(courseRequestDto)));
    }
}
