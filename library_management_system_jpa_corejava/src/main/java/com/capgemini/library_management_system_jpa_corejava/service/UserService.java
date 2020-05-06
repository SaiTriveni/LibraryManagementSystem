package com.capgemini.library_management_system_jpa_corejava.service;

import java.util.List;

import com.capgemini.library_management_system_jpa_corejava.dto.BookDTO;
import com.capgemini.library_management_system_jpa_corejava.dto.InformationDto;

public interface UserService {
	
	boolean register(InformationDto std);
	List<BookDTO> searchBookTitle(String bookName);
	List<BookDTO> searchBookAuthor(String bookAuthor);
	List<BookDTO> searchBookType(String bookType);
	List<Integer> getBookIds();
	List<BookDTO> getBooksInfo();
	boolean requestBook(int bookId,int userId);
	boolean returnBook(int userId,int bookId);

}
