package com.epam.newyeargift.entity;

public class Caramel extends Candy {
	private Color color;
	private CaramelType caramelType;
	
	public Caramel(String name, int weight, int shugarAmount, 
			       Color color, CaramelType caramelType) throws ParameterException {
		super(name, weight, shugarAmount);
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

}