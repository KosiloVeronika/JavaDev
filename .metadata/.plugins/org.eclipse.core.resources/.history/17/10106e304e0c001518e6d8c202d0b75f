package com.epam.newyeargift.entity;

public abstract class Candy implements Comparable<Candy> {
	
	private String name;
	private int weight;
	private int shugarAmount;

	public Candy(String name, int weight, int shugarAmount) throws EntityException {
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

	public void setWeight(int weight) throws EntityException {
		if (weight > 0) {
			this.weight = weight;
		} else {
			throw new EntityException("Wrong input data weight" + weight);
		}
	}

	public int getShugarAmount() {
		return shugarAmount;
	}

	public void setShugarAmount(int shugarAmount) throws EntityException {
		if (shugarAmount > 0) {
			this.shugarAmount = shugarAmount;
		} else {
			throw new EntityException("Wrong input data shugarAmount" + shugarAmount);
		}
	}
	
	@Override 
	public int compareTo(Candy candy) {
		return weight - candy.weight;	
	}
}
