package com.epam.newyeargift.entity;

public class Jelly extends Candy {
	
	private Taste taste;

	public Jelly(String name, int weight, int shugarAmount, Taste taste) throws EntityException {
		super(name, weight, shugarAmount);
		this.setTaste(taste);
	}

	public Taste getTaste() {
		return taste;
	}

	public void setTaste(Taste taste) {
		this.taste = taste;
	}

	@Override
	public String toString() {
		return String.format("Name: %s; weight: %d; shugar amount: %d; taste: %s", 
			   getName(), getWeight(), getShugarAmount(), getTaste());
	}
}
