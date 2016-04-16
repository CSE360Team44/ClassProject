import java.util.*;

public class Menu 
{
	public Game newGame;
	public Player me;
	public boolean gameActive = false;
	
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

		while(input != 5)
		{
			
			if(input == 1)
			{
				roll();
			}
			else if(input == 2)
			{
				newGame();
				gameActive = true;
			}
			else if(input == 3)
			{
				viewStats();
			}
			else if(input ==4)
			{
				viewRules();
			}
			else if(input == 6)
			{
				hold();
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
		newGame.gameRoll();
	}

	/**
	* Hold function
	*/
	public void hold()
	{
		newGame.hold();
	}
	
	/**
	 * New Game object is created
	 */
	public void newGame()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("new game");
		
		System.out.println("Specify number of players: ");
		int players = scan.nextInt();
		
		System.out.println("Specify the winning score: ");
		int winningScore = scan.nextInt();
		
		newGame = new Game(players, winningScore);
	}
	
	/**
	 * Shows statistics
	 */
	public void viewStats()
	{
		System.out.println("view stats");
	}
	
	/**
	 * Shows rules
	 */
	public void viewRules()
	{
		System.out.println("view rules");
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


