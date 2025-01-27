package com.practice.strava.common.exceptions;

public class DuplicateUserExceptions extends RuntimeException {
    public DuplicateUserExceptions(String message) {
        super(message);
    }
}
