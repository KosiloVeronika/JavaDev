package com.epam.parcerapp.entity;

public class Leaf extends Component {
	
	private String part;
	private LeafType name;
	
	
	public Leaf(LeafType name, String part) {
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

	public LeafType getName() {
		return name;
	}

	public void setName(LeafType name) {
		this.name = name;
	}

}
