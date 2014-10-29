package com.bayviewglen.dayFour;

import java.util.Scanner;

public class ExampleTwo {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter words: ");
		
		String x = keyboard.nextLine();
		
		int a = x.length();
		int b = (int)(Math.random()*a);
		char c = x.charAt(b);
		System.out.println("The random letter is " + c);
		
		keyboard.close();
	}

}
