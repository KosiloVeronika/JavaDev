package com.epam.parcerapp.logic;

import java.util.ArrayList;
import java.util.Collections;

import com.epam.parcerapp.entity.Component;
import com.epam.parcerapp.entity.Leaf;

public class Sorter {
	
	private static ArrayList<String> words = new ArrayList<String>(); 
	
	public static String sortWords(Component component ) throws LogicException {
		StringBuilder sb = new StringBuilder();
		revive(component);
		sort(sb);
		return sb.toString();
	}
	
	private static void revive(Component component) {
		int s = component.showSize();
		for(int i = 0; i < s ; i++) {
			if(component.getChild(i) instanceof Leaf) {
				findWord(((Leaf) component.getChild(i)).getPart());
			} else {
				revive((Component)component.getChild(i));
			}
		}
	}
	
	private static void findWord(String part) {
		if(part.matches("[a-zA-Z]+")) {
			words.add(part);
		}
	}
	
	private static void sort(StringBuilder sb) throws LogicException {
		Collections.sort(words);
		try {
	        for (int i = 0; i < words.size() - 1; i++) {
	                sb.append(words.get(i));
	                sb.append(",");
	                if(words.get(i).charAt(0) != words.get(i+1).charAt(0)) {
	                	sb.append("\n");
	                }
	                       
	        }
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new LogicException("index out of bound", e);
		}
	}

}
