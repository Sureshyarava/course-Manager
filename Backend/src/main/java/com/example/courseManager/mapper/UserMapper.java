package com.example.courseManager.mapper;

import com.example.courseManager.dtos.userDto.UserRequestDto;
import com.example.courseManager.dtos.userDto.UserResponseDto;
import com.example.courseManager.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserRequestDto userRequestDto);
    UserResponseDto toUserResponseDto(User user);
}
