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
		
		int luckyDay = 0;
		int unluckyDay = 0;
		int maxAmountWon = 0;
		int maxAmountLoss = 0;
		
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
			
			maxAmountWon = Math.max(maxAmountWon, dailyWin);
			maxAmountLoss = Math.max(maxAmountLoss, dailyLoss);
			
			if (maxAmountWon == dailyWin)
				luckyDay = day;
			if (maxAmountLoss == dailyLoss)
				unluckyDay = day;
			System.out.println(day + " Day -> \tGambler WON: " + dailyWin + " \tGambler Loss: " + dailyLoss + " \tDiffernce:  " + (dailyWin - dailyLoss));
		}
	System.out.println("After 20 days -> Total Win amount: " + totalWin);	
	System.out.println("After 20 days -> Total Loos amount: " + totalLoss);	
	System.out.println("Lucky Day is " + "Amount Won: " + maxAmountWon);	
	System.out.println("UnLucky Day is " + "Amount Won: " + maxAmountLoss);	
	
	}
}
