package com.epam.example.run;

import com.epam.example.entity.Column;
import com.epam.example.entity.Composite;
import com.epam.example.entity.Primitive;
import com.epam.example.entity.Row;

public class Run {
	public static void main( String[] args ) {
	      Composite first  = new Row( 1 );          // Row1
	      Composite second = new Column( 2 );       //   |
	      Composite third  = new Column( 3 );       //   +-- Col2
	      Composite fourth = new Row( 4 );          //   |     |
	      Composite fifth  = new Row( 5 );          //   |     +-- 7
	      first.add( second );                      //   +-- Col3
	      first.add( third  );                      //   |     |
	      third.add( fourth );                      //   |     +-- Row4
	      third.add( fifth  );                      //   |     |     |
	      first.add(  new Primitive( 6 ) );         //   |     |     +-- 9
	      second.add( new Primitive( 7 ) );         //   |     +-- Row5
	      third.add(  new Primitive( 8 ) );         //   |     |     |
	      fourth.add( new Primitive( 9 ) );         //   |     |     +-- 10
	      fifth.add(  new Primitive(10 ) );         //   |     +-- 8
	      first.traverse();                         //   +-- 6
	}

}
