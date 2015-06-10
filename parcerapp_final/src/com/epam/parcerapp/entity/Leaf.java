package com.epam.parcerapp.entity;

public class Leaf extends Component {
	private String part;
	public Leaf(CompositeType name, String part) {
		this.setName(name);
		this.setPart(part);
	}	

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}
	
	public void setName(CompositeType name) {
	}

	@Override
	public void add(Component c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void remove(Component c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object getChild(int index) {
		throw new UnsupportedOperationException();

	}

	@Override
	public int showSize() {
		throw new UnsupportedOperationException();
	}

}
