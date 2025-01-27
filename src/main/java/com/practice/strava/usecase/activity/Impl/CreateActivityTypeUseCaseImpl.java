package com.practice.strava.usecase.activity.Impl;

import com.practice.strava.common.exceptions.DuplicateActivityTypeExceptions;
import com.practice.strava.entity.ActivityType;
import com.practice.strava.infrastructure.activity.dto.ActivityTypeRequest;
import com.practice.strava.infrastructure.activity.dto.ActivityTypeResponse;
import com.practice.strava.infrastructure.activity.repository.ActivityTypeRepository;
import com.practice.strava.usecase.activity.CreateActivityTypeUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateActivityTypeUseCaseImpl implements CreateActivityTypeUseCase {
    @Autowired
    ActivityTypeRepository activityTypeRepository;


    @Override
    public ActivityTypeResponse createActivityType(ActivityTypeRequest req) {
        Optional<ActivityType> activityType = activityTypeRepository.findByName(req.getName());

        if (activityType.isPresent()){
            throw new DuplicateActivityTypeExceptions("Activity type with the name " + req.getName() + " already exist !");
        }

        ActivityType newActivityType = activityTypeRepository.save(req.toEntity());
        return new ActivityTypeResponse(newActivityType);
    }
}
