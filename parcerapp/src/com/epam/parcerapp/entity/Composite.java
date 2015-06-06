package com.epam.parcerapp.entity;

import java.util.ArrayList;

public class Composite extends Component {
	
	private ArrayList<Component> components = new ArrayList<Component>();
	private ComponentType type;
	
	public Composite(ComponentType type) {
		this.setType(type);
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

	public ComponentType getType() {
		return type;
	}

	public void setType(ComponentType type) {
		this.type = type;
	}
	
	@Override
	public int showSize() {
		return components.size();
	}

}
