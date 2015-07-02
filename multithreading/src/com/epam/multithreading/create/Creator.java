package com.epam.multithreading.create;

import java.util.ArrayList;
import java.util.HashMap;

import com.epam.multithreading.entity.Book;
import com.epam.multithreading.entity.Library;

public class Creator {

	public static Library CreateLibrary() {
		HashMap<Integer, Boolean> lib = new HashMap<Integer, Boolean>(9);
		ArrayList<Book> bookList = new ArrayList<Book>(9);
		bookList.add(new Book(1, "\"������\"", "�������� ������������ �������", true, false));
		bookList.add(new Book(2, "\"���������� ���� �� ���������\"", "����� ������", true, false));
		bookList.add(new Book(3, "\"���������� ����\"", "��� �������", true, false));
		bookList.add(new Book(4, "\"������\"", "��� �������", true, false));
		bookList.add(new Book(5, "\"������������ ����", "�.�.������", true, false));
		bookList.add(new Book(6, "\"�� �������� ������ ��� �������\"", "�.�.������", false, false));
		bookList.add(new Book(7, "\"������ ���������� ������\"", "��������� ������", true , false));
		bookList.add(new Book(8, "\"������������ ������\"","���� ����", false, false));
		bookList.add(new Book(9, "\"��������� ������\"", "��������� ������", false, false));
		for(int i = 0; i < bookList.size(); i++) {
			lib.put(bookList.get(i).getID(), true);
		}
		return new Library(lib, bookList);
	}

}
