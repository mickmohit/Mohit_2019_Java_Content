package org.mohit.rest.REST_messenger.advanced;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.mohit.rest.REST_messenger.advanced.resource.MyDate;
import org.mohit.rest.REST_messenger.advanced.resource.User;

@Path("date")
public class DateResource {

	//http://localhost:8080/REST_messenger/webapi/date/tommorow
	@GET
	@Path("/{dateString}")
	@Produces(MediaType.TEXT_PLAIN)
	public String method_Converter(@PathParam("dateString") MyDate myDate)
	{
		return myDate.toString();
	}
	
	//http://localhost:8080/REST_messenger/webapi/date/
	//here without writer it will throw error as you are trying to return date in text_plain
	@GET
	@Consumes(MediaType.APPLICATION_XML)
	public Date method_Writer()
	{
		return Calendar.getInstance().getTime();
	}
	
	//http://localhost:8080/REST_messenger/webapi/date/user
	// with header content-type=application/xml
	@POST
	@Path("/user")
	@Consumes(MediaType.APPLICATION_XML)
    public void getUser(User user){
        System.out.println(user);
    }

	// ********************Custom Media Type**********************
	//http://localhost:8080/REST_messenger/webapi/date/shortdate
	//you can provide any media type like below and customer will choose from accept header=text/shortdate
	
	@GET
	@Path("/shortdate")
	@Consumes(value= {MediaType.TEXT_PLAIN,"text/shortdate"})
    public Date getDate(){
        return Calendar.getInstance().getTime();
    }

}
