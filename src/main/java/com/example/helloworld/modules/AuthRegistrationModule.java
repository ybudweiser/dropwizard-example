package com.example.helloworld.modules;

import com.example.helloworld.auth.ExampleAuthenticator;
import com.example.helloworld.auth.ExampleAuthorizer;
import com.example.helloworld.core.User;
import dagger.Module;
import dagger.Provides;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;

import javax.inject.Singleton;

@Module
public class AuthRegistrationModule {

    @Singleton
    @Provides
    AuthDynamicFeature providesAuthDynamicFeature(ExampleAuthenticator authn, ExampleAuthorizer authz ){
        return new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<User>()
                .setAuthenticator(authn)
                .setAuthorizer(authz)
                .setRealm("SUPER SECRET STUFF")
                .buildAuthFilter());
    }

    @Singleton
    @Provides
    AuthValueFactoryProvider.Binder<User> provideAuthValueFactoryProviderBinder(){
        return new AuthValueFactoryProvider.Binder<>(User.class);
    }
}
