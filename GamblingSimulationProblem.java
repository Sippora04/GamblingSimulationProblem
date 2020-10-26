package com.gamblingsimulation;

public class GamblingSimulationProblem {
	
	public static final int STAKE = 100;
	public  static final int BET = 1;

	private static int checkWinOrLose () {
		return (int) Math.floor(Math.random() * 10) % 2;
	}
	
	private static int checkResign (int initialStake, int totalAmount) {
		
		double winResignAmount = 1.5 * initialStake;
		double lossResignAmount = 0.5 * initialStake;
		if ( totalAmount >= winResignAmount || totalAmount <= lossResignAmount)
			return 1;
		else
			return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" ***** Welcome to Gambling Simulation Problem ***** ");
		
		int totalAmount = STAKE;
		
		while (checkResign (STAKE, totalAmount) != 1) {
			if (checkWinOrLose () == 1) {
				totalAmount += BET;
				System.out.println("Total WIN Amount: " + totalAmount);	
			}
			else {
				totalAmount -= BET;
				System.out.println("Total LOSS Amount: " + totalAmount);	
			}
		}
		
	System.out.println("Total Amount: " + totalAmount);	
	}
}
