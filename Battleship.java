package battleship;

public class Battleship extends Ship {
    public Battleship() {
        super(4);
    }

    @Override
    public String getShipType() {
        return "battleship";
    }
}

