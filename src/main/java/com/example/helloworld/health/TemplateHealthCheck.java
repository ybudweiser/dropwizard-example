package com.example.helloworld.health;

import com.codahale.metrics.health.HealthCheck;
import com.example.helloworld.core.Template;

import javax.inject.Inject;
import java.util.Optional;

public class TemplateHealthCheck extends HealthCheck {
    private final Template template;

    @Inject
    public TemplateHealthCheck(Template template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        template.render(Optional.of("woo"));
        template.render(Optional.empty());
        return Result.healthy();
    }
}
