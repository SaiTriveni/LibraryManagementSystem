package com.capgemini.library_management_system_jdbc_corejava.factory;

import com.capgemini.library_management_system_jdbc_corejava.dao.AdminDao;
import com.capgemini.library_management_system_jdbc_corejava.dao.AdminDaoImplementation;
import com.capgemini.library_management_system_jdbc_corejava.dao.UserDao;
import com.capgemini.library_management_system_jdbc_corejava.dao.UserDaoImplementation;
import com.capgemini.library_management_system_jdbc_corejava.service.AdminService;
import com.capgemini.library_management_system_jdbc_corejava.service.AdminServiceImplementation;

import com.capgemini.library_management_system_jdbc_corejava.service.UserService;
import com.capgemini.library_management_system_jdbc_corejava.service.UserServiceImplementation;

public class BookFactory {
	
	
	public static AdminDao getAdminDao() {
		return new AdminDaoImplementation();
		
	}
	
	public static AdminService getAdminService() {
		return new AdminServiceImplementation();
	}
	
	public static UserDao getUserDAO() {
		
		return new UserDaoImplementation();
	}
	
	public static UserService getUserService() {
		return new UserServiceImplementation();
	}
	

}
