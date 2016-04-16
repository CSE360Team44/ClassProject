import java.util.*;

/**
 * Class to test the implementation of random dice rolls.  
 * 		private int minimum initialized to 1 (lowest number on dice). 
 * 		private int maximum initialized to 6 (highest number on dice).
 * 		Default initialization for private int numOfDice and private int list[].
 * 		Default initialization for private int riggedList[]. riggedList[] is only used
 * 		for testing purposes - unable to test for expected and actual random values
 * 		so dice rolls are also "rigged".
 * 
 * @author CSE360 Spring 2016 Team 44: Fernando Avalos,
 * 		    		       			   Maria Castro,
 * 		    	   	       			   Patricia Evans,
 * 		    		       			   Anthony Gonzalez,
 * 		    		       			   Ivan Soledad.
 * @version April 15, 2016
 * 
 */
public class DiceTesting
{
	
	private int minimum = 1;
	private int maximum = 6;

	private int numOfDice;
	private int list[];
	private int riggedList[];

	/**
	 * DiceTesing - Constructor initializes the number of dice being rolled and 
	 * 			the array size of list to the number of dice being rolled. 
	 * 			Also implements unit testing or random dice rolls and rigged dice rolls. 
	 * 				
	 * @param numOfDice int the number of dice being rolled.  
	 */
	DiceTesting(int numOfDice)
	{
		
		this.numOfDice = numOfDice;
		list = new int[numOfDice];
		riggedList = new int[numOfDice];
			
		rollDice();
		
		System.out.println("--Random Number--");
		int randRoll = roll();
		System.out.println("roll(): " + randRoll);
		System.out.print("rollDice(): ");
		
		for(int index = 0; index < numOfDice; index++)
		{
			
			System.out.print(list[index] + " ");
			
		}
		
		System.out.println("\n");
		
		System.out.println("--Rigged Number--");
		int riggedDice = riggedRoll(3);
		System.out.println("riggedRoll(): " + riggedDice);
		riggedRollDice(3);
		System.out.print("riggedRollDice(): ");
		for(int index = 0; index < numOfDice; index++)
		{
			
			System.out.print(riggedList[index] + " ");
			
		}
		
		System.out.println("\n");
		testingRiggedRoll(3, riggedRoll(3));
		
		String expectedTestRoll = "";
		
		for(int index = 0; index < numOfDice; index++){
			
			expectedTestRoll += "3 ";
			
		}
		
		String actualTestRoll = printList(riggedList);
	
		
		testingRiggedRollDice(expectedTestRoll, actualTestRoll);
		
		System.out.println("\n");
		
		riggedRollDice(roll());
		System.out.println("--    Validate rigged logic   --");
		System.out.println("-- using single random number --");
		System.out.print("riggedRollDice(roll()): ");
		
		for(int index = 0; index < numOfDice; index++)
		{
			
			System.out.print(riggedList[index] + " ");
			
		}
		
		System.out.println();
		
		
	}
	
	public static void main (String args[])
	{
		System.out.println("---------------------------------------");
		System.out.println("\tBegin Testing");
		System.out.println("---------------------------------------\n\n");
		
		System.out.println("\tTesting Six Rolls.");
		System.out.println("---------------------------------------");
		new DiceTesting(6);
		System.out.println("---------------------------------------");
		
		System.out.println("\tTesting Five Rolls.");
		System.out.println("---------------------------------------");
		new DiceTesting(5);
		System.out.println("---------------------------------------");
		
		System.out.println("\tTesting Four Rolls.");
		System.out.println("---------------------------------------");
		new DiceTesting(4);
		System.out.println("---------------------------------------");
		
		System.out.println("\tTesting Three Rolls.");
		System.out.println("---------------------------------------");
		new DiceTesting(3);
		System.out.println("---------------------------------------");
		
		System.out.println("\tTesting Two Rolls.");
		System.out.println("---------------------------------------");
		new DiceTesting(2);
		System.out.println("---------------------------------------");
		
		System.out.println("\tTesting One Roll.");
		System.out.println("---------------------------------------");
		new DiceTesting(1);
		System.out.println("---------------------------------------");
		
		System.out.println("---------------------------------------");
		System.out.println("\tEnd Testing");
		System.out.println("---------------------------------------\n\n");
		
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
		
		for(int index = 0; index < numOfDice; index++)
		{
			
			list[index] = roll();
			
		}

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

		Random rand = new Random();
	
		int value = (rand.nextInt((maximum - minimum) + 1) + minimum); 

		return value;

	}
	
	/**
	 * riggedRoll - private method used only for testing purposes to compare
	 * 					actual and tested values. Sets value equal to input 
	 * 					(an integer within range of 1 - 6).
	 * 				
	 * @param riggedNum int input of a roll value. 
	 * @return value int returns an integer number. 
	 */
	private int riggedRoll(int riggedNum)
	{
	
		int value = riggedNum; 

		return value;

	}
	
	/**
	 * riggedRollDice - public method that iterates through the list array inserting a roll value
	 * 				until the number of dice rolled has been reached.
	 * 						
	 * @param riggedNum int input of a roll value. 
	 * @return list int[] the list of face values of each die rolled. 
	 */
	public int[] riggedRollDice(int riggedNum) 
	{
		
		int value = riggedNum;
		
		for(int index = 0; index < numOfDice; index++)
		{
			
			riggedList[index] = riggedRoll(value);
			
		}

		return riggedList;
		
	}	
	
	/**
	 * testingRiggedRoll - testing method that checks if the expected rigged roll matches the actual rigged roll. 
	 * 						
	 * @param expectedRoggedRoll int expected rigged roll. 
	 * 		  actualRiggedRoll int actual rigged roll. 
	 * @return none 
	 */
	public void testingRiggedRoll(int expectedRiggedRoll, int actualRiggedRoll){
		
		if(expectedRiggedRoll == actualRiggedRoll){
			
			System.out.println("Expected rigged roll " + expectedRiggedRoll + " matches the actual rigged roll " + actualRiggedRoll);
			
		}
		
		else{
			
			System.out.println("Expected rigged roll " + expectedRiggedRoll + " does not match the actual rigged roll " + actualRiggedRoll);
			
		}
	}
	
	/**
	 * testingRiggedRollDice - testing method that checks if the expected rigged rolls listed matches the actual rigged rolls listed.
	 * 						
	 * @param expectedRoggedRollDice String expected rigged rolls.
	 * 		  actualRiggedRollDice String actual rigged rolls.
	 * @return none 
	 */
	public void testingRiggedRollDice(String expectedRiggedRollDice, String actualRiggedRollDice){
		
		if(expectedRiggedRollDice.equals(actualRiggedRollDice)){
			
			if(expectedRiggedRollDice.equals("") && actualRiggedRollDice.equals("")){
				
				expectedRiggedRollDice = "\"\"";
				actualRiggedRollDice = "\"\"";
				
				System.out.println("Expected rigged dice rolls " + expectedRiggedRollDice + "matches the actual rigged dice rolls " + actualRiggedRollDice);
			
			}
			
			else{
				
				System.out.println("Expected rigged dice rolls " + expectedRiggedRollDice + "matches the actual rigged dice rolls " + actualRiggedRollDice);
				
			}
			
		}
		
		else{
			
			System.out.println("Expected rigged dice rolls " + expectedRiggedRollDice +  "does not match the actual rigged dice rolls " + actualRiggedRollDice);
			
		}
	
		
	}
		
	/**
	 * printList - converts the list of integer rolls into a String list of the rolls. 
	 * 						
	 * @param rollList int[] the array that contains all the face values of each roll. 
	 * @return  listString String contains the list of the rolls. 
	 */
	public String printList(int[] rollList){
		
		String listString = "";
		
			for(int index = 0; index < numOfDice; index++){
			
				int rolledNum = rollList[index];
				String rollNumString = Integer.toString(rolledNum);
				listString = listString + rollNumString + " ";
				
			}
					
		return listString;
		
	}

}