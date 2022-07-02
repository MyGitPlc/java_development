package com.dapy.assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class RegisterProperty {
static Properties properties;
	static {
		try{
			properties = new Properties();
			properties.load(new FileInputStream("configuration.properties"));
		//	properties.store(new FileOutputStream("configuration.properties"), null);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
	
	public static void setProperty(String key, String value) throws FileNotFoundException, IOException {
		 properties.setProperty(key, value);
		properties.store(new FileOutputStream("configuration.properties"), null);
		
	}

	public static void remove(String userName) {
		properties.remove(userName);
		// TODO Auto-generated method stub
	
	}
}