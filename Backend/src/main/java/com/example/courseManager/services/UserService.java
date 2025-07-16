package com.example.courseManager.services;

import com.example.courseManager.dtos.userDto.UserRequestDto;
import com.example.courseManager.dtos.userDto.UserResponseDto;
import com.example.courseManager.exception.UserNotFoundException;
import com.example.courseManager.mapper.UserMapper;
import com.example.courseManager.models.User;
import com.example.courseManager.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDto save(UserRequestDto userRequestDto) {
        User user = userMapper.toUser(userRequestDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.toUserResponseDto(userRepository.save(user));
    }

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toUserResponseDto).collect(Collectors.toList());
    }

    public UserResponseDto getUser(Long userId) {
        return userMapper.toUserResponseDto(userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found")));
    }

    public User getUserByUsername(String username) {
        return userRepository.findByName(username).orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
