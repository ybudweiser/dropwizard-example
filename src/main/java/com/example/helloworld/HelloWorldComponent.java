package com.example.helloworld;

import com.example.helloworld.core.User;
import com.example.helloworld.health.TemplateHealthCheck;
import com.example.helloworld.modules.AuthRegistrationModule;
import com.example.helloworld.modules.RegistrationModule;
import com.example.helloworld.resources.*;
import com.example.helloworld.tasks.EchoTask;
import dagger.Component;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;

import javax.inject.Singleton;

@Singleton
@Component(modules = {RegistrationModule.class, AuthRegistrationModule.class})
public interface HelloWorldComponent {

    ViewResource viewResource();

    TemplateHealthCheck templateHealthCheck();

    EchoTask echoTask();

    AuthDynamicFeature authDynamicFeature();

    AuthValueFactoryProvider.Binder<User> authValueFactoryProviderBinder();

    ProtectedResource protectedResource();

    FilteredResource filteredResource();

    HelloWorldResource helloWorldResource();

    PeopleResource peopleResource();

    PersonResource personResource();


}
