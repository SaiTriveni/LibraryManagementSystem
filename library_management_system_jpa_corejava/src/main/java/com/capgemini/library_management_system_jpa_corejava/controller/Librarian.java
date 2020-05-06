package com.capgemini.library_management_system_jpa_corejava.controller;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.library_management_system_jpa_corejava.dto.AdminDTO;
import com.capgemini.library_management_system_jpa_corejava.dto.BookDTO;
import com.capgemini.library_management_system_jpa_corejava.dto.InformationDto;
import com.capgemini.library_management_system_jpa_corejava.exception.ValidationException;
import com.capgemini.library_management_system_jpa_corejava.factory.BookFactory;
import com.capgemini.library_management_system_jpa_corejava.service.AdminService;
import com.capgemini.library_management_system_jpa_corejava.service.UserService;
import com.capgemini.library_management_system_jpa_corejava.validation.ValidationAdminStudent;

public class Librarian extends Thread{


	public void performOperations() {

		boolean flag = false;
		boolean flag1 = false;

		int regId = 0; 
		String regName = null; 
		String regEmail = null;
		String regPassword = null;
		String regRole = null;
		String regDepartment = null;

		int regId1 = 0; 
		String regName1 = null; 
		String regEmail1 = null; 
		String regPassword1 = null;

		AdminService service = BookFactory.getAdminService();
		ValidationAdminStudent validation = new ValidationAdminStudent();

		Scanner scanner = new Scanner(System.in);
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
						
						System.out.println("Enter Role");
						regRole = scanner.next();
									
						do {
							try {
								System.out.println("Enter ID :");
								regId = scanner.nextInt();
								validation.validatedId(regId);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Id should contains only digits");
							} catch (ValidationException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);

						do {
							try {
								System.out.println("Enter Name :");
								regName = scanner.next();
								validation.validatedName(regName);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Name should contains only Alphabates");
							} catch (ValidationException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);



						do {
							try {
								System.out.println("Enter Email :");
								regEmail = scanner.next();
								validation.validatedEmail(regEmail);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Email should be proper ");
							} catch (ValidationException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);



						do {
							try {
								System.out.println("Enter Password :");
								regPassword = scanner.next();
								validation.validatedPassword(regPassword);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Enter correct Password ");
							} catch (ValidationException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);

						
//						AdminDTO adminDto = new AdminDTO();
						InformationDto adminDto=new InformationDto();
						adminDto.setTypeOfUser(role);
						adminDto.setId(regId);
						adminDto.setName(regName);
						adminDto.setEmail(regEmail);
						adminDto.setPassword(regPassword);
						boolean check = service.register(adminDto);
						if(check) {
							System.out.println("Registered");
						} else {
							System.out.println("Email already exist");
						}	

						break;

					case 2:
					do {	
						System.out.println("Enter email");
						String email = scanner.next();
						System.out.println("Enter Password");
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
								System.out.println("Press 9 to Issue a book");
								System.out.println("Press 10 to return a book");
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

									BookDTO bean2 = new BookDTO();
									bean2.setBookId(bookId);	
									bean2.setBookTitle(bookName);
									bean2.setBookType(bookCategory);
									bean2.setBookAuthor(bookAuthor);
									bean2.setBookPublisher(bookPubName);
									flag = service.addBook(bean2);
									if(flag) {
										System.out.println("Book is added successfully");
									} else {
										System.out.println("Book already exist");
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
										System.out.println("Entered BookId is not available");
									}

									break;
								case 3:
									System.out.println("Enter the Book Name to Search Books");
									String book_Name = scanner.next();
									List<BookDTO> dto = service.searchBookTitle(book_Name);
									for (BookDTO bookDTO : dto) {
										if(bookDTO != null) {
											System.out.println("Book Is is "+bookDTO.getBookId());
											System.out.println("Book Name is " + bookDTO.getBookTitle());
											System.out.println("Book Author is " + bookDTO.getBookAuthor()); 
											System.out.println("Book Category is "+bookDTO.getBookType());
											System.out.println("Book Publisher is "+bookDTO.getBookPublisher());
										}else {
											System.out.println("No books are present by given book name");
										}
									}

									break;
								case 4:
									System.out.println("Enter the Book Author for required books");
									String book_Author = scanner.next();
									BookDTO bean5 = new BookDTO();
									bean5.setBookAuthor(book_Author);
									List<BookDTO> dto1 = service.searchBookAuthor(book_Author);
									for (BookDTO bookDTO : dto1) {
										if(bookDTO != null) {
											System.out.println("Book Is is "+bookDTO.getBookId());
											System.out.println("Book Name is " + bookDTO.getBookTitle());
											System.out.println("Book Author is " + bookDTO.getBookAuthor()); 
											System.out.println("Book Category is "+bookDTO.getBookType());
											System.out.println("Book Publisher is "+bookDTO.getBookPublisher());
										}else {
											System.out.println("No books are present by given author name");
										}
									}
									break;
								case 5:
									System.out.println("Enter the Book Type for required books");
									String book_Type = scanner.next();
									BookDTO bean6 = new BookDTO();
									bean6.setBookType(book_Type);
									List<BookDTO> dto2 = service.searchBookType(book_Type);
									for (BookDTO bookDTO : dto2) {
										if(bookDTO != null) {
											System.out.println("Book Is is "+bookDTO.getBookId());
											System.out.println("Book Name is " + bookDTO.getBookTitle());
											System.out.println("Book Author is " + bookDTO.getBookAuthor()); 
											System.out.println("Book Category is "+bookDTO.getBookType());
											System.out.println("Book Publisher is "+bookDTO.getBookPublisher());
										}else {
											System.out.println("No books are present by given Book Type");
										}
									}
									break;

								case 6:
									//BookDTO bean7 = new BookDTO();
									List<BookDTO> dto3 = service.getBookIds();
									for (BookDTO integer : dto3) {

										//if(integer != null ) {
											System.out.println(integer);
										//}
										//else {
										//	System.out.println("No books are present");
										//}
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
											System.out.println("Entered book is not available");
										}
									break;

								case 8:
									List<BookDTO> dto4 = service.getBooksInfo();
									for (BookDTO bookDTO : dto4) {

										if(bookDTO != null) {
											System.out.println("Book Is is "+bookDTO.getBookId());
											System.out.println("Book Name is " + bookDTO.getBookTitle());
											System.out.println("Book Author is " + bookDTO.getBookAuthor()); 
											System.out.println("Book Category is "+bookDTO.getBookType());
											System.out.println("Book Publisher is "+bookDTO.getBookPublisher());
										}else {
											System.out.println("No Books are present");
										}
									}
									break;

								case 9 :
									System.out.println("Enter Book Id");
									int issueId=scanner.nextInt();
									System.out.println("Enter User Id");
									int userId = scanner.nextInt();
									boolean check4=service.issueBook(issueId,userId);
									if(check4) {
										System.out.println("-----------------------------------------------");
										System.out.println("Book Issued");
									}else {
										System.out.println("-----------------------------------------------");
										System.out.println("Book not issued");
									}
									break;
								case 10 :
									System.out.println("Enter book id");
									int bookId1 = scanner.nextInt();
									System.out.println("Enter user id");
									int userId1 = scanner.nextInt();
									boolean check5 = service.returnBook(userId1, bookId1);
									if(check5 == true) {
										System.out.println("Book Returned");
									}else {
										System.out.println("Book cannot be returned");
									}
									break;

								case 11:
									performOperations();
									break;

								default:
									System.out.println("Invalid Choice");
									break;
								}
							}while(true);
						} catch (Exception e) {
							System.out.println("Invalid Credentials");
						}

						break;
					case 3:
						performOperations();
						break;
					default:
						System.out.println("Invalid Choice");
						break;
					}
				} while(true);

			case "User":
				UserService service1 = BookFactory.getUserService();
				do {
					System.out.println("Press 1 to Register as User ");
					System.out.println("Press 2 for User Login");
					System.out.println("Press 3 to main");
					int choice = scanner.nextInt();
					switch (choice) {
					case 1:
						do {
							try {
								System.out.println("Enter ID :");
								regId1 = scanner.nextInt();
								validation.validatedId(regId1);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Id should contains only digits");
							} catch (ValidationException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);




						do {
							try {
								System.out.println("Enter Name :");
								regName1 = scanner.next();
								validation.validatedName(regName1);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Name should contains only Alphabates");
							} catch (ValidationException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);



						do {
							try {
								System.out.println("Enter Email :");
								regEmail1 = scanner.next();
								validation.validatedEmail(regEmail1);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Email should be proper ");
							} catch (ValidationException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);

						do {
							try {
								System.out.println("Enter Password :");
								regPassword1 = scanner.next();
								validation.validatedPassword(regPassword1);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Enter correct Password ");
							} catch (ValidationException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);

						System.out.println();

//						UserDTO user = new UserDTO();
						InformationDto user=new InformationDto();
						user.setTypeOfUser(role);
						user.setId(regId1);
						user.setName(regName1);
						user.setEmail(regEmail1);
						user.setPassword(regPassword1);
						boolean check = service1.register(user);
						if(check) {
							System.out.println("Registered");
						} else {
							System.out.println("Email already exist");
						}
						break;
					case 2:
						do {	
							System.out.println("Enter email");
							String email = scanner.next();
							System.out.println("Enter Password");
							String password = scanner.next();
							flag1 = service.auth(email, password);
							}while(!flag1);
						try {
							
							System.out.println("Logged in");

							do {
								System.out.println("*****************************************");
								System.out.println("Press 1 to Search Book by Book Name");
								System.out.println("Press 2 to Search Book by Book Author");
								System.out.println("Press 3 to Search Book by Book Id");
								System.out.println("Press 4 to Get Book Id's ");
								System.out.println("Press 5 to get all books available");
								System.out.println("Press 6 to Request Book ");
								System.out.println("Press 7 to place Return request Book ");
								System.out.println("Press 8 to Go to Main");
								System.out.println("*****************************************");

								int choice1 = scanner.nextInt();
								switch (choice1) {
								case 1:
									System.out.println("Enter the Book Name to Search Books");
									String book_Name = scanner.next();
									List<BookDTO> dto = service1.searchBookTitle(book_Name);
									for (BookDTO bookDTO : dto) {
										if(bookDTO != null) {
											System.out.println("Book Is is "+bookDTO.getBookId());
											System.out.println("Book Name is " + bookDTO.getBookTitle());
											System.out.println("Book Author is " + bookDTO.getBookAuthor()); 
											System.out.println("Book Category is "+bookDTO.getBookType());
											System.out.println("Book Publisher is "+bookDTO.getBookPublisher());
										}else {
											System.out.println("No books are present by given book name");
										}
									}
									break;

								case 2:
									System.out.println("Enter the Book Author for required books");
									String book_Author = scanner.next();
									List<BookDTO> dto1 = service1.searchBookAuthor(book_Author);
									for (BookDTO bookDTO : dto1) {
										if(bookDTO != null) {
											System.out.println("Book Is is "+bookDTO.getBookId());
											System.out.println("Book Name is " + bookDTO.getBookTitle());
											System.out.println("Book Author is " + bookDTO.getBookAuthor()); 
											System.out.println("Book Category is "+bookDTO.getBookType());
											System.out.println("Book Publisher is "+bookDTO.getBookPublisher());
										}else {
											System.out.println("No books are present by given author name");
										}
									}
									break;

								case 3:
									System.out.println("Enter the Book Type for required books");
									String book_Type = scanner.next();
									List<BookDTO> dto2 = service1.searchBookType(book_Type);
									for (BookDTO bookDTO : dto2) {

										if(bookDTO != null) {
											System.out.println("Book Is is "+bookDTO.getBookId());
											System.out.println("Book Name is " + bookDTO.getBookTitle());
											System.out.println("Book Author is " + bookDTO.getBookAuthor()); 
											System.out.println("Book Category is "+bookDTO.getBookType());
											System.out.println("Book Publisher is "+bookDTO.getBookPublisher());
										}else {
											System.out.println("No books are present by given Book Type");
										}
									}
									break;

								case 4:
									List<Integer> dto3 = service1.getBookIds();
									for (Integer integer : dto3) {
										if(integer != null ) {
											System.out.println(integer);
										}else {
											System.out.println("No books are present");
										}
									}
									break;

								case 5:
									List<BookDTO> dto4 = service1.getBooksInfo();
									for (BookDTO bookDTO : dto4) {

										if(bookDTO != null) {
											System.out.println("Book Is is "+bookDTO.getBookId());
											System.out.println("Book Name is " + bookDTO.getBookTitle());
											System.out.println("Book Author is " + bookDTO.getBookAuthor()); 
											System.out.println("Book Category is "+bookDTO.getBookType());
											System.out.println("Book Publisher is "+bookDTO.getBookPublisher());
										}else {
											System.out.println("No Books are present");
										}
									}
									break;
								case 6:
									System.out.println("enter book id");
									int reqBook = scanner.nextInt();
									System.out.println("enter id");
									int  reqId = scanner.nextInt();
									boolean book = service1.requestBook(reqBook,reqId);
									if(book == true) {
										System.out.println("requested successfully");
									}else {
										System.out.println("book not found");
									}	
									break;
								case 7:
									System.out.println("Returning a book:");
									System.out.println("------------------");
									
										
										System.out.println("enter user id");
										int returned = scanner.nextInt();
										System.out.println("enter book id");
										int book_id = scanner.nextInt();
										boolean returnBook = service1.returnBook(returned, book_id);
										if(returnBook) {
											System.out.println("Book returned");
										}else {
											System.out.println("book not returned");
										}
									break;

								case 8:
									performOperations();

								default:
									System.out.println("Invalid Choice");
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
						System.out.println("Invalid Role");
					}
				} while(true);
			}
		}while(true);
	}
	
	public void run() {
		System.out.println("-----------------WELCOME TO LIBRARY MANAGEMENT SYSTEM----------------------");
		performOperations();
		}
}





