package com.practice.strava.usecase.user;

import com.practice.strava.infrastructure.user.dto.UserRequest;
import com.practice.strava.infrastructure.user.dto.UserResponse;

public interface CreateUserUseCase {
    UserResponse createUser(UserRequest req);
}
