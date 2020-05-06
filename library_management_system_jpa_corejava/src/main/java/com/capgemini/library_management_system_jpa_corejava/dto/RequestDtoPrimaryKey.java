package com.capgemini.library_management_system_jpa_corejava.dto;

import java.io.Serializable;

public class RequestDtoPrimaryKey implements Serializable{

	private int bookId;
	
	private String email;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "RequestDtoPrimaryKey [bookId=" + bookId + ", email=" + email + "]";
	}
	
	
}
