import static org.junit.Assert.*;

public class PlayerTest
{

	public void testPlayer()
	{
		Player p = new Player("Andrew");


		//assume name from player class is public
		assertEquals( "Andrew",p.getName());

		
		
	}

	public void testGetTempScore()
	{
		Player p = new Player("Andrew");

		//assume temp score from player class is public
		assertEquals(0, p.getTempScore());
	}

	public void testGetOverallScore()
	{
		Player p = new Player("Andrew");


		//assume overall score from player class is public
		assertEquals(0, p.getOverallScore());

	}

	public void testSetTempScore()
	{
		Player p = new Player("Andrew");

	
		p.setTempScore(51);
		
		assertEquals(51, p.getTempScore());

	}

	public void testSetOverallScore()
	{
	
		Player p = new Player("Andrew");

	
		p.setOverallScore(51);
		
		assertEquals(51, p.getOverallScore());		

	}

	public void testGetName()
	{
		Player p = new Player("Andrew");
		
		assertTrue( p.getName().equals("Andrew"));

		
	}

	public void testHold()
	{
		
	}

	public void testRoll()
	{
	
	}

	public void testTempRoll()
	{
	
	}

	public void testComputeScore()
	{
	
	}

	public void testAnalyze()
	{
	
	}

	public void testDoOne()
	{
	
	}

	public void testDoTwo()
	{
	
	}

	public void testDoThree()
	{
		//cannot test because a private test is required.
	}	


	public void testDoFour()
	{
		//cannot test because a private test is required.
	}

	public void testDoFive()
	{
		//cannot test because a private test is required.
	}

	public void testDoSix()
	{
		//cannot test because a private test is required.

	}

	public void testDoAll()
	{
		//cannot test because a private test is required.

	}

}//class end