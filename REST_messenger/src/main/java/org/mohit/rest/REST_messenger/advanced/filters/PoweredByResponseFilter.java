package org.mohit.rest.REST_messenger.advanced.filters;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class PoweredByResponseFilter implements ContainerResponseFilter {

	//http://localhost:8080/REST_messenger/webapi/
	//to get new header in request
	
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		
		responseContext.getHeaders().add("Powered by MD","Rest Web Service");
		
	}

}
