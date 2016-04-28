import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Class to implement game play. The game class creates a game with the number of player inputed,
 * 		and input of the winning score. Players are created with a name and their scores 
 * 		updated. Game class checks if the winning score has been reached. 
 * 		Default initialization for private int winningScore, private int currentPlayer,
 * 		private Player players[], and private String stats.
 * 
 * @author CSE360 Spring 2016 Team 44: Fernando Avalos,
 * 		    		       Maria Castro,
 * 		    	   	       Patricia Evans,
 * 		    		       Anthony Gonzalez,
 * 		    		       Ivan Soledad.
 * @version April 27, 2016
 * 
 */
public class Game{
	
	private int winningScore;
	private int currentPlayer;
	private Player players[];
	private String stats;
	
	/**
	 * Game - Constructor initializes the Player array size based on the number of 
	 * 		players input to play the game, the index of the current player to be used
	 * 		in the array, the number of points inputted to win the game, and setting each 
	 * 		player with a name. 
	 * 				
	 * @param playersNum int the number of players playing the game.
	 * 	  winScore int the number of point required to win the game. 
	 */
	Game(int playersNum, int winScore)
	{
		players = new Player[playersNum];
		currentPlayer = 0;
		winningScore = winScore;
		setNames(players);
	}

	/**
	 * setNames - iterates through the player array inserting the
	 * 		name entered by the user. 
	 * 						
	 * @param array Player[] contains a list of the player names in the game. 
	 */
	public void setNames(Player[] array)
	{
		Scanner scan = new Scanner(System.in);
		String name = "";
		
		// each player is prompted for their name
		for(int index = 0; index < array.length; index++)
		{
			System.out.print("Enter your name: ");
			name = scan.nextLine();

			System.out.println("\n");

			array[index] = new Player(name);
		}
		players = array;
	}

	/**
	 * gameRoll - Current player rolls, the score is checked for winning score, 
	 * 	           the winning score and player is stored in a textfile, and
	 * 		   gameFinished will be set to true.
	 * 		   If the player has not yet won and the turn has ended,
	 * 		   the temp score is 0, the next player can roll, and 
	 *  		   gameFinished remains false. 
	 * 	
	 * @throws IOException						
	 * @param none
	 * @return gameFinished boolean a flag that will become true when the game has finished. 
	 */
	public boolean gameRoll() throws IOException 
	{
		
		boolean gameFinished = false;

		// current player rolls
		players[currentPlayer].roll();

		// checks if the current player has surpassed the winning score
		// if they have, the game is over
		if(players[currentPlayer].checkWin(winningScore))
		{
			
			storeResult(players[currentPlayer].getName());
			System.out.println("Game over\n");
			//this.gameOver();
			gameFinished = true;
			
		}

		// if they haven't, set the temporary score to 0 and the turn ends
		// once the turn ends, go to next player
		if(players[currentPlayer].getTurnEnd() &&  players[currentPlayer].checkWin(winningScore) == false)
		{
			
			players[currentPlayer].setTempScore(0);
			nextPlayer();
		
		}
		
		System.out.print("your overall score is now : " + players[currentPlayer].getOverallScore() + 
				"\nyour temp score is now " + players[currentPlayer].getTempScore() + "\nyour name is " + players[currentPlayer].getName()
				+ "\n");
		
		updateStats();
		
		return gameFinished;
	
	}

	/**
	* getCurrentPlayer - Returns the current player in the players array using the currentPlayer
	* 			variable as the index.
	* 
	* @return players[currentPlayer] Player the current player contained in the players array
	*/
	public Player getCurrentPlayer()
	{
		
		return players[currentPlayer];

	}
	
	/**
	* hold - Returns a value of true if the player holds dice, and false if the player continues
	* 			with their rolls. If the player holds, the score is recorded and the 
	* 			player will have their turn. 
	* 
	* @return held boolean a flag that will become true if the player holds on their dice roll 
	* 			and false if the player continues to roll. 
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
	private void gameOver() throws FileNotFoundException
	{
		//System.out.println("Game over\n");

		PrintWriter outputFile = new PrintWriter ("View Stats.txt");
		// printStats is called to print the players' scores and display the winner
		for(int index = 0; index < players.length; index++)
		{
			outputFile.println(players[index].getName() + " " + players[index].getOverallScore() + "\n");

		}
		printStats();
		outputFile.close();
	}
	
	/**
	 * printStats - iterates through the players array printing the name and
	 * 		score of the user. 
	 * 						
	 * @param none
	 */
	private void printStats()
	{
		for(int index = 0; index < players.length; index++)
		{
			System.out.println(players[index].getName() + " " + players[index].getOverallScore() + "\n");
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

	public int getPlayerScore()
	{
		return players[currentPlayer].getTempScore() + players[currentPlayer].getOverallScore();
	}
	
	private void storeResult(String winnersName) throws IOException
	{
				
		FileIO.appendIntToFile("History.txt", winnersName);
	}
		
	private void updateStats()
	{
		stats = "";
		for(int index = 0; index < players.length; index++)
		{
			stats += players[index].getName() + " " + players[index].getOverallScore() + "\n";
		}
		
	}
	
	public String getStats()
	{
		return stats;
	}
	
	
}
