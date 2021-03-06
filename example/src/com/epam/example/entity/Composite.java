package com.epam.example.entity;

public abstract class Composite implements Component {

	private Component[] children = new Component[9];  // 3. Couple to interface
	private int         total    = 0;
	private int         value;
	
	public Composite( int val ) { 
		value = val; 
		}
	
	public void add( Component c ) {
		children[total++] = c; 
	} // 3. Couple to

	@Override
	public void traverse() {
		  System.out.print( value + "  " );
	      for (int i=0; i < total; i++)
	          children[i].traverse();            // 4. Delegation and polymorphism 
	}

}
