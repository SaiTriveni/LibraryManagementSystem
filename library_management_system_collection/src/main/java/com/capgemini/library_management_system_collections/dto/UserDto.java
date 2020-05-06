package com.capgemini.library_management_system_collections.dto;

import java.io.Serializable;

public class UserDto implements Serializable{

	private int userId;
	private String userName;
	private String userPassword;
	private String userEmail;
	private int userBooksBorrowed;

	public UserDto() {

	}

	public UserDto(int userId, String userName, String userPassword, String userEmail, int userBooksBorrowed) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userBooksBorrowed = userBooksBorrowed;
	}







	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getUserBooksBorrowed() {
		return userBooksBorrowed;
	}
	public void setUserBooksBorrowed(int userBooksBorrowed) {
		this.userBooksBorrowed = userBooksBorrowed;
	}






}
