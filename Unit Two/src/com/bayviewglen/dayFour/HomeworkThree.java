package com.bayviewglen.dayFour;

import java.util.Scanner;

public class HomeworkThree {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter two integers: ");

		int a = keyboard.nextInt();
		int b = keyboard.nextInt();
		int c = Math.abs(b - a + 1);
		int d = (int) (Math.random() * c) + a;
		int e = (int) (Math.random() * c) + b;

		if (a < b) {
			System.out.println("The random number is " + d);
		} else if (a > b) {
			System.out.println("The random number is " + e);

		}
		
		keyboard.close();
	}

}
