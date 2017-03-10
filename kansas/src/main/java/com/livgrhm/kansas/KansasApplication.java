package com.livgrhm.kansas;

import com.livgrhm.kansas.api.AuthMap;
import com.livgrhm.kansas.db.GoalDAO;
import com.livgrhm.kansas.db.UserDAO;
import com.livgrhm.kansas.health.EmailHealthCheck;
import com.livgrhm.kansas.resources.AuthResource;
import com.livgrhm.kansas.resources.GoalResource;
import com.livgrhm.kansas.resources.UserResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.jdbi.bundles.DBIExceptionsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import io.dropwizard.bundles.redirect.HttpsRedirect;
import io.dropwizard.bundles.redirect.RedirectBundle;
import org.eclipse.jetty.servlets.CrossOriginFilter;
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
        bootstrap.addBundle(new DBIExceptionsBundle());
        //bootstrap.addBundle(new MultiPartBundle()); // upload imgs etc
        //bootstrap.addBundle(new RedirectBundle(new HttpsRedirect(false))); any 8080 redirect to ssl
    }

    @Override
    public void run(final KansasConfiguration configuration, final Environment environment) {
        
        // Enable CORS headers
        final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        cors.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");
        cors.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        
        // Health checks
        final EmailHealthCheck healthCheck = new EmailHealthCheck(configuration.getSmtpServer());
        environment.healthChecks().register("smtpServer", healthCheck);
        
        // Database (MySQL)
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
        
        // Data Access Objects
        final UserDAO userDAO = jdbi.onDemand(UserDAO.class);
        final GoalDAO goalDAO = jdbi.onDemand(GoalDAO.class);
        
        // Authentication Resource
        AuthMap checkAuth = new AuthMap(userDAO);
        final AuthResource authResource = new AuthResource(userDAO, checkAuth, configuration.getSystemType());
        
        // User Resource
        final UserResource userResource = new UserResource(userDAO, checkAuth);
        final GoalResource goalResource = new GoalResource(goalDAO, checkAuth);
        
        // Set URL pattern
        environment.jersey().setUrlPattern("/api/*");
        
        // Register Resources
        environment.jersey().register(authResource);
        environment.jersey().register(userResource);
        environment.jersey().register(goalResource);
    }
    
} // /class KansasApplication
