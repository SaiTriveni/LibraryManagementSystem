package com.capgemini.library_management_system_jpa_corejava.dao;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.library_management_system_jpa_corejava.dto.AdminDTO;
import com.capgemini.library_management_system_jpa_corejava.dto.BookDTO;
import com.capgemini.library_management_system_jpa_corejava.dto.InformationDto;

public interface AdminDAO {
	
	boolean register(InformationDto admin);
	boolean auth(String email,String password);
	//List<BookDTO> search(BookDTO book);
	boolean addBook(BookDTO book);
	List<BookDTO> searchBookTitle(String bookTitle);
	List<BookDTO> searchBookAuthor(String bookAuthor);
	List<BookDTO> searchBookType(String bookType);
	boolean updateBook(int bookId,String bookAuthor);
	boolean removeBook(int bookId);
	List<BookDTO> getBookIds();
	List<BookDTO> getBooksInfo();

	boolean issueBook(int bookId, int userId);
	boolean returnBook(int userId, int bookId);
	
}
