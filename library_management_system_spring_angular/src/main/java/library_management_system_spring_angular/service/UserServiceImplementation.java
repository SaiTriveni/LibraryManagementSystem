package library_management_system_spring_angular.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library_management_system_spring_angular.dao.UserDAO;
import library_management_system_spring_angular.dto.BookDto;
import library_management_system_spring_angular.dto.InformationDto;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserDAO dao;

	public boolean register(InformationDto std) {

		return dao.register(std);
	}

	public List<BookDto> searchBookTitle(String bookName) {
		return dao.searchBookTitle(bookName);
	}

	public List<BookDto> searchBookAuthor(String bookAuthor) {
		return dao.searchBookAuthor(bookAuthor);
	}

	public List<BookDto> searchBookType(String bookType) {
		return dao.searchBookType(bookType);
	}

	public List<Integer> getBookIds() {
		return dao.getBookIds();
	}

	public List<BookDto> getBooksInfo() {
		return dao.getBooksInfo();
	}

	@Override
	public boolean requestBook(int bookId, int userId) {
		// TODO Auto-generated method stub
		return dao.requestBook(bookId, userId);
	}

	@Override
	public boolean returnBook(int userId, int bookId) {
		// TODO Auto-generated method stub
		return dao.returnBook(bookId, userId);
	}

}
