package com.practice.strava.usecase.activity.Impl;

import com.practice.strava.entity.ActivityType;
import com.practice.strava.infrastructure.activity.repository.ActivityTypeRepository;
import com.practice.strava.usecase.activity.GetActivityTypeUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetActivityTypeUseCaseImpl implements GetActivityTypeUseCase {
    @Autowired
    ActivityTypeRepository activityTypeRepository;


    @Override
    public List<ActivityType> getAllActivityType() {
        return activityTypeRepository.findAll();
    }
}
