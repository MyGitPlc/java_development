package com.dapy.assignment;

import java.io.IOException;
import java.text.ParseException;

public class RegisterSystemTest {

	public static void main (String[] arg) throws IOException, ClassNotFoundException, ParseException {
	
		RegisterSystemMenu rsm = new RegisterSystemMenu();
		try {
		rsm.doOperation();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
