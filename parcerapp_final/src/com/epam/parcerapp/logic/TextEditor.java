package com.epam.parcerapp.logic;

import java.util.HashSet;
import java.util.Set;

import com.epam.parcerapp.entity.Component;
import com.epam.parcerapp.entity.Leaf;

public class TextEditor {
	
	static final Set<Character> CONSONANTS_SET;
	
	static {
		CONSONANTS_SET = new HashSet<Character>();
		char[] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 
					'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
		for(Character consonant : consonants) {
			CONSONANTS_SET.add(consonant);
		}
	}
	
	public static String deleteWord(Component component, int wordLength) {
		StringBuilder sb = new StringBuilder();
		revive(component, sb, wordLength);
		return sb.toString();	
	}

	private static void revive(Component component, StringBuilder sb, int wordLength) {
		int s = component.showSize();
		for(int i = 0; i < s ; i++) {
			if(component.getChild(i) instanceof Leaf) {
				if(!(check( ((Leaf) component.getChild(i)).getPart(), wordLength))) {
					sb.append(((Leaf) component.getChild(i)).getPart());
				}
			} else {
				revive((Component)component.getChild(i), sb, wordLength);
			}
		}
	}
	
	private static boolean check(String part, int length) {
		boolean result = false;
		if(part.length() == length 
		   && CONSONANTS_SET.contains(part.toLowerCase().charAt(0))) {
			result = true;
		}
		return result;
	}
	
	

}
