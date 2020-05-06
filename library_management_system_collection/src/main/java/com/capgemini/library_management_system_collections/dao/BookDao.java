package com.capgemini.library_management_system_collections.dao;

import java.util.List;

import com.capgemini.library_management_system_collections.dto.BookDto;

public interface BookDao {
	
	boolean addBook(BookDto dto);
	BookDto issueBook(String book_name,int book_id);
	boolean returnBook(int book_id);
	List<BookDto> search(int book_id);
	boolean delete(String book_name,int book_id);
    
}
