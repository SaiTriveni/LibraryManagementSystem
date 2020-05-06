package com.capgemini.library_management_system_jdbc_corejava.service;

import java.util.LinkedList;

import com.capgemini.library_management_system_jdbc_corejava.dao.UserDao;
import com.capgemini.library_management_system_jdbc_corejava.dto.BookDto;
import com.capgemini.library_management_system_jdbc_corejava.dto.UserDto;
import com.capgemini.library_management_system_jdbc_corejava.factory.BookFactory;

public class UserServiceImplementation implements UserService {
	
	private UserDao dao=BookFactory.getUserDAO();

	public boolean register(UserDto std) {

		return dao.register(std);
	}


	public LinkedList<BookDto> searchBookTitle(String bookName) {
		return dao.searchBookTitle(bookName);
	}

	public LinkedList<BookDto> searchBookAuthor(String bookAuthor) {
		return dao.searchBookAuthor(bookAuthor);
	}

	public LinkedList<BookDto> searchBookType(String bookType) {
		return dao.searchBookType(bookType);
	}

	public LinkedList<Integer> getBookIds() {
		return dao.getBookIds();
	}

	public LinkedList<BookDto> getBooksInfo() {
		return dao.getBooksInfo();
	}

	@Override
	public boolean requestBook(int bookId,int userId) {
		// TODO Auto-generated method stub
		return dao.requestBook(bookId, userId);
	}

	@Override
	public boolean returnBook(int userId,int bookId) {
		// TODO Auto-generated method stub
		return dao.returnBook(bookId, userId);
	}

	
	

}
