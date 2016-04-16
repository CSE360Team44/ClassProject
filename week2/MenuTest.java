import static org.junit.Assert.*;

import org.junit.Test;

public class MenuTest {

	@Test
	public void testPrintMenu() {
		Menu test = new Menu();
		test.printMenu();
	}
	
	@Test
	public void testRunMenu() {
		Menu test = new Menu();
		test.runMenu();
	}

	@Test
	public void testRoll() {
		Menu test = new Menu();
		test.newGame();
	}

	@Test
	public void testHold() {
		Menu test = new Menu();
		test.newGame();
		assertEquals(test.newGame.hold(), false);
	}

	@Test
	public void testNewGame() {
		Menu test = new Menu();
		test.newGame();
		assertNotNull(test.newGame);
	}

	@Test
	public void testViewStats() {
		Menu test = new Menu();
		test.viewStats();
	}

	@Test
	public void testViewRules() {
		Menu test = new Menu();
		test.viewRules();
	}
}
