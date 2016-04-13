import java.util.Scanner;

public class Game{
	
	public Player players[];
	
	/**
	 * Constructor that creates a new Game
	 * @param playersNum number of players in the game
	 * @param winScore score needed to win the game
	 */
	Game(int playersNum, int winScore)
	{
		players = new Player[playersNum];
		int currentPlayer = 0;
		int winningScore = winScore;
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
	public void roll()
	{
		
	}
	
	/**
	 * Function that implements hold
	 */
	public void hold()
	{
		
	}
	
	/**
	 * Function that checks if the game is over
	 * @return
	 */
	public boolean isGameOver()
	{
		return false;
	}
	
	/** 
	 * Function that goes to next player
	 * @return
	 */
	private int nextPlayer()
	{
		return 0;
	}
}
