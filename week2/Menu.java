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
	public String viewRules()
	{
		return "  
1. Number of player required: 2\n\n 
2. The turns shifts from player to player if the following happens:\n
      	The player loses their points (*)\n
      	The player decided to hold (**)\n
 (*) The player loses his/her points if in the dice they roll, no dice of value 1 or 5 are rolled, and if in the dice that are rolled, no triples of any value are rolled.
(**) For a player to be able to hold, that player must have first amassed a minimum of 1000 points. From this point on this player can hold, if so desired, and let the next player exercise their roll. \n\n
3. The Point System:\n
	The die values that are worth something, individually, are the values of 1 and 5. Otherwise, to get any points in this game, at least 3 of any value have to be rolled.\n
	There is a special case described at the bottom(*) that when rolled is worth 1000 points. \n
	 The point system is broken down as the following:\n\n  

	1 = 100 points		5 = 50 points\n 

	One 1 		100 points\n 
	Three 1 	1000 points\n 
	Four 1		2000 points\n 
	Five 1		4000 points\n 
	Six 1		8000 points\n \n 

	Three 2	        200 points\n 
	Four 2		400 points\n 
	Five 2		800 points\n 
	Six 2		1600 points\n \n 

	Three 3	        300 points\n 
	Four 3		600 points\n 
	Five 3		1200 points\n 
	Six 3		2400 points\n \n 

	Three 4	        400 points\n 
	Four 4		800 points\n 
	Five 4		1600 points\n 
	Six 4		3200 points\n \n 

	One 5		50  points\n 
	Three 5	        500 points\n 
	Four 5		1000 points\n 
	Five 5		2000 points\n 
	Six 5		4000 points\n \n 

	Three 6	        600 points\n 
	Four 6		1200 points\n 
	Five 6		2400 points\n 
	Six 6		4800 points\n\n  

	A roll of 1, 2, 3, 4, 5, 6 on the dice is a 1000 points(*)\n  "; 
		//System.out.println("View Rules: Not Yet Implemented\n");
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


