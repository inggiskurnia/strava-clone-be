package com.practice.strava.usecase.activity;

import com.practice.strava.infrastructure.activity.dto.ActivityRequest;
import com.practice.strava.infrastructure.activity.dto.ActivityResponse;

public interface CreateActivityUseCase {
    ActivityResponse createActivity(ActivityRequest req);
}
