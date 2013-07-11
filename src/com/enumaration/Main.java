package com.enumaration;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.serializable.Car;

public class Main {
	public static void main(String[] args){
		try {
			Color red1 = Color.RED;
			Color green1 = Color.GREEN;
			Color blue1 = Color.BLUE;
			
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream;
	
			System.out.println("Serializing...");
			objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(red1);
			objectOutputStream.writeObject(green1);
			objectOutputStream.writeObject(blue1);
			
			objectOutputStream.flush();
			byteArrayOutputStream.flush();
			objectOutputStream.close();
			byteArrayOutputStream.close();
			
			ByteArrayInputStream bais = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            System.out.println("Deserializing...");
            Color red2 = (Color)ois.readObject();
            Color green2 = (Color)ois.readObject();
            Color blue2 = (Color)ois.readObject();
            
            if(red1 == red2) System.out.println("red1 == red2");
            if(green1 == green2) System.out.println("green1 == green2");
            if(blue1 == blue2) System.out.println("blue1 == blue2");
          
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
