package com.capgemini.library_management_system_collections.dao;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.library_management_system_collections.database.Database;
import com.capgemini.library_management_system_collections.dto.BookDto;
import com.capgemini.library_management_system_collections.dto.RequestDto;
import com.capgemini.library_management_system_collections.dto.UserDto;
import com.capgemini.library_management_system_collections.exception.CollectionsException;

public class UserDaoImplementation implements UserDao{

	
	public boolean register(UserDto std) {
		
		for(UserDto dto : Database.USERS) {
			if(dto.getUserEmail().equals(std.getUserEmail())) {
				return false;
			}
		}
		Database.USERS.add(std);
		return true;
	}

	public boolean auth(String email, String password) {
		
		boolean flag = false;
		for(UserDto dto : Database.USERS) {
			if(dto.getUserEmail().equals(email) && dto.getUserPassword().equals(password)) {
				flag = true;
			}
			else if(dto.getUserEmail().equals(email) && !dto.getUserPassword().equals(password)) {
				System.err.println("Incorrect password");
				flag = false;
			}
			else {
				flag = false;
			}
		}
		return flag;
	}
	
	public ArrayList<BookDto> searchBookTitle(String bookName) {
		ArrayList<BookDto> searchList=new ArrayList<BookDto>();
		for(int i=0;i<=Database.BOOKS.size()-1;i++)
		{
			BookDto retrievedBook=Database.BOOKS.get(i);
			String retrievedBookName=retrievedBook.getBookTitle();
			if(bookName.equals(retrievedBookName))
			{
				searchList.add(retrievedBook);	
				return searchList;	
			}
		}
		if(searchList.size()==0)
		{
			throw new CollectionsException("Book is Not Found");
		}
		else
		{
			return searchList;
		}		

	}

	public ArrayList<BookDto> searchBookAuthor(String bookAuthor) {
		ArrayList<BookDto> searchList=new ArrayList<BookDto>();
		for(int i=0;i<=Database.BOOKS.size()-1;i++)
		{
			BookDto retrievedBook=Database.BOOKS.get(i);
			String retrievedBookAuthor=retrievedBook.getBookAuthor();
			if(bookAuthor.equals(retrievedBookAuthor))
			{
				searchList.add(retrievedBook);	
			}
		}
		if(searchList.size()==0)
		{
			throw new CollectionsException("Book is Not Found");
		}
		else
		{
			return searchList;
		}
		
	}

	public ArrayList<BookDto> searchBookType(String bookType) {
		ArrayList<BookDto> searchList=new ArrayList<BookDto>();
		for(int i=0;i<=Database.BOOKS.size()-1;i++)
		{
			BookDto retrievedBook=Database.BOOKS.get(i);
			String retrievedBookType=retrievedBook.getBookType();
			if(bookType.equals(retrievedBookType))
			{
				searchList.add(retrievedBook);	
			}
		}
		if(searchList.size()==0)
		{
			throw new CollectionsException("Book is Not Found");
		}
		else
		{
			return searchList;
		}
	}

	public ArrayList<Integer> getBookIds() {
		ArrayList<Integer> idList=new ArrayList<Integer>();
		for(int i=0;i<=Database.BOOKS.size()-1;i++)
		{
			BookDto retrievedBook=Database.BOOKS.get(i);
			int retrievedBookId=retrievedBook.getBookId();
			idList.add(retrievedBookId);
		}
		return idList;
	}

	public List<BookDto> getBooksInfo() {
		
		return Database.BOOKS;
	}

	public RequestDto requestBook(UserDto student, BookDto book) {
		boolean flag = false, isRequestExists = false;
		RequestDto requestInfo = new RequestDto();
		UserDto userInfo2 = new UserDto();
		BookDto bookInfo2 = new BookDto();

		for (RequestDto requestInfo2 : Database.REQUESTS) {
			if (book.getBookId() == requestInfo2.getBookInfo().getBookId()) {
				isRequestExists = true;

			}

		}

		if (!isRequestExists) {
			for (UserDto user : Database.USERS) {
				if (user.getUserId() == student.getUserId()) {
					for (BookDto book1 : Database.BOOKS) {
						if (book1.getBookId() == book1.getBookId()) {
							userInfo2 = user;
							bookInfo2 = book1;
							flag = true;
						}
					}
				}
			}
			if (flag == true) {
				requestInfo.setBookInfo(bookInfo2);
				requestInfo.setStudentInfo(userInfo2);
				Database.REQUESTS.add(requestInfo);
				return requestInfo;
			}

		}

		throw new CollectionsException("Invalid request or you cannot request that book");
	}

	public RequestDto returnBook(UserDto student, BookDto book) {
				for (RequestDto requestInfo : Database.REQUESTS) {
					
					  if (requestInfo.getBookInfo().getBookId() == book.getBookId() &&
					  requestInfo.getStudentInfo().getUserId() == student.getUserId() &&
					  requestInfo.isIssued() == true) {
						System.out.println("Returning Issued book only");
						requestInfo.setReturned(true);
						return requestInfo;
					}

				}

				throw new CollectionsException("Invalid return ");
			}
}
