package com.capgemini.library_management_system_jdbc_corejava.dao;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.library_management_system_jdbc_corejava.dto.AdminDto;
import com.capgemini.library_management_system_jdbc_corejava.dto.BookDto;

public interface AdminDao {
	
	boolean register(AdminDto admin);
	boolean auth(String email,String password);
	//List<BookDTO> search(BookDTO book);
	boolean addBook(BookDto book);
	LinkedList<BookDto> searchBookTitle(String bookTitle);
	LinkedList<BookDto> searchBookAuthor(String bookAuthor);
	LinkedList<BookDto> searchBookType(String bookType);
	boolean updateBook(int bookId,String bookAuthor);
	boolean removeBook(int bookId);
	LinkedList<Integer> getBookIds();
	LinkedList<BookDto> getBooksInfo();
	
	List<String> showStudents();
	LinkedList<Integer> showRequests();
	boolean issueBook(int bookId, int userId);
}
