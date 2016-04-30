import java.io.IOException;

public class gameTest {

	public static void main(String args[]) throws IOException
	{
		
		final int numOfPlayers = 2;
		
		final int gameWinningScore1 = 50000;
		final int gameWinningScore2 = 1000;
		final int gameWinningScore3 = 1000000;
		final int gameWinningScore4 = 1000000;
		final int gameWinningScore5 = 1000000;
		final int gameWinningScore6 = 1000000;
		final int gameWinningScore7 = 1000000;
		
		String names[] = {"Jim", "John"};

		Game newGame1 = new Game(numOfPlayers, gameWinningScore1, names);
		Game newGame2 = new Game(numOfPlayers, gameWinningScore2, names);
		Game newGame3 = new Game(numOfPlayers, gameWinningScore3, names);
		Game newGame4 = new Game(numOfPlayers, gameWinningScore4, names);
		Game newGame5 = new Game(numOfPlayers, gameWinningScore5, names);
		Game newGame6 = new Game(numOfPlayers, gameWinningScore6, names);
		Game newGame7 = new Game(numOfPlayers, gameWinningScore7, names);
		
		
		
		
		
		
		
		
		
		
		//Test Game compiler constructed object properly
		System.out.println("Testing if Game constructor does not return null object");
		if(newGame1 == null)
			System.out.println("Test Failed\n");
		else
			System.out.println("Test Passed\n");
		
		
		
		
		
		//Testing if current player is null
		Player currentPlayer = newGame1.getCurrentPlayer();
		System.out.println("Testing if currentPlayer is not null");
		if(currentPlayer == null)
			System.out.println("Test Failed\n");
		else
			System.out.println("Test Passed\n");
		
		
		
		
		
		//Testing gameRoll to see if the gameFinishes
		System.out.println("Testing gameRoll to check if the game does not finish");
		if(!newGame1.gameRoll())
			System.out.println("Game not finished.\nTest Passed\n");
		else
			System.out.println("Game finished.\nTest Failed\n");
		
		
		
		
		
		//Testing that game will eventually finish with enough time.
		System.out.println("Testing that a game can eventually be completed");
		boolean finished = false;
		int count = 0;
		do{
			count++;
			finished = newGame2.gameRoll();
			if(finished == true)
				System.out.println("Game finished. Took " + count + " tries.\nTest Passed\n");
			
		}while(!finished);
		
		
		
		
		
		//Testing that a player cannot hold
		System.out.println("Testing that a player cannot hold");
		if(newGame3.hold() == false)
			System.out.println("Player could not hold.\nTest Passed\n");
		else
			System.out.println("Player held.\nTest Failed\n");
		
		
		
		
		
		//Testing that the player can hold
		System.out.println("Testing that the player can hold");
		boolean held = false;
		int iterations = 0;
		do{
			iterations++;
			newGame3.gameRoll();
			held = newGame3.hold();
			if(held == true)
				System.out.println("Player was able to hold. Took " + iterations + " tries.\nTest Passed\n");
				
		}while(!held);
		
		
		
		
		
		//Testing that the Players Turn Score is 0
		System.out.println("Testing that the Players Turn Score can be 0");
		if(newGame4.getTurnScore() == 0)
			System.out.println("Test Passed\n");
		else
			System.out.println("Test Failed\n");
		
		
		
		
		
		//Testing that the Players Turn Score is not 0
		System.out.println("Testing that the Players Turn Score can be not 0");
		int iterations2 = 0;
		boolean gotScore = false;
		do{
			iterations2++;
			newGame4.gameRoll();
			if(newGame4.getTurnScore() != 0){
				System.out.println("Turn score is not 0. took " + iterations2 + " tries.\nTest Passed\n");
				gotScore = true;
			}
				
		}while(!gotScore);
		
		
		
		
		
		//Testing that the Players Total Score is 0
		System.out.println("Testing that the Players Total Score can be 0");
		if(newGame5.getTotalScore() == 0)
			System.out.println("Test Passed\n");
		else
			System.out.println("Test Failed\n");
		
		
		
		
		
		//Testing that the Players Total Score is not 0
		System.out.println("Testing that the Players Total Score can be not 0");
		int iterations3 = 0;
		boolean gotScore1 = false;
		do{
			iterations3++;
			newGame5.gameRoll();
			if(newGame5.hold())
				if(newGame5.getTotalScore() != 0){
					System.out.println("Total score is not 0. took " + iterations3 + " tries.\nTest Passed\n");
					gotScore1 = true;
				}
		}while(!gotScore1);
		
		
		
		
		
		//Testing that the Players Overall Score is 0
		System.out.println("Testing that the Players Overall Score is 0");
		if(newGame6.getPlayerScore() == 0)
			System.out.println("Test Passed\n");
		else
			System.out.println("Test Failed\n");
		
		
		
		
		
		//Testing that the Players Overall Score is not 0
		System.out.println("Testing that the Overall Total Score can be not 0");
		int iterations4 = 0;
		boolean gotScore2 = false;
		do{
			iterations4++;
			newGame6.gameRoll();
			if(newGame6.hold())
				if(newGame6.getPlayerScore() != 0){
					System.out.println("Overall score is not 0. took " + iterations4 + " tries.\nTest Passed\n");
					gotScore2 = true;
				}
		}while(!gotScore2);
		
		
		
		
		
		//Testing that stats are returned and not null after values have been added.
		System.out.println("Testing that stats are returned not null");
		for(int index = 0; index < 100; index++){
			newGame7.gameRoll();
			newGame7.hold();
		}
		
		if(newGame7.getStats() != null)
			System.out.println("Test Passed\n");
		else
			System.out.println("Test Failed\n");
			
		
		
		
		
		//Testing that stats are returned and not empty.
		System.out.println("Testing that stats are returned not empty after values have been added");
		if(newGame7.getStats() != "")
			System.out.println("Test Passed\n");
		else
			System.out.println("Test Failed\n");
	}
}