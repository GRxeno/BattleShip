//Papadopoulos Xenofon-Rafail 4141

import java.util.Scanner;

public class HumanShipBoard extends ShipBoard{

    private void enterShipManually(int size, int id)
    {
        boolean validDir = false;
        boolean validPos = true;

        while (!validDir)
        {
            //Asking for the position and direction of the current ship being placed
            System.out.print("Give me the starting position of the ship(Size:"+size+"): ");
            Scanner input = new Scanner(System.in);
            int position1 = input.nextInt();
            int position2 = input.nextInt();
            System.out.print("Give me the direction of the ship (Horizontal/Vertical): ");
            Scanner input2 = new Scanner(System.in);
            String direction = input2.next();

            switch(direction)
            {
                case "horizontal":
                case "Horizontal":
                    if (position2 + size < 12) { //Checking if the ship will be inside the board
                        for (int t = 0; t < size; t++) { //Cheking if there is already a ship where we try to place the ship
                            if (getBoard()[position1 - 1][position2 - 1 + t] != 0){
                                validPos = false;
                            }
                        }
                        if (validPos) {  // If all ok, place the ship
                            for (int i = 0; i < size; i++)
                            {
                                getBoard()[position1 - 1][position2 - 1 + i] = id;
                            }
                            validDir = true;
                            printBoard();
                            break;
                        }
                        else {
                            System.out.println("There is a ship already there!");
                            validPos = true;
                            break;
                        }
                    }
                    else {
                        System.out.println("You are trying to place the ship outside the board!");
                        break;
                    }
                case "vertical":
                case "Vertical":
                    if (position1 + size < 12) { //Checking if the ship will be inside the board
                        for (int t = 0; t < size; t++) { //Cheking if there is already a ship where we try to place the ship
                            if (getBoard()[position1 - 1 + t][position2 - 1] != 0){
                                validPos = false;
                            }
                        }
                        if (validPos) {  // If all ok, place the ship
                            for (int i = 0; i < size; i++)
                            {
                                getBoard()[position1 - 1 + i][position2 - 1] = id;
                            }
                            validDir = true;
                            printBoard();
                            break;
                        }
                        else {
                            System.out.println("There is a ship already there!");
                            validPos = true;
                            break;
                        }
                    }
                    else {
                        System.out.println("You are trying to place the ship outside the board!");
                        break;
                    }
                default:
                    System.out.println("Not Valid Direction!");
            }
        }
    }

    public void enterAllShips(){
        for (int i = 0; i < getShipSize().length; i++) //Take one by one the ships and place them
        {
            enterShipManually(getShipSize()[i], getId()[i]);
        }
    }


}
