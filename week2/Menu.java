import java.util.*;
import java.io.FileNotFoundException;

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
	public void runMenu() throws FileNotFoundException
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
				//if(gameActive)
					System.out.println(viewRules());
				//else
					//4System.out.println("No Game Active\n");
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
	public void roll() throws FileNotFoundException
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
		return " 1. Number of player required: 2\n\n "
				+ "2. The turns shifts from player to player if the following happens:\n"
				+ "\tThe player loses their points (*)\n"
				+ "\tThe player decided to hold (**)\n"
				+ "\t(*) The player loses his/her points if in the dice they roll, no dice of value 1 or 5 are rolled, and if in the dice that are rolled, no triples of any value are rolled.\n"
				+ "\t(**) For a player to be able to hold, that player must have first amassed a minimum of 1000 points. From this point on this player can hold, if so desired, and let the next player exercise their roll. \n\n"
				+ "3. The Point System:\n"
				+ "\tThe die values that are worth something, individually, are the values of 1 and 5. Otherwise, to get any points in this game, at least 3 of any value have to be rolled.\n"
				+ "\tThere is a special case described at the bottom(***) that when rolled is worth 1000 points. \n"
				+ "\tThe point system is broken down as the following:\n\n  "
				+ "\t\t1 = 100 points		5 = 50 points\n\n "
				+ "\t\tOne 1 		100 points\n "
				+ "\t\tThree 1 	1000 points\n "
				+ "\t\tFour 1		2000 points\n "
				+ "\t\tFive 1		4000 points\n "
				+ "\t\tSix 1		8000 points\n \n "
				+ "\t\tThree 2	        200 points\n "
				+ "\t\tFour 2		400 points\n "
				+ "\t\tFive 2		800 points\n "
				+ "\t\tSix 2		1600 points\n \n "
				+ "\t\tThree 3	        300 points\n "
				+ "\t\tFour 3		600 points\n "
				+ "\t\tFive 3		1200 points\n "
				+ "\t\tSix 3		2400 points\n \n "
				+ "\t\tThree 4	        400 points\n "
				+ "\t\tFour 4		800 points\n "
				+ "\t\tFive 4		1600 points\n "
				+ "\t\tSix 4		3200 points\n \n "
				+ "\t\tOne 5		50  points\n "
				+ "\t\tThree 5	        500 points\n "
				+ "\t\tFour 5		1000 points\n "
				+ "\t\tFive 5		2000 points\n "
				+ "\t\tSix 5		4000 points\n \n "
				+ "\t\tThree 6	        600 points\n "
				+ "\t\tFour 6		1200 points\n "
				+ "\t\tFive 6		2400 points\n "
				+ "\t\tSix 6		4800 points\n\n  "
				+ "(***)A roll of 1, 2, 3, 4, 5, 6 on the dice is a 1000 points\n  "; 
		//System.out.println("View Rules: Not Yet Implemented\n");
	}
	
	/**
	 * Runs the program
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		// menu object start is created
		Menu start = new Menu();

		// start is run
		start.runMenu();
		

	}//main end

}//class end


