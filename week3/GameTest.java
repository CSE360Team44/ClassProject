import java.io.IOException;

public class GameTest {

	public static void main(String args[])
	{
		// the setNames function and the Game constructor are both tested by creating a new game
		// object and calling the setName function 2 times to name the number of players specified
		Game newGame = new Game(2, 1200);
		
		// tests the gameRoll function by returning the temporary score based on the roll
		try {
			newGame.gameRoll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(newGame.getCurrentPlayer().getTempScore());
		
		// tests the getCurrentPlayer function by returning the name of the current player
		System.out.println(newGame.getCurrentPlayer().getName());
		
		// tests the hold function by indicating whether one is allowed
		
		// roll
		try {
			newGame.gameRoll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// roll
		try {
			newGame.gameRoll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// roll
		try {
			newGame.gameRoll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// roll
		try {
			newGame.gameRoll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(newGame.hold());
		
		// tests the getPlayerScore
		System.out.println(newGame.getPlayerScore());
		
		// tests the getStats function
		System.out.println(newGame.getStats());
		
	}
}
