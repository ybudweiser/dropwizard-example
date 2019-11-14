package com.example.helloworld.modules;

import com.example.helloworld.core.Template;
import com.example.helloworld.health.TemplateHealthCheck;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class HealthCheckModule {
    private Template template;

    public HealthCheckModule(Template template){
        this.template = template;
    }

    @Singleton
    @Provides
    public TemplateHealthCheck provideTemplateHealthCheck(){
        return new TemplateHealthCheck(template);
    }
}
