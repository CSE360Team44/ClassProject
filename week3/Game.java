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
 * 
 * @author CSE360 Spring 2016 Team 44: 
 * 				       Fernando Avalos,
 * 		    		       Maria Castro,
 * 		    	   	       Patricia Evans,
 * 		    		       Anthony Gonzalez,
 * 		    		       Ivan Soledad.
 * @version April 29, 2016
 * 
 */
public class Game
{
	
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
	Game(int playersNum, int winScore, String[] playerNames)
	{
		
		players = new Player[playersNum];
		currentPlayer = 0;
		winningScore = winScore;
		setNames(playerNames);
		
	}

	/**
	 * setNames - iterates through the player array inserting the
	 * 		name entered by the user. 
	 * 						
	 * @param array Player[] contains a list of the player names in the game. 
	 */
	private void setNames(String[] playerNames)
	{
		
		Player[] tempPlayers = new Player[playerNames.length];
		
		// each players name is set to an object
		for(int index = 0; index < playerNames.length; index++)
		{
			
			tempPlayers[index] = new Player(playerNames[index]);
			
		}
		
		players = tempPlayers;
		
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
			gameFinished = true;
			
		}

		// if they haven't, set the temporary score to 0 and the turn ends
		// once the turn ends, go to next player
		if(players[currentPlayer].getTurnEnd() &&  players[currentPlayer].checkWin(winningScore) == false)
		{
			
			players[currentPlayer].setTempScore(0);
			nextPlayer();
		
		}
		
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
	 * nextPlayer - The turn is reset for the current player and the index variable
	 * 			currentPlayer is incremented to move to the next player in
	 * 			game. If currentPlayer index is incremented greater than
	 * 			the amount of players, currentPlayer is set to 0 (the index
	 * 			of the first player).
	 * 	
	 * @param none
	 */
	private void nextPlayer()
	{
		players[currentPlayer].resetTurn();

		currentPlayer++;

		if(currentPlayer >= players.length)
		{
			
			currentPlayer = 0;
			
		}
			
	}

	
	/**
	 * Function for retrieving the current player's turn score
	 * @return The current player's current turn score
	 */
	public int getTurnScore()
	{
		
		return players[currentPlayer].getTempScore();
		
	}
	
	/**
	 * Function for retrieving the current player's total score
	 * @return The current player's total score
	 */
	public int getTotalScore()
	{
		
		return players[currentPlayer].getOverallScore();
		
	}
	
	/**
	 * getPlayerScore - Returns the result of the current player's stored overall score 
	 * 			with their temporary score.
	 * 	
	 * @param none
	 * @return playerScore int a number containing the sum of the current player's temporary
	 * 				and overall score. 
	 */
	public int getPlayerScore()
	{
		
		//int playerScore = players[currentPlayer].getTempScore() + players[currentPlayer].getOverallScore();
		//return playerScore;
		return players[currentPlayer].getTempScore() + players[currentPlayer].getOverallScore();
		
	}
	
	/**
	 * storeResult - The winner's name is written to the file "History.txt". 
	 * 			"History.txt" can be appended and will contain all
	 * 			winners of each game played. 
	 * 
	 * @throws IOException
	 * @param winnersName String a string of the winner's name.
	 */
	private void storeResult(String winnersName) throws IOException
	{
				
		FileIO.appendIntToFile("History.txt", winnersName);
		
	}
	
	/**
	 * updateStats - Iterates through the players array and appends to the string variable, stats. 
	 * 			The statistics of each player is on a new line and has the player name
	 * 			and score. 
	 * 
	 * @param none
	 */	
	private void updateStats()
	{
		stats = "";
		
		for(int index = 0; index < players.length; index++)
		{
			
			stats += players[index].getName() + " " + players[index].getOverallScore() + "\n";
			
		}
		
	}
	
	/**
	 * getStats - Returns the statistics of each player in the game. 
	 * 		 	Statistics are the player's name and score. 	
	 * 	
	 * @param none
	 * @return stats String a string that contains on a new line each players statistics, 
	 * 				their name and score. 
	 */
	public String getStats()
	{
		
		return stats;
		
	}
	
}
