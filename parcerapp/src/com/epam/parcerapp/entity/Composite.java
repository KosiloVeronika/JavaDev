package com.epam.parcerapp.entity;

import java.util.ArrayList;

public class Composite extends Component {
	private ArrayList<Component> components = new ArrayList<Component>();
	private CompositeType type;
	
	public Composite(CompositeType type) {
		setType(type);
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

	public CompositeType getType() {
		return type;
	}

	public void setType(CompositeType type) {
		this.type = type;
	}
	
	@Override
	public int showSize() {
		return components.size();
	}

}
