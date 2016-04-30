import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	// Testing the Player constructor is not null.
	@Test
	public void testPlayerNotNull() {
		
		Player newPlayer = new Player("Player");
		assertNotNull(newPlayer);
		
	}

	// Testing getTempScore when the temporary score is default 0. 
	@Test
	public void testGetTempScoreNull() {
		
		Player newPlayer = new Player("Player");
		assertEquals(0, newPlayer.getTempScore());
	
	}
	
	// Testing setTempScore and getTempScore when set to 0. 
	@Test
	public void testTempScoreZero() {
		
		Player newPlayer = new Player("Player");
		newPlayer.setTempScore(0);
		assertEquals(0, newPlayer.getTempScore());
		
	}
	
	// Testing setTempScore and getTempScore when set to 600.
	@Test
	public void testTempScoreGreaterThanZero() {
		
		Player newPlayer = new Player("Player");
		newPlayer.setTempScore(600);
		assertEquals(600, newPlayer.getTempScore());
		
	}
	
	// Testing setTempScore and getTempScore when setTempScore
	// is called twice to set the temporary score to 1500.
	@Test
	public void testTempScoreMultipleSets() {
		
		Player newPlayer = new Player("Player");
		newPlayer.setTempScore(600);
		newPlayer.setTempScore(1500);
		assertEquals(1500, newPlayer.getTempScore());
		
	}
	
	// Testing getOverallScore when the overall score is default 0.
	@Test
	public void testGetOverallScoreNull() {
		
		Player newPlayer = new Player("Player");
		assertEquals(0, newPlayer.getOverallScore());
		
	}
	
	// Testing setOverallScore and getOverallScore when set to 0. 
	@Test
	public void testOverallScoreZero() {
		
		Player newPlayer = new Player("Player");
		newPlayer.setOverallScore(0);
		assertEquals(0, newPlayer.getOverallScore());
		
	}
	
	// Testing setOverallScore and getOverallScore when set to 1000.
	@Test
	public void testOverallScoreGreaterThanZero() {
		
		Player newPlayer = new Player("Player");
		newPlayer.setOverallScore(1000);
		assertEquals(1000, newPlayer.getOverallScore());
		
	}
	
	// Testing setOverallScore and getOverallScore when setOverallScore
	// is called three to set the temporary score to 4000.
	@Test
	public void testOverallScoreMultipleSets() {
		
		Player newPlayer = new Player("Player");
		newPlayer.setOverallScore(600);
		newPlayer.setOverallScore(1500);
		newPlayer.setOverallScore(4000);
		assertEquals(4000, newPlayer.getOverallScore());
		
	}

	// Testing getName to return the name John. 
	@Test
	public void testGetName() {
		
		Player newPlayer = new Player("John");
		assertEquals("John", newPlayer.getName());
		
	}

	// Testing hold method. Player is able to hold when their overall score 
	// is greater than 1000.
	
	@Test
	public void testHoldTrue() {
		
		Player newPlayer = new Player("Player");
		newPlayer.setOverallScore(2000);
		assertTrue(newPlayer.hold());
		
	}
	
	// Testing hold method. Player is able to hold when their overall score 
	// is greater than 1000. Setting overall to 500 and then 2000 for hold
	// to still be implemented. 
	
	@Test
	public void testHoldTrueMultipleScores() {
		
		Player newPlayer = new Player("Player");
		newPlayer.setOverallScore(500);
		newPlayer.setOverallScore(2000);
		assertTrue(newPlayer.hold());
		
	}
	
	// Testing hold method. Player is not able to hold when their overall  
	// score is less than 1000.
	@Test
	public void testHoldFalse() {
			
		Player newPlayer = new Player("Player");
		newPlayer.setOverallScore(300);
		assertFalse(newPlayer.hold());
			
	}
	
	// Testing hold method. Player is not able to hold when their overall  
	// score is less than 1000. Setting overall to 3000 and then 700 for hold
	// to not be implemented. 
	@Test
	public void testHoldFalseMultipleScores() {
			
		Player newPlayer = new Player("Player");
		newPlayer.setOverallScore(3000);
		newPlayer.setOverallScore(700);
		assertFalse(newPlayer.hold());
			
	}

	// tests the resetTurn function
	@Test
	public void testResetTurn() {
		
		Player newPlayer = new Player("Player");
		newPlayer.roll();
		newPlayer.resetTurn();
		assertFalse(newPlayer.getTurnEnd());
		
	}

	// Testing the roll does not return a null value. 
	// Roll is random and score is not able to assertEquals. 
	@Test
	public void testRoll() {
		
		Player newPlayer = new Player("Player");
		newPlayer.roll();
		assertNotNull(newPlayer.getTempScore());
		
	}
	
	// Testing multiple rolls do not return a null value. 
	// Roll is random and score is not able to assertEquals. 
	@Test
	public void testRollMultipleRolls() {
		
		Player newPlayer = new Player("Player");
		newPlayer.roll();
		newPlayer.roll();
		newPlayer.roll();
		assertNotNull(newPlayer.getTempScore());
		
	}

	// Testing getTurnEnd to end the turn. A turn will end  
	// when the overall score is greater than 1000 and the player holds. 
	@Test
	public void testGetTurnEndTrue() {
		
		Player newPlayer = new Player("Player");
		newPlayer.setOverallScore(2000);
		assertTrue(newPlayer.hold());
		assertTrue(newPlayer.getTurnEnd());
		
	}
	
	// Testing getTurnEnd to end the turn. A turn will end  
	// when the overall score is greater than 1000 and the player holds.
	// Setting the overall to lower than 1000 two times and then setting 
	// it over 1000 to assert that the turn will still end. 
	@Test
	public void testGetTurnEndTrueMultipleScores() {
		
		Player newPlayer = new Player("Player");
		newPlayer.setOverallScore(800);
		newPlayer.setOverallScore(300);
		newPlayer.setOverallScore(2000);
		assertTrue(newPlayer.hold());
		assertTrue(newPlayer.getTurnEnd());
		
	}
	
	// Testing getTurnEnd to not end the turn. A turn will not end  
	// when the overall score is less than 1000 and the player is unable to hold. 
	@Test
	public void testGetTurnEndFalse() {
		
		Player newPlayer = new Player("Player");
		newPlayer.setOverallScore(100);
		assertFalse(newPlayer.hold());
		assertFalse(newPlayer.getTurnEnd());
		
	}
	
	// Testing getTurnEnd to not end the turn. A turn will not end  
	// when the overall score is less than 1000 and the player is unable to hold.
	// Setting the overall to lower than 1000 two times and then setting 
	// it over 1000 to assert that the turn will still end. 
	@Test
	public void testGetTurnEndFalseMultipleScores() {
		
		Player newPlayer = new Player("Player");
		newPlayer.setOverallScore(3000);
		newPlayer.setOverallScore(200);
		newPlayer.setOverallScore(600);
		assertFalse(newPlayer.hold());
		assertFalse(newPlayer.getTurnEnd());
		
	}

	// Testing checkWin for no players reaching the score required
	// to win the game.
	@Test
	public void testCheckWinNoWinner() {
		
		Player newPlayer1 = new Player("John");
		Player newPlayer2 = new Player("Timmy");
		Player newPlayer3 = new Player("Barry");
		
		newPlayer1.setOverallScore(300);
		newPlayer2.setOverallScore(1000);
		newPlayer3.setOverallScore(600);
		assertFalse(newPlayer1.checkWin(2000));
		assertFalse(newPlayer2.checkWin(2000));
		assertFalse(newPlayer3.checkWin(2000));
		
	}
	
	// Testing checkWin for a winner with the exact score required 
	// to win the game.
	@Test
	public void testCheckWinExactScore() {
		
		Player newPlayer1 = new Player("John");
		Player newPlayer2 = new Player("Timmy");
		
		newPlayer1.setOverallScore(1500);
		newPlayer2.setOverallScore(1000);
		assertTrue(newPlayer1.checkWin(1500));
		assertFalse(newPlayer2.checkWin(1500));
		
	}
	
	// Testing checkWin for a winner with a score over the amount
	//required to win the game.
	@Test
	public void testCheckWinOverScore() {
		
		Player newPlayer1 = new Player("John");
		Player newPlayer2 = new Player("Timmy");
		Player newPlayer3 = new Player("Scott");
		Player newPlayer4 = new Player("May");
		
		newPlayer1.setOverallScore(1500);
		newPlayer2.setOverallScore(4500);
		newPlayer3.setOverallScore(10000);
		newPlayer4.setOverallScore(0);
		assertFalse(newPlayer1.checkWin(8000));
		assertFalse(newPlayer2.checkWin(8000));
		assertTrue(newPlayer3.checkWin(8000));
		assertFalse(newPlayer4.checkWin(8000));
		
	}
	
}
