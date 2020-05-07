package library_management_system_spring_angular.dao;

import java.util.List;

import library_management_system_spring_angular.dto.BookDto;
import library_management_system_spring_angular.dto.InformationDto;

public interface AdminDAO {

	boolean register(InformationDto admin);

	boolean auth(String email, String password);

	// List<BookDTO> search(BookDTO book);
	boolean addBook(BookDto book);

	List<BookDto> searchBookTitle(String bookTitle);

	List<BookDto> searchBookAuthor(String bookAuthor);

	List<BookDto> searchBookType(String bookType);

	boolean updateBook(BookDto book);

	boolean removeBook(int bookId);

	List<BookDto> getBookIds();

	List<BookDto> getBooksInfo();

	boolean issueBook(int bookId, int userId);

	boolean returnBook(int userId, int bookId);

}
