package com.bayviewglen.HorseRacingAssignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Draft1 {

	public static void main(String[] args) throws InterruptedException {
		
		introduction();
		
		boolean done = false;
		while (!done){
		
			String[] playerNames = getNames();
			int[] playerWallet = getWallet();
			String[] horses = getHorses();
			String[] horsesInRace = getRaceHorses(horses);
			int[] playerBets = new int[playerNames.length];
			int[] horsesChosen = new int[playerNames.length];
			playerBets = getBet(playerNames, playerWallet, horsesInRace, horsesChosen);
			
			int winHorse = race(horsesInRace);
		
		}
	}
	
	
	private static int race(String[] horsesInRace) {
		boolean doneRace = false;
		int number = horsesInRace.length;
		int[] numberCount = new int[horsesInRace.length];
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for(int i = 0; i < number; i++){
			System.out.printf("%20s%1s%100s", horsesInRace[i], "|", i + 1);
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
		
		while (!doneRace){
			int[] horseSteps = new int[number];
			
			for (int i = 0; i < number; i++){
				horseSteps[i] = (int)(Math.random()*5) + 1;
			}
			
			for (int i = 0; i < number; i++){
				numberCount[i] += horseSteps[i];
				
				String[] space = new String[horsesInRace.length];
				for (int j = 0; j < number; j++){
					for (int g = 0; g < numberCount[g]; g++){
						space[g] += " ";
					}
				}
				
				System.out.printf("%20s%1s%100s", horsesInRace[i], "|", space[i] + (i + 1));
			}
			
			for (int i = 0; i < number; i++){
				if (numberCount[i] >= 99){
					return i;
				}
			}
			
		}
		
		return -1;
	}


	private static int[] getBet(String[] playerNames, int[] playerWallet, String[] horsesInRace, int[] horsesChosen) {
			
		Scanner keyboard = new Scanner(System.in);
		
		int[] bet = new int[playerNames.length];
		
		boolean choosePlayer = false;
		
		
		while (!choosePlayer){
			displayPlayers(playerNames, playerWallet);
			System.out.print("\nPlease choose a player: ");
			
			int playerIndex = choosePlayer(playerNames, playerWallet, horsesInRace, keyboard);
			individualPlayerBet(bet, playerIndex, playerNames, playerWallet, horsesInRace, keyboard);
			if (bet[playerIndex] != 0){
				horsesChosen = ChooseHorse(playerIndex, horsesInRace, keyboard, playerNames);
				System.out.println(playerNames[playerIndex] + ", you have placed a bet of $" + bet[playerIndex] + " on horse " + horsesInRace[horsesChosen[playerIndex]] + ".");
			}
			choosePlayer = continueChosing(keyboard);
		}
			 
		return bet;
	}


	private static int[] ChooseHorse(int playerIndex, String[] horsesInRace, Scanner keyboard, String[] playerNames) {
		System.out.println("\nWhich horse will you be betting on?");
		displayHorses(horsesInRace);
		int[] arr = new int[playerNames.length];
		
		for (int i = 0; i < arr.length; i++){
			arr[i] = -1;
		}
		
		System.out.print("\nPlease choose a horse from above: ");
		String input = keyboard.nextLine();
		boolean ifInteger = CheckIfInteger(input);
		if (ifInteger){
			int x = Integer.parseInt(input);
			for (int i = 0; i < horsesInRace.length; i++){
				if (i == x - 1){
					arr[playerIndex] = i;
				}
			}
		}else{
			for (int i = 0; i < horsesInRace.length; i++){
				if (horsesInRace[i].equals(input)){
					arr[playerIndex] = i;
				}
			}
		}
		
		return arr;
	}


	private static void displayHorses(String[] horsesInRace) {
		System.out.println();
		System.out.println("#" + "|" + "    Horses Names    " + "|");
		for (int i = 0; i < horsesInRace.length; i++){
			System.out.printf("%1s%1s%20s%1s\n", "~", "|", "~~~~~~~~~~~~~~~~~~~~", "|");
			System.out.printf("%1s%1s%20s%1s\n", i + 1, "|", horsesInRace[i], "|");
		}
	}


	private static int choosePlayer(String[] playerNames, int[] playerWallet,
			String[] horsesInRace, Scanner keyboard) {
		int playerIndex = -1;
		boolean checkingName = false;
		
		while(!checkingName){
			String nameEntered = keyboard.nextLine();
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


	private static boolean CheckIfInteger(String nameEntered) {
		try { 
	        Integer.parseInt(nameEntered); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    return true;
		
	}


	private static void individualPlayerBet(int[] playerBets, int playerIndex,
			String[] playerNames, int[] playerWallet, String[] horsesInRace, Scanner keyboard) {
		System.out.print(playerNames[playerIndex] + ", you have $" + playerWallet[playerIndex] + ", how much would you want to bet? (Note: Any bet that is not a whole number will be converted to whole number) ");
		boolean betting = false;
		Double money = 0.0;
		int wallet = playerWallet[playerIndex];
		
		if (wallet == 0){
			playerBets[playerIndex] = -1;
		}
		
		while(!betting){
			String userBet = keyboard.nextLine();
			try{
				money =Double.parseDouble(userBet);
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
		playerWallet[playerIndex] -= moneyINT;
		playerBets[playerIndex] = moneyINT;
	}
		
		


	private static boolean continueChosing(Scanner keyboard) {
		System.out.println("What would you like to do? 1. Choose other player\t2.Start racing!");
		boolean correctInput = false;
		
		while(!correctInput){
			String input = keyboard.nextLine();
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
				if("Choose".equalsIgnoreCase(input) || "bet".equalsIgnoreCase(input)){
					return true;
				}else if("START".equalsIgnoreCase(input) || "start racing".equalsIgnoreCase(input)){
					return false;
				}else{
					System.out.print("Please enter a correct action:");
				}
			}
		}
		return false;
	}



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


	private static void displayPlayers(String[] names, int[] wallets) {
		System.out.println();
		System.out.printf("%1s%1s%16s%1s%16s%1s\n", "#", "|", "  Player Names  ", "|", " Player Wallets ", "|");
		for(int i = 0; i < names.length; i++){
			System.out.printf("%1s%1s%16s%1s%16s%1s\n", "~", "|", "~~~~~~~~~~~~~~~~", "|", "~~~~~~~~~~~~~~~~", "|");
			System.out.printf("%1s%1s%16s%1s%16s%1s\n", i + 1, "|", names[i], "|", wallets[i], "|");
		}
		
	}


	private static int[] getWallet() {
		int[] wallet = null;
		try{
			Scanner keyboard = new Scanner(new File("input/playerData.dat"));
			int numPlayers = Integer.parseInt(keyboard.nextLine());
			wallet = new int[numPlayers];
			
			for (int i = 0; i < numPlayers; i++){
				String x = keyboard.nextLine();
				String[] parts = x.split(" ");
				wallet[i] = Integer.parseInt(parts[1]);
			}
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return wallet;
	}


	private static String[] getNames() {
		String[] names = null;
		try {
			Scanner keyboard = new Scanner(new File("input/playerData.dat"));
			int numPlayers = Integer.parseInt(keyboard.nextLine());
			names = new String[numPlayers];
			
			for (int i = 0; i < numPlayers; i++){
				String x = keyboard.nextLine();
				String[] parts = x.split(" ");
				names[i] = parts[0];
			}
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return names;
	}


	private static void introduction() throws InterruptedException {
		System.out.println("Welcome to House Racing!");
		Thread.sleep(1000);
		System.out.println("Program designed by Daniel Yan");
		Thread.sleep(1000);
		System.out.println("Have fun!!!");
	}


	// Reads the horses from a file assume the file exists and is in the format specified in the assignment
	public static String[] getHorses(){
		String[] horses = null;
		try {
			Scanner scanner = new Scanner(new File("input/horseData.dat"));
			int numHorses = Integer.parseInt(scanner.nextLine());
			horses = new String[numHorses];
			
			for (int i = 0; i<numHorses; i++){
				horses[i] = scanner.nextLine();
			}
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		 return horses;
	}
	
	/* 
	 * Check if a horse is already in the race - uses a modified search method
	 */
	public static boolean alreadyInRace(String horse, String[] horsesInRace){
		
		for (int i = 0; i < horsesInRace.length; i++){
			if (horse.equalsIgnoreCase(horsesInRace[i])){
				return true;
			}
		}
			
		return false;
	}

	

}
