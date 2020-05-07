package library_management_system_spring_angular.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library_management_system_spring_angular.dao.AdminDAO;
import library_management_system_spring_angular.dto.BookDto;
import library_management_system_spring_angular.dto.InformationDto;

@Service
public class AdminServiceImplementation implements AdminService {

	@Autowired
	private AdminDAO dao;

	public boolean register(InformationDto admin) {
		return dao.register(admin);
	}

	public boolean auth(String email, String password) {

		return dao.auth(email, password);
	}

	public boolean addBook(BookDto book) {
		return dao.addBook(book);
	}

	public List<BookDto> searchBookTitle(String bookTitle) {
		return dao.searchBookTitle(bookTitle);
	}

	public List<BookDto> searchBookAuthor(String bookAuthor) {
		return dao.searchBookAuthor(bookAuthor);
	}

	public List<BookDto> searchBookType(String bookType) {
		return dao.searchBookType(bookType);
	}

	public boolean updateBook(BookDto book) {
		return dao.updateBook(book);
	}

	public boolean removeBook(int bookId) {
		return dao.removeBook(bookId);
	}

	public List<BookDto> getBookIds() {
		return dao.getBookIds();
	}

	public List<BookDto> getBooksInfo() {
		return dao.getBooksInfo();
	}

	@Override
	public boolean issueBook(int bookId, int userId) {
		// TODO Auto-generated method stub
		return dao.issueBook(bookId, userId);
	}

	@Override
	public boolean returnBook(int userId, int bookId) {
		// TODO Auto-generated method stub
		return dao.returnBook(userId, bookId);
	}

}
