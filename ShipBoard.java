//Papadopoulos Xenofon-Rafail 4141

abstract public class ShipBoard
{
	/**
	 * Board with the ships
	 * Board that holds the strikes the player has done. Does not if hit or miss
	 */
	private int[][] board = new int[10][10];
	private boolean[][] StrikeBoard = new boolean[10][10];
	private int[] shipSize = {5, 4, 3, 3, 2};
	private int[] id = {1, 2, 3, 4, 5};

	public abstract void enterAllShips();

	public void printBoard()
	{
		int i = 1;
		System.out.println("_____________________________________");
        System.out.println(" ");
		System.out.println("    1 2 3 4 5 6 7 8 9 10");
		System.out.println(" ");
		for(int c = 0; c < board.length; c++)
		{
			for(int r = 0; r < board[0].length; r++)
			{
				if (r == 0)
				{
					if (i != 10)
					{
						System.out.print(i + "  ");
						i++;
					}
					else
					{
						System.out.print(i + " ");
					}
				}
				System.out.print(" "+board[c][r]);
			}
		System.out.println(" ");
		}
		System.out.println("_____________________________________");
        System.out.println(" ");
	}

	public boolean lastStrikeSankShip() {
		/**
		 * Every time a ship is hit the ship size is subtracted by one
		 * If it reaches 0 it means the ship was sank
		 * And i subtract one more so i can be sure the next turn if the player hits a ship position the method won't return true
		 */
		for (int i = 0; i < shipSize.length; i++) {
			if (shipSize[i] == 0) {
				shipSize[i] -= 1;
				return true;
			}
		}
		return false;
	}

	public boolean allShipsSank()
	{
		//If the all the ship's sizes are bellow 0 it means all the ships are gone
		for (int i = 0; i < shipSize.length; i++){
				if (shipSize[i] > 0) {
					return false;
				}
			}
		return true;
	}

	public boolean getStrike (int[] firePos)
	{
		if (StrikeBoard[firePos[0]-1][firePos[1]-1]) { //First checking if the player has hit there already
			System.out.println("Already hit there!");
			return false;
		}
		if (board[firePos[0]-1][firePos[1]-1] == 0) { //If the ship board does not have an id there the player has missed
			System.out.println("MISS");
			StrikeBoard[firePos[0]-1][firePos[1]-1] = true;

			return false;
		}
		else {
			System.out.println("HIT"); //Else the board has a number there and therefore a ship was hit
			StrikeBoard[firePos[0]-1][firePos[1]-1] = true;
			for (int i = 0; i < id.length; i++) { //Finding what ship was hit so i can subtract one size
				//Checking all the id board so i can find the size of the ship that was hit
				// because the ship id board and size board are always corresponding
				 if (id[i] == board[firePos[0]-1][firePos[1]-1]) {
					shipSize[i] -= 1;
				}
			}
			return true;
		}
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	public int[][] getBoard() {
		return board;
	}

	public int[] getShipSize() {
		return shipSize;
	}

	public int[] getId() {
		return id;
	}
}


