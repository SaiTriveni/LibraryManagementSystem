package com.capgemini.library_management_system_jpa_corejava.service;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.library_management_system_jpa_corejava.dao.AdminDAO;
import com.capgemini.library_management_system_jpa_corejava.dto.AdminDTO;
import com.capgemini.library_management_system_jpa_corejava.dto.BookDTO;
import com.capgemini.library_management_system_jpa_corejava.dto.InformationDto;
import com.capgemini.library_management_system_jpa_corejava.factory.BookFactory;

public class AdminServiceImplementation implements AdminService {

	private AdminDAO dao=BookFactory.getAdminDao();
	
	public boolean register(InformationDto admin) {
		return dao.register(admin);
	}

	public boolean auth(String email, String password) {

		return dao.auth(email, password);
	}

	public boolean addBook(BookDTO book) {
		return dao.addBook(book);
	}

	public List<BookDTO> searchBookTitle(String bookTitle) {
		return dao.searchBookTitle(bookTitle);
	}

	public List<BookDTO> searchBookAuthor(String bookAuthor) {
		return dao.searchBookAuthor(bookAuthor);
	}

	public List<BookDTO> searchBookType(String bookType) {
		return dao.searchBookType(bookType);
	}

	public boolean updateBook(int bookId,String bookAuthor) {
		return dao.updateBook(bookId, bookAuthor);
	}

	public boolean removeBook(int bookId) {
		return dao.removeBook(bookId);
	}

	public List<BookDTO> getBookIds() {
		return dao.getBookIds();
	}

	public List<BookDTO> getBooksInfo() {
		return dao.getBooksInfo();
	}



	@Override
	public boolean issueBook(int bookId, int userId) {
		// TODO Auto-generated method stub
		return dao.issueBook(bookId,userId);
	}

	@Override
	public boolean returnBook(int userId, int bookId) {
		// TODO Auto-generated method stub
		return dao.returnBook(userId, bookId);
	}




	

}
