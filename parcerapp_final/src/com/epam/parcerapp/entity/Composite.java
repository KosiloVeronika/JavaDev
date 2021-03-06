package com.epam.parcerapp.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Composite extends Component {
	private ArrayList<Component> components = new ArrayList<Component>();
	private CompositeType type;
	private int wordsCount;
	
	public Composite(CompositeType type) {
		setType(type);
	}

	public CompositeType getType() {
		return type;
	}

	public void setType(CompositeType type) {
		this.type = type;
	}
	
	public List<Component> getComponents() throws EntityException{
		try {
			return Collections.unmodifiableList(components);
		} catch(NullPointerException e) {
			throw new NullPointerException();
		}
	}
	
	public int getWordsCount() {
		return wordsCount;
	}

	public void setWordsCount(int wordsCount) {
		this.wordsCount = wordsCount;
	}
	
	@Override
	public void add(Component component) {
		components.add(component);
	}
	
	@Override
	public void remove(Component component) {
		components.remove(component);

	}
	
	@Override
	public Object getChild(int index) {
		return components.get(index);

	}
	
	@Override
	public int showSize() {
		return components.size();
	}

}
