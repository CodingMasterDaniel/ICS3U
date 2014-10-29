package com.bayviewglen.dayTwo;

import java.util.Scanner;

public class HomeworkThree {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Please enter a tag and words: ");
		String tag = keyboard.next();
		String word = keyboard.next();

		System.out.println("<" + tag + ">" + word + "</" + tag + ">");

		keyboard.close();

	}

}
