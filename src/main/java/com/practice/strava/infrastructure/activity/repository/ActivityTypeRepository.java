package com.practice.strava.infrastructure.activity.repository;

import com.practice.strava.entity.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivityTypeRepository extends JpaRepository<ActivityType, Long> {
    Optional<ActivityType> findByName(String name);
}
