package com.capgemini.library_management_system_collections.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.capgemini.library_management_system_collections.dto.AdminDto;
import com.capgemini.library_management_system_collections.dto.BookDto;
import com.capgemini.library_management_system_collections.dto.RequestDto;
import com.capgemini.library_management_system_collections.dto.UserDto;

public interface AdminService {
	
	boolean register(AdminDto admin);
	boolean auth(String email,String password);
	boolean addBook(BookDto book);
	ArrayList<BookDto> searchBookTitle(String bookTitle);
	ArrayList<BookDto> searchBookAuthor(String bookAuthor);
	ArrayList<BookDto> searchBookType(String bookType);
	int updateBook(int bookId);
	boolean removeBook(int bookId);
	LinkedList<Integer> getBookIds();
	List<BookDto> getBooksInfo();
	
	List<UserDto> showStudents();
	List<RequestDto> showRequests();
	boolean bookIssue(UserDto student,BookDto book);
	boolean isBookReceived(UserDto student,BookDto book);
	
}
