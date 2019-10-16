package org.mohit.rest.REST_messenger.model;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommentResource {

	@GET
	public String test() {
		// TODO Auto-generated method stub
		return "hello";
	}
	
	@GET
	@Path("/{commentID}")
	public String test1(@PathParam("commentID") long commentId, @PathParam("messageID") long messagesId) {
		// TODO Auto-generated method stub
		return "commentID"+commentId+"______"+"messageID"+messagesId;
	}

}
