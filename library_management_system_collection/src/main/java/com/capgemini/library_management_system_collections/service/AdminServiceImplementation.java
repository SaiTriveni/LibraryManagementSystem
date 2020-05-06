package com.capgemini.library_management_system_collections.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.capgemini.library_management_system_collections.dao.AdminDao;
import com.capgemini.library_management_system_collections.dto.AdminDto;
import com.capgemini.library_management_system_collections.dto.BookDto;
import com.capgemini.library_management_system_collections.dto.RequestDto;
import com.capgemini.library_management_system_collections.dto.UserDto;
import com.capgemini.library_management_system_collections.factory.BookFactory;

public class AdminServiceImplementation implements AdminService {

	private AdminDao dao=BookFactory.getAdminDao();
	
	public boolean register(AdminDto admin) {
		return dao.register(admin);
	}

	public boolean auth(String email, String password) {

		return dao.auth(email, password);
	}

	public boolean addBook(BookDto book) {
		return dao.addBook(book);
	}

	public ArrayList<BookDto> searchBookTitle(String bookTitle) {
		return dao.searchBookTitle(bookTitle);
	}

	public ArrayList<BookDto> searchBookAuthor(String bookAuthor) {
		return dao.searchBookAuthor(bookAuthor);
	}

	public ArrayList<BookDto> searchBookType(String bookType) {
		return dao.searchBookType(bookType);
	}

	public int updateBook(int bookId) {
		return dao.updateBook(bookId);
	}

	public boolean removeBook(int bookId) {
		return dao.removeBook(bookId);
	}

	public LinkedList<Integer> getBookIds() {
		return dao.getBookIds();
	}

	public List<BookDto> getBooksInfo() {
		return dao.getBooksInfo();
	}

	public List<UserDto> showStudents() {
		// TODO Auto-generated method stub
		return dao.showStudents();
	}

	public List<RequestDto> showRequests() {
		// TODO Auto-generated method stub
		return dao.showRequests();
	}

	public boolean bookIssue(UserDto student, BookDto book) {
		// TODO Auto-generated method stub
		return dao.bookIssue(student, book);
	}

	public boolean isBookReceived(UserDto student, BookDto book) {
		// TODO Auto-generated method stub
		return dao.isBookReceived(student, book);
	}

	

}
