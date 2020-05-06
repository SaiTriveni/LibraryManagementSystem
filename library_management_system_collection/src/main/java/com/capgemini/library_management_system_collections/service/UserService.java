package com.capgemini.library_management_system_collections.service;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.library_management_system_collections.dto.BookDto;
import com.capgemini.library_management_system_collections.dto.RequestDto;
import com.capgemini.library_management_system_collections.dto.UserDto;

public interface UserService {
	
	boolean register(UserDto std);
	boolean auth(String email,String password);
	ArrayList<BookDto> searchBookTitle(String bookName);
	ArrayList<BookDto> searchBookAuthor(String bookAuthor);
	ArrayList<BookDto> searchBookType(String bookType);
	ArrayList<Integer> getBookIds();
	List<BookDto> getBooksInfo();
	RequestDto requestBook(UserDto student, BookDto book);
	RequestDto returnBook(UserDto student, BookDto book);

}
