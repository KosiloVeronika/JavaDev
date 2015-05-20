package com.epam.newyeargift.entity;

public class Chocolate extends Candy {
	private Filling filling;
	private ChocolateType chocolateType;
	
	public Chocolate(String name, int weight, int shugarAmount, 
					 Filling filling, ChocolateType chocolateType ) throws ParameterException {
		super(name, weight, shugarAmount);
		this.filling = filling;
		this.chocolateType = chocolateType;
	}

	public Filling getFilling() {
		return filling;
	}

	public void setFilling(Filling filling) {
		this.filling = filling;
	}

	public ChocolateType getChocolateType() {
		return chocolateType;
	}

	public void setChocolateType(ChocolateType chocolateType) {
		this.chocolateType = chocolateType;
	}

}
