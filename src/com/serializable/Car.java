package com.serializable;

import java.io.Serializable;

public class Car extends Vehicle implements Serializable{
	private static final long serialVersionUID = 3329999866918906824L;
	public String mark = "";
	public String model = "";
	
	public Car(){
		System.out.println("Car::Car()");
	}
	
	public Car(String mark, String model){
		System.out.println("Car::Car(String, String)");
		this.mark = mark;
		this.model = model;
	}
}


