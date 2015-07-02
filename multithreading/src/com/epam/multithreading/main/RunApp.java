package com.epam.multithreading.main;

import com.epam.multithreading.create.Creator;
import com.epam.multithreading.entity.Library;
import com.epam.multithreading.entity.Reader;

public class RunApp {

	public static void main(String[] args) {
		Library lib = Creator.CreateLibrary();
		Thread reader1 = new Reader(lib, 1);
		Thread reader2 = new Reader(lib, 2);
		Thread reader3 = new Reader(lib, 3);
		reader1.start();
		reader2.start();
		reader3.start();
	}

}