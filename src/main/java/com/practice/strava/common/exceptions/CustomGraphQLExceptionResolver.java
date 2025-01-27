package com.practice.strava.common.exceptions;

import graphql.GraphQLError;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CustomGraphQLExceptionResolver extends DataFetcherExceptionResolverAdapter {
    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        return switch (ex) {
            case UserNotFoundException userNotFoundException -> GraphQLError.newError()
                    .message(ex.getMessage())
                    .extensions(Map.of(
                            "code", "USER_NOT_FOUND",
                            "details", "The user ID is invalid"))
                    .build();
            case DuplicateUserExceptions duplicateUserExceptions -> GraphQLError.newError()
                    .message(ex.getMessage())
                    .path(env.getExecutionStepInfo().getPath())
                    .extensions(Map.of(
                            "code", "DUPLICATE_USER",
                            "details", "The user already exists in the system."
                    ))
                    .build();
            case DuplicateActivityTypeExceptions duplicateActivityTypeExceptions -> GraphQLError.newError()
                    .message(ex.getMessage())
                    .path(env.getExecutionStepInfo().getPath())
                    .extensions(Map.of(
                            "code", "DUPLICATE_ACTIVITY_TYPE",
                            "details", "Activity type already exists in the system."
                    ))
                    .build();
            default -> null;
        };
    }
}
