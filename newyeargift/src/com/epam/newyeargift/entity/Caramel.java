package com.epam.newyeargift.entity;

public class Caramel extends Candy {
	
	private Color color;
	private CaramelType caramelType;
	
	public Caramel() { }
	
	public Caramel(String id, String name, int weight, int shugarAmount, 
			       Color color, CaramelType caramelType) throws EntityException {
		super(id, name, weight, shugarAmount);
		this.color = color;
		this.setCaramelType(caramelType);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public CaramelType getCaramelType() {
		return caramelType;
	}

	public void setCaramelType(CaramelType caramelType) {
		this.caramelType = caramelType;
	}	
	
	@Override
	public String toString() {
		return String.format("ID: %s; Name: %s; weight: %d; shugar amount: %d; color: %s; Caramel type: %s", 
			   getId() ,getName(), getWeight(), getShugarAmount(), getColor(), getCaramelType());
	}

}
