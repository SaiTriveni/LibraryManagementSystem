package com.capgemini.library_management_system_collections.service;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.library_management_system_collections.dao.UserDao;
import com.capgemini.library_management_system_collections.dto.BookDto;
import com.capgemini.library_management_system_collections.dto.RequestDto;
import com.capgemini.library_management_system_collections.dto.UserDto;
import com.capgemini.library_management_system_collections.factory.BookFactory;

public class UserServiceImplementation implements UserService {
	
	private UserDao dao=BookFactory.getStudentDAO();

	public boolean register(UserDto std) {

		return dao.register(std);
	}

	public ArrayList<BookDto> searchBookTitle(String bookName) {
		return dao.searchBookTitle(bookName);
	}

	public ArrayList<BookDto> searchBookAuthor(String bookAuthor) {
		return dao.searchBookAuthor(bookAuthor);
	}

	public ArrayList<BookDto> searchBookType(String bookType) {
		return dao.searchBookType(bookType);
	}

	public ArrayList<Integer> getBookIds() {
		return dao.getBookIds();
	}

	public List<BookDto> getBooksInfo() {
		return dao.getBooksInfo();
	}

	public RequestDto requestBook(UserDto student, BookDto book) {
		// TODO Auto-generated method stub
		return dao.requestBook(student, book);
	}

	public RequestDto returnBook(UserDto student, BookDto book) {
		// TODO Auto-generated method stub
		return dao.returnBook(student, book);
	}

	@Override
	public boolean auth(String email, String password) {
		// TODO Auto-generated method stub
		return dao.auth(email, password);
	}
	
	

}
