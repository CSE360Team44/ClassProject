import java.util.*;

public class Dice
{
	private int minimum = 1;
	private int maximum = 6;

	private int numOfDice;
	private int list[];

	Dice(int numOfDice)
	{
		this.numOfDice = numOfDice;
		list = new int[numOfDice];
	}

	public int[] rollDice()
	{
		for(int index = 0; index < numOfDice; index++)
		{
			
			list[index] = roll();
		}

		return list;
		
	}

	private int roll()
	{

		Random rand = new Random();
	
		int value = (rand.nextInt((maximum - minimum) + 1) + minimum); 

		return value;

	}
	
}
