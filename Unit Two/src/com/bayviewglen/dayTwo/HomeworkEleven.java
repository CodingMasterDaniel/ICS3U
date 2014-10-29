package com.bayviewglen.dayTwo;

import java.util.Scanner;

public class HomeworkEleven {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter one word: ");

		String a = keyboard.next();
		int b = a.length();
		String c = a.substring(0, 2);
		String d = a.substring(2, b);

		System.out.println(d + c);

		keyboard.close();
	}

}
