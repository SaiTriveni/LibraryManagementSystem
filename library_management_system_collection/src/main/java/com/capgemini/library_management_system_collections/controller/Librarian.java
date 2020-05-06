package com.capgemini.library_management_system_collections.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.library_management_system_collections.dto.BookDto;
import com.capgemini.library_management_system_collections.dto.RequestDto;
import com.capgemini.library_management_system_collections.dto.UserDto;
import com.capgemini.library_management_system_collections.factory.BookFactory;
import com.capgemini.library_management_system_collections.service.AdminService;
import com.capgemini.library_management_system_collections.service.UserService;
import com.capgemini.library_management_system_collections.validation.ValidationAdminStudent;

public class Librarian extends Thread{

	Scanner scanner = new Scanner(System.in);
	public void performOperations() {

		boolean flag = false;
		int count = 0;

		AdminService service = BookFactory.getAdminService();
		ValidationAdminStudent validation = new ValidationAdminStudent();


		String i = null;
		do {

			do {
				try {
					System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
					System.out.println("Choose admin or user to proceed");
					System.out.println("Enter the role :");
					System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
					i = scanner.next();
					if ((i.equals("admin")) || (i.equals("user"))) {
						flag = true;
					} else {
						System.err.println("Enter either admin or user only");
					}
				} catch (InputMismatchException e) {
					System.err.println("Enter either 1 or 2 only");
					flag = false;
				}
			} while (!flag);

			switch (i) {
			case "admin":
				do {
					System.out.println("#########################################");
					System.out.println("Press 1 to Register as Admin");
					System.out.println("Press 2 for Admin Login ");
					System.out.println("Press 3 to exit");
					System.out.println("#########################################");

					int choice = scanner.nextInt();
					switch (choice) {
					case 1:
						count = 1;
						boolean status = Registration.register(count);
						if(status) {
							System.out.println("Admin Successfully registered");
						}
						else
						{
							System.out.println("Admin already registered, kindly login");
						}					

						break;

					case 2:
						boolean authBean = false;
						do {
							System.out.println("Enter Admin EmailId");
							String email = scanner.next();
							System.out.println("Enter Admin Password");
							String password = scanner.next();
							
							authBean = service.auth(email, password);
						}while(!authBean);
						try {
							System.out.println("Successfully logged in");

							do {
								System.out.println("*****************************************");
								System.out.println("Press 1 to Add Books");
								System.out.println("Press 2 to Update");
								System.out.println("Press 3 to Search Book by Book Name");
								System.out.println("Press 4 to Search Book by Book Author");
								System.out.println("Press 5 to Search Book by Book Type");
								System.out.println("Press 6 to Get Book Id's ");
								System.out.println("Press 7 to Remove Any Book");
								System.out.println("Press 8 to Get information of all books ");
								System.out.println("Press 9 to Issue Book");
								System.out.println("Press 10 Show all Users ");
								System.out.println("Press 11 Show Requests");
								System.out.println("Press 12 Receive Returned Books");
								System.out.println("Press 13 to Go to Main");
								System.out.println("*****************************************");

								int choice1 = scanner.nextInt();
								switch (choice1) {
								case 1:
									System.out.println("Enter Book Id");
									int bookId = scanner.nextInt();
									System.out.println("Enter Book Name");
									String bookName = scanner.next();
									System.out.println("Enter Book Author");
									String bookAuthor = scanner.next();
									System.out.println("Enter Book Category");
									String bookCategory = scanner.next();
									System.out.println("Enter Book Publisher Name");
									String bookPubName = scanner.next();

									BookDto bean2 = new BookDto();
									bean2.setBookId(bookId);
									bean2.setBookTitle(bookName);
									bean2.setBookType(bookCategory);
									bean2.setBookAuthor(bookAuthor);
									bean2.setBookPublisher(bookPubName);
									boolean check2 = service.addBook(bean2);
									if (check2) {
										System.out.println("Book has been added to the library successfully");
									} else {
										System.err.println("Entered Book already exists in the library");
									}
									break;
								case 2:
									System.out.println("Enter the Book Id to Update");
									int bookID = scanner.nextInt();
									BookDto bean3 = new BookDto();
									bean3.setBookId(bookID);
									int update = service.updateBook(bookID);
									if (update != 0) {
										System.out.println("Entered BookId is Updated ");
									} else {
										System.err.println("Entered BookId is not updated ");
									}

									break;
								case 3:
									try {
									System.out.println("Enter the Book Name to Search Books");
									String book_Name = scanner.next();
									BookDto bean4 = new BookDto();
									bean4.setBookTitle(book_Name);
									List<BookDto> dto = service.searchBookTitle(book_Name);
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

										if (integer != null) {
											System.out.println(integer);
										} else {
											System.err.println("No books are present");
										}
									}
									break;

								case 7:
									System.out.println("Enter the book Id to delete book");
									int book_Id = scanner.nextInt();
									if (book_Id == 0) {
										System.out.println("Enter the Value other than 0");
									} else {
										BookDto bean8 = new BookDto();
										bean8.setBookId(book_Id);
										boolean check3 = service.removeBook(book_Id);
										if (check3) {
											System.out.println(book_Id+" Book is Deleted");
										} else {
											System.err.println(book_Id+" Book is not Deleted");
										}
									}
									break;

								case 8:
									try {
									List<BookDto> dto4 = service.getBooksInfo();
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
									UserDto userDto = new UserDto();
									BookDto bookDto = new BookDto();
									System.out.println("Enter Book Id");
									int bId = scanner.nextInt();
									System.out.println("Enter User Id");
									int uId = scanner.nextInt();
									bookDto.setBookId(bId);
									userDto.setUserId(uId);
									try {
										boolean isIssued = service.bookIssue(userDto, bookDto);
										if (isIssued) {
											System.out.println("Book Issued Successfully");
										} else {
											System.err.println("Book cannot be issued");
										}

									} catch (Exception e) {
										System.err.println("Invalid data request book cannot be issued");
									}
									break;

								case 10:
									try {
										System.out.println("Users of Library are :");
										System.out.println("-------------------------------");

										List<UserDto> userInfos = service.showStudents();
										System.out.println(String.format("%-5s %-10s %-30s %-30s", "USERId",
												"USERNAME", "EMAILID", "NoOfBooksBorrowed"));
										for (UserDto info : userInfos) {
											System.out.println();
											System.out.println(String.format("%-5s %-10s %-30s %-30s ",
													info.getUserId(), info.getUserName(), info.getUserEmail(),
													info.getUserBooksBorrowed()));
										}
									} catch (Exception e) {
										System.err.println(e.getMessage());
									}
									break;
								case 11:
									try {
										System.out.println("Requests for Books are :");
										System.out.println("-------------------------------");

										List<RequestDto> requestInfos = service.showRequests();
										System.out.println(String.format("%-10s %-10s %-10s %-40s %-15s %-20s",
												"USER ID", "USERNAME", "BOOK ID", "BOOK TITLE", "IS ISSUED", "IS RETURNED"));
										for (RequestDto info : requestInfos) {

											System.out.println(String.format("%-10s %-10s %-40s %-15s %-20s",
													info.getStudentInfo().getUserId(), info.getStudentInfo().getUserName(), info.getBookInfo().getBookId(),
													info.getBookInfo().getBookTitle(), info.isIssued(),
													info.isReturned()));
											System.out.println("-------------------------------");
										}
									} catch (Exception e) {
										System.err.println(e.getMessage());
									}
									break;
								case 12:
									System.out.println("Receive Returned Book");
									System.out.println("-----------------------");
									System.out.println("Enter User Id");
									int user1 = scanner.nextInt();
									System.out.println("Enter Book Id");
									int book1 = scanner.nextInt();

									UserDto student = new UserDto();
									BookDto book = new BookDto();
									student.setUserId(user1);
									book.setBookId(book1);
									boolean isReceive = service.isBookReceived(student, book);
									if (isReceive) {
										System.out.println(" Received Returned book");
									} else {
										System.err.println("Invalid ! Admin unable to receive");
									}

									break;
								case 13:
									performOperations();
									break;

								default:
									System.err.println("Invalid Choice");
									break;
								}
							} while (true);
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
				} while (true);

			case "user":
				UserService service1 = BookFactory.getStudentService();
				do {
					System.out.println("#########################################");
					System.out.println("Press 1 to Register as User");
					System.out.println("Press 2 for User Login ");
					System.out.println("Press 3 to exit");
					System.out.println("#########################################");
					int choice = scanner.nextInt();
					switch (choice) {
					case 1:
						count = 2;
						boolean status = Registration.register(count);
						if(status) {
							System.out.println("User Successfully registered");
						}
						else
						{
							System.out.println("User already registered,kindly login");
						}				
						
						break;
					case 2:
						boolean authBean = false;
						do {
							System.out.println("Enter User EmailId");
							String email = scanner.next();
							System.out.println("Enter User Password");
							String password = scanner.next();
							authBean = service1.auth(email, password);
						}while(!authBean);
							System.out.println("User Logged in Successfully");
							try {
							do {
								System.out.println("*****************************************");
								System.out.println("Press 1 to Search Book by Book Name");
								System.out.println("Press 2 to Search Book by Book Author");
								System.out.println("Press 3 to Search Book by Book Id");
								System.out.println("Press 4 to Get Book Id's ");
								System.out.println("Press 5 to Get Information Of Books Available ");
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
									BookDto bean4 = new BookDto();
									bean4.setBookTitle(book_Name);
									List<BookDto> dto1 = service1.searchBookTitle(book_Name);
									System.out.println(String.format("%-20s %-40s %-20s %-20s %-20s", "BOOKID",
											"BOOKNAME", "AUTHOR", "CATEGORY", "PUBLISHER"));
									for (BookDto bookDto : dto1) {
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
									BookDto bean5 = new BookDto();
									bean5.setBookAuthor(book_Author);
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
									BookDto bean6 = new BookDto();
									bean6.setBookType(book_Type);
									List<BookDto> dto1 = service1.searchBookType(book_Type);
									System.out.println(String.format("%-20s %-40s %-20s %-20s %-20s", "BOOKID",
											"BOOKNAME", "AUTHOR", "CATEGORY", "PUBLISHER"));
									for (BookDto bookDto : dto1) {
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
									BookDto bean7 = new BookDto();
									ArrayList<Integer> dto3 = service1.getBookIds();
									for (Integer integer : dto3) {
										if (integer != null) {
											System.out.println(integer);
										} else {
											System.err.println("No books are present");
										}
									}
									break;

								case 5:
									try {
									List<BookDto> dto4 = service1.getBooksInfo();
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
									System.out.println("Enter book id");
									int bookId = scanner.nextInt();
									BookDto dto5 = new BookDto();
									dto5.setBookId(bookId);
									System.out.println("Enter user id");
									int userId = scanner.nextInt();
									UserDto bean8 = new UserDto();
									bean8.setUserId(userId);

									try {
										RequestDto request = service1.requestBook(bean8, dto5);
										System.out.println("Request placed to admin");
										System.out.println(String.format("%-5s %-10s %-20s %-40s", "USERId",
												"USERNAME", "BOOKID", "BOOKTITLE"));
										System.out.println();
										System.out.println(String.format("%-5s %-10s %-20s %-40s",
												request.getStudentInfo().getUserId(), request.getStudentInfo().getUserName(),
												request.getBookInfo().getBookId(), request.getBookInfo().getBookTitle()));

									} catch (Exception e) {
										System.err.println("Enter valid data or Invalid Request");
									}
									break;
								case 7:
									System.out.println("Returning a book:");
									System.out.println("------------------");
									System.out.println("Enter User Id");
									int id = scanner.nextInt();
									System.out.println("Enter Book Id");
									int book = scanner.nextInt();
									BookDto dto6 = new BookDto();
									UserDto bean9 = new UserDto();
									bean9.setUserId(id);
									dto6.setBookId(book);

									try {
										RequestDto requestInfo = service1.returnBook(bean9, dto6);
										System.out.println("Book is Returning to Admin");
										System.out.println(String.format("%-5s %-20s %-20s", "USERId","BOOKID", "IS RETURNED"));
										System.out.println(String.format("%-5s %-20s %-20s",
												requestInfo.getStudentInfo().getUserId(), requestInfo.getBookInfo().getBookId(),
												requestInfo.isReturned()));
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
							} while (true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					case 3:
						performOperations();
						break;

					default:
						System.err.println("Invalid Option");
					}
				} while (true);
			}
		} while (true);
	}

	public void run() {
		System.out.println("-----------------WELCOME TO LIBRARY MANAGEMENT SYSTEM----------------------");
		performOperations();
	}
}
