package com.epam.newyeargift.entity;

public abstract class Candy {
	private String name;
	private int weight;
	private int shugarAmount;

	public Candy(String name, int weight, int shugarAmount) throws ParameterException {
		super();
		this.name = name;
		setWeight(weight);
		setShugarAmount(shugarAmount);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) throws ParameterException{
		if (weight > 0) {
			this.weight = weight;
		} else {
			throw new ParameterException();
		}
	}

	public int getShugarAmount() {
		return shugarAmount;
	}

	public void setShugarAmount(int shugarAmount) throws ParameterException {
		if (shugarAmount > 0) {
			this.shugarAmount = shugarAmount;
		} else {
			throw new ParameterException();
		}
	}	
}
