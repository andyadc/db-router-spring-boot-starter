package com.andyadc.middleware.db.router.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class DataSourceAutoConfig implements EnvironmentAware {

    @Override
    public void setEnvironment(Environment environment) {

    }
}
