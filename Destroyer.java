package battleship;

public class Destroyer extends Ship {
    public Destroyer() {
        super(2);
    }

    @Override
    public String getShipType() {
        return "destroyer";
    }
}

