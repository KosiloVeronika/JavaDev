package com.epam.example.entity;

public class Column extends Composite {

	public Column(int val) {
		super(val);
		
	}
	
	public void traverse() {
	      System.out.print( "Col" );
	      super.traverse();
	}

}