package com.dapy.assignment;

import java.util.Arrays;
import java.util.Scanner;

public class Assignment9AprilMenu {
	int noOfArrayElement;
	int[] arrayOfNumber;
	Scanner sc = new Scanner(System.in);
	String myArray = "";
	Assignment9April obj;
	String inputI = "";

	public void doOperation() {
		printMenu();

		String input = "";

		obj = new Assignment9April();
		do {

			System.out.println("Enter your choice");
			input = sc.next();
			switch (input.toUpperCase()) { 
		
			case "A":
				System.out.println("Enter number of elements of your Array");
				noOfArrayElement = sc.nextInt();
				arrayOfNumber = new int[noOfArrayElement];
				inputArray();

				System.out.println("The Highest Element is " + obj.getMax(arrayOfNumber));

				break;

			case "B":
				System.out.println("Enter number of elements of your Array");
				noOfArrayElement = sc.nextInt();
				arrayOfNumber = new int[noOfArrayElement];
				inputArray();
				System.out.println("The Minimum Element is " + obj.getMin(arrayOfNumber));

				break;

			case "C":
				System.out.println("Enter number of elements for Array1");
				noOfArrayElement = sc.nextInt();
				arrayOfNumber = new int[noOfArrayElement];
				int[] array1 = new int[noOfArrayElement];
				System.out.println("Input Elelment for first Array");
				inputArray();
				array1 = arrayOfNumber;

				System.out.println("Enter number of elements for Array2");
				noOfArrayElement = sc.nextInt();
				arrayOfNumber = new int[noOfArrayElement];
				int[] array2 = new int[noOfArrayElement];

				inputArray();
				array2 = arrayOfNumber;

				array2 = obj.doMerge(array1, array2);
				String myArray = Arrays.toString(array2);

				// System.out.println("Your merged Array is " + obj.doMerge(array1, array2));

				System.out.println("Your merged Array is " + myArray);

				break;

			case "D":
				System.out.println("Enter number of elements of your Array");
				noOfArrayElement = sc.nextInt();
				arrayOfNumber = new int[noOfArrayElement];
				inputArray();

				// System.out.println("Array is :" + myArray);

				System.out.println("Enter the elements to replace");
				int elementToReplace = sc.nextInt();

				System.out.println("Enter the new value");
				int newElement = sc.nextInt();

				arrayOfNumber = obj.doReplace(arrayOfNumber, elementToReplace, newElement);
				myArray = Arrays.toString(arrayOfNumber);

				System.out.println("Your new Array is " + myArray);

				break;

			case "E":
				System.out.println("Enter number of elements for your Array");
				noOfArrayElement = sc.nextInt();
				arrayOfNumber = new int[noOfArrayElement];
				inputArray();

				arrayOfNumber = obj.removeDuplicates(arrayOfNumber);
				myArray = Arrays.toString(arrayOfNumber);

				System.out.println("Your new Array is " + myArray);

				break;
			case "F":
				System.out.println("Enter number of elements for your Array");
				noOfArrayElement = sc.nextInt();
				arrayOfNumber = new int[noOfArrayElement];
				inputArray();

				arrayOfNumber = obj.doReverse(arrayOfNumber);
				myArray = Arrays.toString(arrayOfNumber);
				System.out.println("Your Reversed Array is " + myArray);
				break;
			case "G":
				System.out.println("Enter number of elements of Array to Sort");
				noOfArrayElement = sc.nextInt();
				arrayOfNumber = new int[noOfArrayElement];
				inputArray();

				arrayOfNumber = obj.doSortAsc(arrayOfNumber);
				myArray = Arrays.toString(arrayOfNumber);
				System.out.println("Your Array Ordered in Asc. Order " + myArray);
				break;
			case "H":
				System.out.println("Enter number of elements of Array to Sort");
				noOfArrayElement = sc.nextInt();
				arrayOfNumber = new int[noOfArrayElement];
				inputArray();

				arrayOfNumber = obj.doSortDesc(arrayOfNumber);
				myArray = Arrays.toString(arrayOfNumber);
				System.out.println("Your Array Ordered in Desc. Order " + myArray);
				break;
			case "I":
				
				System.out.println("Enter number of elements in the Array to sum digits");
				noOfArrayElement = sc.nextInt();
				arrayOfNumber = new int[noOfArrayElement];
				inputI = input.toUpperCase();
				inputArray();

				arrayOfNumber = obj.doSumOfDigit(arrayOfNumber);
				myArray = Arrays.toString(arrayOfNumber);
				System.out.println("Your new Array is " + myArray);
				break;
			case "?":
				printMenu();
				break;
			case "Q":
				System.out.println("Exiting the Calculator...");
				break;
			default:
				System.out.println("Invaid option");
			}
		} while (!input.toUpperCase().equals("Q") || input.length() != 1);

		sc.close();

	}

	public static void printMenu() {
		System.out.println("Welcome to Calculator");
		System.out.println("Please Select below Options");
		System.out.print("Choice\t\tAction\n" + "------\t\t------\n" + "A\t\tGet Maximum Array Element\n"
				+ "B\t\tGet Minimum Array Element\n" + "C\t\tMerge Arrays\n" + "D\t\tReplace Element of Array\n"
				+ "E\t\tRemove Duplicate Elements in Array\n" + "F\t\tReverse Elements in Array\n" + "G\t\tArrange Array Elements in Assending Order\n" + "H\t\tArrange Array Elements in Descending Order\n" + "I\t\tSum of Digits in an Array\n"+ "Q\t\tQuit\n"
				+ "?\t\tDisplay Help\n");
	}

	public void inputArray() {

		for (int i = 0; i < arrayOfNumber.length; i++) {
			System.out.println("Enter Element Number " + (i + 1) );
			arrayOfNumber[i] = sc.nextInt();
			// myArray = myArray.concat(Integer.toString(arrayOfNumber[i]) + ",");
			

			if (arrayOfNumber[i] >= 100 & inputI.equalsIgnoreCase(inputI)) {
				System.out.println("Error - Array Element should be the range 1 to 99, Pls Re-Enter");
				--i;
				continue;
		}
		
		
		}

		myArray = Arrays.toString(arrayOfNumber);
		System.out.println("Array is :" + myArray);

	}
}
