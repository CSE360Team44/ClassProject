import java.util.*;

/**
 * Class to implement random dice rolls.  
 * 		private int minimum initialized to 1 (lowest number on dice). 
 * 		private int maximum initialized to 6 (highest number on dice).
 * 		Default initialization for private int numOfDice and private int list[].
 * 
 * @author CSE360 Spring 2016 Team 44: Fernando Avalos,
 * 		    		       Maria Castro,
 * 		    	   	       Patricia Evans,
 * 		    		       Anthony Gonzalez,
 * 		    		       Ivan Soledad.
 * @version April 15, 2016
 * 
 */
public class Dice
{
	private int minimum = 1;
	private int maximum = 6;

	private int numOfDice;
	private int list[];

	/**
	 * Dice - Constructor initializes the number of dice being rolled and 
	 * 			the array size of list to the number of dice being rolled. 
	 * 				
	 * @param numOfDice int the number of dice being rolled.  
	 */
	Dice(int numOfDice)
	{
		
		this.numOfDice = numOfDice;
		list = new int[numOfDice];
		
	}

	/**
	 * rollDice - public method that iterates through the list array inserting a roll value
	 * 				until the number of dice rolled has been reached.
	 * 						
	 * @param none
	 * @return list int[] the list of face values of each die rolled. 
	 */
	public int[] rollDice()
	{
		System.out.print("Roll: ");

		// each die is given a random value
		for(int index = 0; index < numOfDice; index++){
			
			list[index] = roll();

			// the values are printed
			System.out.print(list[index] + " ");
		
		}

		System.out.println("\n");

		return list;
	
	}

	/**
	 * roll - private method that generates a random number from 1 (the minimum value of a die)
	 * 				to 6 (the maximum value of a die).
	 * 				
	 * @param none
	 * @return value int a random number between 1 and 6. 
	 */
	private int roll()
	{

		// random object rand is created
		Random rand = new Random();
	
		// rand generates a random number 1 - 6
		int value = (rand.nextInt((maximum - minimum) + 1) + minimum); 

		return value;

	}

}
