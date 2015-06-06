package com.epam.newyeargift.logic;

import com.epam.newyeargift.entity.*;

public class CandyFactory {
	
	public static Candy createCandy(String type, CandyProperties properties) 
				  throws EntityException {
		CandyType candyType = CandyType.valueOf(type.toUpperCase());
		switch(candyType) {
		case CARAMEL: 
			return new Caramel(properties.getId(), properties.getName(),
							   properties.getWeight(),
							   properties.getShugarAmount(), 
					           properties.getColor(), 
					           properties.getCaramelType());
		case CHOCOLATE: 
			return new Chocolate(properties.getId(), properties.getName(), 
					             properties.getWeight(), 
								 properties.getShugarAmount(), 
								 properties.getFilling(), 
								 properties.getChocolateType());
		case JELLY: 
			return new Jelly(properties.getId(), properties.getName(), 
					         properties.getWeight(),
					         properties.getShugarAmount(),
					         properties.getTaste());
		default: throw new EnumConstantNotPresentException(CandyType.class, 
				                                           candyType.name());
		}
	
	}

}
