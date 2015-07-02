package com.epam.multithreading.create;

import java.util.ArrayList;
import java.util.HashMap;

import com.epam.multithreading.entity.Book;
import com.epam.multithreading.entity.Library;

public class Creator {

	public static Library CreateLibrary() {
		HashMap<Integer, Boolean> lib = new HashMap<Integer, Boolean>(9);
		ArrayList<Book> bookList = new ArrayList<Book>(9);
		bookList.add(new Book(1, "\"Лолита\"", "Владимир Владимирович Набоков", true, false));
		bookList.add(new Book(2, "\"Похороните меня за плинтусом\"", "Павел Санаев", true, false));
		bookList.add(new Book(3, "\"Бойцовский клуб\"", "Чак Паланик", true, false));
		bookList.add(new Book(4, "\"Удушье\"", "Чак Паланик", true, false));
		bookList.add(new Book(5, "\"Триумфальная арка", "Э.М.Ремарк", true, false));
		bookList.add(new Book(6, "\"На западном фронте без перемен\"", "Э.М.Ремарк", false, false));
		bookList.add(new Book(7, "\"Голова профессора Доуэля\"", "Александр Беляев", true , false));
		bookList.add(new Book(8, "\"Таинственный остров\"","Жюль Верн", false, false));
		bookList.add(new Book(9, "\"Избранные Романы\"", "Александр Беляев", false, false));
		for(int i = 0; i < bookList.size(); i++) {
			lib.put(bookList.get(i).getID(), true);
		}
		return new Library(lib, bookList);
	}

}
