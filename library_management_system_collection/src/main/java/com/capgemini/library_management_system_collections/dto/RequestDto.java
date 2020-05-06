package com.capgemini.library_management_system_collections.dto;


public class RequestDto {
	
	private BookDto bookInfo;
	private UserDto studentInfo;
	private boolean isIssued;
	private boolean isReturned;
	
	public boolean isIssued() {
		return isIssued;
	}
	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}
	public boolean isReturned() {
		return isReturned;
	}
	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}
	public BookDto getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(BookDto bookInfo) {
		this.bookInfo = bookInfo;
	}
	public UserDto getStudentInfo() {
		return studentInfo;
	}
	public void setStudentInfo(UserDto studentInfo) {
		this.studentInfo = studentInfo;
	}

}
