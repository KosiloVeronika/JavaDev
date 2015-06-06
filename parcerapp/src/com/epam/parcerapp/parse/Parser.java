package com.epam.parcerapp.parse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.parcerapp.entity.Component;
import com.epam.parcerapp.entity.ComponentType;
import com.epam.parcerapp.entity.Composite;
import com.epam.parcerapp.entity.Leaf;

public class Parser {
	
	private Composite root = new Composite(ComponentType.TEXT);
	private static Properties prop = new Properties();
	
	private Parser() { }

	public static void parseManager(String text, Composite composite) {
		ComponentType compositeType = composite.getType();
		switch(compositeType) {
		case TEXT:
			parse(text, compositeType);
			break;
		case SENTENCE:
			parse(text, compositeType);
			break;
		default:
		}

	}
	
	private static void parse(String text, ComponentType cType) {
		
	}
	
	public static void configure(String path) throws ParserException {
		
		FileInputStream inputStream;
		
		try {
			inputStream = new FileInputStream(path);
			prop.load(inputStream);
		} catch (IOException e) {
			throw new ParserException("Problem with property file", e);
		}
		
	}
	
	private static void findMatches(String text, String type, Composite father) {
		String regEx = prop.getProperty(type);
		String typeOfObject = prop.getProperty(String.format("%sType",type));
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(text);
		while(matcher.find()) {
				String outputText = matcher.group();
				createComponent(outputText, father, typeOfObject, type);
				outputText = "";
		}
	}
	
	private static void createComponent(String outputText, Composite father,
			String typeOfObject, String type) {
		switch (typeOfObject) {
		case "Leaf":
			Component leaf = new Leaf(type, outputText);
			father.add(leaf);
			break;
		case "Composite":
			Composite composite = new Composite(ComponentType.SENTENCE);
			parseManager(outputText, composite);
			father.add(composite);
			break;
		default: 
			throw new ParserException("this element type can not be recognized");
		}
		
	}

	private static boolean isCode(String text) {
		boolean result = true;
		if(findMatches(text,"code"))
		return result;
	}
	
}
