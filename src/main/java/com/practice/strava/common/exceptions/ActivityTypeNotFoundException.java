package com.practice.strava.common.exceptions;

public class ActivityTypeNotFoundException extends RuntimeException {
    public ActivityTypeNotFoundException(String message) {
        super(message);
    }
}
