package com.capgemini.library_management_system_collections.validation;


	
	 import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.library_management_system_collections.exception.CollectionsException;


	public class ValidationAdminStudent {
		public boolean validatedId(int id) throws CollectionsException {
			String idRegEx = "[0-9]{1}[0-9]{5}" ;
			boolean result = false;
			if (Pattern.matches(idRegEx, String.valueOf(id))) {
				result = true;
			} else {
				throw new CollectionsException("Id should contains exactly 6 digits");
			}
			return result;
		}
		public boolean validatedName(String name) throws CollectionsException {
			String nameRegEx = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$" ;
			boolean result = false;
			Pattern pattern = Pattern.compile(nameRegEx);
			Matcher matcher = pattern.matcher(name);
			if (matcher.matches()) {
				result = true;
			} else {
				throw new CollectionsException("Name should contains only Alpabates");
			}
			return result;
		}

		public boolean validatedEmail(String email) throws CollectionsException {
			String emailRegEx = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
			boolean result = false;
			Pattern pattern = Pattern.compile(emailRegEx);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				result = true;
			} else {
				throw new CollectionsException("Enter proper email ");
			}
			return result;
		}

		public boolean validatedPassword(String password) throws CollectionsException {
			String passwordRegEx = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})" ;
			boolean result = false;
			if (Pattern.matches(passwordRegEx, String.valueOf(password))) { 
				result = true;
			} else {
				throw new CollectionsException("Password should contain atleast 8 characters ,one uppercase,one lowercase and one symbol "); 
			}

			return result;
		}
	}


