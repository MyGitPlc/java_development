package com.dapy.assignment;

public class MethodExampleTest {

	public static void main(String[] args) {

		MethodExample obj = new MethodExample();

		
		  MethodExample obj1 = new MethodExample();
		  
		  MethodExample obj2 = new MethodExample();
		  
		  System.out.println("For Loop Table"); obj.printTableForLoop(2);
		  
		  System.out.println("While Loop Table"); obj.printTableWhileLoop(4);
		  
		  System.out.println("Do While Loop Table"); obj.printTableDoWhileLoop(5);
		  
		  // "Odd number"; 
		  obj.getOdd(20);
		  
		  // "Even number";
		  obj.getEven(20);
		  
		  // "Odd number"; 
		  obj.getOdd1(15);
		  
		  // "Even number"; 
		  obj.getEven1(20);
		  
		  // Print Star
		  obj.printStar(10);
		 
		
		// Print pattern
		obj.getPrintComplexPattern(100, 10);

	}

}
