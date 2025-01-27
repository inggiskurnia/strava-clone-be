package com.practice.strava.infrastructure.user.dto;

import com.practice.strava.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String name;
    private String email;

    public UserResponse(User user){
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
