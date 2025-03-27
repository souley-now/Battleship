package battleship;

public class Ocean {
    private Ship[][] ships = new Ship[10][10];
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;

    public Ocean() {
        // Initialize the ocean
    }

    // Add all required methods

    /**
     * Methods
     */

     void placeAllShipsRandomly(){
    /*
      * Place all ten ships randomly on the (initially empty) ocean. Place larger ships arrayshootatbefore smaller ones, or you may end up with no legal place to put a large ship. You will want to use the Random class in the java.util package, so look that up in the Java API.
      To help you write the code for this method, reference the printWithShips() method below. It will allow you to see where ships are actually being placed in the Ocean while you are writing and debugging your program.
     */
     }


    boolean isOccupied(int row, int column){
        /*
         * Returns true if the given location contains a ship, false if it does not
         */

        
    }

    boolean shootAt(int row, int column){
        /*
         * Returns true if the given location contains a ”real” ship, still afloat, (not an EmptySea), false if it does not. In addition, this method updates the number of shots that have been fired, and the number of hits.
         * Note: If a location contains a “real” ship, shootAt should return true every time the user shoots at that same location. Once a ship has been ”sunk”, additional shots at its location should return false
         */
    }

    int getShotsFired(){
        /*
         * Returns the number of shots fired (in the game)
         */
    }

    int getHitCount(){
        /*
         * Returns the number of hits recorded (in the game). All hits are counted, not just the first time a given square is hit.
         */
    }

    int getShipsSunk(){
        /*
         * Returns the number of ships sunk (in the game)
         */
    }

    boolean isGameOver(){
        /*
         * Returns true if all ships have been sunk, otherwise false
         */
    }

    Ship[][] getShipArray(){
        /*
         * Returns the 10x10 array of Ships. The methods in the Ship class that take an Ocean parameter need to be able to look at the contents of this array; the placeShipAt() method even needs to modify it. While it is undesirable to allow methods in one class to directly access instance variables in another class, sometimes there is just no good alternative.
         */
    }

    void print(){
        /*
         * Prints the Ocean. To aid the user, row numbers should be displayed along the left edge of the array, and column numbers should be displayed along the top. Numbers should be 0 to 9, not 1 to 10.
         * The top left corner square should be 0, 0.
         * ‘x’: Use ‘x’ to indicate a location that you have fired upon and hit a (real) ship.
         * (reference the description of toString in the Ship class)
         * ‘-’: Use ‘-’ to indicate a location that you have fired upon and found nothing there. (reference the description of toString in the EmptySea class)
         * ‘s’: Use ‘s’ to indicate a location containing a sunken ship. (reference the description of toString in the Ship class)
         * ‘.’: and use ‘.’ (a period) to indicate a location that you have never fired upon 
         * This is the only method in the Ocean class that does any input/output, and it is never called from within the Ocean class, only from the BattleshipGame class
         */
    }

    void printWithShips(){
        /*
         * USED FOR DEBUGGING PURPOSES ONLY.
         * Like the print() method, this method prints the Ocean with row numbers displayed along the left edge of the array, and column numbers displayed along the top. Numbers should be 0 to 9, not 1 to 10. The top left corner square should be 0, 0.
         * Unlike the print() method, this method shows the location of the ships. This method can be used during development and debugging, to see where ships are actually being placed in the Ocean. (The TAs may also use this method when running your program and grading.) It can be called from the BattleshipGame class, after creating the Ocean and placing ships in it.
         * Be sure to comment out any call to this method before actually playing the game and before submitting your Java project.
         * ‘b’: Use ‘ b’ to indicate a Battleship.
         * ‘c’: Use ‘c’ to indicate a Cruiser.
         * ‘d’: Use ‘d ’ to indicate a Destroyer.
         * ‘s’: Use ‘ s ’ to indicate a Submarine.
         * ‘ ‘: Use ‘  ’ (single space) to indicate an EmptySea.
         */
    }

}