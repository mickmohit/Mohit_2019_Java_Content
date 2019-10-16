package org.mohit.rest.REST_messenger.advanced.resource;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	 private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
	 
}
