package com.capgemini.library_management_system_jdbc_corejava.controller;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.library_management_system_jdbc_corejava.dto.BookDto;
import com.capgemini.library_management_system_jdbc_corejava.dto.UserDto;
import com.capgemini.library_management_system_jdbc_corejava.factory.BookFactory;
import com.capgemini.library_management_system_jdbc_corejava.service.AdminService;
import com.capgemini.library_management_system_jdbc_corejava.service.UserService;
import com.capgemini.library_management_system_jdbc_validation.ValidationAdminStudent;

public class Librarian extends Thread{


	Scanner scanner = new Scanner(System.in);
	public void performOperations() {

		boolean flag = false;
		boolean flag1 = false;

		AdminService service = BookFactory.getAdminService();
		ValidationAdminStudent validation = new ValidationAdminStudent();

		
		int i = 0;
		String role = "";
		do {
			
			do {
				try {

					System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
					System.out.println("Enter the role to choose either User or Admin");
					System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

					role = scanner.next();
					 flag = true;
				}catch(InputMismatchException e) {
					System.out.println("Enter only Integers");
					flag=false;
				}
			}while(!flag);


			switch(role) {
			case "Admin":
				
				do{
					System.out.println("#########################################");
					System.out.println("Press 1 to Register as Admin");
					System.out.println("Press 2 for Admin Login ");
					System.out.println("Press 3 to exit");
					System.out.println("#########################################");

					int choice = scanner.nextInt();
					switch (choice) {
					case 1:

						boolean status = Registration.register("admin");
						if(status) {
							System.out.println("Admin Successfully registered");
						}
						else
						{
							System.out.println("Admin already registered, kindly login");
						}	

						break;

					case 2:
					do {	
						System.out.println("Enter Admin EmailId");
						String email = scanner.next();
						System.out.println("Enter Admin Password");
						String password = scanner.next();
						flag1 = service.auth(email, password);
						}while(!flag1);
						try {
							
							System.out.println("Logged in");

							do {
								System.out.println("*****************************************");
								System.out.println("Press 1 to Add Books");
								System.out.println("Press 2 to Update");
								System.out.println("Press 3 to Search Book by Book Name");
								System.out.println("Press 4 to Search Book by Book Author");
								System.out.println("Press 5 to Search Book by Book Type");
								System.out.println("Press 6 to Get Book Id's ");
								System.out.println("Press 7 to Remove Any Book");
								System.out.println("Press 8 to Get No Of Books Available ");
								System.out.println("Press 9 Show Students ");
								System.out.println("Press 10 Show Requests");
								System.out.println("Press 11 to Go to Main");
								System.out.println("*****************************************");


								int choice1 = scanner.nextInt();
								switch (choice1) {
								case 1:
									System.out.println("Enter ID");
									int bookId = scanner.nextInt();
									System.out.println("Enter Book Name");
									String bookName = scanner.next();
									System.out.println("Enter Author");
									String bookAuthor = scanner.next();
									System.out.println("Enter Type");
									String bookCategory = scanner.next();
									System.out.println("Enter Publisher Name");
									String bookPubName = scanner.next();

									BookDto bean2 = new BookDto();
									bean2.setBookId(bookId);	
									bean2.setBookTitle(bookName);
									bean2.setBookType(bookCategory);
									bean2.setBookAuthor(bookAuthor);
									bean2.setBookPublisher(bookPubName);
									flag = service.addBook(bean2);
									if(flag) {
										System.out.println("Book is added successfully");
									} else {
										System.err.println("Book already exist");
									}
									break;
								case 2:
									System.out.println("Enter the Book Id to Update");
									int bookID = scanner.nextInt();
									System.out.println("Enter the Book AUthor to be updated");
									String author = scanner.next();
									flag = service.updateBook(bookID,author);
									if(flag)
									{
									System.out.println("Entered Book is Updated ");
									}
									else
									{
										System.err.println("Entered BookId is not available");
									}

									break;
								case 3:
									try {
									System.out.println("Enter the Book Name to Search Books");
									String book_Name = scanner.next();
									LinkedList<BookDto> dto = service.searchBookTitle(book_Name);
									System.out.println(String.format("%-20s %-40s %-20s %-20s %-20s", "BOOKID",
											"BOOKNAME", "AUTHOR", "CATEGORY", "PUBLISHER"));
									for (BookDto bookDto : dto) {
										if (bookDto != null) {
											System.out.println();
											System.out.println(String.format("%-20s %-40s %-20s %-20s %-20s",
													bookDto.getBookId(), bookDto.getBookTitle(), bookDto.getBookAuthor(),
													bookDto.getBookType(), bookDto.getBookPublisher()));
										} else {
											System.err.println("No books are present by given book name");
										}
									}
									}
									catch(Exception e)
									{
										System.err.println(e.getMessage());
									}

									break;
								case 4:
									try {
									System.out.println("Enter the Book Author for required books");
									String book_Author = scanner.next();
									BookDto bean5 = new BookDto();
									bean5.setBookAuthor(book_Author);
									List<BookDto> dto1 = service.searchBookAuthor(book_Author);
									System.out.println(String.format("%-20s %-40s %-20s %-20s %-20s", "BOOKID",
											"BOOKNAME", "AUTHOR", "CATEGORY", "PUBLISHER"));
									for (BookDto bookDto : dto1) {
										if (bookDto != null) {
											System.out.println();
											System.out.println(String.format("%-20s %-40s %-20s %-20s %-20s",
													bookDto.getBookId(), bookDto.getBookTitle(), bookDto.getBookAuthor(),
													bookDto.getBookType(), bookDto.getBookPublisher()));
										} else {
											System.err.println("No books are present by given author name");
										}
									}
									}
									catch(Exception e)
									{
										System.err.println(e.getMessage());
									}
									break;
								case 5:
									try {
									System.out.println("Enter the Book Type for required books");
									String book_Type = scanner.next();
									BookDto bean6 = new BookDto();
									bean6.setBookType(book_Type);
									List<BookDto> dto2 = service.searchBookType(book_Type);
									System.out.println(String.format("%-20s %-40s %-20s %-20s %-20s", "BOOKID",
											"BOOKNAME", "AUTHOR", "CATEGORY", "PUBLISHER"));
									for (BookDto bookDto : dto2) {
										if (bookDto != null) {
											System.out.println();
											System.out.println(String.format("%-20s %-40s %-20s %-20s %-20s",
													bookDto.getBookId(), bookDto.getBookTitle(), bookDto.getBookAuthor(),
													bookDto.getBookType(), bookDto.getBookPublisher()));
										} else {
											System.err.println("No books are present by given Book Type");
										}
									}
									}
									catch(Exception e)
									{
										System.err.println(e.getMessage());
									}
									break;

								case 6:
									BookDto bean7 = new BookDto();
									LinkedList<Integer> dto3 = service.getBookIds();
									for (Integer integer : dto3) {

										if(integer != null ) {
											System.out.println(integer);
										}else {
											System.err.println("No books are present");
										}
									}
									break;

								case 7:
									System.out.println("Enter the book Id to delete any book");
									int book_Id = scanner.nextInt();
									
										flag = service.removeBook(book_Id);
										if(flag)
										{
											System.out.println("Book has been removed successfully");
										}
										else
										{
											System.err.println("Entered book is not available");
										}
									break;

								case 8:
									try {
									LinkedList<BookDto> dto4 = service.getBooksInfo();
									System.out.println(String.format("%-20s %-40s %-20s %-20s %-20s", "BOOKID",
											"BOOKNAME", "AUTHOR", "CATEGORY", "PUBLISHER"));
									for (BookDto bookDto : dto4) {

										if (bookDto != null) {
											System.out.println();
											System.out.println(String.format("%-20s %-40s %-20s %-20s %-20s",
													bookDto.getBookId(), bookDto.getBookTitle(), bookDto.getBookAuthor(),
													bookDto.getBookType(), bookDto.getBookPublisher()));
										} else {
											System.err.println("No Books are present");
										}
									}
									}
									catch(Exception e) {
										System.err.println(e.getMessage());
									}
									break;

					

								case 9:
									try {
										System.out.println("Students of Library are :");
										System.out.println("-------------------------------");

										List<String> userInfos = service.showStudents();
										for (String info : userInfos) {

											System.out.println("Student Name -------- " + info);
											System.out.println("-------------------------------");
										}
									} catch (Exception e) {
										System.err.println("no books present in library");
									}
									break;
								case 10:
									try {
										System.out.println("Requests for Books are :");
										System.out.println("-------------------------------");

										List<Integer> requestInfos = service.showRequests();
										for (int info : requestInfos) {

											System.out.println("User id has requested book---------- " + info);
											System.out.println("-------------------------------");
										}
									} catch (Exception e) {
										System.err.println("no books present in library");
									}
									break;
					
								case 11:
									performOperations();
									break;

								default:
									System.err.println("Invalid Choice");
									break;
								}
							}while(true);
						} catch (Exception e) {
							System.err.println("Invalid Credentials");
						}

						break;
					case 3:
						performOperations();
						break;
					default:
						System.err.println("Invalid Choice");
						break;
					}
				} while(true);

			case "User":
				UserService service1 = BookFactory.getUserService();
				do {
					System.out.println("#########################################");
					System.out.println("Press 1 to Register as User");
					System.out.println("Press 2 for User Login ");
					System.out.println("Press 3 to exit");
					System.out.println("#########################################");
					int choice = scanner.nextInt();
					switch (choice) {
					case 1:
						
						boolean status = Registration.register("user");
						if(status) {
							System.out.println("User Successfully registered");
						}
						else
						{
							System.err.println("User already registered, kindly login");
						}	

						break;
					case 2:
						do {	
							flag1 = false;
							System.out.println("Enter User EmailId");
							String email = scanner.next();
							System.out.println("Enter User Password");
							String password = scanner.next();
							flag1 = service.auth(email, password);
							}while(!flag1);
						try {
							
							System.out.println("Successfully Logged in");

							do {
								System.out.println("*****************************************");
								System.out.println("Press 1 to Search Book by Book Name");
								System.out.println("Press 2 to Search Book by Book Author");
								System.out.println("Press 3 to Search Book by Book Id");
								System.out.println("Press 4 to Get Book Id's ");
								System.out.println("Press 5 to get all books available");
								System.out.println("Press 6 to Request Book ");
								System.out.println("Press 7 to Return Book ");
								System.out.println("Press 8 to Go to Main");
								System.out.println("*****************************************");

								int choice1 = scanner.nextInt();
								switch (choice1) {
								case 1:
									try {
									System.out.println("Enter the Book Name to Search Books");
									String book_Name = scanner.next();
									List<BookDto> dto = service1.searchBookTitle(book_Name);
									System.out.println(String.format("%-20s %-40s %-20s %-20s %-20s", "BOOKID",
											"BOOKNAME", "AUTHOR", "CATEGORY", "PUBLISHER"));
									for (BookDto bookDto : dto) {
										if (bookDto != null) {
											System.out.println();
											System.out.println(String.format("%-20s %-40s %-20s %-20s %-20s",
													bookDto.getBookId(), bookDto.getBookTitle(), bookDto.getBookAuthor(),
													bookDto.getBookType(), bookDto.getBookPublisher()));
										} else {
											System.err.println("No books are present by given book name");
										}
									}
									}
									catch(Exception e)
									{
										System.err.println(e.getMessage());
									}
									break;

								case 2:
									try {
									System.out.println("Enter the Book Author for required books");
									String book_Author = scanner.next();
									List<BookDto> dto1 = service1.searchBookAuthor(book_Author);
									System.out.println(String.format("%-20s %-40s %-20s %-20s %-20s", "BOOKID",
											"BOOKNAME", "AUTHOR", "CATEGORY", "PUBLISHER"));
									for (BookDto bookDto : dto1) {
										if (bookDto != null) {
											System.out.println();
											System.out.println(String.format("%-20s %-40s %-20s %-20s %-20s",
													bookDto.getBookId(), bookDto.getBookTitle(), bookDto.getBookAuthor(),
													bookDto.getBookType(), bookDto.getBookPublisher()));
										} else {
											System.err.println("No books are present by given author name");
										}
									}
									}
									catch(Exception e)
									{
										System.err.println(e.getMessage());
									}
									break;

								case 3:
									try {
									System.out.println("Enter the Book Type for required books");
									String book_Type = scanner.next();
									List<BookDto> dto2 = service1.searchBookType(book_Type);
									System.out.println(String.format("%-20s %-40s %-20s %-20s %-20s", "BOOKID",
											"BOOKNAME", "AUTHOR", "CATEGORY", "PUBLISHER"));
									for (BookDto bookDto : dto2) {
										if (bookDto != null) {
											System.out.println();
											System.out.println(String.format("%-20s %-40s %-20s %-20s %-20s",
													bookDto.getBookId(), bookDto.getBookTitle(), bookDto.getBookAuthor(),
													bookDto.getBookType(), bookDto.getBookPublisher()));
										} else {
											System.err.println("No books are present by given type");
										}
									}
									}
									catch(Exception e)
									{
										System.err.println(e.getMessage());
									}
									break;

								case 4:
									LinkedList<Integer> dto3 = service1.getBookIds();
									for (Integer integer : dto3) {
										if(integer != null ) {
											System.out.println(integer);
										}else {
											System.err.println("No books are present");
										}
									}
									break;

								case 5:
									try {
									LinkedList<BookDto> dto4 = service1.getBooksInfo();
									System.out.println(String.format("%-20s %-40s %-20s %-20s %-20s", "BOOKID",
											"BOOKNAME", "AUTHOR", "CATEGORY", "PUBLISHER"));
									for (BookDto bookDto : dto4) {

										if (bookDto != null) {
											System.out.println();
											System.out.println(String.format("%-20s %-40s %-20s %-20s %-20s",
													bookDto.getBookId(), bookDto.getBookTitle(), bookDto.getBookAuthor(),
													bookDto.getBookType(), bookDto.getBookPublisher()));
										} else {
											System.err.println("No Books are present");
										}
									}
									}
									catch(Exception e) {
										System.err.println(e.getMessage());
									}
									break;
								case 6:
									System.out.println("Enter book id which is required");
									int bookId = scanner.nextInt();
									BookDto dto5 = new BookDto();
									dto5.setBookId(bookId);
									System.out.println("Enter user id");
									int userId = scanner.nextInt();
									UserDto bean8 = new UserDto();

									try {
										boolean request = service1.requestBook(bookId, userId);
										if(request)
										{
											System.out.println("Book has been successfully issued");
										}
									} catch (Exception e) {

										System.err.println("Enter valid data or Invalid Request");
									}
									break;
								case 7:
									System.out.println("Returning a book:");
									System.out.println("------------------");
									System.out.println("Enter Book Id");
									int book = scanner.nextInt();
									System.out.println("Enter User Id");
									int id  = scanner.nextInt();

									try {
										boolean requestInfo = service1.returnBook(book,id);
										if(requestInfo)
										{
											System.out.println("Book has been successfully returned");
										}
										else
										{
											System.out.println("Book has not returned successfully");
										}
										
									} catch (Exception e) {
										System.err.println("Invalid Return");
									}
									break;

								case 8:
									performOperations();

								default:
									System.err.println("Invalid Choice");
									break;
								}
							}while(true);
						}catch(Exception e) {
							e.printStackTrace();
						}
					case 3:
						performOperations();
						break;

					default:
						System.err.println("Invalid Role");
					}
				} while(true);
			}
		}while(true);
	}
	
	public void run() {
		System.out.println("-----------------WELCOME TO LIBRARY MANAGEMENT SYSTEM----------------------");
		performOperations();
		scanner.close();
		}
}





