package com.epam.newyeargift.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

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

public class StaxParser implements DataAccessDao {
	private GiftBox box;
    private Candy currentBook;
    private ArrayList<Candy> candies = new ArrayList<Candy>();
    private CandiesTagsEnum cTagsEnum;
    
	@Override
	public GiftBox getGiftFromSource(Object... args) throws DaoException {
		try {
            String filePath = (String) args[0];
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = inputFactory.createXMLStreamReader(new FileInputStream(filePath));
            return parsing(reader);
            
        } catch (XMLStreamException | FileNotFoundException | NumberFormatException | EntityException ex) {
            throw new DaoException(ex.getMessage(), ex);
        } 
	}
	
	private GiftBox parsing(XMLStreamReader reader) 
			throws XMLStreamException, NumberFormatException, EntityException {
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    CandiesTagsEnum[] cte = CandiesTagsEnum.values();
            		for(CandiesTagsEnum c:cte) {
            			if(name.equals(c.getValue())) {
                			cTagsEnum = c;
                		}
            		}
                    switch (cTagsEnum) {
                        case BOX:
                            box = new GiftBox(Color.BLUE, candies);
                            break;
                        case CHOCOLATE:
                            currentBook = new Chocolate();
                            currentBook.setId(reader.getAttributeValue(0));
                            break;
                        case CARAMEL:
                            currentBook = new Caramel();
                            currentBook.setId(reader.getAttributeValue(0));
                            break;
                        case JELLY:
                            currentBook = new Jelly();
                            currentBook.setId(reader.getAttributeValue(0));
                            break;
                        default:
                            writeCandyFeature(reader);
                            break;
                    }
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    cte = CandiesTagsEnum.values();
            		for(CandiesTagsEnum c:cte) {
            			if(name.equals(c.getValue())) {
                			cTagsEnum = c;
                		}
            		}
                    switch (cTagsEnum) {
	                    case BOX:
	                    	return box;
	                    case CHOCOLATE:
	                    	candies.add(currentBook);
	                        break;
	                    case CARAMEL:
	                    	candies.add(currentBook);
	                        break;
	                    case JELLY:
	                    	candies.add(currentBook);
	                        break;
					default:
						break;
                    }
                    break;
            }
        }
        return null;
    }

    private void writeCandyFeature(XMLStreamReader reader) 
    		throws XMLStreamException, NumberFormatException, EntityException {
    	
        CandiesTagsEnum[] cte = CandiesTagsEnum.values();
		for(CandiesTagsEnum c:cte) {
    		String name = reader.getLocalName();
			if(name.equals(c.getValue())) {
    			cTagsEnum = c;
    		}
		}
        switch (cTagsEnum) {
            
            case NAME:
                currentBook.setName(reader.getElementText());
                break;
            case WEIGHT:
                currentBook.setWeight(Integer.parseInt(reader.getElementText()));
                break;
            case SHUGAR_AMOUNT:
                currentBook.setShugarAmount(Integer.parseInt(reader.getElementText()));
                break;
            case COLOR:
                ((Caramel) currentBook).setColor(Color.valueOf(reader.getElementText()));
                break;
            case TYPE_OF_CARAMEL:
                ((Caramel) currentBook).setCaramelType(CaramelType.valueOf(reader.getElementText()));
                break;
            case TYPE_OF_CHOCOLATE:
                ((Chocolate) currentBook).setChocolateType(ChocolateType.valueOf(reader.getElementText()));
                break;
            case FILLING:
                ((Chocolate) currentBook).setFilling(Filling.valueOf(reader.getElementText()));
                break;
            case TASTE:
                ((Jelly) currentBook).setTaste(Taste.valueOf((reader.getElementText())));
                break;
		default:
			break;
        }

    }
}

