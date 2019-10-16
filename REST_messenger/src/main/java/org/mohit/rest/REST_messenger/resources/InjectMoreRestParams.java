package org.mohit.rest.REST_messenger.resources;

import java.util.List;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.mohit.rest.REST_messenger.model.Message;

@Path("/more")
@Produces({MediaType.TEXT_PLAIN,MediaType.TEXT_PLAIN})
public class InjectMoreRestParams {

	///more/annotations;param=Mohit...using matri param for valure from URI
	//we use ; instead of /
	
	@GET
	@Path("/annotations")
	public String getMessages(@MatrixParam("param") String  matrix,
			@HeaderParam("customerauth") String header, @CookieParam("__cfduid") String cookie
			)
	{
		return "matrix" + matrix +" "+ "header"+ header+ " " +"cookie"+ cookie;
	}
	
	@GET
	@Path("/context")
	public String getMessages(@Context UriInfo uriInfo, @Context HttpHeaders headers)
	{
		String path=uriInfo.getAbsolutePath().toString();
		String cookie= headers.getCookies().toString();
		return path +"   " +cookie;
	}
}
