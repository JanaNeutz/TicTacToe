package de.yananeutz;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * In this Applikation I tried to follow naming rules:
 * - use descriptive and searchable names
 * - I made the code self-explanatory to avoid abundant comments
 * - I tried to avoid sideeffects, so i introduced an input validation
 * - variables are declared as close to their usage as possible
 * - no comment-out code
 * - no unused code
 * - DRY observed
 */
public class Main {

    public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		System.out.println(game.startGame());
		String player = "X";
		boolean playIsActive = true;
		while (playIsActive) {
			System.out.println("You are a player " + player + ". Your move...");
			System.out.println("Enter the row number, starting from 1 to 3: ");
			Scanner input = new Scanner(System.in);
			int row = convertInputToInteger(input);
			if (row != -1) {
				System.out.println("Enter the column number, starting from 1 to 3: ");
				int column = convertInputToInteger(input);
				if (column != -1) {
					game.setPlayerChoice(row, column, player);
					System.out.println(game.printBoard());
					playIsActive = checkIfGameOver(game, player, playIsActive);
					player = invertPlayer(player);
				} else {
					errorLog();
				}
			} else {
				errorLog();
			}
		}
	}

	private static boolean checkIfGameOver(TicTacToe game, String player, boolean playIsActive) {
		if (game.isGameOver()) {
			System.out.println("The player " + player + " wins!");
			playIsActive = false;
		}
		return playIsActive;
	}

	private static String invertPlayer(String player) {
		if (player.equals("X")) {
			player = "O";
		} else {
			player = "X";
		}
		return player;
	}

	private static int convertInputToInteger(Scanner input) {
    	int integer = -1;
    	try {
    		integer = input.nextInt();
		} catch (InputMismatchException ignored) {
		}
    	if (isValidNumber(integer)) {
    		return integer - 1;
		} else {
    		return -1;
		}
	}

	private static boolean isValidNumber(int number) {
    	return number > 0 && number < 4;
	}

	private static void errorLog() {
		System.out.println("Your input is invalid. Write a number from 1 to 3.");
	}
}
