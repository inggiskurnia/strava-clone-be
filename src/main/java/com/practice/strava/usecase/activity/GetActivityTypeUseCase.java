package com.practice.strava.usecase.activity;

import com.practice.strava.infrastructure.activity.dto.ActivityTypeResponse;

import java.util.List;

public interface GetActivityTypeUseCase {
    List<ActivityTypeResponse> getAllActivityType();
}
