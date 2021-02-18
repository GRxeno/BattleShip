//Papadopoulos Xenofon-Rafail 4141

public class StrikeBoard {

	// Board that holds the misses and strikes of the player
	private int[][] StrikeBoard = new int[10][10];
	
	public void addStrike(int[] firePos, boolean getStrike) {
		if (getStrike) { //If the hit successful
			StrikeBoard[firePos[0]-1][firePos[1]-1] = 1;
		}
		else { 
			if (StrikeBoard[firePos[0]-1][firePos[1]-1] != 1) { //If the player hits a ship position twice it will change it to -1, we don't want that
				StrikeBoard[firePos[0]-1][firePos[1]-1] = -1;
			}
		}
		
	}
	
	public void printBoard()
	{
		int i = 1;
		System.out.println("_____________________________________");
        System.out.println("");
		System.out.println("    1  2  3  4  5  6  7  8  9  10");
		System.out.println("");
		for(int c = 0; c < StrikeBoard.length; c++)
		{
			for(int r = 0; r < StrikeBoard[0].length; r++)
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
				if (StrikeBoard[c][r] == -1) {
					System.out.print(StrikeBoard[c][r]+" ");
				}
				else {System.out.print(" "+StrikeBoard[c][r]+" ");}
			}
		System.out.println("");
		}
		System.out.println("_____________________________________");
        System.out.println("");
	}
}
