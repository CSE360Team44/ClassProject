

import java.util.*;



public class Dice
{


	private int minimum = 1;
	private int maximum = 6;

	private int numOfDice;
	private int list[];


	Dice(int numOfDice)
	{
		this.numOfDice =numOfDice;
		list = new int[numOfDice];
	}



	public int[] rollDice()
	{
		for(int i=0;i < numOfDice;i++)
			list[i] = roll();


		return list;

	}




	private int roll()
	{

		Random rand = new Random();
	
		int value =( rand.nextInt((maximum - minimum) + 1) + minimum); 

		return value;

	}




	public static void main(String[] args)
	{

		Dice dice1 = new Dice(6);


		Dice dice2 = new Dice(3);

		int arr1[];
		int arr2[];

		arr1 = dice1.rollDice();
		arr2 = dice2.rollDice();

		for(int i=0;i< arr1.length;i++)
			System.out.print( arr1[i]+" ");		

		
		System.out.print("\n");


		for(int i=0;i< arr2.length;i++)
			System.out.print( arr2[i]+" ");		

		
		System.out.print("\n");

			
	}
}

//--------------------------------------------------------------------------------


import java.util.*;


public class Player
{
    private int score;
    private Dice myDice;
    private String name;
    
    
    
  
    
    public void playerRoll()
    {
        
        
        
        
        
    }
    

    public Player(String name)
    {
        
        score =0;
        myDice = new Dice(6);
        this.name = name;
    }
    
    public int getScore()
    {
        return score;
    }
    
    public void setScore(int score)
    {
        this.score = score;
    }
    
    public String getName()
    {
        return name;
    }   
}


































