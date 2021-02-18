//Papadopoulos Xenofon-Rafail 4141

import java.util.Scanner;

public class HumanPlayer extends Player{

	public void createBoard() {
		ShipBoard shipBoard = new HumanShipBoard();
		shipBoard.printBoard();
		shipBoard.enterAllShips();
	}

	public int[] nextStrike() {
		//Asking the next position the player will hit
		int[] firePos = new int[2];
		System.out.print("Where would you like to shoot: ");
		Scanner input = new Scanner(System.in);
		firePos[0] = input.nextInt();
		firePos[1] = input.nextInt();
		return firePos;
	}
}
