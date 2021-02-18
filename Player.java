//Papadopoulos Xenofon-Rafail 4141

abstract public class Player {

    private StrikeBoard strikeBoard = new StrikeBoard();
    private ShipBoard shipBoard1 = new HumanShipBoard();

    public abstract void createBoard();
    public abstract int[] nextStrike();


    public Player(){
       System.out.println(this + " Please place your ships!");
       this.createBoard();
    }

    public boolean getStrike (int[] firePos) {
        return shipBoard1.getStrike(firePos);
    }

    public boolean allShipsSank(){
        return shipBoard1.allShipsSank();
    }

    public boolean lastStrikeSankShip(){
        return shipBoard1.lastStrikeSankShip();
    }

    public void update(int[] firePos, boolean getStrike) {
        strikeBoard.addStrike(firePos, getStrike);
        strikeBoard.printBoard();
    }

}
