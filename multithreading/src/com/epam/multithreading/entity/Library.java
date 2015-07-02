package com.epam.multithreading.entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Library {
	
	private HashMap<Integer, Boolean> library;
	private ArrayList<Book> bookList;
	

	public Library(HashMap<Integer, Boolean> library, ArrayList<Book> bookList) {
		setLibrary(library);
		this.setBookList(bookList);
	}

	public HashMap<Integer, Boolean> getLibrary() {
		return library;
	}

	public void setLibrary(HashMap<Integer, Boolean> library) {
		this.library = library;
	}

	public ArrayList<Book> getBookList() {
		return bookList;
	}

	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}

}