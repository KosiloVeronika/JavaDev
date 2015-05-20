package com.epam.newyeargift.entity;

import java.util.ArrayList;

public class GiftBox {
	private Color boxColor;
	private ArrayList<Candy> candies;
	
	public GiftBox(Color boxColor, ArrayList<Candy> candies) {
		this.boxColor = boxColor;
		this.candies = candies;
	}
	
	public Color getBoxColor() {
		return boxColor;
	}
	
	public void setBoxColor(Color boxColor) {
		this.boxColor = boxColor;
	}

	
	public ArrayList<Candy> getCandies() {
		return candies;
	}
	
	public void setCandies(ArrayList<Candy> candies) {
		this.candies = candies;
	}
	
}