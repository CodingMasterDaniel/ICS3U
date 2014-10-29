package com.bayviewglen.dayTwo;

import java.util.Scanner;

public class HomeworkEight {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter a word: ");
		
		String string = keyboard.next();
		
		int a = string.length()-1;
		String b = string.substring(1, a);
		
		System.out.println(b);
		
		keyboard.close();


	}

}
