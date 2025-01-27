package com.practice.strava.common.exceptions;

import com.practice.strava.common.responses.ApiResponse;
import lombok.extern.java.Log;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Log
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?>handleUserNotFoundException(DataAccessException ex){
        return ApiResponse.failed(ex.getMessage());
    }

    @ExceptionHandler(ActivityTypeNotFoundException.class)
    public ResponseEntity<?>handleActivityTypeNotFoundException(DataAccessException ex){
        return ApiResponse.failed(ex.getMessage());
    }

    @ExceptionHandler(DuplicateUserExceptions.class)
    public ResponseEntity<?>handleDuplicateUserExceptions(DataAccessException ex){
        return ApiResponse.failed(ex.getMessage());
    }

    @ExceptionHandler(DuplicateActivityTypeExceptions.class)
    public ResponseEntity<?>handleDuplicateActivityTypeExceptions(DataAccessException ex){
        return ApiResponse.failed(ex.getMessage());
    }
}
