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
public class ActivityResponse {
    private Long userId;
    private String userName;
    private String name;
    private Long activityTypeId;
    private String activityTypeName;
    private Long distance;
    private Duration duration;
    private OffsetDateTime startedAt;
    private OffsetDateTime endedAt;

    public ActivityResponse(Activity activity){
        this.userId = activity.getUser().getId();
        this.userName = activity.getUser().getName();
        this.activityTypeId = activity.getActivityType().getId();
        this.activityTypeName = activity.getActivityType().getName();
    }
}
