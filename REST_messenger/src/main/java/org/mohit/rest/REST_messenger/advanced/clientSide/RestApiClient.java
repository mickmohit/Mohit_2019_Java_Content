package org.mohit.rest.REST_messenger.advanced.clientSide;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.mohit.rest.REST_messenger.model.Message;

public class RestApiClient {

	public static void main(String[] args) {
	Client client= ClientBuilder.newClient();
	Response response=
	client.target("http://localhost:8080/REST_messenger/webapi/messages/links/2")
	.request(MediaType.TEXT_XML).get();
	Message message= response.readEntity(Message.class);
	
	///************** Industry standard way of writing rest client side
	
	WebTarget baseTarget= client.target("http://localhost:8080/REST_messenger/webapi/");
	WebTarget messageTarget=baseTarget.path("messages");
	WebTarget singleMessageTarget =messageTarget.path("{messageID}");
	
	Message message1= singleMessageTarget.resolveTemplate("messageID", "2")
					.request(MediaType.TEXT_XML).get(Message.class);
	
	System.out.println(message.getMessage());
	System.out.println(message1.getLinks());
	
	// Post Method
	
	Message message_post= new Message(8, "Rest Post Message", "Mohit");
	Response res_post=	messageTarget.request().post(Entity.entity(message_post, MediaType.TEXT_XML));
	
	Message mess_post_check= res_post.readEntity(Message.class);
	System.out.println(mess_post_check.getMessage());
}

}