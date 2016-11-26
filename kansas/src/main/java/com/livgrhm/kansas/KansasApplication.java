package com.livgrhm.kansas;

import com.livgrhm.kansas.db.MyDAO;
import com.livgrhm.kansas.db.UserDAO;
import com.livgrhm.kansas.health.EmailHealthCheck;
import com.livgrhm.kansas.resources.AuthResource;
import com.livgrhm.kansas.resources.KansasResource;
import com.livgrhm.kansas.resources.RandomResource;
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
        
        final KansasResource resource = new KansasResource(
            configuration.getTemplate(),
            configuration.getDefaultName()
        );
        environment.jersey().register(resource);
        
        final EmailHealthCheck healthCheck = 
                new EmailHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
        
        // Auth & User Service
        final UserDAO userDAO = jdbi.onDemand(UserDAO.class);
        final AuthResource authResource = new AuthResource(userDAO, configuration.getSystemType());
        final UserResource userResource = new UserResource(userDAO);
        environment.jersey().register(authResource);
        environment.jersey().register(userResource);
        
    }

}
