package com.example.courseManager.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer rating;

    @ManyToOne
    @JoinColumn(name="userId")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name="courseId")
    @JsonBackReference
    private Course course;
}
