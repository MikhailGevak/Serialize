package com.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	 public static void main(String[] args){
	        try {
	            System.out.println("Creating...");
	            Car car = new Car("Zaz", "Forza");
	            car.number = "AA0001BP";
		           
	            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
	            System.out.println("Serializing...");
	            objectOutputStream.writeObject(car);
	            objectOutputStream.flush();
	            byteArrayOutputStream.flush();
	            objectOutputStream.close();
	            
	            byteArrayOutputStream.close();
	            
	            ByteArrayInputStream bais = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
	            ObjectInputStream ois = new ObjectInputStream(bais);
	            System.out.println("Deserializing...");
	            Car car2 = (Car)ois.readObject();
	            
	            System.out.println("car2.number=" + car2.number);
	            System.out.println("car2.mark=" + car2.mark);
	            System.out.println("car2.model=" + car2.model);
	        } catch (IOException ex){
	            ex.printStackTrace();
	        } catch (ClassNotFoundException ex){
	            ex.printStackTrace();
	        }
	    }
}
