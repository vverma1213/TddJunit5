package com.database;

import java.util.Objects;

public class Credentials {

	private String username;
	private String password;
	
	public Credentials(String username,String password) {
		this.username=username;
		this.password=password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(username,password);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this ==obj)
			return true;
		if(obj==null || getClass()!=obj.getClass())
			return false;
		Credentials cred=(Credentials)obj;
		return Objects.equals(username, cred.username) &&
				Objects.equals(password, cred.password);
	}
	
}
