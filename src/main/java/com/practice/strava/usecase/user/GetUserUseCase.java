package com.practice.strava.usecase.user;

import com.practice.strava.infrastructure.user.dto.UserResponse;

import java.util.List;

public interface GetUserUseCase {
    List<UserResponse> getAllUser();
    UserResponse getUserById(Long userId);
}
