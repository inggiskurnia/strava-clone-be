package com.practice.strava.usecase.activity.Impl;

import com.practice.strava.infrastructure.activity.dto.ActivityResponse;
import com.practice.strava.infrastructure.activity.repository.ActivityRepository;
import com.practice.strava.usecase.activity.GetActivityUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetActivityUseCaseImpl implements GetActivityUseCase {
    @Autowired
    ActivityRepository activityRepository;


    @Override
    public List<ActivityResponse> getActivityByUserId(Long userId) {

        return activityRepository.findActivityByUserId(userId)
                .stream().toList().stream().map(ActivityResponse::new).toList();
    }
}
