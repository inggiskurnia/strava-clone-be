package com.practice.strava.usecase.activity.Impl;

import com.practice.strava.common.exceptions.ActivityTypeNotFoundException;
import com.practice.strava.common.exceptions.UserNotFoundException;
import com.practice.strava.entity.Activity;
import com.practice.strava.entity.ActivityType;
import com.practice.strava.entity.User;
import com.practice.strava.infrastructure.activity.dto.ActivityRequest;
import com.practice.strava.infrastructure.activity.dto.ActivityResponse;
import com.practice.strava.infrastructure.activity.repository.ActivityRepository;
import com.practice.strava.infrastructure.activity.repository.ActivityTypeRepository;
import com.practice.strava.infrastructure.user.repository.UserRepository;
import com.practice.strava.usecase.activity.CreateActivityUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateActivityUseCaseImpl implements CreateActivityUseCase {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ActivityTypeRepository activityTypeRepository;

    @Autowired
    ActivityRepository activityRepository;

    @Override
    public ActivityResponse createActivity(ActivityRequest req) {
        User user = userRepository.findById(req.getUserId())
                .orElseThrow(()-> new UserNotFoundException("User with ID " + req.getUserId() + " not found !"));

        ActivityType activityType = activityTypeRepository.findById(req.getActivityTypeId())
                .orElseThrow(()-> new ActivityTypeNotFoundException("Activity type with ID " + req.getActivityTypeId() + " not found !"));

        Activity newActivity = activityRepository.save(req.toEntity(user, activityType));
        return new ActivityResponse(newActivity);
    }
}
