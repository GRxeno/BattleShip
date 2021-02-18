//Papadopoulos Xenofon-Rafail 4141


public class ComputerPlayer extends Player {

	private RandomStrategy randomStrategy = new RandomStrategy();

	public int[] nextStrike() {
		//Asking the next random position the computer will hit
		return randomStrategy.nextStrike();	
	}

	public void createBoard(){
		ShipBoard shipBoard = new ComputerShipBoard();
		shipBoard.enterAllShips();
	}
}

