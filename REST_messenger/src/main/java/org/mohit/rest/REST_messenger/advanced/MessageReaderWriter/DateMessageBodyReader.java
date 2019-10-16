package org.mohit.rest.REST_messenger.advanced.MessageReaderWriter;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.mohit.rest.REST_messenger.advanced.resource.User;

@Provider
@Consumes(MediaType.APPLICATION_XML)
public class DateMessageBodyReader implements MessageBodyReader<User> {

	@Override
	public boolean isReadable(Class<?> type, Type arg1, Annotation[] arg2, MediaType arg3) {
		// TODO Auto-generated method stub
		return type == User.class;
	}

	@Override
	public User readFrom(Class<User> arg0, Type arg1, Annotation[] arg2, MediaType arg3,
			MultivaluedMap<String, String> arg4, InputStream input) throws IOException, WebApplicationException {
		
		try {
            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
            return (User) jaxbContext.createUnmarshaller().unmarshal(input);
        } catch (JAXBException e) {
            throw new ProcessingException("Error deserializing user.", e);
        }
	}

	

}
