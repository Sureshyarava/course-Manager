package com.example.courseManager.mapper;

import com.example.courseManager.dtos.courseDto.CourseRequestDto;
import com.example.courseManager.dtos.courseDto.CourseResponseDto;
import com.example.courseManager.models.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course toCourse(CourseRequestDto courseRequestDto);

    CourseResponseDto toCourseResponseDto(Course course);
}
