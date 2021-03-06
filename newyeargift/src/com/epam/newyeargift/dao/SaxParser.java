package com.epam.newyeargift.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.epam.newyeargift.entity.Candy;
import com.epam.newyeargift.entity.Caramel;
import com.epam.newyeargift.entity.CaramelType;
import com.epam.newyeargift.entity.Chocolate;
import com.epam.newyeargift.entity.ChocolateType;
import com.epam.newyeargift.entity.Color;
import com.epam.newyeargift.entity.EntityException;
import com.epam.newyeargift.entity.Filling;
import com.epam.newyeargift.entity.GiftBox;
import com.epam.newyeargift.entity.Jelly;
import com.epam.newyeargift.entity.Taste;

public class SaxParser extends DefaultHandler implements DataAccessDao {
	private final GiftBox box;
    private Candy currentCandy;
    private final ArrayList<Candy> candies;
    private CandiesTagsEnum cTagsEnum;
    
    public SaxParser() throws EntityException {
        candies = new ArrayList<Candy>();
        box = new GiftBox(Color.BLUE, candies);
        cTagsEnum = null;
    }

	@Override
	public GiftBox getGiftFromSource(Object... args) throws DaoException {
		try {
            String filePath = (String) args[0];
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(new File(filePath), this);
            return box;
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            throw new DaoException(ex.getMessage(), ex);
        }
	}
	
	@Override 
    public void startElement(String namespaceURI, String localName, 
    		                 String qName,Attributes atts) throws SAXException { 
		boolean f = false;
		if(qName.equals("caramel")) {
			currentCandy = new Caramel();
			f = true;
		}
		if(qName.equals("jelly")) {
			currentCandy = new Jelly();
			f = true;
		}
		if (qName.equals("chocolate")){
            currentCandy = new Chocolate();
			f = true;
		}
        if (f){
            currentCandy.setId(atts.getValue(0));
        } else {
        	CandiesTagsEnum[] cte = CandiesTagsEnum.values();
			for(CandiesTagsEnum c:cte) {
        		if(qName.equals(c.getValue())) {
        			cTagsEnum = c;
        		}
        	}
        }
  
    }
    
    @Override
    public void endElement(String uri, String localName,String qName){
        if (qName.equals("chocolate")|qName.equals("caramel")|
        	qName.equals("jelly")) {
            candies.add(currentCandy);
        }
        cTagsEnum = null;
    }
    
    @Override 
    public void characters(char[] ch, int start, int length) throws SAXException { 
        String value = new String(ch, start, length).trim();
        if (cTagsEnum != null) {
		    switch(cTagsEnum) {
		        case NAME:
		            currentCandy.setName(value);
		            break;
		        case WEIGHT:
						try {
							currentCandy.setWeight(Integer.parseInt(value));
						} catch (EntityException e) {}
		            break;
		        case SHUGAR_AMOUNT:
						try {
							currentCandy.setShugarAmount(Integer.parseInt(value));
						} catch (EntityException e) {}
			         break;
		        case COLOR:
		            ((Caramel) currentCandy).setColor(Color.valueOf(value));
		            break;
		        case TYPE_OF_CARAMEL:
		            ((Caramel) currentCandy).setCaramelType(CaramelType.valueOf(value));
		            break;
		        case TYPE_OF_CHOCOLATE:
		            ((Chocolate) currentCandy).setChocolateType(ChocolateType.valueOf(value));
		            break;
		        case FILLING:
		            ((Chocolate) currentCandy).setFilling(Filling.valueOf(value));
		            break;
		        case TASTE:
		            ((Jelly) currentCandy).setTaste(Taste.valueOf(value));
		            break;
		        default:
		        	break;
		    }
		}
    }

}


