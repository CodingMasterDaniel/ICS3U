package com.bayviewglen.dayFour;

public class HomeworkSix {

	public static void main(String[] args) {
		final int NUM_OF_LETTERS = 26;
		final int UPPER_CASE_A = 65;

		char letter = (char) ((int) (Math.random() * NUM_OF_LETTERS) + UPPER_CASE_A);
		System.out.print("The random upper case letter is " + letter + ".");

	}

}
