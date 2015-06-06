package com.epam.newyeargift.dao;

public enum CandiesTagsEnum {
	BOX("box"), 
    CHOCOLATE("chocolate"),
    CARAMEL("caramel"), 
    JELLY("jelly"),
    NAME("name"), 
    WEIGHT("weight"),
    SHUGAR_AMOUNT("shugar-amount"), 
    COLOR("color"), 
    TYPE_OF_CARAMEL("type-of-caramel"),
    TYPE_OF_CHOCOLATE("type-of-chocolate"),
    FILLING("filling"),
    TASTE("taste");
    
    private String value;
    
    private CandiesTagsEnum(String value) {
    	this.value = value;
    }
    
    public String getValue() {
    	return value;
    }
}
