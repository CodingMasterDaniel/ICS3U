package com.bayviewglen.dayTwo;

import java.util.Scanner;

public class HomeworkTwelve {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter one word: ");

		String a = keyboard.next();
		int b = a.length();
		String c = a.substring(b - 2, b);
		String d = a.substring(0, b - 2);

		System.out.println(c + d);

		keyboard.close();

	}

}
