package com.practice.strava.infrastructure.activity.dto;

import com.practice.strava.entity.Activity;
import com.practice.strava.entity.ActivityType;
import com.practice.strava.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityRequest {
    private Long userId;
    private String name;
    private Long activityTypeId;
    private Long distance;
    private Duration duration;
    private OffsetDateTime startedAt;
    private OffsetDateTime endedAt;

    public Activity toEntity(User user, ActivityType activityType){
        Activity activity = new Activity();
        activity.setUser(user);
        activity.setName(this.name);
        activity.setActivityType(activityType);
        activity.setDistance(this.distance);
        activity.setDuration(this.duration);
        activity.setStartedAt(this.startedAt);
        activity.setEndedAt(this.endedAt);
        return activity;
    }
}
