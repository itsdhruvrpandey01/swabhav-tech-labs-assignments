package com.aurionpro.basics.assignments;

import java.util.Scanner;

public class PigGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		startPig(5,0,scanner);
		scanner.close();

	}
	private static void startPig(int totalTurns,int totalPoints,Scanner scanner) {
		System.out.println("Let's Play PIG");
		System.out.println("Rules: \nYou are given dice of 1 to 6"
				+ "\nOnce you reach 20 or above total points you win "
				+ "\nyou will loose all your points if dice rolls 1."
				+ "\nYou have atmost 5 turns"
				+ "You'll Lose your turn if you rolled 1 or used hold");
		
		System.out.println("Press 1 to play or press 0 to exit");
		int option = scanner.nextInt();
		
		while(option == 1) {
			
			playPig(totalTurns,totalPoints,scanner);
			
			System.out.println("Press 1 to play again or press 0 to exit");
			
			option = scanner.nextInt();
		}
		System.out.println("Thanks for playing PIG....!");
	}
	public static void playPig(int total_turns,int total_points,Scanner scanner) {
		while(total_turns>0 && total_points<20) {
			System.out.println("Your current score is "+total_points+"\nAnd Total Turns Remaining "+total_turns);
			System.out.println("Type 1 for roll or Type 2 for hold");
			
			int choice = scanner.nextInt();
			int updatedPointsAndTurns[] = doUpdatePointsAndTurns( total_turns,total_points,choice);
			total_turns = updatedPointsAndTurns[0];
			total_points+=updatedPointsAndTurns[1];
			
		}
		if(total_turns==0) System.out.println("You lost");
		if(total_points>=20) {
			System.out.println("Congratulations You Win!");
		}
	}
	public static int[] doUpdatePointsAndTurns(int total_turns,int total_points,int choice) {
		int [] pointsAndTurns = new int[2];
		if(choice == 2) {
			pointsAndTurns[0] = total_turns-1;
			pointsAndTurns[1] = total_points;
			return pointsAndTurns;
		}
		
		int roll = (int)(Math.random()*6+1);
		
		if(roll==1) {
			System.out.println("Oops 1");
			pointsAndTurns[0] = total_turns-1;
			pointsAndTurns[1] = -total_points;
			return pointsAndTurns;
		}
		pointsAndTurns[0] = total_turns;
		pointsAndTurns[1] = roll;
		System.out.println("Roll = "+roll);
		return pointsAndTurns;
	}
}