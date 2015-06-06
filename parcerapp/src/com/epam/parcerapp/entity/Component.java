package com.epam.parcerapp.entity;

public abstract class Component {
	abstract void add(Component c);
	abstract void remove(Component c);
	abstract Object getChild(int index);
	abstract int showSize();
	
}
