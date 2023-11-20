package com.sallu.socialmediaapplication.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
        ErrorResponse response = new ErrorResponse();
        response.setTime(LocalDateTime.now());
        response.setMessage(ex.getMessage());
        response.setDescription(request.getDescription(false));

        return new ResponseEntity<ErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
        ErrorResponse response = new ErrorResponse();
        response.setTime(LocalDateTime.now());
        response.setMessage(ex.getMessage());
        response.setDescription(request.getDescription(false));

        return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        ErrorResponse response = new ErrorResponse();
        response.setTime(LocalDateTime.now());
        response.setMessage(ex.getFieldError().getDefaultMessage());
        response.setDescription(request.getDescription(false));

        return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
    }
}
