package com.java.library;

public class LibUsers {
	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LibUsers [userName=" + userName + ", password=" + password + "]";
	}

	public LibUsers(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public LibUsers() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
