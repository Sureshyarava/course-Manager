package com.example.courseManager.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class ErrorResponse {
    public String message;
    public HttpStatus status;

}
