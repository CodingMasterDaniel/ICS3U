package com.bayviewglen.dayFour;

public class HomeworkSeven {

	public static void main(String[] args) {
		final int NUM_OF_LETTERS = 26;
		final int LOWER_CASE_A = 97;

		char letter = (char) ((int) (Math.random() * NUM_OF_LETTERS) + LOWER_CASE_A);
		System.out.print("The random lower case letter is " + letter + ".");

	}

}
