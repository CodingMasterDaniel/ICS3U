package com.bayviewglen.dayTwo;

import java.util.Scanner;

public class HomeworkFour {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter 4 alphabets or symbols, and then enter a word: ");
		
		String outString = keyboard.next();
		String word = keyboard.next();
		
		String front = outString.substring(0,2);
		String back = outString.substring(2, 4);
		
		System.out.println(front + word + back);
		
		keyboard.close();

	}

}
