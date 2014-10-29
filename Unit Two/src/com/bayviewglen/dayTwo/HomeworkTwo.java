package com.bayviewglen.dayTwo;

import java.util.Scanner;

public class HomeworkTwo {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Please enter two words: ");
		String a = keyboard.next();
		String b = keyboard.next();

		System.out.println(a + b + b + a);

		keyboard.close();
	}

}
