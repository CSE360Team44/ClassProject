import java.util.*;

public class Dice
{
	private int minimum = 1;
	private int maximum = 6;

	private int numOfDice;
	private int list[];

	/**
	* Contructor that creates array of dice
	* @param numOfDice number of dice available to be rolled
	*/
	Dice(int numOfDice)
	{
		this.numOfDice = numOfDice;
		list = new int[numOfDice];
	}


	/**
	* Rolls dice
	* @return list array of rolled integers
	*/
	public int[] rollDice()
	{
		System.out.println("Roll: ");

		// each die is given a random value
		for(int index = 0; index < numOfDice; index++){
			list[index] = roll();

		// the values are printed
		System.out.print(list[index] + " ");
		}

		System.out.println("\n");

		return list;
	}

	/*
	* Random number is rolled
	* @return value random integer generated
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