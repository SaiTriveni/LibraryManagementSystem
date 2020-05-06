package com.capgemini.library_management_system_collections.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.capgemini.library_management_system_collections.database.Database;
import com.capgemini.library_management_system_collections.dto.AdminDto;
import com.capgemini.library_management_system_collections.dto.BookDto;
import com.capgemini.library_management_system_collections.dto.RequestDto;
import com.capgemini.library_management_system_collections.dto.UserDto;
import com.capgemini.library_management_system_collections.exception.CollectionsException;

public class AdminDaoImplementation implements AdminDao {

	public boolean register(AdminDto admin) {

		for(AdminDto adm : Database.ADMINS) {
			if(adm.getAdminEmail().equals(admin.getAdminEmail())) {
				return false;
			}
		}
		Database.ADMINS.add(admin);
		return true;
	}

	public boolean auth(String email, String password) {
		
		boolean flag = false;

		for(AdminDto adm : Database.ADMINS) {
			if(adm.getAdminEmail().equals(email) && adm.getAdminPassword().equals(password)) {
				flag = true;
			}
			else if(adm.getAdminEmail().equals(email) && !adm.getAdminPassword().equals(password)) {
				System.err.println("Password Incorrect");
				flag = false;
			}
			else {
				System.err.println("Invalid Credentials");
				flag = false;
			}
		}
		return flag;
		}


	public boolean addBook(BookDto book) {
		for(BookDto bookDto : Database.BOOKS) {
			if(bookDto.getBookId() == book.getBookId()  ) {
				return false;
			}
		}
		Database.BOOKS.add(book);
		return true;
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

	public int updateBook(int bookId) {

		int status=0;
		for(int i=0;i<=Database.BOOKS.size()-1;i++)
		{
			BookDto retrievedBook=Database.BOOKS.get(i);
			int retrievedId=retrievedBook.getBookId();
			if(bookId==retrievedId)
			{
				status++;
				break;
			}
		}
		 throw new CollectionsException("Book is Not Found");
		
	}

	public LinkedList<Integer> getBookIds() {
		LinkedList<Integer> idList=new LinkedList<Integer>();
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

	public boolean removeBook(int bookId) {
		boolean status=false;
		for(int i=0;i<=Database.BOOKS.size()-1;i++)
		{
			BookDto retrievedBook=Database.BOOKS.get(i);
			int retrievedId=retrievedBook.getBookId();
			if(bookId==retrievedId)
			{
				status=true;
				Database.BOOKS.remove(i);
				
			}
		}
		return status;
	}

	public List<UserDto> showStudents() {
		List<UserDto> show = new LinkedList<UserDto>();

		for (UserDto info : Database.USERS) {
			info.getUserId();
			info.getUserName();
			info.getUserEmail();
			info.getUserBooksBorrowed();
			show.add(info);
		}
		return show;
	}
		
	public List<RequestDto> showRequests() {
		List<RequestDto> show = new LinkedList<RequestDto>();
		for (RequestDto requestInfo : Database.REQUESTS) {
			requestInfo.getBookInfo();
			requestInfo.getStudentInfo();
			requestInfo.isIssued();
			requestInfo.isReturned();
			show.add(requestInfo);
		}
		return show;
	}
		

	public boolean bookIssue(UserDto student, BookDto book) {
		boolean isValid = false;

		RequestDto requestInfo = new RequestDto();

		int noOfBooksBorrowed = student.getUserBooksBorrowed();
		for (RequestDto info : Database.REQUESTS) {
			if (info.getStudentInfo().getUserId() == student.getUserId()) {
				if (info.getBookInfo().getBookId() == book.getBookId()) {
					requestInfo = info;

					isValid = true;

				}
			}
		}

		if (isValid)

		{
			

			for (BookDto info2 : Database.BOOKS) {
				if (info2.getBookId() == book.getBookId()) {
					book = info2;
				}

			}

			for (UserDto studentInfo : Database.USERS) {
				if (studentInfo.getUserId() == student.getUserId()) {
					student = studentInfo;
					noOfBooksBorrowed = student.getUserBooksBorrowed();

				}

			}

			if (noOfBooksBorrowed < 3) {
				
				boolean isRemoved = Database.BOOKS.remove(book);
				if (isRemoved) {
					
					noOfBooksBorrowed++;
					System.out.println(noOfBooksBorrowed);
					student.setUserBooksBorrowed(noOfBooksBorrowed);
					requestInfo.setIssued(true);
					return true;
				} else {
					throw new CollectionsException("Book can't be borrowed");
				}

			} else {
				throw new CollectionsException("Student Exceeds maximum limit");
			}

		} else {
			throw new CollectionsException("Book data or Student data is incorrect");

		}
	}
		
	public boolean isBookReceived(UserDto student, BookDto book) {
		boolean isValid = false;
		RequestDto requestInfo1 = new RequestDto();
		for (RequestDto requestInfo : Database.REQUESTS) {

			if (requestInfo.getBookInfo().getBookId() == book.getBookId()
					&& requestInfo.getStudentInfo().getUserId() == student.getUserId() && requestInfo.isReturned() == true) {
				isValid = true;
				requestInfo1 = requestInfo;
			}
		}
		if (isValid) {
			
			book.setBookAuthor(requestInfo1.getBookInfo().getBookAuthor());
			book.setBookTitle(requestInfo1.getBookInfo().getBookTitle());
			//book.setPrice(requestInfo1.getBookInfo().getPrice());
			Database.BOOKS.add(book);
			Database.REQUESTS.remove(requestInfo1);
			

			for (UserDto userInfo2 : Database.USERS) {
				if (userInfo2.getUserId() == student.getUserId()) {
					student = userInfo2;
				}

			}
			
			int noOfBooksBorrowed = student.getUserBooksBorrowed();
			noOfBooksBorrowed--;
			student.setUserBooksBorrowed(noOfBooksBorrowed);
			return true;

		}

		return false;
	}
		
	

}
