package com.epam.newyeargift.logic;

import com.epam.newyeargift.entity.CaramelType;
import com.epam.newyeargift.entity.ChocolateType;
import com.epam.newyeargift.entity.Color;
import com.epam.newyeargift.entity.Filling;
import com.epam.newyeargift.entity.Taste;

public class CandyProperties {
	private String name;
	private int weight;
	private int shugarAmount;
	private Color color;
	private CaramelType caramelType;
	private Taste taste;
	private Filling filling;
	private ChocolateType chocolateType;
	
	
	public CandyProperties(String name, int weight, int shugarAmount,
			Filling filling, ChocolateType chocolateType) {
		this.name = name;
		this.weight = weight;
		this.shugarAmount = shugarAmount;
		this.filling = filling;
		this.chocolateType = chocolateType;
	}
	public CandyProperties(String name, int weight, int shugarAmount,
			Taste taste) {
		this.name = name;
		this.weight = weight;
		this.shugarAmount = shugarAmount;
		this.taste = taste;
	}
	public CandyProperties(String name, int weight, int shugarAmount,
			Color color, CaramelType caramelType) {
		this.name = name;
		this.weight = weight;
		this.shugarAmount = shugarAmount;
		this.color = color;
		this.caramelType = caramelType;
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
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getShugarAmount() {
		return shugarAmount;
	}
	public void setShugarAmount(int shugarAmount) {
		this.shugarAmount = shugarAmount;
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
	public Taste getTaste() {
		return taste;
	}
	public void setTaste(Taste taste) {
		this.taste = taste;
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
