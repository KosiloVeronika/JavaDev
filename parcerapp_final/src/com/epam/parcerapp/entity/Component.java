package com.epam.parcerapp.entity;

public abstract class Component {
	public abstract void add(Component c);
	public abstract void remove(Component c);
	public abstract Object getChild(int index);
	public abstract int showSize();
}
