package com.enumaration;

public enum Color {
    RED("red"),GREEN("green"),BLUE("blue");
    
    private Color(String name){
    	this.name = name;
    }
    
    public String getName(){
    	return name;
    }
    
    private String name;
}