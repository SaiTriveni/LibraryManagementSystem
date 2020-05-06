package com.capgemini.library_management_system_collections.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.library_management_system_collections.dto.AdminDto;
import com.capgemini.library_management_system_collections.dto.UserDto;
import com.capgemini.library_management_system_collections.exception.CollectionsException;
import com.capgemini.library_management_system_collections.factory.BookFactory;
import com.capgemini.library_management_system_collections.service.AdminService;
import com.capgemini.library_management_system_collections.service.UserService;
import com.capgemini.library_management_system_collections.validation.ValidationAdminStudent;

public class Registration {

	
	public static boolean register(int count) {

		ValidationAdminStudent validation = new ValidationAdminStudent();
		AdminService service = BookFactory.getAdminService();
		UserService service1 = BookFactory.getStudentService();
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
			} catch (CollectionsException e) {
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
			} catch (CollectionsException e) {
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
			} catch (CollectionsException e) {
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
			} catch (CollectionsException e) {
				flag = false;
				System.err.println(e.getMessage());
			}
		} while (!flag);

		if(count == 1) {
			AdminDto adminDto = new AdminDto();
			adminDto.setAdminUserId(regId);
			adminDto.setAdminUserName(regName);
			adminDto.setAdminEmail(regEmail);
			adminDto.setAdminPassword(regPassword);
			check = service.register(adminDto);
		}
		else {
			UserDto user = new UserDto();
			user.setUserId(regId);
			user.setUserName(regName);
			user.setUserEmail(regEmail);
			user.setUserPassword(regPassword);
			check = service1.register(user);
		}
		return check;
	}
	
}
