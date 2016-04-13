import java.util.*;

public class Player
{
	
	private int overallScore;
	private int tempScore;
	private String name;
	private int diceLeft;
	private boolean turnEnd;
    
    public Player(String name)
    {
    	
        this.overallScore = 0;
        this.tempScore = 0;
        this.name = name;
        this.diceLeft = 0;
        this.turnEnd = false;
        
    }
    
    public int getTempScore()
    {
    	
        return this.tempScore;
        
    }
    
    public int getOverallScore()
    {
    	
    	return this.overallScore;
    	
    }
    
    public void setTempScore(int score)
    {
    	
        this.tempScore = score;
        
    }
    
    public void setOverallScore(int score)
    {
    	
    	this.overallScore = score;
    	
    }
    
    public String getName()
    {
    	
        return this.name;
        
    }   
    
    public int roll()
    {  
    	
    	int myRolls[] = tempRoll();
    	
    	return computeScore(myRolls);
    	
    }
    
    public int[] tempRoll()
    {
    	
    	Dice myDice = new Dice(diceLeft);
    	
    	return myDice.rollDice();
    	
    }
    
    //needs to update turnEnd and diceLeft
    private int computeScore(int diceResult[])
    {
    	
    	int[] count = new int[6];
    	
    	for(int index = 0; index < diceResult.length; index++)
    	{
    		count[diceResult[index] - 1]++;
    		
    	}
    	
    }
    	
}
