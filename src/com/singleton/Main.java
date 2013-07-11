package com.singleton;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.serializable.Car;

public class Main {
	public static void main(String[] args){
		try {
			Singleton instance1 = Singleton.getInstance();
			instance1.name = "instance1";
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream;
	
			System.out.println("Serializing...");
			System.out.println("instance1.name:" + instance1.name);
			objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(instance1);
			objectOutputStream.flush();
			byteArrayOutputStream.flush();
			objectOutputStream.close();
			byteArrayOutputStream.close();
			
			instance1.name = "instance2";
			ByteArrayInputStream bais = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            System.out.println("Deserializing...");
            Singleton instance2 = (Singleton)ois.readObject();
            
            if(instance1 == instance2){
            	System.out.println("instance1 == instance2");
            }else{
            	System.out.println("instance1 != instance2");
            }
            
            System.out.println("instance2.name:" + instance2.name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
