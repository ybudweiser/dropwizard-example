package com.example.helloworld.auth;

import com.example.helloworld.core.User;
import io.dropwizard.auth.Authorizer;

import javax.inject.Inject;

public class ExampleAuthorizer implements Authorizer<User> {

    @Inject
    public ExampleAuthorizer(){}

    @Override
    public boolean authorize(User user, String role) {
        return user.getRoles() != null && user.getRoles().contains(role);
    }
}
