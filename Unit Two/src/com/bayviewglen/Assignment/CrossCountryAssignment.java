/*
 * Name: Daniel Yan
 * Course: ICS3U
 * Title: Cross Country Assignment
 * Description: Unit 2 Assignment that prompt the user for names and cross-country times and calculates. Then display information in a table.
 * Due Date: October 31, 2014
 * Teacher: Mr.DesLauriers
 */

package com.bayviewglen.Assignment;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CrossCountryAssignment {
	
	final static int SECONDS_IN_MIN = 60;

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in); //Added scanner
		
		// Person a (Runner One)
		// Getting Person a Name
		System.out.print("Please enter your first and last name: ");
		String aFirst = keyboard.next();
		String aLast = keyboard.next();
		
		// Getting Person a mile one time
		System.out.print(aFirst + ", please enter your Mile One Time <mm:ss.sss>: ");
		String aMileOne = keyboard.next();
		String aMileOneMinutes = aMileOne.split(":")[0];
		int aMOMinutes = Integer.parseInt(aMileOneMinutes);
		String aMileOneSeconds = aMileOne.split(":")[1];
		double aMOSeconds = Double.parseDouble(aMileOneSeconds);
		double aMOTotalSeconds = aMOMinutes * SECONDS_IN_MIN + aMOSeconds;
		
		// Getting Person a time towards the end of mile two
		System.out.print(aFirst + ", please enter your time to the end of the second mile <mm:ss.sss>: ");
		String aMileTwo = keyboard.next();
		String aMileTwoMinutes = aMileTwo.split(":")[0];
		int aMTMinutes = Integer.parseInt(aMileTwoMinutes);
		String aMileTwoSeconds = aMileTwo.split(":")[1];
		double aMTSeconds = Double.parseDouble(aMileTwoSeconds);
		double aMTTotalSeconds = aMTMinutes * SECONDS_IN_MIN + aMTSeconds;
		
		// Getting Person a total time
		System.out.print(aFirst + ", please enter your time to the end of the 5 km <mm:ss.sss>: ");
		String aTotal = keyboard.next();
		String aTotalMinutes = aTotal.split(":")[0];
		int aTMinutes = Integer.parseInt(aTotalMinutes);
		String aTotalSeconds = aTotal.split(":")[1];
		double aTSeconds = Double.parseDouble(aTotalSeconds);
		double aTTotalSeconds = aTMinutes * SECONDS_IN_MIN + aTSeconds;
		
		// Calculating Person a Split Two and Split Three time
		double aSplitTwo = aMTTotalSeconds - aMOTotalSeconds;
		double aSplitThree = aTTotalSeconds - aMTTotalSeconds;
		
		// Formating answer to get ready to display
		DecimalFormat formatter = new DecimalFormat("00.000");
		int aSplitOneMinutes = aMOMinutes;
		String aSplitOneSeconds = formatter.format(aMOSeconds);
		int aSplitTwoMinutes = (int)(aSplitTwo) / SECONDS_IN_MIN;
		String aSplitTwoSeconds = formatter.format((aSplitTwo) % SECONDS_IN_MIN);
		int aSplitThreeMinutes = (int)(aSplitThree) / SECONDS_IN_MIN;
		String aSplitThreeSeconds = formatter.format((aSplitThree) % SECONDS_IN_MIN);
		String a5k = formatter.format(aTSeconds);
		
		// Finalizing values to display
		String aFinalSO = (aSplitOneMinutes + ":" + aSplitOneSeconds);
		String aFinalST = (aSplitTwoMinutes + ":" + aSplitTwoSeconds);
		String aFinalSTH = (aSplitThreeMinutes + ":" + aSplitThreeSeconds);
		String aFinal5k = (aTMinutes + ":" + a5k);
		
		// Displaying the summary for Person a (Runner One)
		System.out.println("\nRunner One Summary" + "\n******************");
		System.out.println("\nRunner: " + aLast + ", " + aFirst);
		System.out.println("Split One: " + aFinalSO);
		System.out.println("Split Two: " + aFinalST);
		System.out.println("Split Three: " + aFinalSTH);
		System.out.println("Total: " + aFinal5k);

		// Person b (Runner Two)
		// Getting Person b Name
		System.out.print("\nPlease enter your first and last name: ");
		String bFirst = keyboard.next();
		String bLast = keyboard.next();
		
		// Getting Person b mile one time
		System.out.print(bFirst + ", please enter your Mile One Time <mm:ss.sss>: ");
		String bMileOne = keyboard.next();
		String bMileOneMinutes = bMileOne.split(":")[0];
		int bMOMinutes = Integer.parseInt(bMileOneMinutes);
		String bMileOneSeconds = bMileOne.split(":")[1];
		double bMOSeconds = Double.parseDouble(bMileOneSeconds);
		double bMOTotalSeconds = bMOMinutes * SECONDS_IN_MIN + bMOSeconds;
		
		// Getting Person b time towards the end of mile two
		System.out.print(bFirst + ", please enter your time to the end of the second mile <mm:ss.sss>: ");
		String bMileTwo = keyboard.next();
		String bMileTwoMinutes = bMileTwo.split(":")[0];
		int bMTMinutes = Integer.parseInt(bMileTwoMinutes);
		String bMileTwoSeconds = bMileTwo.split(":")[1];
		double bMTSeconds = Double.parseDouble(bMileTwoSeconds);
		double bMTTotalSeconds = bMTMinutes * SECONDS_IN_MIN + bMTSeconds;
		
		// Getting Person b total time
		System.out.print(bFirst + ", please enter your time to the end of the 5 km <mm:ss.sss>: ");
		String bTotal = keyboard.next();
		String bTotalMinutes = bTotal.split(":")[0];
		int bTMinutes = Integer.parseInt(bTotalMinutes);
		String bTotalSeconds = bTotal.split(":")[1];
		double bTSeconds = Double.parseDouble(bTotalSeconds);
		double bTTotalSeconds = bTMinutes * SECONDS_IN_MIN + bTSeconds;
		
		// Calculating Person b Split Two and Split Three time
		double bSplitTwo = bMTTotalSeconds - bMOTotalSeconds;
		double bSplitThree = bTTotalSeconds - bMTTotalSeconds;
		
		// Formating answer to get ready to display
		int bSplitOneMinutes = bMOMinutes;
		String bSplitOneSeconds = formatter.format(bMOSeconds);
		int bSplitTwoMinutes = (int)(bSplitTwo) / SECONDS_IN_MIN;
		String bSplitTwoSeconds = formatter.format((bSplitTwo) % SECONDS_IN_MIN);
		int bSplitThreeMinutes = (int)(bSplitThree) / SECONDS_IN_MIN;
		String bSplitThreeSeconds = formatter.format((bSplitThree) % SECONDS_IN_MIN);
		String b5k = formatter.format(bTSeconds);
		
		// Finalizing values to display
		String bFinalSO = (bSplitOneMinutes + ":" + bSplitOneSeconds);
		String bFinalST = (bSplitTwoMinutes + ":" + bSplitTwoSeconds);
		String bFinalSTH = (bSplitThreeMinutes + ":" + bSplitThreeSeconds);
		String bFinal5k = (bTMinutes + ":" + b5k);
		
		// Displaying the summary for Person b (Runner Two)
		System.out.println("\nRunner Two Summary" + "\n******************");
		System.out.println("\nRunner: " + bLast + ", " + bFirst);
		System.out.println("Split One: " + bFinalSO);
		System.out.println("Split Two: " + bFinalST);
		System.out.println("Split Three: " + bFinalSTH);
		System.out.println("Total: " + bFinal5k);
		
		// Person c (Runner Three)
		// Getting Person c Name
		System.out.print("\nPlease enter your first and last name: ");
		String cFirst = keyboard.next();
		String cLast = keyboard.next();
		
		// Getting Person c mile one time
		System.out.print(cFirst + ", please enter your Mile One Time <mm:ss.sss>: ");
		String cMileOne = keyboard.next();
		String cMileOneMinutes = cMileOne.split(":")[0];
		int cMOMinutes = Integer.parseInt(cMileOneMinutes);
		String cMileOneSeconds = cMileOne.split(":")[1];
		double cMOSeconds = Double.parseDouble(cMileOneSeconds);
		double cMOTotalSeconds = cMOMinutes * SECONDS_IN_MIN + cMOSeconds;
		
		// Getting Person c time towards the end of mile two
		System.out.print(cFirst + ", please enter your time to the end of the second mile <mm:ss.sss>: ");
		String cMileTwo = keyboard.next();
		String cMileTwoMinutes = cMileTwo.split(":")[0];
		int cMTMinutes = Integer.parseInt(cMileTwoMinutes);
		String cMileTwoSeconds = cMileTwo.split(":")[1];
		double cMTSeconds = Double.parseDouble(cMileTwoSeconds);
		double cMTTotalSeconds = cMTMinutes * SECONDS_IN_MIN + cMTSeconds;
		
		// Getting Person c total time
		System.out.print(cFirst + ", please enter your time to the end of the 5 km <mm:ss.sss>: ");
		String cTotal = keyboard.next();
		String cTotalMinutes = cTotal.split(":")[0];
		int cTMinutes = Integer.parseInt(cTotalMinutes);
		String cTotalSeconds = cTotal.split(":")[1];
		double cTSeconds = Double.parseDouble(cTotalSeconds);
		double cTTotalSeconds = cTMinutes * SECONDS_IN_MIN + cTSeconds;
		
		// Calculating Person c Split Two and Split Three time
		double cSplitTwo = cMTTotalSeconds - cMOTotalSeconds;
		double cSplitThree = cTTotalSeconds - cMTTotalSeconds;
		
		// Formating answer to get ready to display
		int cSplitOneMinutes = cMOMinutes;
		String cSplitOneSeconds = formatter.format(cMOSeconds);
		int cSplitTwoMinutes = (int)(cSplitTwo) / SECONDS_IN_MIN;
		String cSplitTwoSeconds = formatter.format((cSplitTwo) % SECONDS_IN_MIN);
		int cSplitThreeMinutes = (int)(cSplitThree) / SECONDS_IN_MIN;
		String cSplitThreeSeconds = formatter.format((cSplitThree) % SECONDS_IN_MIN);
		String c5k = formatter.format(cTSeconds);
		
		// Finalizing values to display
		String cFinalSO = (cSplitOneMinutes + ":" + cSplitOneSeconds);
		String cFinalST = (cSplitTwoMinutes + ":" + cSplitTwoSeconds);
		String cFinalSTH = (cSplitThreeMinutes + ":" + cSplitThreeSeconds);
		String cFinal5k = (cTMinutes + ":" + c5k);
		
		// Displaying the summary for Person c (Runner Three)
		System.out.println("\nRunner Three Summary" + "\n******************");
		System.out.println("\nRunner: " + cLast + ", " + cFirst);
		System.out.println("Split One: " + cFinalSO);
		System.out.println("Split Two: " + cFinalST);
		System.out.println("Split Three: " + cFinalSTH);
		System.out.println("Total: " + cFinal5k);
			
		// Person d (Runner Four)
		// Getting Person d Name
		System.out.print("\nPlease enter your first and last name: ");
		String dFirst = keyboard.next();
		String dLast = keyboard.next();
		
		// Getting Person d mile one time
		System.out.print(dFirst + ", please enter your Mile One Time <mm:ss.sss>: ");
		String dMileOne = keyboard.next();
		String dMileOneMinutes = dMileOne.split(":")[0];
		int dMOMinutes = Integer.parseInt(dMileOneMinutes);
		String dMileOneSeconds = dMileOne.split(":")[1];
		double dMOSeconds = Double.parseDouble(dMileOneSeconds);
		double dMOTotalSeconds = dMOMinutes * SECONDS_IN_MIN + dMOSeconds;
		
		// Getting Person d time towards the end of mile two
		System.out.print(dFirst + ", please enter your time to the end of the second mile <mm:ss.sss>: ");
		String dMileTwo = keyboard.next();
		String dMileTwoMinutes = dMileTwo.split(":")[0];
		int dMTMinutes = Integer.parseInt(dMileTwoMinutes);
		String dMileTwoSeconds = dMileTwo.split(":")[1];
		double dMTSeconds = Double.parseDouble(dMileTwoSeconds);
		double dMTTotalSeconds = dMTMinutes * SECONDS_IN_MIN + dMTSeconds;
		
		// Getting Person d total time
		System.out.print(dFirst + ", please enter your time to the end of the 5 km <mm:ss.sss>: ");
		String dTotal = keyboard.next();
		String dTotalMinutes = dTotal.split(":")[0];
		int dTMinutes = Integer.parseInt(dTotalMinutes);
		String dTotalSeconds = dTotal.split(":")[1];
		double dTSeconds = Double.parseDouble(dTotalSeconds);
		double dTTotalSeconds = dTMinutes * SECONDS_IN_MIN + dTSeconds;
		
		// Calculating Person d Split Two and Split Three time
		double dSplitTwo = dMTTotalSeconds - dMOTotalSeconds;
		double dSplitThree = dTTotalSeconds - dMTTotalSeconds;
		
		// Formating answer to get ready to display
		int dSplitOneMinutes = dMOMinutes;
		String dSplitOneSeconds = formatter.format(dMOSeconds);
		int dSplitTwoMinutes = (int)(dSplitTwo) / SECONDS_IN_MIN;
		String dSplitTwoSeconds = formatter.format((dSplitTwo) % SECONDS_IN_MIN);
		int dSplitThreeMinutes = (int)(dSplitThree) / SECONDS_IN_MIN;
		String dSplitThreeSeconds = formatter.format((dSplitThree) % SECONDS_IN_MIN);
		String d5k = formatter.format(dTSeconds);
		
		// Finalizing values to display
		String dFinalSO = (dSplitOneMinutes + ":" + dSplitOneSeconds);
		String dFinalST = (dSplitTwoMinutes + ":" + dSplitTwoSeconds);
		String dFinalSTH = (dSplitThreeMinutes + ":" + dSplitThreeSeconds);
		String dFinal5k = (dTMinutes + ":" + d5k);
		
		// Displaying the summary for Person d (Runner Four)
		System.out.println("\nRunner Four Summary" + "\n******************");
		System.out.println("\nRunner: " + dLast + ", " + dFirst);
		System.out.println("Split One: " + dFinalSO);
		System.out.println("Split Two: " + dFinalST);
		System.out.println("Split Three: " + dFinalSTH);
		System.out.println("Total: " + dFinal5k);
		
		// Person e (Runner Five)
		// Getting Person e Name
		System.out.print("\nPlease enter your first and last name: ");
		String eFirst = keyboard.next();
		String eLast = keyboard.next();
		
		//Getting Person e mile one time
		System.out.print(eFirst + ", please enter your Mile One Time <mm:ss.sss>: ");
		String eMileOne = keyboard.next();
		String eMileOneMinutes = eMileOne.split(":")[0];
		int eMOMinutes = Integer.parseInt(eMileOneMinutes);
		String eMileOneSeconds = eMileOne.split(":")[1];
		double eMOSeconds = Double.parseDouble(eMileOneSeconds);
		double eMOTotalSeconds = eMOMinutes * SECONDS_IN_MIN + eMOSeconds;
		
		//Getting Person e time towards the end of mile two
		System.out.print(eFirst + ", please enter your time to the end of the second mile <mm:ss.sss>: ");
		String eMileTwo = keyboard.next();
		String eMileTwoMinutes = eMileTwo.split(":")[0];
		int eMTMinutes = Integer.parseInt(eMileTwoMinutes);
		String eMileTwoSeconds = eMileTwo.split(":")[1];
		double eMTSeconds = Double.parseDouble(eMileTwoSeconds);
		double eMTTotalSeconds = eMTMinutes * SECONDS_IN_MIN + eMTSeconds;
		
		//Getting Person e total time
		System.out.print(eFirst + ", please enter your time to the end of the 5 km <mm:ss.sss>: ");
		String eTotal = keyboard.next();
		String eTotalMinutes = eTotal.split(":")[0];
		int eTMinutes = Integer.parseInt(eTotalMinutes);
		String eTotalSeconds = eTotal.split(":")[1];
		double eTSeconds = Double.parseDouble(eTotalSeconds);
		double eTTotalSeconds = eTMinutes * SECONDS_IN_MIN + eTSeconds;
		
		//Calculating Person e Split Two and Split Three time
		double eSplitTwo = eMTTotalSeconds - eMOTotalSeconds;
		double eSplitThree = eTTotalSeconds - eMTTotalSeconds;
		
		//Formating answer to get ready to display
		int eSplitOneMinutes = eMOMinutes;
		String eSplitOneSeconds = formatter.format(eMOSeconds);
		int eSplitTwoMinutes = (int)(eSplitTwo) / SECONDS_IN_MIN;
		String eSplitTwoSeconds = formatter.format((eSplitTwo) % SECONDS_IN_MIN);
		int eSplitThreeMinutes = (int)(eSplitThree) / SECONDS_IN_MIN;
		String eSplitThreeSeconds = formatter.format((eSplitThree) % SECONDS_IN_MIN);
		String e5k = formatter.format(eTSeconds);
		
		//Finalizing values to display
		String eFinalSO = (eSplitOneMinutes + ":" + eSplitOneSeconds);
		String eFinalST = (eSplitTwoMinutes + ":" + eSplitTwoSeconds);
		String eFinalSTH = (eSplitThreeMinutes + ":" + eSplitThreeSeconds);
		String eFinal5k = (eTMinutes + ":" + e5k);
		
		//Displaying the summary for Person e (Runner Five)
		System.out.println("\nRunner Five Summary" + "\n******************");
		System.out.println("\nRunner: " + eLast + ", " + eFirst);
		System.out.println("Split One: " + eFinalSO);
		System.out.println("Split Two: " + eFinalST);
		System.out.println("Split Three: " + eFinalSTH);
		System.out.println("Total: " + eFinal5k);
		
		//Closing the keyboard
		keyboard.close();
		
		//Displaying the final table
		System.out.println("\nFinal Summary" + "\n*******************************************************************************************************************");
		System.out.printf("%15s%20s%20s%20s%20s%20s\n", "Runner Number", "Runner Name", "Split One Time", "Split Two time", "Split Three Time", "Total Time");
		System.out.printf("%15s%20s%20s%20s%20s%20s\n", "1.", aLast +", " + aFirst, aFinalSO, aFinalST, aFinalSTH, aFinal5k);
		System.out.printf("%15s%20s%20s%20s%20s%20s\n", "2.", bLast +", " + bFirst, bFinalSO, bFinalST, bFinalSTH, bFinal5k);
		System.out.printf("%15s%20s%20s%20s%20s%20s\n", "3.", cLast +", " + cFirst, cFinalSO, cFinalST, cFinalSTH, cFinal5k);
		System.out.printf("%15s%20s%20s%20s%20s%20s\n", "4.", dLast +", " + dFirst, dFinalSO, dFinalST, dFinalSTH, dFinal5k);
		System.out.printf("%15s%20s%20s%20s%20s%20s\n", "5.", eLast +", " + eFirst, eFinalSO, eFinalST, eFinalSTH, eFinal5k);
		
	}

}
