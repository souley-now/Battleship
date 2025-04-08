package battleship;

import java.util.ArrayList;
import java.util.Random;

/**
 * Abstract class representing a Ship in the Battleship game.
 * Provides common properties and behaviors for all types of ships.
 * 
 * @author Souley Diallo
 */
public abstract class Ship {

	// Instance variables
	private int bowRow; // The row that contains the bow of the ship
	private int bowColumn; // The column that contains the bow of the ship
	private int length; // The length of the ship
	private boolean horizontal; // Whether the ship is placed horizontally or vertically
	private boolean[] hit; // Array indicating whether each part of the ship has been hit

	/**
	 * Constructor for the Ship class.
	 * Initializes the ship's length and sets all parts as not hit.
	 * 
	 * @param length The length of the ship.
	 */
	public Ship(int length) {
		this.length = length;
		this.hit = new boolean[length];
		for (int i = 0; i < length; i++) {
			hit[i] = false;
		}
	}

	// Getters

	/**
	 * @return The length of the ship.
	 */
	public int getLength() {
		return this.length;
	}

	/**
	 * @return The row of the bow.
	 */
	public int getBowRow() {
		return this.bowRow;
	}

	/**
	 * @return The column of the bow.
	 */
	public int getBowColumn() {
		return this.bowColumn;
	}

	/**
	 * @return The hit array indicating which parts of the ship have been hit.
	 */
	public boolean[] getHit() {
		return this.hit;
	}

	/**
	 * @return True if the ship is placed horizontally, false otherwise.
	 */
	public boolean isHorizontal() {
		return this.horizontal;
	}

	// Setters

	/**
	 * Sets the row of the bow.
	 * 
	 * @param row The row to set.
	 */
	public void setBowRow(int row) {
		this.bowRow = row;
	}

	/**
	 * Sets the column of the bow.
	 * 
	 * @param column The column to set.
	 */
	public void setBowColumn(int column) {
		this.bowColumn = column;
	}

	/**
	 * Sets whether the ship is placed horizontally.
	 * 
	 * @param horizontal True if the ship is horizontal, false otherwise.
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	// Abstract methods

	/**
	 * @return The type of the ship as a string.
	 */
	public abstract String getShipType();

	// Methods

	/**
	 * Checks if it is valid to place the ship at the specified location.
	 * 
	 * @param row        The row to place the bow.
	 * @param column     The column to place the bow.
	 * @param horizontal True if the ship is horizontal, false otherwise.
	 * @param ocean      The ocean where the ship is being placed.
	 * @return True if it is valid to place the ship, false otherwise.
	 */
	boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		if (horizontal) {
			if (row >= 0 && row <= 9 && column - length + 1 >= 0 && column <= 9) {
				return isAreaClear(row, column, horizontal, ocean);
			}
		} else {
			if (column >= 0 && column <= 9 && row - length + 1 >= 0 && row <= 9) {
				return isAreaClear(row, column, horizontal, ocean);
			}
		}
		return false;
	}

	/**
	 * Helper method to check if the area around the ship is clear.
	 * 
	 * @param row        The row to place the bow.
	 * @param column     The column to place the bow.
	 * @param horizontal True if the ship is horizontal, false otherwise.
	 * @param ocean      The ocean where the ship is being placed.
	 * @return True if the area is clear, false otherwise.
	 */
	private boolean isAreaClear(int row, int column, boolean horizontal, Ocean ocean) {
		int startRow = horizontal ? row - 1 : row - length;
		int endRow = horizontal ? row + 1 : row + 1;
		int startColumn = horizontal ? column - length : column - 1;
		int endColumn = horizontal ? column + 1 : column + 1;

		for (int r = Math.max(0, startRow); r <= Math.min(9, endRow); r++) {
			for (int c = Math.max(0, startColumn); c <= Math.min(9, endColumn); c++) {
				if (ocean.isOccupied(r, c)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Places the ship at the specified location in the ocean.
	 * 
	 * @param row        The row to place the bow.
	 * @param column     The column to place the bow.
	 * @param horizontal True if the ship is horizontal, false otherwise.
	 * @param ocean      The ocean where the ship is being placed.
	 */
	void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		setBowRow(row);
		setBowColumn(column);
		setHorizontal(horizontal);

		if (horizontal) {
			for (int i = column - length + 1; i <= column; i++) {
				ocean.getShipArray()[row][i] = this;
			}
		} else {
			for (int i = row - length + 1; i <= row; i++) {
				ocean.getShipArray()[i][column] = this;
			}
		}
	}

	/**
	 * Places the ship randomly in the ocean.
	 * 
	 * @param ocean The ocean where the ship is being placed.
	 */
	void placeRandomly(Ocean ocean) {
		Random random = new Random();
		boolean placed = false;

		while (!placed) {
			int row = random.nextInt(10);
			int column = random.nextInt(10);
			boolean horizontal = random.nextBoolean();

			if (okToPlaceShipAt(row, column, horizontal, ocean)) {
				placeShipAt(row, column, horizontal, ocean);
				placed = true;
			}
		}
	}

	/**
	 * Shoots at the specified location.
	 * 
	 * @param row    The row to shoot at.
	 * @param column The column to shoot at.
	 * @return True if the shot hits the ship, false otherwise.
	 */
	boolean shootAt(int row, int column) {
		if (horizontal) {
			if (row == bowRow && column >= bowColumn - length + 1 && column <= bowColumn && !isSunk()) {
				hit[bowColumn - column] = true;
				return true;
			}
		} else {
			if (column == bowColumn && row >= bowRow - length + 1 && row <= bowRow && !isSunk()) {
				hit[bowRow - row] = true;
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the ship has been sunk.
	 * 
	 * @return True if all parts of the ship have been hit, false otherwise.
	 */
	boolean isSunk() {
		for (boolean partHit : hit) {
			if (!partHit) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @return "s" if the ship is sunk, "x" otherwise.
	 */
	@Override
	public String toString() {
		return isSunk() ? "s" : "x";
	}
}
