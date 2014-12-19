package com.bayviewglen.assignment;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class BlackJack {

	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		
		introduction();	//method of displaying intro messages
		
		String userName = getUserName(scanner);	//method for getting user name (AND PREVENTING JUSTIN TO PLAY THE GAME)
		
		//while loop to make sure that the game quits when name is quit
		while(!userName.equalsIgnoreCase("quit")){
			int wallet = 500;
			boolean done = false;
			NumberFormat formatter = getFormatter(scanner);	// method of returning a formatter for money
			 
			
			while(!done){
				
				wallet = playGame(scanner, wallet, formatter);	//method of the actual game, updates wallet after game
				
				if(wallet == 0){
					System.out.println("You don't have any more money!");	
				}
				done = (wallet == 0 || playAgain(scanner));	//game ends if no more money or choose to not play anymore
			}


			userName = getUserName(scanner);	//method for getting user name within the game loop, making playing game again possible
		}


		closingMessage();	//method of displaying ending 
		scanner.close();

	}

	private static void closingMessage() throws InterruptedException {
		System.out.println("Thank you for playing!");
		Thread.sleep(1000);	//Wait a second then display next message
		System.out.println("Have a nice day!");
		
	}

	private static boolean playAgain(Scanner scanner) {
		boolean play = false;
		System.out.print("Would you like to play another round? ");	//Ask user if they still want to play
		
		while(!play){		
		String a = scanner.nextLine();
		
		//LOTS OF POSSIBLE OPTION OF CONTINUE THE GAME
		if(a.equalsIgnoreCase("Sure") || a.equalsIgnoreCase("Yes") || a.equalsIgnoreCase("ok") || a.equalsIgnoreCase("Go ahead") || a.equalsIgnoreCase("Y")){
			return false;
			
		//LOTS OF POSSIBLE OPTION OF NOT CONTINUE THE GAME
		}else if(a.equalsIgnoreCase("N") || a.equalsIgnoreCase("NO") || a.equalsIgnoreCase("Hell no") || a.equalsIgnoreCase("quit")){
			return true;
			
		//Get user to choose option again if the previous command is not understandable
		}else{
			System.out.print("Please enter a proper response: ");
		}
		}
		return play;
	}

	private static int playGame(Scanner scanner, int wallet,NumberFormat formatter) {
		int bet = getBet(wallet, formatter, scanner);
		int playerNumOfAce = 0;
		int dealerNumOfAce = 0;
		
		System.out.println("<><><><><><><><><><><><><><>GAME START<><><><><><><><><><><><><><>");
			
		//initialize the two cards that the user suppose to get
		String PC1D = getCardDisplay();	//PC1D = PlayerCard1Display
		int PC1V = getCardValue(PC1D);	//PC1V = PlayerCard1Value
		String PC1S = getCardSuit();	//PC1S = PlayerCard1Suit
		String PC2D = getCardDisplay();
		int PC2V = getCardValue(PC2D);
		String PC2S = getCardSuit();
		String playerDisplay = PC1D + PC1S + "\t" + PC2D + PC2S + "\t";
		int playerPoints = PC1V + PC2V;
		if(PC1D.equals("A"))
			playerNumOfAce += 1;
		if(PC2D.equals("A"))
			playerNumOfAce += 1;
		
		//initialize the two cards that the dealer suppose to get	
		String DC1D = getCardDisplay();	//DC1D = DealerCard1Display
		int DC1V  = getCardValue(DC1D);	//DC1V = DealerCard1Value
		String DC1S = getCardSuit();	//DC1S = DealerCard1Suit
		String DC2D = getCardDisplay();
		int DC2V  = getCardValue(DC2D);
		String DC2S = getCardSuit();
		String dealerDisplay = DC1D + DC1S + "\t" + DC2D + DC2S + "\t";
		int dealerPoints = DC1V + DC2V;
		if(DC1D.equals("A"))
			dealerNumOfAce += 1;
		if(DC2D.equals("A"))
			dealerNumOfAce += 1;
		
			
		//display the two cards				
		System.out.println("Dealer:\t" + DC1D + DC1S + "\t" + "XX");
		System.out.println("Player:\t" + playerDisplay);
		System.out.println("<><><><><><><><><><><><><><><>PLAYING<><><><><><><><><><><><><><><>");
			
		//if player wins immediately
		if(calculateScore(playerPoints, playerNumOfAce) == 21){
			System.out.println("Dealer:\t" + dealerDisplay + " === " + calculateScore(dealerPoints, dealerNumOfAce));
			System.out.println("Player:\t" + playerDisplay + " === " + calculateScore(playerPoints, playerNumOfAce));
			System.out.println("<><><><><><><><><><><><><><><>RESULT<><><><><><><><><><><><><><><>");
			System.out.println("Congratulations! You win!");
			wallet += bet;
			return wallet;
		}
		
		//if player did not win immediately
		boolean playerDone = false;
		while(calculateScore(playerPoints, playerNumOfAce) < 21 && !playerDone){
			int action = 0;
			
			//player command with double down option available
			if(2 * bet <= wallet){
				System.out.print("What do you want to do? 1.Hit   2.Stay   3.Double Down ");
				
				boolean properResponse = false;
				while(!properResponse){		
					String playerAction = scanner.nextLine();
					if(playerAction.equalsIgnoreCase("Hit") || playerAction.equals("1")){
						action = 1;
						properResponse = true;
					}else if(playerAction.equalsIgnoreCase("Stay") || playerAction.equals("2")){
						action = 2;
						properResponse = true;
					}else if(playerAction.equalsIgnoreCase("Double Down") || playerAction.equals("3")){
						action = 3;
						properResponse = true;
					}else{
						System.out.print("Please enter a proper response: ");
					}
				
				//consequence of player's command
				if(action == 1){
					String playerNextCardDisplay = getCardDisplay();
					String playerNextCardSuit = getCardSuit();
					int nextCardValue = getCardValue(playerNextCardDisplay);
					String playerNextCard = playerNextCardDisplay + playerNextCardSuit + "\t";
					
					if(playerNextCardDisplay == "A"){
						playerNumOfAce += 1;
					}
					playerPoints += nextCardValue;
					playerDisplay = playerDisplay + playerNextCard;
					
					System.out.println("");
					System.out.println("Dealer:\t" + DC1D + DC1S + "\t" + "XX");
					System.out.println("Player:\t" + playerDisplay);
										
				}else if(action == 3){
					String playerNextCardDisplay = getCardDisplay();
					String playerNextCardSuit = getCardSuit();
					int nextCardValue = getCardValue(playerNextCardDisplay);
					String playerNextCard = playerNextCardDisplay + playerNextCardSuit + "\t";
					
					if(playerNextCardDisplay == "A"){
						playerNumOfAce += 1;
					}
					playerPoints += nextCardValue;
					playerDisplay = playerDisplay + playerNextCard;
					bet *= 2;
					
					System.out.println("");
					System.out.println("Dealer:\t" + DC1D + DC1S + "\t" + "XX");
					System.out.println("Player:\t" + playerDisplay);
					
					playerDone = true;
					
				}else if(action == 2){
					playerDone = true;
					
				}else{
					properResponse = false;
				}
				
				
				
				
				
				}
			
			//player command without double down option
			}else{
				System.out.print("What do you want to do? 1.Hit   2. Stay");
								
				boolean properResponse = false;
				while(!properResponse){		
					String playerAction = scanner.nextLine();
					if(playerAction.equalsIgnoreCase("Hit") || playerAction.equals("1")){
						action = 1;
						properResponse = true;
					}else if(playerAction.equalsIgnoreCase("Stay") || playerAction.equals("2")){
						action = 2;
						properResponse = true;
					}else{
						System.out.print("Please enter a proper response: ");
					}
				
				}
				
				//consequences of player's command
				if(action == 1){
					String playerNextCardDisplay = getCardDisplay();
					String playerNextCardSuit = getCardSuit();
					int nextCardValue = getCardValue(playerNextCardDisplay);
					String playerNextCard = playerNextCardDisplay + playerNextCardSuit + "\t";
					
					if(playerNextCardDisplay == "A"){
						playerNumOfAce += 1;
					}
					playerPoints += nextCardValue; 
					playerDisplay = playerDisplay + playerNextCard;
					
					System.out.println("");
					System.out.println("Dealer:\t" + DC1D + DC1S + "\t" + "XX");
					System.out.println("Player:\t" + playerDisplay);
					
					
				}else if(action == 2){
					playerDone = true;
				}
			}
		
		//calculate if player immediately win after getting cards or get busted
		if(calculateScore(playerPoints, playerNumOfAce) > 21){
			System.out.println("<><><><><><><><><><><><><><><>RESULT<><><><><><><><><><><><><><><>");
			System.out.println("Dealer:\t" + dealerDisplay + " === " + calculateScore(dealerPoints, dealerNumOfAce));
			System.out.println("Player:\t" + playerDisplay + " === " + calculateScore(playerPoints, playerNumOfAce));
			System.out.println("You have busted!");
			System.out.println("");
			wallet -= bet;
			return wallet;
			
			
		}else if(calculateScore(playerPoints, playerNumOfAce) == 21){
			System.out.println("<><><><><><><><><><><><><><><>RESULT<><><><><><><><><><><><><><><>");
			System.out.println("Dealer:\t" + dealerDisplay + " === " + calculateScore(dealerPoints, dealerNumOfAce));
			System.out.println("Player:\t" + playerDisplay + " === " + calculateScore(playerPoints, playerNumOfAce));
			System.out.println("Congratulations! You win!");
			System.out.println("");
			wallet += bet;
			return wallet;
		}
			
			
			
		}
		
		//dealer starts playing		
		if(calculateScore(dealerPoints, dealerNumOfAce) != 21){
			
			if(calculateScore(dealerPoints, dealerNumOfAce) >= 17){
				
			}else{
				System.out.println("<><><><><><><><><><><><><>DEALER PLAYING<><><><><><><><><><><><><>");
			
				//if dealer has points less than 17, dealer will draw another card
				while(dealerPoints < 17){
			
				String dealerNextCardDisplay = getCardDisplay();
				String dealerNextCardSuit = getCardSuit();
				int nextCardValue = getCardValue(dealerNextCardDisplay);
				String dealerNextCard = dealerNextCardDisplay + dealerNextCardSuit + "\t";
				
				if(dealerNextCardDisplay == "A"){
					dealerNumOfAce += 1;
				}
				dealerPoints += nextCardValue;
				dealerDisplay = dealerDisplay + dealerNextCard;
			
				System.out.println("");
				System.out.println("Dealer:\t" + dealerDisplay);
				System.out.println("Player:\t" + playerDisplay);
			
			}
			}
		
		//final calculation if player wins or dealer wins
		if(calculateScore(dealerPoints, dealerNumOfAce) == 21){
			System.out.println("<><><><><><><><><><><><><><><>RESULT<><><><><><><><><><><><><><><>");
			System.out.println("Dealer:\t" + dealerDisplay + " === " + calculateScore(dealerPoints, dealerNumOfAce));
			System.out.println("Player:\t" + playerDisplay + " === " + calculateScore(playerPoints, playerNumOfAce));
			System.out.println("Dealer wins! You lost!");
			System.out.println("");
			wallet -= bet;
		
		}else if(calculateScore(dealerPoints, dealerNumOfAce) > 21){
			System.out.println("<><><><><><><><><><><><><><><>RESULT<><><><><><><><><><><><><><><>");
			System.out.println("Dealer:\t" + dealerDisplay + " === " + calculateScore(dealerPoints, dealerNumOfAce));
			System.out.println("Player:\t" + playerDisplay + " === " + calculateScore(playerPoints, playerNumOfAce));
			System.out.println("Dealer busted! You win!");
			System.out.println("");
			wallet += bet;
		
		}else if(calculateScore(dealerPoints, dealerNumOfAce) > calculateScore(playerPoints, playerNumOfAce)){
			System.out.println("<><><><><><><><><><><><><><><>RESULT<><><><><><><><><><><><><><><>");
			System.out.println("Dealer:\t" + dealerDisplay + " === " + calculateScore(dealerPoints, dealerNumOfAce));
			System.out.println("Player:\t" + playerDisplay + " === " + calculateScore(playerPoints, playerNumOfAce));
			System.out.println("Dealer wins! You lost!");
			System.out.println("");
			wallet -= bet;
			
		}else if(calculateScore(dealerPoints, dealerNumOfAce) < calculateScore(playerPoints, playerNumOfAce)){
			System.out.println("<><><><><><><><><><><><><><><>RESULT<><><><><><><><><><><><><><><>");
			System.out.println("Dealer:\t" + dealerDisplay + " === " + calculateScore(dealerPoints, dealerNumOfAce));
			System.out.println("Player:\t" + playerDisplay + " === " + calculateScore(playerPoints, playerNumOfAce));
			System.out.println("Congratulations! You win!");
			System.out.println("");
			wallet += bet;
			
		}else if(calculateScore(dealerPoints, dealerNumOfAce) == calculateScore(playerPoints, playerNumOfAce)){
			System.out.println("<><><><><><><><><><><><><><><>RESULT<><><><><><><><><><><><><><><>");
			System.out.println("Dealer:\t" + dealerDisplay + " === " + calculateScore(dealerPoints, dealerNumOfAce));
			System.out.println("Player:\t" + playerDisplay + " === " + calculateScore(playerPoints, playerNumOfAce));
			System.out.println("You went even as the Dealer!");
			System.out.println("");
		}
		}else{
			System.out.println("Waaaat happened here????");
			System.out.println("Dealer:\t" + dealerDisplay + " === " + calculateScore(dealerPoints, dealerNumOfAce));
			System.out.println("Player:\t" + playerDisplay + " === " + calculateScore(playerPoints, playerNumOfAce));
			System.err.println("Something went wrong :/");
			return wallet;
		}
			
		
		return wallet;
	}

	//method for calculating points from Mr.DesLauriers
	private static int calculateScore(int currentTotal, int numAces) {
		int score = currentTotal;
		
		for (int i=0; i<numAces; ++i){
			if (score + 10 <= 21)
				score += 10;
		}
		
		return score;
	}
	

	//method for getting suit of card
	private static String getCardSuit() {
		int playerCardKind = (int)(Math.random()*4) + 1;
		String playerCardSuit = "";
		if(playerCardKind == 1){
			playerCardSuit = "S";
		}else if(playerCardKind == 2){
			playerCardSuit = "C";
		}else if(playerCardKind == 3){
			playerCardSuit = "H";
		}else{
			playerCardSuit = "D";
		}
		return playerCardSuit;
	}

	//method of getting card value
	private static int getCardValue(String display) {
		int CardValue = 0;
		if(display.equals("A")){
			CardValue = 1;
		}else if(display.equals("J") || display.equals("Q") || display.equals("K")){
			CardValue = 10;
		}else{
			CardValue = Integer.parseInt(display);
		}
		return CardValue;
	}

	//method of the appropriate display of cards
	private static String getCardDisplay() {
		int CardValue = (int)(Math.random()*13) + 1;
		String CardDisplay = "";
		if(CardValue == 1){
			CardDisplay = "A";
		}else if(CardValue == 11){
			CardDisplay = "J";
		}else if(CardValue == 12){
			CardDisplay = "Q";
		}else if(CardValue == 13){
			CardDisplay = "K";
		}else{
			CardDisplay = Integer.toString(CardValue);
		}
		return CardDisplay;
	}

	//method for getting bet amount
	private static int getBet(int wallet, NumberFormat formatter, Scanner scanner) {
		String bank = formatter.format(wallet);
		System.out.print("\nYou have " + bank + ". Please enter the amount you want to bet: ");
		boolean betting = false;
		int money = 0;
		while(!betting){
			String Userbet = scanner.nextLine();
			try{
				money = Integer.parseInt(Userbet);
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
				System.out.print("That is not a proper amount of money! Please enter a number you want to bet: ");
				betting = false;
			}
		}
		int moneyINT = (int)money;
		return moneyINT;
	}

	//method for getting number formatter from a location
	private static NumberFormat getFormatter(Scanner scanner) {
		
		return NumberFormat.getCurrencyInstance(getLocale(scanner));
	}

	//method of getting locale
	private static Locale getLocale(Scanner scanner) {
		boolean location = false;
		System.out.println("Please select your location from the list below: ");
		System.out.println("1. Canada");
		System.out.println("2. French Canada");
		System.out.println("3. United States");
		System.out.println("4. China");
		System.out.println("5. Great Britain");
		System.out.println("6. France");
		System.out.println("7. Italy");
		
		int locNumber = 0;
		while(!location){
			System.out.print("Please enter a location number from above: ");
			String n = scanner.nextLine();
			try{
				locNumber = Integer.parseInt(n);
			}catch(Exception ex){
				
			}
			
			if(locNumber >= 1 && locNumber <= 7){
				location = true;
			}
	
		}
			
			if(locNumber == 1){
				System.out.println("\nYou have selected the location: Canada");
				return Locale.CANADA;
			}else if(locNumber == 2){				
				System.out.println("\nYou have selected the location: Canada, French Region");
				return Locale.CANADA_FRENCH;
			}else if(locNumber == 3){				
				System.out.println("\nYou have selected the location: United States");
				return Locale.US;
			}else if(locNumber == 4){				
				System.out.println("\nYou have selected the location: China");
				return Locale.CHINA;
			}else if(locNumber == 5){				
				System.out.println("\nYou have selected the location: United Kingdom");
				return Locale.UK;
			}else if(locNumber == 6){				
				System.out.println("\nYou have selected the location: France");
				return Locale.FRANCE;
			}else if(locNumber == 7){				
				System.out.println("\nYou have selected the location: Italy");
				return Locale.ITALY;
			}
		
		return null;
	}

	//method of getting username and prevent Justin to play my game
	private static String getUserName(Scanner scanner) {
		System.out.print("Please enter your name: ");
		String username = scanner.nextLine();
		if (username.startsWith("jus") || username.startsWith("Jus")){
			System.out.println("You cannot play!!!!");
			System.exit(1);
		}
		
		return username;
	}

	//Beginning messages
	private static void introduction() throws InterruptedException {
		System.out.println("Welcome to BlackJack!");
		Thread.sleep(1000);
		System.out.println("Program designed by: Daniel Yan");
		Thread.sleep(1000);
		System.out.println("Have fun!");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
	}

}
