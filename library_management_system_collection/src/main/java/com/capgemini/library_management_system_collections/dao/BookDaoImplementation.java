package com.capgemini.library_management_system_collections.dao;

import java.util.List;

import com.capgemini.library_management_system_collections.database.Database;
import com.capgemini.library_management_system_collections.dto.BookDto;

public class BookDaoImplementation implements BookDao {

	public boolean addBook(BookDto dto) {

		for(BookDto bookdto : Database.BOOKS) {
			if(bookdto!=null) {
				System.out.println("Book is Added");
				return true;
			} else {
				System.out.println("Book is not added");
				
			}
		}
		return false;
	}

	public BookDto issueBook(String book_name, int book_id) {

		return null;
	}

	public boolean returnBook(int book_id) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<BookDto> search(int book_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(String book_name, int book_id) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
