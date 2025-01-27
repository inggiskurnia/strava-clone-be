package com.practice.strava.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.OffsetDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "activity_id_gen")
    @SequenceGenerator(name = "activity_id_gen", sequenceName = "activities_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private ActivityType activityType;

    @Column(name = "distance")
    private Long distance;

    @Column(name = "duration")
    private Duration duration;

    @Column(name = "time_started")
    private OffsetDateTime startedAt;

    @Column(name = "time_ended")
    private OffsetDateTime endedAt;
}
