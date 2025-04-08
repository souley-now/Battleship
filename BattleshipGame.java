package battleship;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class for a human vs. computer version of Battleship.
 * This class handles the game logic, user input, and interaction with the Ocean class.
 * 
 * @author Tangji Li & Bowen Chen
 */
public class BattleshipGame {

	/**
	 * Default constructor for the BattleshipGame class.
	 */
	public BattleshipGame() {
	}

	/**
	 * Main method to start the Battleship game.
	 * 
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		// Scanner for game flag (to start or quit the game)
		Scanner gameFlag = new Scanner(System.in);

		// Scanner for player input during the game
		Scanner input = new Scanner(System.in);

		// Main game loop
		while (true) {
			// Prompt user to enter the game or quit
			System.out.print("Press 1 to enter the game, or press any other number to quit: ");

			// Exit the game if the user does not press 1
			if (gameFlag.nextInt() != 1) {
				System.out.println("See ya!");
				break;
			}

			// Initialize the game
			Ocean ocean = new Ocean();
			ocean.placeAllShipsRandomly();
			System.out.println("Welcome to Battleship Game!");
			System.out.println("Your ocean looks like this:");
			ocean.print();

			// Game loop until all ships are sunk
			while (!ocean.isGameOver()) {
				int row;
				int column;

				// Get valid user input for firing at a position
				while (true) {
					System.out.println("Please enter the position in the form of row,column that you want to fire at:");
					System.out.println("Use ',' to separate. For example: 1,2");

					// Parse user input
					String str = input.next();
					String[] s = str.split(",");
					row = Integer.parseInt(s[0]);
					column = Integer.parseInt(s[1]);

					// Store the player's input in an ArrayList
					ArrayList<Integer> intYourCR = new ArrayList<>();
					intYourCR.add(row);
					intYourCR.add(column);
					ocean.yourCR.add(intYourCR);

					// Validate the input
					if (row >= 0 && row <= 9 && column >= 0 && column <= 9) {
						break;
					} else {
						System.out.println("Invalid input. Please enter a row and column between 0 and 9.");
					}
				}

				// Fire at the specified position and display the result
				if (ocean.shootAt(row, column)) {
					if (ocean.getShipArray()[row][column].isSunk()) {
						System.out.println("You just sunk a ship!");
					} else {
						System.out.println("Your shot landed on a ship!");
					}
				} else {
					System.out.println("Sorry, it seems that you missed.");
				}

				// Display game statistics
				System.out.println("You have fired " + ocean.getShotsFired() + " shot(s).");
				System.out.println("The number of hits is " + ocean.getHitCount() + ".");
				System.out.println("You have sunk " + ocean.getShipsSunk() + " ship(s).");
				System.out.println("Now the ocean looks like this:");
				ocean.print();
			}

			// Congratulate the player for winning
			System.out.println("Congrats! You just won!");

			// Ask the player if they want to play again
			boolean asking = true;
			while (asking) {
				System.out.println("Do you want to play again? (y/n)");

				// Get the player's response
				String input1 = gameFlag.next();

				if (input1.equals("y")) {
					asking = false; // Stop asking and restart the game
				} else if (input1.equals("n")) {
					asking = false; // Stop asking and quit the game
					System.out.println("Thanks for playing! Goodbye!");
					gameFlag.close();
					input.close();
					return; // Exit the program
				} else {
					// Invalid input, prompt again
					System.out.println("Invalid input. Please enter 'y' to play again or 'n' to quit.");
				}
			}
		}
	}
}
