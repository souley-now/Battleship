package battleship;

import java.util.ArrayList;

/**
 * Class Ocean
 */
public class Ocean {

  /**
   * Instance variables
   */
  private Ship[][] ships = new Ship[10][10]; // Used to determine which ship is in any given location
  private int shotsFired; // The total number of shots fired by the user
  private int hitCount; // The number of times a shot hit a ship
  private int shipsSunk; // The number of ships sunk

  // Ship instances
  Ship battleShip1 = new Battleship();
  Ship cruiser1 = new Cruiser();
  Ship cruiser2 = new Cruiser();
  Ship destroyer1 = new Destroyer();
  Ship destroyer2 = new Destroyer();
  Ship destroyer3 = new Destroyer();
  Ship submarine1 = new Submarine();
  Ship submarine2 = new Submarine();
  Ship submarine3 = new Submarine();
  Ship submarine4 = new Submarine();

  // ArrayList to store user's input as {row, column}
  ArrayList<ArrayList<Integer>> yourCR = new ArrayList<>();

  /**
   * Constructor
   */
  public Ocean() {
    // Initialize the ocean with EmptySea objects
    for (int i = 0; i <= 9; i++) {
      for (int j = 0; j <= 9; j++) {
        this.getShipArray()[i][j] = new EmptySea();
        ships[i][j].setBowRow(i);
        ships[i][j].setBowColumn(j);
      }
    }

    // Initialize counters
    shotsFired = 0;
    hitCount = 0;
    shipsSunk = 0;
  }

  /**
   * Place all ten ships randomly on the (initially empty) ocean
   */
  void placeAllShipsRandomly() {
    battleShip1.placeRandomly(this);
    cruiser1.placeRandomly(this);
    cruiser2.placeRandomly(this);
    destroyer1.placeRandomly(this);
    destroyer2.placeRandomly(this);
    destroyer3.placeRandomly(this);
    submarine1.placeRandomly(this);
    submarine2.placeRandomly(this);
    submarine3.placeRandomly(this);
    submarine4.placeRandomly(this);
  }

  /**
   * Check if the given location contains a ship
   */
  boolean isOccupied(int row, int column) {
    return !ships[row][column].getShipType().equals("empty");
  }

  /**
   * Shoot at the given location
   */
  boolean shootAt(int row, int column) {
    shotsFired++;

    if (isOccupied(row, column)) {
      hitCount++;

      if (!ships[row][column].isSunk()) {
        if (ships[row][column].isHorizontal()) {
          ships[row][column].getHit()[ships[row][column].getBowColumn() - column] = true;
        } else {
          ships[row][column].getHit()[ships[row][column].getBowRow() - row] = true;
        }

        if (ships[row][column].isSunk()) {
          shipsSunk++;
        }

        return true;
      }
    }

    return false;
  }

  /**
   * Get the number of shots fired
   */
  int getShotsFired() {
    return shotsFired;
  }

  /**
   * Get the number of hits recorded
   */
  int getHitCount() {
    return hitCount;
  }

  /**
   * Get the number of ships sunk
   */
  int getShipsSunk() {
    return shipsSunk;
  }

  /**
   * Check if the game is over
   */
  boolean isGameOver() {
    return shipsSunk == 10;
  }

  /**
   * Get the 10x10 array of Ships
   */
  Ship[][] getShipArray() {
    return ships;
  }

  /**
   * Print the Ocean
   */
  void print() {
    for (int i = 0; i <= 10; i++) {
      if (i == 0) {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        continue;
      }

      System.out.print((i - 1) + " ");

      for (int j = 0; j <= 9; j++) {
        ArrayList<Integer> ij = new ArrayList<>();
        ij.add(i - 1);
        ij.add(j);

        if (this.yourCR.contains(ij)) {
          System.out.print(this.getShipArray()[i - 1][j] + " ");
        } else {
          System.out.print(". ");
        }
      }

      System.out.println();
    }
  }
}
