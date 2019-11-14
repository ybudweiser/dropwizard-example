package com.example.helloworld.modules;

import com.example.helloworld.HelloWorldConfiguration;
import com.example.helloworld.core.Template;
import com.example.helloworld.db.PersonDAO;
import dagger.Module;
import dagger.Provides;
import org.hibernate.SessionFactory;

import javax.inject.Singleton;

@Module
public class RegistrationModule {
    private HelloWorldConfiguration configuration;
    private SessionFactory sessionFactory;

    public RegistrationModule(HelloWorldConfiguration configuration, SessionFactory sessionFactory){
        this.configuration = configuration;
        this.sessionFactory = sessionFactory;
    }

    @Singleton
    @Provides
    public Template provideTemplate(){
        return configuration.buildTemplate();
    }

    @Singleton
    @Provides
    public PersonDAO providePersonDAO(){
        return new PersonDAO(sessionFactory);
    }
}
