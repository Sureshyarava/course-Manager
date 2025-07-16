package com.example.courseManager.controllers;

import com.example.courseManager.dtos.userDto.UserRequestDto;
import com.example.courseManager.dtos.userDto.UserResponseDto;
import com.example.courseManager.security.CustomUserDetails;
import com.example.courseManager.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public UserResponseDto registerUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        return userService.save(userRequestDto);
    }

    @GetMapping("/me")
    public UserResponseDto getCurrentUser(@AuthenticationPrincipal CustomUserDetails userDetails) {
        return UserResponseDto.builder().id(userDetails.getId()).name(userDetails.getUsername()).build();
    }

    @GetMapping("/users")
    public List<UserResponseDto> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public UserResponseDto getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
}
