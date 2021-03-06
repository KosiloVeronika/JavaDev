package com.epam.parcerapp.parse;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.parcerapp.entity.Component;
import com.epam.parcerapp.entity.Composite;
import com.epam.parcerapp.entity.CompositeType;
import com.epam.parcerapp.entity.Leaf;

public class Parser {
	
	private static Properties prop;
	
	private Parser() throws ParserException { }

	public static void parseManage(String text, Composite composite) throws ParserException {
		
		switch(composite.getType()) {
			case TEXT:
				parse(text,CompositeType.SENTENCE, composite);
				break;
			case SENTENCE:
				parse(text,CompositeType.WORD, composite);
				break;
			case CODE:
				parse(text,CompositeType.CODE, composite);
				break;
			default: throw new ParserException ("This element type can not be recognized");
		}
	}
	
	public static void configure(String propFilePath) throws ParserException {
		prop = new Properties();
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(propFilePath);
			prop.load(inputStream);
		} catch (IOException e) {
			throw new ParserException("Problem with property file", e);
		}
	}
	
	private static void parse(String text, 
			CompositeType type, Composite parent) throws ParserException {
		String outputText = "";
		String typeOfObject;
		String regEx = prop.getProperty(type.toString().toLowerCase());
		String regExCode = prop.getProperty("code");
		typeOfObject = prop.getProperty(String.format("%sType",type.toString().toLowerCase()));
		Pattern pattern = Pattern.compile(regEx);
		Pattern codePattern = Pattern.compile(regExCode);
		Matcher matcher = pattern.matcher(text);
		int startPosition;
		int endPosition;
		while(matcher.find()) {
				startPosition = matcher.start();
				endPosition = matcher.end();
				outputText = matcher.group();
				Matcher codeMatch = codePattern.matcher(text);
				if(codeMatch.find(startPosition) && codeMatch.end() == endPosition) {
					createComponent(outputText, parent, "Leaf", CompositeType.CODE);
				} else {
					createComponent(outputText, parent, typeOfObject, type);
				}
				outputText = "";
		}
	}


	private static void createComponent(String outputText, Composite father,
			String typeOfObject, CompositeType type) throws ParserException {
		switch (typeOfObject) {
		case "Leaf":
			Component leaf = new Leaf(type, outputText);
			father.add(leaf);
			break;
		case "Composite":
			Composite composite = new Composite(CompositeType.SENTENCE);
			parseManage(outputText, composite);
			father.add(composite);
			break;
		default: 
			throw new ParserException("This element type can not be recognized");
		}
		
	}

	public static String revive(Component component) {
		StringBuilder sb = new StringBuilder();
		revive(component, sb);
		return sb.toString();		
	}
	
	private static void revive(Component component, StringBuilder sb) {
		int s = component.showSize();
		for(int i = 0; i < s ; i++) {
			if(component.getChild(i) instanceof Leaf) {
				sb.append(((Leaf) component.getChild(i)).getPart());
			} else {
				revive((Component)component.getChild(i), sb);
			}
		}
	}
	
}
