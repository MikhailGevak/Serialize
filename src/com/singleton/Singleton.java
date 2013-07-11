package com.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Singleton  implements Serializable {
	private static final long serialVersionUID = 8413502725007695828L;
	private static Singleton instance = null;
	
	public String name = "";
	
	private Singleton(){};
	
	public static Singleton getInstance(){
		if (instance == null){
			instance = new Singleton();
		}
		
		return instance;
	}
	
	private Object readResolve() throws ObjectStreamException{ 
		instance.name = this.name;
        return instance;
    }
}
