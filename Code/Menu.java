import java.util.*;

public class Menu 
{
	
	public static void printMenu()
	{
		System.out.print("Menu\n" +
				"1 - roll\n" +
				"2 - new game\n" +
				"3 - view stats\n" +
				"4 - view rules\n" +
				"5 - quit\n" +
				"\n\n\n");
	}
	
	public static void runMenu()
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
	
	public static void roll()
	{
		
		System.out.println("roll");
	
	}
	
	public static void newGame()
	{
	
		System.out.println("new game");
	
		
	}
	
	public static void viewStats()
	{
		
		System.out.println("view stats");
	
	}
	
	public static void viewRules()
	{
		
		
		System.out.println("view rules");
	}
	
	public static void main(String[] args)
	{
		
		runMenu();
		
	}//main end

}//class end
