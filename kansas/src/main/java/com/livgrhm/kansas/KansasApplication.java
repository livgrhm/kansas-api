package com.livgrhm.kansas;

import com.livgrhm.kansas.db.GoalDAO;
import com.livgrhm.kansas.db.UserDAO;
import com.livgrhm.kansas.health.EmailHealthCheck;
import com.livgrhm.kansas.resources.AuthResource;
import com.livgrhm.kansas.resources.GoalResource;
import com.livgrhm.kansas.resources.KansasResource;
import com.livgrhm.kansas.resources.UserResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

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
        
        // Core resource/app configuration
        final KansasResource resource = new KansasResource(
            configuration.getTemplate(),
            configuration.getDefaultName()
        );
        environment.jersey().register(resource);
        
        // Health checks
        final EmailHealthCheck healthCheck = 
                new EmailHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        
        // Database (MySQL)
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
        
        // Data Access Objects
        final UserDAO userDAO = jdbi.onDemand(UserDAO.class);
        final GoalDAO goalDAO = jdbi.onDemand(GoalDAO.class);
        
        // Init Resources
        final AuthResource authResource = new AuthResource(userDAO, configuration.getSystemType());
        final UserResource userResource = new UserResource(userDAO);
        final GoalResource goalResource = new GoalResource(goalDAO);
        
        // Register Resources
        environment.jersey().register(authResource);
        environment.jersey().register(userResource);
        environment.jersey().register(goalResource);
    }
    
} // /class KansasApplication
