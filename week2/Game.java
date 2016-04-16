import java.util.Scanner;

public class Game{
	
	private int winningScore;
	private int currentPlayer;
	private Player players[];
	
	/**
	 * Constructor that creates a new Game
	 * @param playersNum number of players in the game
	 * @param winScore score needed to win the game
	 */
	Game(int playersNum, int winScore)
	{
		players = new Player[playersNum];
		currentPlayer = 0;
		winningScore = winScore;
		setNames(players);
	}

	/**
	 * Sets the names of the players
	 * @param array array of players
	 */
	public void setNames(Player[] array)
	{
		Scanner scan = new Scanner(System.in);
		String name = "";
		
		// each player is prompted for their name
		for(int index = 0; index < array.length; index++)
		{
			System.out.println("Enter your name: ");
			name = scan.nextLine();
			array[index] = new Player(name);
		}
		players = array;
	}

	/**
	 * Function that implements roll
	 */
	public void gameRoll()
	{
		// current player rolls
		players[currentPlayer].roll();

		// checks if the current player has surpassed the winning score
		// if they have, the game is over
		if(players[currentPlayer].checkWin(winningScore))
			this.gameOver();

		// if they haven't, set the temporary score to 0 and the turn ends
		// once the turn ends, go to next player
		if(players[currentPlayer].getTurnEnd())
		{
			players[currentPlayer].setTempScore(0);
			nextPlayer();
		}
	}

	/**
	* Gets the current player
	* @return players[currentPlayer] the current player in the player array
	*/
	public Player getCurrentPlayer()
	{
		return players[currentPlayer];
	}
	
	/**
	 * Function that implements the hold function
	 */
	public boolean hold()
	{
		// held = whether one has held
		boolean held = false;

		// if the current player holds, save their score and go to next player
		if (players[currentPlayer].hold())
		{
			held = true;			
			nextPlayer();
		}
		return held;
	}
	
	/**
	 * Function that checks if the game is over
	 * @return
	 */
	public void gameOver()
	{
		System.out.println("Game over");

		// printStats is called to print the players' scores and display the winner
		printStats();
	}
	
	// prints the players' names and scores
	private void printStats()
	{
		for(int index = 0; index < players.length; index++)
		{
			System.out.println(players[index].getName() + " " + players[index].getOverallScore());

		}
	}

	/** 
	 * Function that goes to next player
	 * @return
	 */
	private void nextPlayer()
	{
		players[currentPlayer].resetTurn();

		currentPlayer++;

		if(currentPlayer >= players.length)
			currentPlayer = 0;
	}
	
}
