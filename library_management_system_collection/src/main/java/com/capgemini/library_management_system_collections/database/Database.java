package com.capgemini.library_management_system_collections.database;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.library_management_system_collections.dto.AdminDto;
import com.capgemini.library_management_system_collections.dto.BookDto;
import com.capgemini.library_management_system_collections.dto.RequestDto;
import com.capgemini.library_management_system_collections.dto.UserDto;

public class Database {
	
	public static final List<AdminDto> ADMINS= new ArrayList<AdminDto>();
	public static final List<UserDto> USERS= new ArrayList<UserDto>();
	public static final List<BookDto> BOOKS= new ArrayList<BookDto>();
	public static final List<RequestDto> REQUESTS= new ArrayList<RequestDto>();
	
public static void addToDatabase() {
		
		ADMINS.add(new AdminDto(111111,"Sai Triveni","sai@gmail.com","Sai@160498"));
		
		
		BOOKS.add(new BookDto(123456,"Java","Mr.Sunil","Education","AKMPublishers"));
		BOOKS.add(new BookDto(123457,"Jdbc","Mr.Mahesh","Education","AKMPublishers"));
		BOOKS.add(new BookDto(123458,"Sequel","Mr.Dinesh","Education","SAPPublishers"));
		BOOKS.add(new BookDto(123459,"FullStackDevelopment","Mr.Sunil","Technical","SAPPublishers"));
		
		USERS.add(new UserDto(222222,"Sai","Sai@1234","sai@gmail.com",3));
		USERS.add(new UserDto(333333,"Akhil Kandula","Akhil@123","akhil@gmail.com",2));
		USERS.add(new UserDto(444444,"Junnu","Junnu@123","junnu@gmail.com",3));
}
	
	}
