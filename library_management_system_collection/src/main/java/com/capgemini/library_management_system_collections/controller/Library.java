package com.capgemini.library_management_system_collections.controller;

import com.capgemini.library_management_system_collections.database.Database;

public class Library {
	public static void main(String[] args) {
		Database.addToDatabase();
		Librarian librarian=new Librarian();
		librarian.start();
	} 
} 
