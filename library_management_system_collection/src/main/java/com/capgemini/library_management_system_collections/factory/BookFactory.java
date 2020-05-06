package com.capgemini.library_management_system_collections.factory;

import com.capgemini.library_management_system_collections.dao.AdminDao;
import com.capgemini.library_management_system_collections.dao.AdminDaoImplementation;
import com.capgemini.library_management_system_collections.dao.BookDao;
import com.capgemini.library_management_system_collections.dao.BookDaoImplementation;
import com.capgemini.library_management_system_collections.dao.UserDao;
import com.capgemini.library_management_system_collections.dao.UserDaoImplementation;
import com.capgemini.library_management_system_collections.service.AdminService;
import com.capgemini.library_management_system_collections.service.AdminServiceImplementation;
import com.capgemini.library_management_system_collections.service.BookService;
import com.capgemini.library_management_system_collections.service.BookServiceImplementation;
import com.capgemini.library_management_system_collections.service.UserService;
import com.capgemini.library_management_system_collections.service.UserServiceImplementation;

public class BookFactory {
	
	public static BookDao getBookDAO() {
		
		return new BookDaoImplementation();
	}
	
	public static BookService getBookService() {
		
		return new BookServiceImplementation();
	}
	
	public static AdminDao getAdminDao() {
		return new AdminDaoImplementation();
		
	}
	
	public static AdminService getAdminService() {
		return new AdminServiceImplementation();
	}
	
	public static UserDao getStudentDAO() {
		
		return new UserDaoImplementation();
	}
	
	public static UserService getStudentService() {
		return new UserServiceImplementation();
	}
	

}
