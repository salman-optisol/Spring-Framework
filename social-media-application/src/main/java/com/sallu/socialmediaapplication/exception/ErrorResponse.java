package com.sallu.socialmediaapplication.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    LocalDateTime time;
    String message;
    String description;
}
