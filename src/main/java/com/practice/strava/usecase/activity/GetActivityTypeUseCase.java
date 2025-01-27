package com.practice.strava.usecase.activity;

import com.practice.strava.entity.ActivityType;

import java.util.List;

public interface GetActivityTypeUseCase {
    List<ActivityType> getAllActivityType();
}
