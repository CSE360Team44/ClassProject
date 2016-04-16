import java.util.*;

public class Menu 
{
	public Game newGame;
	public Player me;
	public boolean gameActive = false;
	public boolean gameFinished = false;
	
	/**
	 * Prints the menu
	 */
	public void printMenu()
	{

		// while the game is active print the following menu
		if(gameActive)
			System.out.println("Player: " + me.getName() + "\tOverall Score: " + me.getOverallScore() + "\tTemp Score: " + me.getTempScore());

		System.out.print("Menu\n" +
				"1 - roll\n" +
				"2 - new game\n" +
				"3 - view stats\n" +
				"4 - view rules\n" +
				"5 - quit\n" +
				"6 - hold\n" +
				"\n\n\n");
	}
	
	/**
	 * Runs the game's menu
	 */
	public void runMenu()
	{
		Scanner in = new Scanner(System.in);
		int input;
		
		// menu is printed
		printMenu();
		
		input = in.nextInt();

		while(input != 5 && gameFinished == false)
		{
			
			if(input == 1)
			{
				if(gameActive)
					roll();
				else
					System.out.println("No Game Active\n");
			}
			else if(input == 2)
			{
				if(!gameActive)
				{
					newGame();
					gameActive = true;
				}else
					System.out.println("Game already in session\n");
			}
			else if(input == 3)
			{
				if(gameActive)
					viewStats();
				else
					System.out.println("No Game Active\n");
			}
			else if(input == 4)
			{
				if(gameActive)
					viewRules();
				else
					System.out.println("No Game Active\n");
			}
			else if(input == 6)
			{
				if(gameActive)
					hold();
				else
					System.out.println("No Game Active\n");
			}
			
			// if game is active, get the current player
			if(gameActive)
				me = newGame.getCurrentPlayer();

			// menu is printed
			printMenu();

			// wait for input
			input = in.nextInt();
			
		}
		
		System.out.println("goodbye");
	}
	
	/**
	 * Roll function
	 */
	public void roll()
	{
		gameFinished = newGame.gameRoll();
	}

	/**
	* Hold function
	*/
	public void hold()
	{
		int currentScore = newGame.getPlayerScore();

		if(newGame.hold())
		{
			System.out.println("Turn Held");
			System.out.println("Current Score: " + currentScore + "\n");
		}else
		{
			System.out.println("Cannot hold turn at this time. Continue Rolling!\n");
		}
	}
	
	/**
	 * New Game object is created
	 */
	public void newGame()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("New Game!");
		
		System.out.print("Specify number of players: ");
		int players = scan.nextInt();

		System.out.println("\n");
		
		System.out.print("Specify the winning score: ");
		int winningScore = scan.nextInt();

		System.out.println("\n");
		
		newGame = new Game(players, winningScore);
	}
	
	/**
	 * Shows statistics
	 */
	public void viewStats()
	{
		System.out.println("View Stats: Not Yet Implemented\n");
	}
	
	/**
	 * Shows rules
	 */
	public void viewRules()
	{
		System.out.println("View Rules: Not Yet Implemented\n");
	}
	
	/**
	 * Runs the program
	 * @param args
	 */
	public static void main(String[] args)
	{
		// menu object start is created
		Menu start = new Menu();

		// start is run
		start.runMenu();
		

	}//main end

}//class end


