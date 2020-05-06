package com.capgemini.library_management_system_collections.dto;

import java.io.Serializable;

public class BookDto implements Serializable{
	
	private int bookId;
	private String bookTitle;
	private String bookAuthor;
	private String bookType;
	private String bookPublisher;
	
	public BookDto() {
		
	}
	
	public BookDto(int bookId, String bookTitle, String bookAuthor, String bookType, String bookPublisher) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookType = bookType;
		this.bookPublisher = bookPublisher;
	}



	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public String getBookPublisher() {
		return bookPublisher;
	}
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
	
	

}
