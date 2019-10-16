package org.mohit.rest.REST_messenger.advanced;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("{pathParam}/test")
//@Singleton
public class MyResource {

	private int count;
	
	@PathParam("pathParam") String pathParam;
	@QueryParam("query") String query;
	
	// for above variable http://localhost:8080/REST_messenger/webapi/-2/test?query=Mohit
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testmethod()
	{
	return "it works"+(count++)+ pathParam + query;	
	}
	
	
}