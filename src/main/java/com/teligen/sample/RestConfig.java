package com.teligen.sample;

import org.glassfish.jersey.server.ResourceConfig;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.teligen.sample.rest.AppEndpoint;
import com.teligen.sample.rest.SysEndpoint;
import com.teligen.sample.rest.UserEndpoint;

@Component
public class RestConfig extends ResourceConfig {

	public RestConfig() {
//		packages("com.teligen.sample.rest");
		register(UserEndpoint.class);
		
		register(AppEndpoint.class);
		register(SysEndpoint.class);
		
		register(JacksonJsonProvider.class); 
	}

}
