package com.epam.newyeargift.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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

public class DomParser implements DataAccessDao {

	@Override
	public GiftBox getGiftFromSource(Object... args) throws DaoException {
		try {
            String filePath = (String) args[0];
            ArrayList<Candy> candies = new ArrayList<Candy>();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filePath));
            Element rootElement = document.getDocumentElement();

            NodeList choccolateList = rootElement.getElementsByTagName("chocolate");

            for (int i = 0; i < choccolateList.getLength(); i++) {
                Chocolate candy = new Chocolate();
                
                NodeList list = ((Element) choccolateList.item(i)).getElementsByTagName("*");
                NamedNodeMap attributes = choccolateList.item(i).getAttributes();
                candy.setId(attributes.item(0).getTextContent());
                
                candy.setName(list.item(0).getTextContent());
                candy.setWeight(Integer.parseInt(list.item(1).getTextContent()));
                candy.setShugarAmount(Integer.parseInt(list.item(2).getTextContent()));
                candy.setChocolateType(ChocolateType.valueOf(list.item(3).getTextContent()));
                candy.setFilling(Filling.valueOf(list.item(4).getTextContent()));
                
                candies.add(candy);
            }
            
            NodeList caramelList = rootElement.getElementsByTagName("caramel");
            
            for (int i = 0; i < caramelList.getLength(); i++) {
                Caramel candy = new Caramel();
                
                NodeList list = ((Element) caramelList.item(i)).getElementsByTagName("*");
                NamedNodeMap attributes = caramelList.item(i).getAttributes();
                candy.setId(attributes.item(0).getTextContent());
                
                candy.setName(list.item(0).getTextContent());
                candy.setWeight(Integer.parseInt(list.item(1).getTextContent()));
                candy.setShugarAmount(Integer.parseInt(list.item(2).getTextContent()));
                candy.setColor(Color.valueOf(list.item(3).getTextContent()));
                candy.setCaramelType(CaramelType.valueOf(list.item(4).getTextContent()));
                
                candies.add(candy);
            }
            
            NodeList jellylList = rootElement.getElementsByTagName("jelly");
            
            for (int i = 0; i < jellylList.getLength(); i++) {
                Jelly candy = new Jelly();
                
                NodeList list = ((Element) jellylList.item(i)).getElementsByTagName("*");
                NamedNodeMap attributes = jellylList.item(i).getAttributes();
                candy.setId(attributes.item(0).getTextContent());
                
                candy.setName(list.item(0).getTextContent());
                candy.setWeight(Integer.parseInt(list.item(1).getTextContent()));
                candy.setShugarAmount(Integer.parseInt(list.item(2).getTextContent()));
                candy.setTaste(Taste.valueOf(list.item(3).getTextContent()));
                
                candies.add(candy);
            }

            GiftBox box = new GiftBox(Color.BLUE, candies);
            return box;
        } catch (SAXException | IOException | ParserConfigurationException | EntityException ex) {
            throw new DaoException(ex.getMessage(), ex);
        }
	}

}
