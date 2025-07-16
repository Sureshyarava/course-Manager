package com.example.courseManager.dtos.userDto;


import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Size;

public record UserRequestDto (@NotBlank(message = "User name should not come blank") String name,
                              @Size(min = 6) String password
                              ){}
