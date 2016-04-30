/**
 * Class to implement player actions in the game. The player class sets and gets the temporary 
 * 		and overall score, 
 * 		Default initialization for private int overallScore, private int tempScore,
 * 		private String name, and private int diceLeft, private boolean turnEnd, 
 * 		private int myRolls[].
 * 
 * 
 * @author CSE360 Spring 2016 Team 44: 
 * 				       Fernando Avalos,
 * 		    		       Maria Castro,
 * 		    	   	       Patricia Evans,
 * 		    		       Anthony Gonzalez,
 * 		    		       Ivan Soledad.
 * @version April 29, 2016
 * 
 */

public class Player
{
	
    private int overallScore;
    private int tempScore;
    private String name;
    private int diceLeft;
    private boolean turnEnd;
    private int myRolls[];
    
    /** 
     * Player - Constructor passes the player's name to initialize the name variable. 
     * 		Initializes the overallScore to 0, the tempScore to 0, 
     * 		diceLeft to 6, and turnEnd to false. 
     * 			
     * @param name Name of player object
     */
    public Player(String name)
    {
    	
        this.overallScore = 0;
        this.tempScore = 0;
        this.name = name;
        this.diceLeft = 6;
        this.turnEnd = false;
        
    }
    
    /**
     * getTempScore - Retrieves temporary score of player during rolls. 
     *
     * @return Temporary score of the player
     */
    public int getTempScore()
    {
    	
        return this.tempScore;
        
    }
    
    /**
     * getoverallScore - Retrieve player's overall score after rolling dice has ended.
     * 
     * @return Overall score of the player after a rolling dice has ended.
     */
    public int getOverallScore()
    {
    	
    	return this.overallScore;
    	
    }
    
    /**
     * setTempScore - Sets player's temporary score.
     * 
     * @param score Present score value from a roll. 
     */
    public void setTempScore(int score)
    {
    	
        this.tempScore = score;
        
    }
    
    /**
     * setOverallScore - Overall score is set to present score.
     * 
     * @param score Score to be set after rolling.
     */
    public void setOverallScore(int score)
    {
    	
    	this.overallScore = score;
    
    }
    
    /**
     * getName - Return the name of a player. 
     * 
     * @return String that contains the name of a player. 
     */
    public String getName()
    {
    	
        return this.name;
   
    }   
    
    /**
     * hold - Function to allow the player to hold and update the player's overall score 
     * 		with the temporary current turn score.
     * 
     * @return boolean indicating whether the player is allowed to hold or not.
     */
    public boolean hold()
    {
    	
    	boolean holdAllowed = false;
    	
        // player is allowed to hold if either their temporary score or their overall score is over 1000
    	if(overallScore >= 1000 || tempScore >= 1000)
    	{
    		
    		overallScore += tempScore;
    		tempScore = 0;
    		turnEnd = true;
    		diceLeft = 6;
            	holdAllowed = true;
            	
    	}
   
    	return holdAllowed;
    	
    }
    
    /**
    * turnEnd - is set to false to indicate the player turn is not over.
    * 
    */
    public void resetTurn()
    {
    	
        this.turnEnd = false;   
        
    }

    /**
     * roll - Rolls the player's dice and adds result to tempScore
     * 
     */
    public void roll()
    {  
    	
    	myRolls = tempRoll();
    	tempScore += computeScore(myRolls);
    	
    }
   
    /*
     * tempRolls - Rolls dice that player has left in their turn.
     *
     * @return Array of numbers 1 - 6 rolled
     */
    private int[] tempRoll()
    {
    	
    	Dice myDice = new Dice(diceLeft);
    	return myDice.rollDice();
    	
    }
    
    
    /**
     * getRoll - getter method for retrieving player's roll
     * 
     * @return myRolls array of player's roll
     */
    public int[] getRoll()
    {
    	
    	return myRolls;
    	
    }
    
    /*
     * computeScore - Rolls dice that player has left
     *
     * @param diceResult array of the results of the dice rolled. 
     * @return returns score of player's roll
     */
    private int computeScore(int diceResult[])
    {
    	
    	int[] count = new int[6];
    	
    	for(int index = 0; index < diceResult.length; index++)
    	{
    		
    		count[diceResult[index] - 1]++;
    		
    	}
    		
    	return analyze(count);
    	
    }
    	
    /*
     * analyze - Uses the count array to determine the amount of puts roled by the player
     * @param count array of occurrences of each dice number
     * @return score Value of the player's roll
     */
    private int analyze(int[] count)
    {
	
	int score = 0;
		
        // score is 1000 if player rolls 1, 2, 3, 4, 5, 6 exactly
        // if not, calculate the score based on the number of 1's, 2's, etc.
	if(doAll(count) == 1000)
	{
		
		score += 1000;
		
	}

	else 
	{
	
		score += doOne(count);
		score += doTwo(count);
		score += doThree(count);
		score += doFour(count);
		score += doFive(count);
		score += doSix(count);
		
	}
    	
        // if score is 0, end the turn and set dice available to roll to 6
	if(score == 0)
	{
		
		turnEnd = true;
		diceLeft = 6;
			
	}
		
        // set dice available to roll to 6, if 0
	if(diceLeft <= 0)
	{
			
		diceLeft = 6;
			
	}
		
	return score;
		
    }
    
    /*
     * doOne - Assign score based on number of 1's rolled
     *
     * @param count array of occurrences of each dice number
     * @return oneScore score according to number of ones rolled
     */
    private int doOne(int[] count)
    {
    	
    	int oneScore = 0;
    	
    	if(count[0] == 1)
    	{
    		
    		oneScore = 100;	
    		
    	}
    		
	else if(count[0] == 2)
	{
			
		oneScore = 200;
		
	}
	
	else if(count[0] == 3)
	{
		
		oneScore = 1000;
		
	}
	
	else if(count[0] == 4)
	{
		
		oneScore = 2000;
		
	}
	
	else if(count[0] == 5)
	{
		
		oneScore = 4000;
		
	}
	
	else if(count[0] == 6)
	{
		
		oneScore = 8000;
		
	}
    		
	diceLeft -= count[0];
    	
    	return oneScore;
    	
    }
    
    /*
     * doTwo - Assign score based on number of 2's rolled
     *
     * @param count array of occurrences of each dice number
     * @return twoScore score according to number of twos rolled
     */
    private int doTwo(int[] count)
    {
    	
    	int twoScore = 0;
    	
    	if(count[1] == 3)
    	{
		
		twoScore = 200;
		
    	}
	
	else if(count[1] == 4)
	{
		
		twoScore = 400;
		
	}
	
	else if(count[1] == 5)
	{
		
		twoScore = 800;
		
	}
			
	else if(count[1] == 6)
	{

		twoScore = 1600;
			
	}
    	
    	if(count[1] >= 3)
    	{
    		
    		diceLeft -= count[1];
    		
    	}
    	
    	return twoScore;
    	
    }
   
    /*
     * doThree - Assign score based on number of 3's rolled
     *
     * @param count array of occurrences of each dice number
     * @return threeScore score according to number of threes rolled
     */
    private int doThree(int[] count)
    {
    	
    	int threeScore = 0;
    	
    	if(count[2] == 3)
    	{
			
		threeScore = 300;
		
    	}
	
	else if(count[2] == 4)
	{
		
		threeScore = 600;
		
	}
	
	else if(count[2] == 5)
	{
			
		threeScore = 1200;
		
	}
	
	else if(count[2] == 6)
	{
			
		threeScore = 2400;
		
	}
    	
    	if(count[2] >= 3)
    	{
    		
    		diceLeft -= count[2];
    		
    	}
    	
    	return threeScore;
    	
    }
    
    /*
     * doFour - Assign score based on number of 4's rolled
     *
     * @param count array of occurrences of each dice number
     * @return fourScore score according to number of fours rolled
     */
    private int doFour(int[] count)
    {
    	
    	int fourScore = 0;
    	
    	if(count[3] == 3)
    	{
    		
		fourScore = 400;
		
    	}
		
	else if(count[3] == 4)
	{
		
		fourScore = 800;
		
	}
	
	else if(count[3] == 5)
	{
			
		fourScore = 1600;
		
	}
		
	else if(count[3] == 6)
	{
		
		fourScore = 3200;
		
	}
    	
    	if(count[3] >= 3)
    	{
    		
    		diceLeft -= count[3];
    		
    	}
    	
    	return fourScore;
    	
    }
    
    /*
     * doFive - Assign score based on number of 5's rolled
     *
     * @param count array of occurrences of each dice number
     * @return fiveScore score according to number of fives rolled
     */
    private int doFive(int[] count)
    {
    	
    	int fiveScore = 0;
    	
    	if(count[4] == 1)
    	{
    	
    		fiveScore = 50;
    		
    	}
	
	else if(count[4] == 2)
	{
		
		fiveScore = 100;
		
	}
	
	else if(count[4] == 3)
	{
		
		fiveScore = 500;
		
	}
	
	else if(count[4] == 4)
	{
		
		fiveScore = 1000;
		
	}
	
	else if(count[4] == 5)
	{
		
		fiveScore = 2000;
		
	}
	
	else if(count[4] == 6)
	{
		
		fiveScore = 4000;
		
	}
    	
    	diceLeft -= count[4];
    	
    	return fiveScore;
    	
    }
    
    /*
     * doSix - Assign score based on number of 6's rolled
     *
     * @param count array of occurrences of each dice number
     * @return sixScore score according to number of sixes rolled
     */
    private int doSix(int[] count)
    {
    	
    	int sixScore = 0;
    	
    	if(count[5] == 3)
    	{
			
		sixScore = 600;
		
    	}
	
	else if(count[5] == 4)
	{
		
		sixScore = 1200;
		
	}
	
	else if(count[5] == 5)
	{
		
		sixScore = 2400;
		
	}
	
	else if(count[5] == 6)
	{
		
		sixScore = 4800;

	}
    	
    	if(count[5] >= 3)
    	{
    		
    		diceLeft -= count[5];
    		
    	}
    	
    	return sixScore;
 
    }
    
    /*
     * doAll - Assign score depending if 1, 2, 3, 4, 5, 6 is rolled
     *
     * @param count array of occurrences of each dice number
     * @return allScore score depending if 1, 2, 3, 4, 5, 6 is rolled
     */
    private int doAll(int[] count)
    {
 
    	int allScore = 1000;
    	
    	for(int index = 0; index < count.length; index++)
    	{
    		
    		if(count[index] != 1)
    		{
    			
    			allScore = 0;
    			
    		}
    		
    	}
    	
    	if(allScore == 1000)
    	{
    		
    		diceLeft = 0;
    		
    	}
    	
    	return allScore;   
    	
    }

    /**
    * getTurnEnd - A flag function to determine whether a player's turn has ended.
    * 
    * @return turnEnd boolean of it the turn has ended
    */
    public boolean getTurnEnd()
    {
    	
        return turnEnd;
        
    }
    
    /**
    * checkWin - Checks for a win. If the sum of the overall score and the temporary score is 
    * 				greater than or equal to the winning score, win is set to true.
    * 				Otherwise, win is false. 
    * 
    * @param winningScore score needed to win the game
    * @return win boolean value that indicates whether there's been a win
    */
    public boolean checkWin(int winningScore)
    {
    	
        boolean win = false;

        // if the overall score and the temporary score added together is greater than or equal to the winning score
        // win is set to true, indicating a win
        if(tempScore + overallScore >= winningScore)
        {
            
            win = true;
            
        }

        return win;

    }

}
