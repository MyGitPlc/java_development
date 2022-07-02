package com.dapy.assignment;

public class MethodExample {

	static int count;

	public MethodExample() {
		count = count + 1;
		System.out.println("Count = " + count);
	}

	public int doMultiply(int a, int b) {
		return a * b;

	}

	public void printTableForLoop(int tableName) {

		for (int i = 1; i <= 20; i++) {

			System.out.println(i + " X " + tableName + " = " + tableName * i);
		}
	}

	public void printTableWhileLoop(int tableName) {

		int i = 0;
		while (i <= 20) {
			System.out.println(i + " X " + tableName + " = " + tableName * i);
			i++;
		}

	}

	public void printTableDoWhileLoop(int tableName) {

		int i = 0;
		do {
			System.out.println(i + " X " + tableName + " = " + tableName * i);
			i++;
		} while (i <= 20);

	}

	public void getOdd(int number) {

		System.out.println("Odd number between " + "1" + " and " + number);
		int i = 1;
		while (i <= number) {
			if (i % 2 != 0) {

				System.out.println(i);
			}
			i++;
		}
	}

	public void getEven(int number) {

		int i = 0;
		System.out.println("Even number between " + "1" + " and " + number);
		while (i <= number) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
			i++;
		}

	}

	public void getOdd1(int number) {
		System.out.println("Odd number between " + number + " and " + "1");

		while (number >= 0) {
			if (number % 2 != 0) {
				System.out.println(number);
			}
			--number;
		}
	}

	public void getEven1(int number) {
		System.out.println("Even number between " + number + " and " + "1");

		while (number >= 0) {
			if (number % 2 == 0) {
				/*
				 * if (number == 0) { continue; }
				 */
				System.out.println(number);
			} 
			--number;
		}
	}

	public void printStar(int number) {

		int y = 1;
		for (int i = number; i <= number; --i) {
			if (i == 0) {
				break;
			}
			do {

				System.out.print("*");
				y++;
			} while (y <= i);
			y = 1;
			System.out.println();

		}
	}

	public void getPrintComplexPattern(int number, int x) {

		int z = 1;
//		int x = 10;
		int i;
		int cnt = 0;
		do {
			for (i = z; i <= number; i++) {
				// System.out.print(i + ", ");
				cnt++;
				if (cnt == x) {
					System.out.print(i);
					break;
				}
				System.out.print(i + ", ");
			}
			System.out.println();
			z = cnt + i;
			cnt = 0;
			for (i = z; i <= number; --i) {
				cnt++;

				if (cnt == x) {
					System.out.print(i);
					break;
				}
				System.out.print(i + ", ");
			}
			System.out.println();
			z = i + cnt;
			cnt = 0;

		} while (i <= number);

	}

}