package com.capgemini.library_management_system_jdbc_corejava.service;

import java.util.LinkedList;

import com.capgemini.library_management_system_jdbc_corejava.dto.BookDto;
import com.capgemini.library_management_system_jdbc_corejava.dto.UserDto;

public interface UserService {
	
	boolean register(UserDto std);
	LinkedList<BookDto> searchBookTitle(String bookName);
	LinkedList<BookDto> searchBookAuthor(String bookAuthor);
	LinkedList<BookDto> searchBookType(String bookType);
	LinkedList<Integer> getBookIds();
	LinkedList<BookDto> getBooksInfo();
	boolean requestBook(int bookId,int userId);
	boolean returnBook(int userId,int bookId);

}
