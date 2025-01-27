package com.practice.strava.usecase.activity;

import com.practice.strava.infrastructure.activity.dto.ActivityTypeRequest;
import com.practice.strava.infrastructure.activity.dto.ActivityTypeResponse;

public interface CreateActivityTypeUseCase {
    ActivityTypeResponse createActivityType(ActivityTypeRequest req);
}
