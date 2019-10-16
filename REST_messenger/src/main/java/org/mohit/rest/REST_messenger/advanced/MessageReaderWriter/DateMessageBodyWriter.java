package org.mohit.rest.REST_messenger.advanced.MessageReaderWriter;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.TEXT_PLAIN) // this is to tell this writer is only for text_plain
public class DateMessageBodyWriter implements MessageBodyWriter<Date> {

	@Override
	public long getSize(Date arg0, Class<?> arg1, Type arg2, Annotation[] arg3, MediaType arg4) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public boolean isWriteable(Class<?> classType, Type arg1, Annotation[] arg2, MediaType arg3) {
		// TODO Auto-generated method stub
		return classType.getName().equals(Date.class.getName());
	}

	@Override
	public void writeTo(Date date, 
			Class<?> classType, Type arg2,
			Annotation[] annotation, MediaType mediatype,
			MultivaluedMap<String, Object> mm, OutputStream out) 
					throws IOException, WebApplicationException {
		
		out.write(date.toString().getBytes());
	}

}
