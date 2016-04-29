import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	// tests the Player constructor
	@Test
	public void testPlayer() {
		Player newPlayer = new Player("Player");
		assertNotNull(newPlayer);
	}

	// tests the getTempScore function
	@Test
	public void testGetTempScore() {
		Player newPlayer = new Player("Player");
		assertEquals(0, newPlayer.getTempScore());
		
	}

	// tests the getOverallScore function
	@Test
	public void testGetOverallScore() {
		Player newPlayer = new Player("Player");
		assertEquals(0, newPlayer.getOverallScore());
	}

	// tests the setTempScore function
	@Test
	public void testSetTempScore() {
		Player newPlayer = new Player("Player");
		newPlayer.setTempScore(600);
		assertEquals(600, newPlayer.getTempScore());
	}

	// tests the setOverallScore function
	@Test
	public void testSetOverallScore() {
		Player newPlayer = new Player("Player");
		newPlayer.setOverallScore(1500);
		assertEquals(1500, newPlayer.getOverallScore());
	}

	// tests the getName function
	@Test
	public void testGetName() {
		Player newPlayer = new Player("John");
		assertEquals("John", newPlayer.getName());
	}

	// tests the hold function
	@Test
	public void testHold() {
		Player newPlayer = new Player("Player");
		newPlayer.setOverallScore(2000);
		assertTrue(newPlayer.hold());
	}

	// tests the resetTurn function
	@Test
	public void testResetTurn() {
		Player newPlayer = new Player("Player");
		newPlayer.roll();
		newPlayer.resetTurn();
		assertFalse(newPlayer.getTurnEnd());
	}

	// tests the roll function
	@Test
	public void testRoll() {
		Player newPlayer = new Player("Player");
		newPlayer.roll();
		assertNotEquals(0, newPlayer.getTempScore());
	}

	// tests the getTurnEnd function
	@Test
	public void testGetTurnEnd() {
		Player newPlayer = new Player("Player");
		newPlayer.roll();
		newPlayer.roll();
		assertTrue(newPlayer.getTurnEnd());
	}

	// tests the checkWin function
	@Test
	public void testCheckWin() {
		Player newPlayer1 = new Player("Tommy");
		Player newPlayer2 = new Player("Timmy");
		
		newPlayer1.setOverallScore(2000);
		newPlayer2.setOverallScore(1000);
		assertTrue(newPlayer1.checkWin(1500));
		assertFalse(newPlayer2.checkWin(1500));
	}
}
