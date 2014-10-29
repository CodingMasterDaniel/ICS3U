package com.bayviewglen.dayTwo;

import java.util.Scanner;

public class HomeworkNine {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter two words: ");

		String a = keyboard.next();
		String b = keyboard.next();

		if (a.length() < b.length()) {
			System.out.println(a + b + a);
		}

		else if (a.length() > b.length()) {
			System.out.println(b + a + a);
		}

		keyboard.close();

	}

}
