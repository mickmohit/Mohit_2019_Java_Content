package org.mohit.rest.REST_messenger.advanced.filters;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class SecurityFilter implements ContainerRequestFilter {

	private static final String AUTHORIZATION_HEADER_KEY="Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX="Basic ";
	private static final String STRING_URL_PREFIX="secured";
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// TODO Auto-generated method stub
		 if(requestContext.getUriInfo().getPath().contains(STRING_URL_PREFIX)) {
		List<String> authHeader= requestContext.getHeaders().get("AUTHORIZATION_HEADER_KEY");
		if(authHeader!=null && authHeader.size() > 0)
		{
			String token= authHeader.get(0);
			token=token.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
			String decodeString= Base64.decodeAsString(token);
			StringTokenizer tokenizer= new StringTokenizer(decodeString,":");
			String user= tokenizer.nextToken();
			String password=tokenizer.nextToken();
			
			if("user".equals(user) && "password".equals(password))
			{
				return;
			}
			
			Response unauthroised=
			Response.status(Response.Status.UNAUTHORIZED).entity("No Access").build();
			
			requestContext.abortWith(unauthroised);
		}
	}
	}
}
