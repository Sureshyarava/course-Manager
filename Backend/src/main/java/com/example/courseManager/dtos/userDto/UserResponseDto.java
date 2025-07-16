package com.example.courseManager.dtos.userDto;

import com.example.courseManager.models.Review;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {
    public Long id;

    public String name;

    public List<Review> reviews;
}
