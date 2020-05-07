package library_management_system_spring_angular.service;

import java.util.List;

import library_management_system_spring_angular.dto.BookDto;
import library_management_system_spring_angular.dto.InformationDto;

public interface UserService {

	boolean register(InformationDto std);

	List<BookDto> searchBookTitle(String bookName);

	List<BookDto> searchBookAuthor(String bookAuthor);

	List<BookDto> searchBookType(String bookType);

	List<Integer> getBookIds();

	List<BookDto> getBooksInfo();

	boolean requestBook(int bookId, int userId);

	boolean returnBook(int userId, int bookId);

}
