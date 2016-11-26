package com.livgrhm.kansas;

import com.livgrhm.kansas.health.EmailHealthCheck;
import com.livgrhm.kansas.resources.KansasResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class KansasApplication extends Application<KansasConfiguration> {

    public static void main(final String[] args) throws Exception {
        new KansasApplication().run(args);
    }

    @Override
    public String getName() {
        return "Kansas";
    }

    @Override
    public void initialize(final Bootstrap<KansasConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final KansasConfiguration configuration,
                    final Environment environment) {
        
        final KansasResource resource = new KansasResource(
            configuration.getTemplate(),
            configuration.getDefaultName()
        );
        
        final EmailHealthCheck healthCheck = 
                new EmailHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        
        environment.jersey().register(resource);
    }

}
