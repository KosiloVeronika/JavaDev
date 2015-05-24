package com.epam.newyeargift.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.epam.newyeargift.entity.*;

public class Logic {
	
	public static int countWeight(GiftBox gift) {
		List<Candy> candiesList = gift.getCandies();
		int result = 0;
		for (Candy c : candiesList) {
			result += c.getWeight();
		}
		return result;
	}
	
	public static List<Candy> findCandy(GiftBox gift, int minShugarAmount, int maxShugarAmount) {
		List<Candy> candiesList = gift.getCandies();
		
		List<Candy> result = new ArrayList<Candy>();
		for (Candy c : candiesList) {
			if (minShugarAmount < c.getShugarAmount() && c.getShugarAmount() < maxShugarAmount) {
				result.add(c);
			}
		}
		return result;
	}
	
	public static boolean sortByWeight(GiftBox gift) {
		List<Candy> candies = gift.getCandies();
		List<Candy> modifiableCandies = new ArrayList<Candy>(candies);
		Collections.sort(modifiableCandies);
		return gift.addCandiesList(modifiableCandies);
	}
}
