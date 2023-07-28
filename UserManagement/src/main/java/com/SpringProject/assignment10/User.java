package com.SpringProject.assignment10;

import java.io.Serializable;

public class User implements Serializable{
	private long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;

	public User(String username,String password,String firstName,String lastName,String email){
		this.username=username;
		this.password=password;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
	}
	public void setId(long id) {
		this.id=id;
	}
	public long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
}
