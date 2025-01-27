package com.practice.strava.infrastructure.user.delivery.gql;

import com.practice.strava.infrastructure.user.dto.UserRequest;
import com.practice.strava.infrastructure.user.dto.UserResponse;
import com.practice.strava.usecase.user.CreateUserUseCase;
import com.practice.strava.usecase.user.GetUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserResolvers {
    @Autowired
    CreateUserUseCase createUserUseCase;

    @Autowired
    GetUserUseCase getUserUseCase;

    @QueryMapping(value = "getAllUser")
    public List<UserResponse> getAllUser(){
        return getUserUseCase.getAllUser();
    }

    @QueryMapping(value = "getUserById")
    public UserResponse getUseById(@Argument Long userId){
        return getUserUseCase.getUserById(userId);
    }

    @MutationMapping(value = "createUser")
    public UserResponse createUser(@Argument UserRequest req){
        return createUserUseCase.createUser(req);
    }
}
