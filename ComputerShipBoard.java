//Papadopoulos Xenofon-Rafail 4141

import java.util.Random;

public class ComputerShipBoard extends ShipBoard {

    private void enterShipRandomly(int size, int id) {
        boolean validPos = true;
        Random random = new Random();

        while (true)
        {
            int position1 = 1 + random.nextInt(10);
            int position2 = 1 + random.nextInt(10);
            boolean direction = random.nextBoolean();

            if (direction) { //horizontal placement
                if (position2 + size < 12) {
                    for (int t = 0; t < size; t++) {
                        if (getBoard()[position1 - 1][position2 - 1 + t] != 0){
                            validPos = false;
                        }
                    }
                    if (validPos) {
                        for (int i = 0; i < size; i++)
                        {
                            getBoard()[position1 - 1][position2 - 1 + i] = id;
                        }
                        //printBoard(board);
                        break;
                    }
                    else {
                        //System.out.println("There is a ship already there!");
                        validPos = true;
                    }
                }
                //else System.out.println("You are trying to place the ship outside the board!");
            }
            else { // vertical placement
                if (position1 + size < 12) {
                    for (int t = 0; t < size; t++) {
                        if (getBoard()[position1 - 1 + t][position2 - 1] != 0){
                            validPos = false;
                        }
                    }
                    if (validPos) {
                        for (int i = 0; i < size; i++)
                        {
                            getBoard()[position1 - 1 + i][position2 - 1] = id;
                        }
                        //printBoard(board);
                        break;
                    }
                    else {
                        //System.out.println("There is a ship already there!");
                        validPos = true;
                    }
                }
                //else System.out.println("You are trying to place the ship outside the board!");
            }
        }
    }

    public void enterAllShips() {
        for (int i = 0; i < getShipSize().length; i++)
        {
            enterShipRandomly(getShipSize()[i], getId()[i]);
        }
        super.printBoard();
    }

}
