package com.epam.newyeargift.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.epam.newyeargift.entity.*;

public class Logic {
	
	public static List<Candy> showAll(GiftBox gift) throws LogicException{
		try {
		return gift.getCandies();
		} catch (EntityException e) {
			throw new LogicException("Show_All exception", e);
		}
	}
	
	public static int countWeight(GiftBox gift) throws LogicException{
		int result = 0;
		try {
		List<Candy> candiesList = gift.getCandies();
			for (Candy c : candiesList) {
				result += c.getWeight();
			}
		}catch(EntityException e) {
			throw new LogicException("Count_weight exception", e);
		}
		return result;
	}
	
	public static List<Candy> findCandy(GiftBox gift, int minShugarAmount, 
				  int maxShugarAmount) throws LogicException {
		List<Candy> result = new ArrayList<Candy>();
		try {
			List<Candy> candiesList = gift.getCandies();
			for (Candy c : candiesList) {
				if (minShugarAmount < c.getShugarAmount() && 
					c.getShugarAmount() < maxShugarAmount) {
					result.add(c);
				}
			}
		}catch(EntityException e) {
			throw new LogicException("Count_weight exception", e);
		}
		return result;
	}
	
	public static void sortByWeight(GiftBox gift) throws LogicException {
		try {
			List<Candy> candies = gift.getCandies();
			List<Candy> modifiableCandies = new ArrayList<Candy>(candies);
			Collections.sort(modifiableCandies);
			gift.addCandiesList(modifiableCandies);
		}catch(EntityException e) {
			throw new LogicException("Count_weight exception", e);
		}
	}
}
