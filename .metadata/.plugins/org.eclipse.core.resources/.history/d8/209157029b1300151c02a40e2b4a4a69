package com.epam.newyeargift.dao;

import java.util.ArrayList;
import java.util.List;

import com.epam.newyeargift.entity.*;
import com.epam.newyeargift.logic.CandyFactory;
import com.epam.newyeargift.logic.CandyProperties;

public abstract class Creator {
	public static GiftBox createGift() throws EntityException {
		List<Candy> candies = new ArrayList<Candy>();
		candies.add(CandyFactory.createCandy("jelly", 
				new CandyProperties("id-1","Желейка",12,10,Taste.APPLE)));
		candies.add(CandyFactory.createCandy("chocolate", 
				new CandyProperties("id-2","Вавёрка",14,11,Filling.NUTS,ChocolateType.MILK)));
		candies.add(CandyFactory.createCandy("caramel", 
				new CandyProperties("id-3","Кислинка",11,2,Color.YELLOW,CaramelType.CARAMEL_CANDY)));
		GiftBox gift = new GiftBox(Color.BLUE, candies);
		return gift;
	}

}
