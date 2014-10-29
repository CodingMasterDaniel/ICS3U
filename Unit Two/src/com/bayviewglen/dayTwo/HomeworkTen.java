package com.bayviewglen.dayTwo;

import java.util.Scanner;

public class HomeworkTen {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter two words: ");

		String a = keyboard.next();
		String b = keyboard.next();

		int c = a.length();
		int d = b.length();

		String e = a.substring(1, c);
		String f = b.substring(1, d);

		System.out.println(e + f);

		keyboard.close();

	}

}
