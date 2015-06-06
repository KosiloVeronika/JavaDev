package com.epam.parcerapp.entity;

public class Leaf extends Component {
	private String part;
	private CompositeType name;
	
	
	public Leaf(CompositeType name, String part) {
		this.setName(name);
		this.setPart(part);
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

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}



	@Override
	public int showSize() {
		throw new UnsupportedOperationException();
	}

	public CompositeType getName() {
		return name;
	}

	public void setName(CompositeType name) {
		this.name = name;
	}

}
