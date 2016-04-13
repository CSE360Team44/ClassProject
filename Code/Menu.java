import java.util.*;

public class Menu 
{
	public Game newGame;
	
	/**
	 * Prints the menu
	 */
	public void printMenu()
	{
		System.out.print("Menu\n" +
				"1 - roll\n" +
				"2 - new game\n" +
				"3 - view stats\n" +
				"4 - view rules\n" +
				"5 - quit\n" +
				"\n\n\n");
	}
	
	/**
	 * Runs the game's menu
	 */
	public void runMenu()
	{
		Scanner in = new Scanner(System.in);
		int input = 0;
		
		
		
		while(input != 5)
		{
			printMenu();
			
			if(input == 1)
			{
				roll();
			}
			else if(input == 2)
			{
				newGame();
			}
			else if(input == 3)
			{
				viewStats();
			}
			else if(input ==4)
			{
				viewRules();
			}
			
				
			
			
			input = in.nextInt();
			
			
		}
		
		System.out.println("goodbye");
	}
	
	/**
	 * 
	 */
	public void roll()
	{
		System.out.println("roll");
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
	public void main(String[] args)
	{
		runMenu();
		

	}//main end

}//class end


