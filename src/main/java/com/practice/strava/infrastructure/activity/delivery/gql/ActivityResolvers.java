package com.practice.strava.infrastructure.activity.delivery.gql;

import com.practice.strava.common.responses.ApiResponse;
import com.practice.strava.entity.ActivityType;
import com.practice.strava.infrastructure.activity.dto.ActivityRequest;
import com.practice.strava.infrastructure.activity.dto.ActivityResponse;
import com.practice.strava.infrastructure.activity.dto.ActivityTypeRequest;
import com.practice.strava.infrastructure.activity.dto.ActivityTypeResponse;
import com.practice.strava.usecase.activity.CreateActivityTypeUseCase;
import com.practice.strava.usecase.activity.CreateActivityUseCase;
import com.practice.strava.usecase.activity.GetActivityTypeUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ActivityResolvers {
    @Autowired
    CreateActivityUseCase createActivityUseCase;

    @Autowired
    CreateActivityTypeUseCase createActivityTypeUseCase;

    @Autowired
    GetActivityTypeUseCase getActivityTypeUseCase;

    @QueryMapping(value = "getAllActivityType")
    public List<ActivityType> getAllActivityType(){
        return getActivityTypeUseCase.getAllActivityType();
    }

    @MutationMapping(value = "createActivityType")
    public ActivityTypeResponse createActivityType(@Argument ActivityTypeRequest req){
        return createActivityTypeUseCase.createActivityType(req);
    }

    @MutationMapping(value = "createActivity")
    public ActivityResponse createActivity(@Argument ActivityRequest req){
        return createActivityUseCase.createActivity(req);
    }
}