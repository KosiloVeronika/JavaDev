package com.epam.library.entity;

public class Book {
	
	private int id;
	private String name;
	private String author;
	private boolean canTake;
	private boolean isTaken;

	public Book(int id, String name, String author, boolean canTake, boolean isTaken) {
		setID(id);
		setName(name);
		setAuthor(author);
		setCanTake(canTake);
		setTaken(isTaken);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isCanTake() {
		return canTake;
	}

	public void setCanTake(boolean canTake) {
		this.canTake = canTake;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public boolean checkIsTaken() {
		return isTaken;
	}

	public void setTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}

}
