package com.epam.newyeargift.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.epam.newyeargift.dao.DaoException;
import com.epam.newyeargift.dao.DataAccessDao;
import com.epam.newyeargift.dao.DomParser;
import com.epam.newyeargift.dao.SaxParser;
import com.epam.newyeargift.dao.StaxParser;
import com.epam.newyeargift.entity.Candy;
import com.epam.newyeargift.entity.EntityException;
import com.epam.newyeargift.entity.GiftBox;

public class Logic {
	
	public static GiftBox domParsing(String filePath) throws LogicException{
        try {
            DataAccessDao parser = new DomParser();
            return parser.getGiftFromSource(filePath);
        } catch (DaoException ex) {
            throw new LogicException(ex.getMessage(),ex);
        }
    }
    
    public static GiftBox saxParsing(String filePath) throws LogicException {
        try {
            DataAccessDao parser = new SaxParser();
            return parser.getGiftFromSource(filePath);
        } catch (DaoException | EntityException ex) {
            throw new LogicException(ex.getMessage(),ex);
        }
    }
    
    public static GiftBox staxParsing(String filePath) throws LogicException{
        try {
            DataAccessDao parser = new StaxParser();
            return parser.getGiftFromSource(filePath);
        } catch (DaoException ex) {
            throw new LogicException(ex.getMessage(),ex);
        }
    }
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
