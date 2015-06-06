package com.epam.example.entity;

public class Row extends Composite {

	public Row(int val) {
		super(val);
		// TODO Auto-generated constructor stub
	}
	
	 public void traverse() {                  // "meat" is in the Composite
	      System.out.print( "Row" );             // base class.
	      super.traverse();
	} 

}
