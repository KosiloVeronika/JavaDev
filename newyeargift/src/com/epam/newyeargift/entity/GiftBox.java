package com.epam.newyeargift.entity;

import java.util.List;
import java.util.Collection;
import java.util.Collections;

public class GiftBox {
	private Color boxColor;
	private List<Candy> candies;
	
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

	public boolean addCandiesList(Collection<Candy> candies) {
		return candies.addAll(candies);
	}

	public List<Candy> getCandies() {
		return Collections.unmodifiableList(candies);
	}
	
	
}
