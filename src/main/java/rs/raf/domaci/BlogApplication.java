package rs.raf.domaci;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import rs.raf.domaci.repository.BlogRepository;
import rs.raf.domaci.repository.RuntimeRepository;
import rs.raf.domaci.service.CommentsService;
import rs.raf.domaci.service.PostsService;


import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/blog")
public class BlogApplication extends ResourceConfig {

    public BlogApplication() {

        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);

        AbstractBinder binder = new AbstractBinder() {
            @Override
            protected void configure() {

                bind(RuntimeRepository.class).to(BlogRepository.class).in(Singleton.class);
                bind(RuntimeRepository.class).to(BlogRepository.class).in(Singleton.class);
                bindAsContract(PostsService.class);
                bindAsContract(CommentsService.class);
            }
        };

        register(binder);

        packages("rs.raf.domaci.resource");
    }
}