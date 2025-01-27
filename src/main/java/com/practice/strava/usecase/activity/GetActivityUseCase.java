package com.practice.strava.usecase.activity;

import com.practice.strava.infrastructure.activity.dto.ActivityResponse;

import java.util.List;

public interface GetActivityUseCase {
    List<ActivityResponse> getActivityByUserId(Long userId);
}
