package com.practice.strava.infrastructure.user.dto;

import com.practice.strava.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequest {

    @NotNull
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

    public User toEntity(){
        User user = new User();
        user.setEmail(this.email);
        user.setName(this.name);
        user.setPassword(this.password);
        return user;
    }
}
