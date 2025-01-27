package com.practice.strava.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_gen")
    @SequenceGenerator(name = "users_id_gen", sequenceName = "users_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}
