package battleship;

public abstract class Ship {
    private int bowRow;
    private int bowColumn;
    private int length;
    private boolean horizontal;
    private boolean[] hit;

    public Ship(int length) {
        this.length = length;
        this.hit = new boolean[length];
    }

    public abstract String getShipType();

    // Add all required getters, setters, and methods
}



public class Ship {
    class Battleship extends Ship
    /*
    Describes a ship of length 4
    */
    class Cruiser extends Ship
    /*
     * Describes a ship of length 3
     */
    
    class Destroyer extends Ship
    /*
     * Describes a ship of length 2
     */
    class Submarine extends Ship
    /*
     * Describes a ship of length 1
     */

    class EmptySea extends Ship
    /*
     * Describes a part of the ocean that doesn’t have a ship in it. (It seems silly to have the lack of a ship be a type of ship, but this is a trick that simplifies a lot of things. This way, every location in the ocean contains a “ship” of some kind.)
     */

    @Override
    public String getShipType(){
        /*
         * Returns one of the strings “battleship”, “cruiser”, “destroyer”, or “submarine”, as appropriate. Again, these types of hard-coded string values are good candidates for static final variables.
         * This method can be useful for identifying what type of ship you are dealing with, at any given point in time, and eliminates the need to use instanceof
         */
    }
    private int bowRow
    /*The row that contains the bow (front part of the ship)*/
    private int bowColumn
    /*The column that contains the bow (front part of the ship)*/
    private int length
    /*The length of the ship*/
    private boolean horizontal
    /*A boolean that represents whether the ship is going to be placed horizontally or
    vertically */
    private boolean[] hit
    /*An array of booleans that indicate whether that part of the ship has been hit or
    not The default constructor for the Ship class is:*/
    public Ship(int length)
    /*This constructor sets the length property of the particular ship and initializes
    the hit array based on that length The methods in the Ship class are the following:*/
    
    public int getLength()
    /*Returns the ship length*/
    public int getBowRow()
    /*Returns the row corresponding to the position of the bow*/
    public int getBowColumn()
    /*Returns the bow column location*/
    public boolean[] getHit()
    /*Returns the hit array*/
    public boolean isHorizontal()
    /*Returns whether the ship is horizontal or not*/

    public void setBowRow(int row)
    /*Sets the value of bowRow*/
    public void setBowColumn(int column)
    /*Sets the value of bowColumn*/
    public void setHorizontal(boolean horizontal)
    /*Sets the value of the instance variable horizontal*/

}
