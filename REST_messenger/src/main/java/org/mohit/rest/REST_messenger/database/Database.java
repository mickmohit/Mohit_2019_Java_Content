package org.mohit.rest.REST_messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.mohit.rest.REST_messenger.model.Message;
import org.mohit.rest.REST_messenger.model.Profile;

public class Database {

	private static Map<Long, Message> messages= new HashMap<>();
	private static Map<String, Profile> profiles= new HashMap<>();
	
	public static Map<Long,Message>  messages()
	{
		return messages;
	}
	
	public static Map<String,Profile>  profiles()
	{
		return profiles;
	}
	
}
