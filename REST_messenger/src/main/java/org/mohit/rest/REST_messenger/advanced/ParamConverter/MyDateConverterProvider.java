package org.mohit.rest.REST_messenger.advanced.ParamConverter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

import org.mohit.rest.REST_messenger.advanced.resource.MyDate;

// use provider annotation for let JAXrs know about paramconverter provider
@Provider
public class MyDateConverterProvider implements ParamConverterProvider {

	@Override
	public <T> ParamConverter<T> getConverter(final Class<T> className, Type type, Annotation[] annotations) {
		
		if(className.getName().equals(MyDate.class.getName()))
		{
			return new ParamConverter<T>(){

				@Override
				public T fromString(String value) {
					
					Calendar requestedDate = Calendar.getInstance();
					if("tommorow".equals(value))
						requestedDate.add(Calendar.DATE, 1);
					if("yesterday".equals(value))
						requestedDate.add(Calendar.DATE, -1);
					
					MyDate myDate= new MyDate();
					myDate.setDate(requestedDate.get(Calendar.YEAR));
					myDate.setDate(requestedDate.get(Calendar.MONTH));
					myDate.setDate(requestedDate.get(Calendar.DATE));
					
					return className.cast(myDate);
				}

				@Override
				public String toString(T arg0) {
					if(arg0==null)return null;
					return arg0.toString();
				}
				
			};
		}
		return null;
	}

}
