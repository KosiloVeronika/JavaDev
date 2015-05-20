package com.epam.newyeargift.entity;

public class Jelly extends Candy {
	private Taste taste;

	public Jelly(String name, int weight, int shugarAmount, Taste taste) throws ParameterException {
		super(name, weight, shugarAmount);
		this.setTaste(taste);
	}

	public Taste getTaste() {
		return taste;
	}

	public void setTaste(Taste taste) {
		this.taste = taste;
	}

}
