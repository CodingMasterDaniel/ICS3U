package com.bayviewglen.FunctionPractice;

import java.text.DecimalFormat;
import java.util.Scanner;

public class FunctionPractise {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		CubeRoots();				//Practice 1
		SumSequence(keyboard);		//Practice 2
		Factorial(keyboard);		//Practice 3
		Fibonacci(keyboard);		//Practice 4
		Triangle();					//Practice 5
		Diamond();					//Practice 6
		CountDown(keyboard);		//Practice 13
		Point();					//Practice 14
		CalendarMonth(keyboard);	//Practice 16
		Factors(keyboard);			//Practice 17

	}

	
	//Practice 1
	private static void CubeRoots() {
		for(int i = 10; i <= 50; i++){
			double a = Math.cbrt(i);
		    DecimalFormat formatter = new DecimalFormat("0.0000");
		    String b = formatter.format(a);
		    System.out.println(i + "\t" + b);
		}
	}

	
	//Practice 2
	private static void SumSequence(Scanner keyboard) {
		int sum = 0;
		System.out.print("Please enter a number: ");
		int n = keyboard.nextInt();
		for(int i = 0; i <= n; i++){
			sum += i;
			
		}
		System.out.println("The sum from 1 to the number is " + sum);
	}

	
	//Practice 3
	private static void Factorial(Scanner keyboard) {
		int product = 1;
		System.out.print("Please enter a number: ");
		int n = keyboard.nextInt();
		for(int i = 1; i <= n; i++){
			product = i * product;
			
		}
		System.out.println("The factorial of " + n + " is " + product);
		
	}

	
	//Practice 4
	private static void Fibonacci(Scanner keyboard) {
		System.out.print("Please enter a number: ");
		int a = 1;
		int b = 1;
		int n = keyboard.nextInt();
		System.out.print(a + "  " + b + "  ");
		for(int i = 3; i <= n; i += 2){
			a = a + b;
			b = a + b;
			if(n%2 == 1 && i == n){
				System.out.print(a + "  ");
			}else{
				System.out.print(a + "  " + b + "  ");
			}
			
		}
		
	}
	
	
	//Practice 5
	private static void Triangle() {
		for(int i = 1; i <= 6; i++){
			for(int y = 1; y <= i; y++){
				System.out.print("*");
			}
			System.out.println("");
		}
		
	}
	
	
	//Practice 6
	private static void Diamond() {
		for(int i = 1; i <= 5; i++){
			for(int x = 5 - i; x > 0; x--){
				System.out.print(" ");
			}
			for(int y = 1; y <= (2 * i) - 1; y++){
				System.out.print("*");
			}
			for(int x = 5 - i; x > 0; x--){
				System.out.print(" ");
			}
			System.out.println("");
		}
		
		for(int i = 4; i >= 0; i--){
			for(int x = i; x <= 4; x++){
				System.out.print(" ");
			}
			for(int y = 1; y <= (2 * i) - 1; y++){
				System.out.print("*");				
			}
			for(int x = i; x <= 4; x++){
				System.out.print(" ");
			}
			System.out.println("");
		}
		
		
	}

	
	//Practice 13
	private static void CountDown(Scanner keyboard) {
		System.out.print("What number do i stop at?");
		int a = keyboard.nextInt();
		
		for(int i = 100; i >= a; i-= 5){
			if(i > 99){
				System.out.println(i);
			}else if(i > 9){
				System.out.println(" " + i);
			}else{
				System.out.println("  " + i);
			}
		}
		System.out.println("I stopped.");
	}

	
	//Practice 14
	private static void Point() {
		int a = (int)(Math.random()*6) + 1;
		System.out.println(a);
		System.out.println("");
		
		boolean done = false;
		int count = 0;
		
		while(!done){
			int b = (int)(Math.random()*6) + 1;
	
			if(a != b){
				System.out.println(b);
				count++;
			}else{
				System.out.println("\n" + b);
				count ++;
				System.out.println("Number of times the die was rolled: " + count);
				done = true;
			}
		}
		
	}

	
	//Practice 16
	private static void CalendarMonth(Scanner keyboard) {
		System.out.print("Day the month starts on (1 for Sunday): ");
		int start = keyboard.nextInt();
		System.out.println("");
		System.out.print("Number of days in month: ");
		int days = keyboard.nextInt();
		
		System.out.println("");
		System.out.println("Sun Mon Tue Wed Thu Fri Sat");
		
		for(int i = 1; i <= 4 * start - 2; i++){
			System.out.print(" ");
		}
			int x = 8 - start;
			for(int n = 1; n <= x; n++){
				System.out.print(n + "   ");
			}
			System.out.println("");
			for(int n = x + 1; n <= x + 7; n++){
				if(n > 9){
					System.out.print(" " + n + " ");
				}else{	
					System.out.print("  " + n + " ");
				}
			}
			System.out.println("");
			for(int n = x + 8; n <= x + 14; n++){
				if(n > 9){
					System.out.print(" " + n + " ");
				}else{	
					System.out.print("  " + n + " ");
				}
			}
			System.out.println("");
			for(int n = x + 15; n <= x + 21; n++){
				if(n > 9){
					System.out.print(" " + n + " ");
				}else{	
					System.out.print("  " + n + " ");
				}
			}
			if(start == 7){
				System.out.println("");
				for(int n = x + 22; n <= x + 28; n++){
					if(n > 9){
						System.out.print(" " + n + " ");
					}else{	
						System.out.print("  " + n + " ");
					}
				}
				System.out.println("");
				for(int n = x + 29; n <= days; n++){
					if(n > 9){
						System.out.print(" " + n + " ");
					}else{	
						System.out.print("  " + n + " ");
					}
			}
			}else{
				System.out.println("");
				for(int n = x + 22; n <= days; n++){
					if(n > 9){
						System.out.print(" " + n + " ");
					}else{	
						System.out.print("  " + n + " ");
					}
				}
			}
		
	}

	
	//Practice 17
	private static void Factors(Scanner keyboard) {
		System.out.println("");
		System.out.print("Enter a number: ");
		int x = keyboard.nextInt();
		
		for(int i = 1; i <= x; i++){
			if(x % i == 0){
				System.out.print(i + "  ");
			}
		}
		
		
	}

}
