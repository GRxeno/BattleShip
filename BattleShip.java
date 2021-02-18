//Papadopoulos Xenofon-Rafail 4141

import java.util.Scanner;

public class BattleShip {

	public static void main(String[] args) {
		BattleShip game = new BattleShip();

		while(true) {
			System.out.println("Type '1' for Player Vs Computer or '2' for Player Vs Player: ");
			Scanner input = new Scanner(System.in);
			int player = input.nextInt();
			if (player == 1 || player == 2) {
				if (player == 2) {
					Player player1 = new HumanPlayer();
					Player player2 = new HumanPlayer();
					game.playGame(player1, player2);
					break;
				} else {
					Player player1 = new ComputerPlayer();
					Player player2 = new HumanPlayer();
					game.playGame(player1, player2);
					break;
				}
			}
		}
	}

	private void playGame(Player player1, Player player2){

		int[] firePos;

		while(true) {

			System.out.println("Player 1: ");
			firePos = player1.nextStrike();
			player1.update(firePos, player2.getStrike(firePos));
			if (player2.lastStrikeSankShip()) {
				System.out.println("You sank a ship!");
			}
			if (player2.allShipsSank()) {
				System.out.println("Player 1 won the game!");
				break;
			}
			System.out.println("Player 2: ");
			firePos = player2.nextStrike();
			player2.update(firePos, player1.getStrike(firePos));
			if (player1.lastStrikeSankShip()) {
				System.out.println("You sank a ship!");
			}
			if (player1.allShipsSank()) {
				System.out.println("Player 2 won the game!");
				break;
			}
		}
	}
}
