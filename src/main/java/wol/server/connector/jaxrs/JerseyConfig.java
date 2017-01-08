package wol.server.connector.jaxrs;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.context.annotation.Configuration;


//import org.springframework.web.filter.RequestContextFilter;

@ApplicationPath("testRest")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		// Register RequestContextFilter from Spring integration module. 
        register(RequestContextFilter.class);
        register(JacksonFeature.class);
        register(WolMapperProvider.class);
		//register(View.class);
		packages("wol.server.connector.jaxrs.resource");
		//register(TestController.class);
	}

	public JerseyConfig(Set<Class<?>> classes) {
		super(classes);
		// TODO Auto-generated constructor stub
	}

	public JerseyConfig(Class<?>... classes) {
		super(classes);
		// TODO Auto-generated constructor stub
	}

	public JerseyConfig(ResourceConfig original) {
		super(original);
		// TODO Auto-generated constructor stub
	}
	
}
