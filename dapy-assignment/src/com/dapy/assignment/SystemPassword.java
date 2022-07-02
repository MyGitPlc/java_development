package com.dapy.assignment;

import java.util.Scanner;

public class SystemPassword {

	public void RegisterNormalPassword() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter Password, should not be less than 5 characters /n");
		System.out.println("");
		int count = 0;
		while (sc.hasNext()) {

			String passwordInput = sc.next();
			System.out.print("*");
			if (passwordInput.equalsIgnoreCase("\r")) {

				if (count <= 5) {
					continue;
				}

				break;
			}
			count++;

		}

	}

}
