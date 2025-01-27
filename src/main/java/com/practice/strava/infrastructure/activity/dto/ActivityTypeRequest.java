package com.practice.strava.infrastructure.activity.dto;

import com.practice.strava.entity.ActivityType;
import lombok.Data;


@Data
public class ActivityTypeRequest {
    private String name;

    public ActivityType toEntity(){
        ActivityType activityType = new ActivityType();
        activityType.setName(this.name);
        return activityType;
    }
}
