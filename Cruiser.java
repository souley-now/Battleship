package battleship;

public class Cruiser extends Ship {
    public Cruiser() {
        super(3);
    }

    @Override
    public String getShipType() {
        return "cruiser";
    }
}

