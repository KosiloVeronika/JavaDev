package com.epam.newyeargift.entity;

public class Chocolate extends Candy {
	
	private Filling filling;
	private ChocolateType chocolateType;
	
	public Chocolate() { }
	
	public Chocolate(String id, String name, int weight, int shugarAmount, 
					 Filling filling, ChocolateType chocolateType ) throws EntityException {
		super(id, name, weight, shugarAmount);
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
	
	@Override
	public String toString() {
		return String.format("ID: %s; Name: %s; weight: %d; shugar amount: %d; filling: %s; Chocolate type: %s", 
			   getId() ,getName(), getWeight(), getShugarAmount(), getFilling(), getChocolateType());
	}

}
