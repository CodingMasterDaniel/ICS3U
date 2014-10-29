package com.bayviewglen.dayTwo;

import java.util.Scanner;

public class HomeworkOne {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Please enter your name: ");
		String name = keyboard.nextLine();

		System.out.println("Hello " + name + "!");

		keyboard.close();

	}
}
