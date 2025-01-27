package com.practice.strava.common.responses;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
public class ApiResponse<T> {
    private int statusCode;
    private String message;
    private boolean success = false;
    private T data;

    public ApiResponse(int statusCode, String message){
        this.statusCode = statusCode;
        this.message = message;

        if (statusCode == HttpStatus.OK.value()){
            success = true;
        }
    }

    public static <T> ResponseEntity<ApiResponse<T>> failed(String message){
        return failed(HttpStatus.BAD_GATEWAY.value(), message, null);
    }

    public static <T> ResponseEntity<ApiResponse<T>> failed(int statusCode, String message, T data){
        ApiResponse<T> response = new ApiResponse<>(statusCode, message);
        response.setSuccess(false);
        response.setData(data);
        return ResponseEntity.status(statusCode).body(response);
    }

    public static <T> ResponseEntity<ApiResponse<T>> success(int statusCode, String message, T data){
        ApiResponse<T> response = new ApiResponse<>(statusCode, message);
        response.setSuccess(true);
        response.setData(data);
        return ResponseEntity.status(statusCode).body(response);
    }

    public static <T> ResponseEntity<ApiResponse<T>> success(String message){
        return failed(HttpStatus.OK.value(), message, null);
    }

}
