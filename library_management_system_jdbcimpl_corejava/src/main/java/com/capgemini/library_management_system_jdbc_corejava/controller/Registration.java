package com.capgemini.library_management_system_jdbc_corejava.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.library_management_system_jdbc_corejava.factory.BookFactory;
import com.capgemini.library_management_system_jdbc_corejava.service.AdminService;
import com.capgemini.library_management_system_jdbc_corejava.service.UserService;
import com.capgemini.library_management_system_jdbc_validation.ValidationAdminStudent;
import com.capgemini.library_management_system_jdbc_corejava.dto.AdminDto;
import com.capgemini.library_management_system_jdbc_corejava.dto.UserDto;
import com.capgemini.library_management_system_jdbc_corejava.exception.*;


public class Registration {
	


	public static boolean register(String roleType) {

		ValidationAdminStudent validation = new ValidationAdminStudent();
		AdminService service = BookFactory.getAdminService();
		UserService service1 = BookFactory.getUserService();
		@SuppressWarnings("resource")
		Scanner scanner1 = new Scanner(System.in);
		boolean flag = false;
		boolean check = false;
		int regId = 0;
		String regName = null;
		String regEmail = null;
		String regPassword = null;
		String role = "";
		
		do {
			try {
				System.out.println("Enter ID :");
				regId = scanner1.nextInt();
				validation.validatedId(regId);
				flag = true;
			} catch (InputMismatchException e) {
				flag = false;
				System.err.println("Entered Id should contains only digits");
			} catch (ErrorException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);

		do {
			try {
				System.out.println("Enter Name :");
				regName = scanner1.next();
				validation.validatedName(regName);
				flag = true;
			} catch (InputMismatchException e) {
				flag = false;
				System.err.println("Entered Name should contains only Alphabates");
			} catch (ErrorException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);

		do {
			try {
				System.out.println("Enter EmailId :");
				regEmail = scanner1.next();
				validation.validatedEmail(regEmail);
				flag = true;
			} catch (InputMismatchException e) {
				flag = false;
				System.err.println("Entered EmailId should be proper of format like xxxxxx@xxxx.com ");
			} catch (ErrorException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);

		do {
			try {
				System.out.println("Enter Password :");
				regPassword = scanner1.next();
				validation.validatedPassword(regPassword);
				flag = true;
			} catch (InputMismatchException e) {
				flag = false;
				System.err.println("Enter Password with a proper format");
			} catch (ErrorException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);

		if(roleType.equals("admin")) {
			AdminDto adminDto = new AdminDto();
			adminDto.setAdminRole(roleType);
			adminDto.setAdminUserId(regId);
			adminDto.setAdminUserName(regName);
			adminDto.setAdminEmail(regEmail);
			adminDto.setAdminPassword(regPassword);
			check = service.register(adminDto);
		}
		else {
			UserDto user = new UserDto();
			user.setUserRole(roleType);
			user.setUserId(regId);
			user.setUserName(regName);
			user.setUserEmail(regEmail);
			user.setUserPassword(regPassword);
		check = service1.register(user);
		}
		return check;
	}

}
