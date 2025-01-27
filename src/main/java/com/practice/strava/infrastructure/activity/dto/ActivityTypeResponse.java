package com.practice.strava.infrastructure.activity.dto;

import com.practice.strava.entity.ActivityType;
import lombok.Data;

@Data
public class ActivityTypeResponse {
    private Long id;
    private String name;

    public ActivityTypeResponse(ActivityType activityType){
        this.id = activityType.getId();
        this.name = activityType.getName();
    }
}
