import static org.junit.Assert.*;

import org.junit.Test;


public class gameTest {

	@Test
	public void testGame() {
		
		Game gameObj = new Game(2,2000);
		Game gameObj2 = new Game(0,0);
		
		assertNotNull(gameObj);
		assertNotNull(gameObj2);
		
		
	}

	@Test
	public void testSetNames() {
		
		Game gameObj = new Game(2,2000);
		Game gameObj2 = new Game(0,0);
		
		assertNotNull(gameObj2);
		
		assertTrue(gameObj.getCurrentPlayer().getName().equals("fernando"));
		
		
	}

	@Test
	public void testGameRoll() {
		
		Game gameObj = new Game(2,2000);		
		
	}

	@Test
	public void testGetCurrentPlayer() {
		
		//requires the menu class
		
	}

	@Test
	public void testHold() {
		
		//requires The menu class 
	}

	@Test
	public void testGameOver() {
	
		//requires the menu class
		
	}

}
