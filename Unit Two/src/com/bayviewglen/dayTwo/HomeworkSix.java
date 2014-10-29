package com.bayviewglen.dayTwo;

import java.util.Scanner;

public class HomeworkSix {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter a word: ");

		String word = keyboard.next();

		if (word.length() < 2) {
			System.out.println(word);
		}

		else {

			String a = word.substring(0, 2);

			System.out.println(a);
		}

		keyboard.close();

	}

}
