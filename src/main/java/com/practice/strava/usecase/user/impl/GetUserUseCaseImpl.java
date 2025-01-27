package com.practice.strava.usecase.user.impl;

import com.practice.strava.common.exceptions.UserNotFoundException;
import com.practice.strava.entity.User;
import com.practice.strava.infrastructure.user.dto.UserResponse;
import com.practice.strava.infrastructure.user.repository.UserRepository;
import com.practice.strava.usecase.user.GetUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUserUseCaseImpl implements GetUserUseCase {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserResponse> getAllUser() {
        return userRepository.findAll().stream().map(UserResponse::new).toList();
    }

    @Override
    public UserResponse getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException("User with id "+ userId + " not found !"));
        return new UserResponse(user);
    }
}
