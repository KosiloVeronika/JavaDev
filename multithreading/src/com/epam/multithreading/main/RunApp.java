package com.epam.multithreading.main;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.epam.multithreading.create.Creator;
import com.epam.multithreading.entity.Library;
import com.epam.multithreading.entity.Reader;

public class RunApp {

	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Condition isFree = lock.newCondition();
		Library lib = Creator.CreateLibrary();
		Thread reader1 = new Reader(lib, 1, lock, isFree);
		Thread reader2 = new Reader(lib, 2, lock, isFree);
		Thread reader3 = new Reader(lib, 3, lock, isFree);
		reader1.start();
		reader2.start();
		reader3.start();
	}

}
