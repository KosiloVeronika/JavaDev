package com.epam.parcerapp.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.epam.parcerapp.entity.Component;
import com.epam.parcerapp.entity.Composite;
import com.epam.parcerapp.entity.EntityException;
import com.epam.parcerapp.entity.Leaf;

public class WordsCounter {
	
	public static String countWords(Component component) throws EntityException {
		StringBuilder sb = new StringBuilder();
		reviveForCount(component);
		sort(component, sb);
		return sb.toString();
	}
	
	private static void reviveForCount(Component component) {
		int s = component.showSize();
		int count = 0;
		for(int i = 0; i < s ; i++) {
			if(component.getChild(i) instanceof Leaf) {
				if(((Leaf) component.getChild(i)).getPart().matches("[a-zA-Z]+")) {
					((Composite) component).setWordsCount(count++);
				}
			} else {
				reviveForCount((Component)component.getChild(i));
			}
			
		}
	}
	
	private static void revive(Component component, StringBuilder sb) {
		int s = component.showSize();
		for(int i = 0; i < s ; i++) {
			if(component.getChild(i) instanceof Leaf) {
				sb.append(((Leaf) component.getChild(i)).getPart());
			} else if(component instanceof Composite) {
				revive((Component)component.getChild(i), sb);
			}
		}
	}
	
	private static void sort(Component component, StringBuilder sb) throws EntityException {
		List<Component> sentenses = ((Composite) component).getComponents();
		List<Integer> wCount = new ArrayList<Integer>();
		for(Component c: sentenses) {
			if(c instanceof Composite) {
				wCount.add(((Composite) c).getWordsCount());
			}
		}
		Collections.sort(wCount);
		for(int i: wCount) {
			for(Component c: sentenses) {
				if(c instanceof Composite && (((Composite) c).getWordsCount()) == i) {
					revive(c, sb);
				}
			}
		}
	}
}
