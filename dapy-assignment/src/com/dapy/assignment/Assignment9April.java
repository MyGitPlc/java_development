package com.dapy.assignment;

import java.util.Arrays;

//import com.sun.tools.javac.util.ArrayUtils;

public class Assignment9April {
	int result;
	int firstItem;
	String myArray = "";

	public int getMax(int[] inputArray) {
		/*
		 * int max = inputArray[0]; for (int i = 1; i < inputArray.length; i++) { if
		 * (inputArray[i] > max) { max = inputArray[i]; }
		 * 
		 * }
		 */

		for (int i = 0; i < inputArray.length; i++) {

			if (i == 0) {
				firstItem = inputArray[i];
				continue;
			}

			if (firstItem > inputArray[i]) {
				inputArray[i] = firstItem;

			} else {
				firstItem = inputArray[i];
			}
		}

		return firstItem;
	}

	public int getMin(int[] inputArray) {

		int min = inputArray[0];
		for (int i = 1; i < inputArray.length; i++) {
			if (inputArray[i] < min) {
				min = inputArray[i];
			}
		}
		return min;
	}

	public int[] doMerge(int[] inputArray1, int[] inputArray2) {

		int i;
		int[] mergedArray = new int[inputArray1.length + inputArray2.length + 1];
		for (i = 0; i < inputArray1.length; i++) {
			mergedArray[i] = inputArray1[i];
			// myArray = myArray.concat(Integer.toString(mergedArray[i]) + ",");
		}
		int m = inputArray1.length + 1;
		for (i = 0; i < inputArray2.length; i++) {
			mergedArray[m + i] = inputArray2[i];

		}

		return mergedArray;
	}

	public int[] doReplace(int[] inputArray, int noToBeReplaced, int valueToBeReplaced) {

		for (int i = 0; i < inputArray.length; i++) {

			if (inputArray[i] == noToBeReplaced) {
				inputArray[i] = valueToBeReplaced;
			}

		}

		return inputArray;
	}

	public int[] removeDuplicates(int[] inputArray) {
		boolean dup = false;
		int j = 0;
		int p = 0;
		int m = 0;
		String arr = "";
		do {
			for (int i = j + 1; i <= inputArray.length - 1; i++) {

				if (inputArray[j] == inputArray[i]) {
					dup = true;
					m = i;
					continue;
				}

				if (dup == true & m != 0) {
					inputArray[m] = inputArray[i];

					arr = Arrays.toString(inputArray);
					// arr[m] = arr[m];
				}
			}
			j++;

		} while (j <= inputArray.length);
		return inputArray;
	}

	
	public int[] doReverse(int[] inputArray) {
		int[] newArray = new int[inputArray.length];
		for (int i = inputArray.length - 1; i <= inputArray.length; --i) {
			newArray[(inputArray.length - 1) - i] = inputArray[i];
			if (i == 0) {
				break;
			}
		}
		return newArray;
	}

	public int[] doSortAsc(int[] inputArray) {
		int j = 0;
		int m = 0;
		int p = 0;
		do {
			for (int i = j + 1; i <= inputArray.length - 1; i++) {

				if (inputArray[j] > inputArray[i]) {

					m = inputArray[i];
					p = inputArray[j];
					inputArray[j] = m;
					inputArray[i] = p;
				}
			}
			j++;

		} while (j <= inputArray.length);
		return inputArray;
	}

	public int[] doSortDesc(int[] inputArray) {
		int j = 0;
		int m = 0;
		int p = 0;
		do {
			for (int i = j + 1; i <= inputArray.length - 1; i++) {

				if (inputArray[j] < inputArray[i]) {

					m = inputArray[i];
					p = inputArray[j];
					inputArray[j] = m;
					inputArray[i] = p;
				}
			}
			j++;

		} while (j <= inputArray.length);
		return inputArray;
	}

	public int[] doSumOfDigit(int[] inputArray) {

		int arrayIndex = 0;
		for (int i = 0; i < inputArray.length; i++) {

			arrayIndex = inputArray[i];

			if (Integer.toString(inputArray[i]).length() == 1) {
				String firstString1 = Integer.toString(inputArray[i]).substring(0, 1);
				inputArray[i] = Integer.parseInt(firstString1);
			} else {

				String firstString1 = Integer.toString(inputArray[i]).substring(0, 1);
				String secondString1 = Integer.toString(inputArray[i]).substring(1, 2);

				int sumOfIndexStrings1 = Integer.parseInt(firstString1) + Integer.parseInt(secondString1);
				if (sumOfIndexStrings1 >= 10) {

					String firstString2 = Integer.toString(sumOfIndexStrings1).substring(0, 1);
					String secondString2 = Integer.toString(sumOfIndexStrings1).substring(1, 2);

					int sumOfIndexStrings2 = Integer.parseInt(firstString2) + Integer.parseInt(secondString2);
					inputArray[i] = sumOfIndexStrings2;
				} else {
					inputArray[i] = sumOfIndexStrings1;
				}
			}
		}
		return inputArray;
	}

}

