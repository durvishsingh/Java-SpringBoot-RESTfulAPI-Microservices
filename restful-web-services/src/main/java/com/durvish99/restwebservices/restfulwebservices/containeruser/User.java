package com.durvish99.restwebservices.restfulwebservices.containeruser;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

@Entity(name = "USER_DETAILS")
public class User 
{
	protected User() {
		
	}
	
	@Id
	@GeneratedValue
	int id;
	
	String name;
	public User(int id, String name) 
	{
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
