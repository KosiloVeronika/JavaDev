package com.epam.newyeargift.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class GiftBox {
	private Color boxColor;
	private List<Candy> candies;
	
	public GiftBox() { }
	
	public GiftBox(Color boxColor, List<Candy> candies) {
		this.boxColor = boxColor;
		this.candies = candies;
	}
	
	public Color getBoxColor() {
		return boxColor;
	}
	
	public void setBoxColor(Color boxColor) {
		this.boxColor = boxColor;
	}

	public boolean addCandy(Candy candy) {
		return candies.add(candy);
	}

	public void addCandiesList(List<Candy> candies) {
		this.candies = new ArrayList<Candy>(candies);
	}

	public List<Candy> getCandies() throws EntityException{
		try {
			return Collections.unmodifiableList(candies);
		} catch(NullPointerException e) {
			throw new NullPointerException();
		}
	}
	
	@Override
	public String toString() {
		return String.format("Box color: %s", getBoxColor());
	}
	
	
}
