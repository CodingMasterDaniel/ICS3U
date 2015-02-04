package com.bayviewglen.HorseRacingAssignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HorseRacingAssignment {
	
	public static final Scanner KEYBOARD = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {
		
		// Introduction of game
		introduction();
		
		// Main part of the game
		boolean done = false;
		while (!done){
			
			// Declare variables
			String[] playerNames = getNames();											// Names of players
			int[] playerWallets = getWallet();											// Wallets of players
			String[] horses = getHorses();												// Horses available to choose
			String[] horsesInRace = getRaceHorses(horses);								// Horses that are in the race
			int[][] playerBets = new int[playerNames.length][horsesInRace.length];		// Amount of bet of each player on each horse
			
			// Getting bet amounts from user(s)
			playerBets = getBet(playerNames, playerWallets, horsesInRace);
			
			// Race!!!
			int winHorse = race(horsesInRace);
			
			// Calculation of win and loss of players
			afterRace(playerNames, playerWallets, horsesInRace, winHorse, playerBets);
			
			// Ask user(s) if play again (Write data to file (automatic))
			done = gameEnd(playerNames, playerWallets);			
		}
		
		// Game closes
		Conclusion();
		
	}
	
	
	
	//Method for the end of game display
	private static void Conclusion() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Thank you for playing! :)");
		Thread.sleep(1000);
		System.exit(1);
		
	}

	
	
	// Method for asking if user wants to play again
	private static boolean gameEnd(String[] playerNames, int[] playerWallets) {
		System.out.println("");
		
		try {
			PrintWriter printer = new PrintWriter(new FileWriter("input/playerData.dat"));
			
			int n = playerNames.length;
			String numberOfPlayers = String.valueOf(n);
			printer.write(numberOfPlayers);
			
			for (int i = 0; i < playerNames.length; i++){
				printer.write("\n" + playerNames[i] + " " + playerWallets[i]);
			}
			
			printer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print("Would you like to play again? ");
		boolean correctInput = false;
		
		while (!correctInput){
			String input = KEYBOARD.nextLine();
			if ("yes".equalsIgnoreCase(input) || "play again".equalsIgnoreCase(input) || "go ahead".equalsIgnoreCase(input)){
				return false;
			}else if ("no".equalsIgnoreCase(input) || "done".equalsIgnoreCase(input) || "quit".equalsIgnoreCase(input)){
				return true;
			}else{
				System.out.println("Please enter a correct action: ");
			}
		}
		
		return true;
	}

	
	
	// Method for determining if a player win or lost
	private static void afterRace(String[] playerNames, int[] playerWallets, String[] horsesInRace, int winHorse, int[][] playerBets) {
		 
		for (int i = 0; i < playerBets.length; i++){
			if (playerBets[i][winHorse] != 0){
				playerWallets[i] += 2 * playerBets[i][winHorse];
				System.out.println("Congratulations! " + playerNames[i] + " has won $" + playerBets[i][winHorse] + " !");
			}
		}
		
		for (int i = 0; i < playerBets.length; i++){
				for (int j = 0; j < playerBets[i].length; j++){
					if (j != winHorse && playerBets[i][j] != 0){
						System.out.println("Sorry! " + playerNames[i] + " has lost...");
						break;
					}
				}
			
		}
		
	}

	
	
	// Method for the real horse racing!
	private static int race(String[] horsesInRace) throws InterruptedException {
		boolean doneRace = false;
		int number = horsesInRace.length;
		int raceTrack = 100;
		int[] steps = new int[horsesInRace.length];
		String[] spaces = new String[horsesInRace.length];
		String[] spacesForNames = new String[horsesInRace.length];
		
		for (int i = 0; i < horsesInRace.length; i++){
			spacesForNames[i] = "";
		}
		
		for (int i = 0; i < horsesInRace.length; i++){
			int x = 20 - horsesInRace[i].length();
			for (int j = 0; j <= x; j++){
				spacesForNames[i] += " ";
			}
		}
		
		System.out.println("\nRace Starts!!!");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		for (int i = 0; i < horsesInRace.length; i++){
			spaces[i] = "";
		}
		
		for (int i = 0; i < horsesInRace.length; i++){
			for (int j = 0; j < raceTrack - 1; j++){
				spaces[i] += " ";
			}
		}
		
		
		for(int i = 0; i < number; i++){
			System.out.print("|" + horsesInRace[i] + spacesForNames[i] + "|" + (i + 1));
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
		
		while (!doneRace){
			System.out.println("");
			System.out.println("");
			System.out.println("");
			
			int[] runSteps = new int[horsesInRace.length];
			for (int i = 0; i < horsesInRace.length; i++){
				runSteps[i] = (int)(Math.random() * 5) + 1;
			}
			
			for (int i = 0; i < runSteps.length; i++){
				steps[i] += runSteps[i];
				if (steps[i] > 100){
					steps[i] = 100;
				}
			}
			
			for (int i = 0; i < spaces.length; i++){
				for (int j = 0; j <= runSteps.length; j++){
					spaces[i] += " ";
				}
			}
			
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			for (int i = 0; i < number; i++){
				System.out.print("|" + horsesInRace[i] + spacesForNames[i] + "|");

				for (int j = 0; j < steps[i]; j++){
					System.out.print(" ");
				}
				System.out.print(i + 1);
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}
			
			for (int i = 0; i < steps.length; i++){
				if (steps[i] >= raceTrack){
					System.out.println("\nRace finished! Horse #" + (i + 1) + " - " + horsesInRace[i] + " is the first place!");
					return i;
				}
			}
			
			Thread.sleep(1000);
			
		}
		
		return -1;
	}

	
	
	//	Method for getting the amount of bet of each player on each horse
	private static int[][] getBet(String[] playerNames, int[] playerWallets, String[] horsesInRace) {
		int[][] bet = new int[playerNames.length][horsesInRace.length];
		
		boolean choosePlayer = false;
		
		while (!choosePlayer){
			displayPlayers(playerNames, playerWallets);
			System.out.print("\nPlease choose a player: ");
			
			int playerIndex = choosePlayer(playerNames, playerWallets, horsesInRace);
			int amountOfBet = individualPlayerBet(bet, playerIndex, playerNames, playerWallets, horsesInRace);
			
			if (amountOfBet != 0){
				int horseIndex = ChooseHorse(playerIndex, horsesInRace, playerNames);
				bet[playerIndex][horseIndex] += amountOfBet;
				System.out.println(playerNames[playerIndex] + ", you have placed a bet of $" + bet[playerIndex][horseIndex] + " on horse " + horsesInRace[horseIndex] + ".");
			}
			choosePlayer = continueChosing();
		}
			 
		return bet;
	}

	
	
	// Method for user to choose another player or bet on another horse or start racing!
	private static boolean continueChosing() {
		System.out.println("What would you like to do? 1. Choose other player\t2.Start racing!");
		boolean correctInput = false;
		
		while(!correctInput){
			String input = KEYBOARD.nextLine();
			boolean ifInteger = CheckIfInteger(input);
			
			if(ifInteger){
				int x = Integer.parseInt(input);
				if(x == 2){
					return true;
				}else if(x == 1){
					return false;
				}else{
					System.out.print("Please enter a correct action:");
				}
			}else{
				if("Choose".equalsIgnoreCase(input) || "bet".equalsIgnoreCase(input) || "choose other player".equalsIgnoreCase(input)){
					return false;
				}else if("START".equalsIgnoreCase(input) || "start racing".equalsIgnoreCase(input) || "race!".equalsIgnoreCase(input)){
					return true;
				}else{
					System.out.print("Please enter a correct action:");
				}
			}
		}
		return false;
	}

	
	
	// Method for choosing a race horse to place bet on
	private static int ChooseHorse(int playerIndex, String[] horsesInRace, String[] playerNames) {
		System.out.println("\nWhich horse will you be betting on?");
		displayHorses(horsesInRace);
		int horseIndex = -1;
		
		System.out.print("\nPlease choose a horse from above: ");
		boolean choosingHorse = false;
		while(!choosingHorse){
			String input = KEYBOARD.nextLine();
			boolean ifInteger = CheckIfInteger(input);
			if (ifInteger){
				int x = Integer.parseInt(input);
				for (int i = 0; i < horsesInRace.length; i++){
					if (i == x - 1){
						horseIndex = i;
						return horseIndex;
					}
				}
			}else{
				for (int i = 0; i < horsesInRace.length; i++){
					if (horsesInRace[i].equalsIgnoreCase(input)){
						horseIndex = i;
						return horseIndex;
					}
				}
			}
			
			System.out.print("Please enter a correct horse from above: ");
		}
		
		return horseIndex;
	}

	
	
	// Method for displaying race horses
	private static void displayHorses(String[] horsesInRace) {
		System.out.println();
		System.out.println("#" + "|" + "    Horses Names    " + "|");
		for (int i = 0; i < horsesInRace.length; i++){
			System.out.printf("%1s%1s%20s%1s\n", "~", "|", "~~~~~~~~~~~~~~~~~~~~", "|");
			System.out.printf("%1s%1s%20s%1s\n", i + 1, "|", horsesInRace[i], "|");
		}
	}

	
	
	// Method for getting the amount of bet of one player
	private static int individualPlayerBet(int[][] bet, int playerIndex, String[] playerNames, int[] playerWallets, String[] horsesInRace) {

		System.out.print(playerNames[playerIndex] + ", you have $" + playerWallets[playerIndex] + ", how much would you want to bet? (Note: Any bet that is not a whole number will be converted to whole number) ");
		Double money = 0.0;
		int wallet = playerWallets[playerIndex];
		
		boolean betting = false;
		
		if (wallet == 0){
			System.out.println("You have $0! You cannot bet anymore!");
			return 0;
		}
		
		while(!betting){
			String userBet = KEYBOARD.nextLine();
			try{
				money = Double.parseDouble(userBet);
				betting = true;
			
			if(money > wallet){
				System.out.print("You don't have enough money! Enter new bet: ");
				betting = false;
			}else if(money < 1 && money > 0){
				System.out.print("You must bet a whole number amount of money! Enter new bet: ");
				betting = false;
			}else if(money == 0){
				System.out.print("You cannot bet nothing! Enter new bet: ");
				betting = false;
			}else if(money <= 0){
				System.out.print("You cannot bet a negative amount of money! Enter new bet: ");
				betting = false;
			}else{
				betting = true;
			}
			
			}catch(NumberFormatException ex){
				if ("Quit".equalsIgnoreCase(userBet)){
					money = 0.0;
					betting = true;
				}else{
					System.out.print("That is not a proper amount of money! Please enter a number you want to bet: ");
				}
			}
		}
		
		int moneyINT = money.intValue();
		playerWallets[playerIndex] -= moneyINT;
			
		return moneyINT;
	}

			
	
	// Method for choosing a player
	private static int choosePlayer(String[] playerNames, int[] playerWallets, String[] horsesInRace) {
		int playerIndex = -1;
		boolean checkingName = false;
		
		while(!checkingName){
			String nameEntered = KEYBOARD.nextLine();
			boolean ifInteger = CheckIfInteger(nameEntered);
			
			if (ifInteger){
				int x = Integer.parseInt(nameEntered);
				for (int i = 0; i < playerNames.length; i++){
					if (i == x - 1){
						playerIndex = i;
					}
				}
			}else{
				for (int i = 0; i < playerNames.length; i++){
					if (playerNames[i].equalsIgnoreCase(nameEntered)){
						playerIndex = i;
					}
				}
			}
			
			if (playerIndex == -1){
				System.out.print("Please enter a proper name in the list above: ");
			}else{
				checkingName = true;
			}
		}
		
		return playerIndex;
	}

	
	
	// Method for checking if an input is a string or an integer
	private static boolean CheckIfInteger(String s) {
		try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
		
	    return true;
	}

	
	
	//Method for displaying all players
	private static void displayPlayers(String[] playerNames, int[] playerWallets) {
		System.out.println();
		System.out.printf("%1s%1s%16s%1s%16s%1s\n", "#", "|", "  Player Names  ", "|", " Player Wallets ", "|");
		for(int i = 0; i <playerNames.length; i++){
			System.out.printf("%1s%1s%16s%1s%16s%1s\n", "~", "|", "~~~~~~~~~~~~~~~~", "|", "~~~~~~~~~~~~~~~~", "|");
			System.out.printf("%1s%1s%16s%1s%16s%1s\n", i + 1, "|", playerNames[i], "|", playerWallets[i], "|");
		}
		
	}

	
	
	//	Method for picking random number of horses for racing
	private static String[] getRaceHorses(String[] horses) {
		int x = (int)(Math.random() * 4) + 5;
		String[] raceHorses = new String[x];
		
		for (int i = 0; i < x; i++){
			boolean isHorseInRace = false;
			while (!isHorseInRace){
				int horseNum = (int)(Math.random() * horses.length);
				String theHorse = horses[horseNum];
				boolean inRace= alreadyInRace(theHorse, raceHorses);
				if (inRace == false){
					raceHorses[i] = theHorse;
					isHorseInRace = true;
				}
			}
		}
		
		return raceHorses;
	}
	
	
	// Method for testing if a horse is already picked to be in race
	private static boolean alreadyInRace(String theHorse, String[] raceHorses) {
		
		for (int i = 0; i < raceHorses.length; i++){
			if (theHorse.equalsIgnoreCase(raceHorses[i])){
				return true;
			}
		}
			
		return false;
	}

	
	
	// Method for getting the horses from file horseData.dat
	private static String[] getHorses() {
		String[] horses = null;
		
		try {
			Scanner scanner = new Scanner(new File("input/horseData.dat"));
			int numHorses = Integer.parseInt(scanner.nextLine());
			horses = new String[numHorses];
			
			for (int i = 0; i<numHorses; i++){
				horses[i] = scanner.nextLine();
			}
			
			scanner.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		 return horses;
	}

	
	
	// Method for getting the wallets of players from file playerData.dat
	private static int[] getWallet() {
		int[] wallet = null;
		
		try{
			Scanner scanner = new Scanner(new File("input/playerData.dat"));
			int numPlayers = Integer.parseInt(scanner.nextLine());
			wallet = new int[numPlayers];
			
			for (int i = 0; i < numPlayers; i++){
				String x = scanner.nextLine();
				String[] parts = x.split(" ");
				wallet[i] = Integer.parseInt(parts[1]);
			}
			
			scanner.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return wallet;
	}

	
	
	// Method for getting the names from file playerData.dat
	private static String[] getNames() {
		String[] names = null;
		
		try {
			Scanner scanner = new Scanner(new File("input/playerData.dat"));
			int numPlayers = Integer.parseInt(scanner.nextLine());
			names = new String[numPlayers];
			
			for (int i = 0; i < numPlayers; i++){
				String x = scanner.nextLine();
				String[] parts = x.split(" ");
				names[i] = parts[0];
			}
			
			scanner.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return names;
	}

	
	
	// Method for introduction of the game
	private static void introduction() throws InterruptedException {
		System.out.println("Welcome to House Racing!");
		Thread.sleep(1000);
		System.out.println("Program designed by Daniel Yan");
		Thread.sleep(1000);
		System.out.println("Have fun!!!");
		
	}

}
