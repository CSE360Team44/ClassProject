import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testPlayer() {
		Player newPlayer = new Player("Player");
		assertNotNull(newPlayer);
	}

	@Test
	public void testGetTempScore() {
		Player newPlayer = new Player("Player");
		assertEquals(0, newPlayer.getTempScore());
		
	}

	@Test
	public void testGetOverallScore() {
		Player newPlayer = new Player("Player");
		assertEquals(0, newPlayer.getOverallScore());
	}

	@Test
	public void testSetTempScore() {
		Player newPlayer = new Player("Player");
		newPlayer.setTempScore(600);
		assertEquals(600, newPlayer.getTempScore());
	}

	@Test
	public void testSetOverallScore() {
		Player newPlayer = new Player("Player");
		newPlayer.setOverallScore(1500);
		assertEquals(1500, newPlayer.getOverallScore());
	}

	@Test
	public void testGetName() {
		Player newPlayer = new Player("John");
		assertEquals("John", newPlayer.getName());
	}

	@Test
	public void testHold() {
		Player newPlayer = new Player("Player");
		newPlayer.setOverallScore(2000);
		assertTrue(newPlayer.hold());
	}

	@Test
	public void testResetTurn() {
		Player newPlayer = new Player("Player");
		newPlayer.roll();
		newPlayer.resetTurn();
		assertFalse(newPlayer.getTurnEnd());
	}

	@Test
	public void testRoll() {
		Player newPlayer = new Player("Player");
		newPlayer.roll();
		assertNotEquals(0, newPlayer.getTempScore());
	}

	@Test
	public void testGetTurnEnd() {
		Player newPlayer = new Player("Player");
		newPlayer.roll();
		newPlayer.roll();
		assertTrue(newPlayer.getTurnEnd());
	}

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
