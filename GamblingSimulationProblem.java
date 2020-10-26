package com.gamblingsimulation;

import java.util.Random;

public class GamblingSimulationProblem {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" ***** Welcome to Gambling Simulation Problem ***** ");
		
		//UC1: As a Gambler, would start with a stake of $100 every day and bet$1 every game.
		int stake = 100;
		int bet = 1;
		System.out.println("Stake: " + stake + "\nBet: " + bet);
		
		//UC2: As a Gambler make $1 bet so either win or loose $1
		Random random = new Random();
		int check = random.nextInt(2);
		if (check == 1)
			System.out.println("WIN");
		else
			System.out.println("LOOSE");
	}
}
