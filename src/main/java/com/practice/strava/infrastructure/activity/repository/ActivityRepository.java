package com.practice.strava.infrastructure.activity.repository;

import com.practice.strava.entity.Activity;
import com.practice.strava.infrastructure.activity.dto.ActivityResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findActivityByUserId(Long userId);
}
