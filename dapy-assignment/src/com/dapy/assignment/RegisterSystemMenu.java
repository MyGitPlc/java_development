package com.dapy.assignment;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class RegisterSystemMenu {

	private static final RegisterUserDetails UserDetails = null;
	
	public void doOperation() throws Exception {
		String action;
			printMenu();

			String input = "";
			Scanner sc = new Scanner (System.in);
		//	String action1Start;
			
			RegisterSystem obj = new RegisterSystem();
			do {

				System.out.println("Enter your choice");
				input = sc.next();
				switch (input) { 
			
				case "1":
					 action = "Simple Registration";
					//obj.writeActivityLog(action);	//	obj.writeFileHistory(UserDetails);
					obj.RegisterNormalPassword(action);
								
					break;

				case "2":
					
					 action = "Complex Registration";
								
					obj.RegisterComplexPassword(action);
				
					break;

				case "3":
					
					action = "Start login";
				//	obj.writeActivityLog(action);
					
					obj.loginUser(action);
					
				
					break;

				case "?":
					action = "Asked for Help";
					//obj.writeActivityLog(action);
					
					printMenu();
					break;
				case "4":
					
					 action = "Exited the System";
				//	obj.writeActivityLog(action);
					
					System.out.println("Exiting the System...");
					break;
				default:
					System.out.println("Invaid option");
				}
			} while (!input.equals("4") || input.length() != 1);

			sc.close();

		}
	
		public static void printMenu() {
			System.out.println("Welcome to Registration System");
			System.out.println("Please Select below Options");
			System.out.print("Choice\t\tAction\n" + "------\t\t------\n" + "1\t\tSimple Registration\n"
					+ "2\t\tComplex Registration\n" + "3\t\tLogin\n" + "Q\t\tQuit\n"
					+ "?\t\tDisplay Help\n");
		}
	}


