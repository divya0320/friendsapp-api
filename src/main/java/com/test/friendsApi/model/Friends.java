package com.test.friendsApi.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Friends {
	

	@EmbeddedId
	private FriendIdentity id;
	
	private String name;
	
	private String city;

	public FriendIdentity getId() {
		return id;
	}

	public void setId(FriendIdentity id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Friends(FriendIdentity id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	
	
	public Friends() {

	}
	 

}
