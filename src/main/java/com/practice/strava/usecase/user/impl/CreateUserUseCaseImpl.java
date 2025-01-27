package com.practice.strava.usecase.user.impl;

import com.practice.strava.common.exceptions.DuplicateUserExceptions;
import com.practice.strava.entity.User;
import com.practice.strava.infrastructure.user.dto.UserRequest;
import com.practice.strava.infrastructure.user.dto.UserResponse;
import com.practice.strava.infrastructure.user.repository.UserRepository;
import com.practice.strava.usecase.user.CreateUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponse createUser(UserRequest req) {
        User user = userRepository.findByEmail(req.getEmail())
                .orElseThrow(()-> new DuplicateUserExceptions("User with email "+ req.getEmail() + " alrady present"));

        User newUser = userRepository.save(req.toEntity());
        return new UserResponse(newUser);
    }
}
