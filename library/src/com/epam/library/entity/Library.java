package com.epam.library.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Library {
	
	private HashMap<Integer, Boolean> library;
	private List<Book> bookList;

	public Library(HashMap<Integer, Boolean> library, List<Book> bookList) {
		setLibrary(library);
		this.setBookList(bookList);
	}

	public HashMap<Integer, Boolean> getLibrary() {
		return library;
	}

	public void setLibrary(HashMap<Integer, Boolean> library) {
		this.library = library;
	}

	public List<Book> getBookList() {
		return Collections.unmodifiableList(bookList);
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

}
