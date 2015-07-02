package com.epam.multithreading.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Reader extends Thread {
	
	private int readerID;
	private Library lib;
	private Lock lock;
	private Condition isFree;
	private ArrayList<Book> readerBookList;
	private Integer[] books;
	
	public Reader(Library lib, int readerID, Lock lock, Condition isFree) {
		this.lib = lib;
		this.readerID =  readerID;
		this.lock = lock;
		this.isFree = isFree;
		this.readerBookList = new ArrayList<Book>();
	}
	
	@Override
	public void run() {
		System.out.println("�������� " + readerID + " ������ � ����������");
		Random random = new Random();
		HashSet<Integer> bookID = new HashSet<Integer>();
		int bookCount = new Random().nextInt(6) + 1;
		if (bookCount > 0) {
			for(int k = 0; k < bookCount; k++) {
				int ID = random.nextInt(lib.getLibrary().size());
				if(ID == 0) {
					ID++;
				}
				bookID.add(ID);
			}
		}
		lock.lock();
		try {
			books = new Integer[bookID.size()];
			books = bookID.toArray(books);
			for(int i = 0; i < books.length; i++) {
				if (lib.getLibrary().get(books[i])) {
					if(lib.getBookList().get(books[i]).isCanTake()) {
						lib.getBookList().get(books[i]).setTaken(random.nextBoolean());
					}
					readerBookList.add(lib.getBookList().get(books[i]));
					System.out.println("�������� " + readerID + " ���� ����� "
									   + lib.getBookList().get(books[i]).getName()+ " id "+ books[i]);
					lib.getLibrary().put(books[i], false);
				} else {
					System.out.println("�������� " + readerID + " ����� ����� ����� "
							   + lib.getBookList().get(books[i]).getName()+ " id "+ books[i]);
				}
			}
		isFree.signal();
		} finally {
			lock.unlock();
		}
		if (readerBookList.size() != 0) {
			try {
				for(Iterator<Book> bookIter = readerBookList.iterator(); bookIter.hasNext();) {
					Book b = bookIter.next();
					if(!(b.isCanTake()) || !(b.checkIsTaken())) {
						sleep(random.nextInt(200)+100);
						if(random.nextBoolean()) {
							returnBook(b, "� ��������� ��� ");
							bookIter.remove();
						}
					}
				} 
				if (readerBookList.size() != 0) {
					for(Iterator<Book> bookIter = readerBookList.iterator(); bookIter.hasNext();) {
						Book b = bookIter.next();
						if(!(b.isCanTake()) || !(b.checkIsTaken())) {
							if(random.nextBoolean()) {
								returnBook(b, "� ��������� ��� ");
								bookIter.remove();
							}
						}
					}
				}
				if(readerBookList.size() != 0) {
					System.out.println("�������� " + readerID + 
									   " ������� ����������, �� � ���� ���� �����, ������� �� ���� ����� ");
					for(Iterator<Book> bookIter = readerBookList.iterator(); bookIter.hasNext();) {
						Book b = bookIter.next();
						if(b.isCanTake()) {
							sleep(random.nextInt(700)+300);
							if(random.nextBoolean()) {
								System.out.println("�������� " 
												   + readerID + " ������ � ����������");
								returnBook(b, "����� ");
								bookIter.remove();
								System.out.println("�������� " + readerID + " ������� ����������");
							}
						}
						
					}
				}
				if(readerBookList.size() != 0) {
					System.out.println("�������� " 
							   + readerID + " ������ � ���������� ");
					for(Iterator<Book> bookIter = readerBookList.iterator(); bookIter.hasNext();) {
						Book b = bookIter.next();
						returnBook(b, "����� ");
						bookIter.remove();
					}
				}
			} catch (InterruptedException e) {
				 e.printStackTrace();
			}
		}
		System.out.println("�������� " + readerID + " ������� ���������� ");
	}
	
	private void returnBook(Book b, String message) {
		lock.lock();
		try {
			lib.getLibrary().put(b.getID(), true);
			System.out.println("�������� " + readerID + 
						       " ���� �����, ������� ���� " + message
						       + b.getName() + " " + b.getAuthor());
			isFree.signal();
		}
		finally {
			lock.unlock();
		}
	}
	

}
