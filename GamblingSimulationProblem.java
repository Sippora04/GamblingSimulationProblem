package com.gamblingsimulation;

public class GamblingSimulationProblem {
	
	public static final int STAKE = 100;
	public static final int BET = 1;
	public static final int Total_Days = 30;
	
	public static int totalWin = 0;
	public  static int totalLoss = 0;

	private static int checkWinOrLose () {
		return (int) Math.floor(Math.random() * 10) % 2;
	}
	
	private static int checkResign(int initialStake, int totalAmount) {
		double winResignAmount = 1.5 * initialStake;
		double lossResignAmount = 0.5 * initialStake;
		if ( totalAmount >= winResignAmount || totalAmount <= lossResignAmount)
			return 1;
		else
			return 0;
	}
	
	public static void main(String[] args) {
		int month = 0;
		do {
			int netTotal = 0;
			int luckyDay = 0;
			int unluckyDay = 0;
			int luckyDayAmount = 0;
			int unluckyDayAmount = 0;
			
		for (int day = 1; day <= Total_Days; day++) {
			
			int totalAmount = STAKE;
			int dailyWin = 0;
			int dailyLoss = 0;
			
			while (checkResign(STAKE, totalAmount) != 1) {
				if (checkWinOrLose() == 1) {
					totalAmount += BET;
					dailyWin += BET;
				}
				else {
					totalAmount -= BET;
					dailyLoss += BET;
				}
			}
			totalWin += dailyWin;
			totalLoss += dailyLoss;
			netTotal += (dailyWin - dailyLoss);
			
			if (luckyDayAmount < netTotal) {
				luckyDayAmount = netTotal;
				luckyDay = day;
			}
			if (unluckyDayAmount > netTotal) {
				unluckyDayAmount = netTotal;
				unluckyDay = day;
			}
			System.out.println(day + " Day -> \tGambler WON: " + dailyWin + " \tGambler Loss: " + dailyLoss + " \tDiffernce:  " + (dailyWin - dailyLoss));
		}
	System.out.println("After 20 days -> Total Win amount: " + totalWin);	
	System.out.println("After 20 days -> Total Loos amount: " + totalLoss);	
	System.out.println("\nLucky Day ->\tAmount Won: " + luckyDayAmount + ".");	
	System.out.println("UnLucky Day is -> \tAmount Won: " + unluckyDayAmount + ".");	
	System.out.println("\nNet amount : "+ (totalWin-totalLoss));
	}while((totalWin-totalLoss) > 0);
	}
}
