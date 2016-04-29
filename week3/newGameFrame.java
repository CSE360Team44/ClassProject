import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.SystemColor;

public class newGameFrame 
{

	private static int gameWinningScore;
	private static int numberOfPlayers;
	private JFrame frame;

	

	/**
	 * Launch the application.
	 */
	//entry point of our program, creates game window and allows setup to begin
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					newGameFrame window = new newGameFrame();
					window.frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public newGameFrame() {
		initialize();
	}

	/*
	 * Initialize the contents of the frame.
	 */
	// prompts user for needed input, and starts our game window by setting all layour params
	private void initialize()
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 204, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//create label of game title,
		JLabel lblOhSheet = new JLabel("Oh Sheet!");
		lblOhSheet.setForeground(new Color(102, 0, 153));
		lblOhSheet.setHorizontalAlignment(SwingConstants.CENTER);
		lblOhSheet.setFont(new Font("Leelawadee UI Semilight", Font.BOLD | Font.ITALIC, 48));
		lblOhSheet.setBounds(55, 11, 301, 75);
		frame.getContentPane().add(lblOhSheet);
		
		//create button for new game  and add behavior for it
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setBackground(UIManager.getColor("PasswordField.selectionBackground"));
		btnNewGame.setForeground(new Color(153, 102, 204));
		btnNewGame.setToolTipText("Start a new game\r\n");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					gameWinningScore = getGameWinningScore();
					numberOfPlayers = getNumOfPlayers();
					
					frame.dispose();
					GameFrame gameFrame = new GameFrame(gameWinningScore, numberOfPlayers);	//PASS gameWinningScore and numberOfPlayers AS ARGUMENTS
					gameFrame.setVisible(true);
					
				}catch(NumberFormatException exception) {
					 JOptionPane.showMessageDialog(null, "Please enter an integer");
				}catch(InvalidScoreException exception) {
					JOptionPane.showMessageDialog(null, "Please use a number greater than 1000.\nSee rules for details");
				}catch(InvalidNumOfPlayersException exception) {
					JOptionPane.showMessageDialog(null, "Number of players must be 2 or greater.\nSee rules for details");
				}
			}
		});
		
		btnNewGame.setFont(new Font("Impact", Font.PLAIN, 13));
		btnNewGame.setBounds(152, 97, 106, 42);
		frame.getContentPane().add(btnNewGame);
		
		//create button for new game  and add behavior for it
		JButton btnViewStats = new JButton("View History");
		btnViewStats.setBackground(UIManager.getColor("PasswordField.selectionBackground"));
		btnViewStats.setForeground(new Color(153, 102, 204));
		btnViewStats.setToolTipText("View previous game winners");
		btnViewStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//Creating and setting Test format
					JTextArea historyArea = new JTextArea(FileIO.getHistory(), 35, 50);
					historyArea.setLineWrap(true);
					historyArea.setWrapStyleWord(true);
					historyArea.setEditable(false);
					
					//Setting text into a scroll pane
					JScrollPane scrollRules = new JScrollPane(historyArea);
					
					//Displaying rules information
					JOptionPane.showMessageDialog(null, scrollRules, "History of Winners", JOptionPane.INFORMATION_MESSAGE);
					
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, "There is no history of winners to view");
				}
			}
		});
		btnViewStats.setFont(new Font("Impact", Font.PLAIN, 13));
		btnViewStats.setBounds(152, 150, 106, 42);
		frame.getContentPane().add(btnViewStats);
		
		JButton btnViewRules = new JButton("View Rules");
		btnViewRules.setBackground(UIManager.getColor("PasswordField.selectionBackground"));
		btnViewRules.setForeground(new Color(153, 102, 204));
		btnViewRules.setToolTipText("View game rules");
		btnViewRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Creating and setting Test format
				JTextArea rulesArea = new JTextArea(viewRules(), 35, 75);
				rulesArea.setLineWrap(true);
				rulesArea.setWrapStyleWord(true);
				rulesArea.setEditable(false);
				
				//Setting text into a scroll pane
				JScrollPane scrollRules = new JScrollPane(rulesArea);
				
				//Displaying rules information
				JOptionPane.showMessageDialog(null, scrollRules, "Rules", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnViewRules.setFont(new Font("Impact", Font.PLAIN, 13));
		btnViewRules.setBounds(152, 203, 106, 42);
		frame.getContentPane().add(btnViewRules);
	}

	//get game winning score from user input
	private int getGameWinningScore() throws InvalidScoreException {		
		int gameWinningScore = Integer.parseInt(JOptionPane.showInputDialog("Enter Game Winning Score"));
			
		if(gameWinningScore < 1000)
			throw new InvalidScoreException();
				
		return gameWinningScore;
	}
	
	//get number of players from user input
	private int getNumOfPlayers() throws InvalidNumOfPlayersException {
		int numberOfPlayers = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of players"));
		
		if(numberOfPlayers < 2)
			throw new InvalidNumOfPlayersException();
		
		return numberOfPlayers;
	}

	/**
	 * Function for acquiring the rules of the game
	 * @return String containing game rules
	 */
	//print game rules
	public static String viewRules() {
		return 	"Oh Sheet gains its name from elderly Mexican woman that upon loseing a roll would shout Oh $#!+, but their accencts made it sound like Oh Sheet!\n\n"
				+ "1. Number of player required: 2+\n\n "
				+ "2. The turns shifts from player to player if the following happens:\n"
				+ "\tThe player loses their points (*)\n"
				+ "\tThe player decided to hold (**)\n\n"
				+ "3. The Point System:\n"
				+ "\tThe indiviual die values that are worth points are the values of 1 and 5.\n"
				+ "\tOtherwise, at least 3+ of any value have to be rolled.\n"
				+ "\tThere is a special case described at the bottom that when rolled is worth 1000 points (***)\n\n"
				+ "4. Game winning score must be 1000 or greater.\n\n"
				+ "\tThe point system is broken down as the following:\n\n"
				+ "\t\tOne 1 \t 100 points\n "
				+ "\t\tThree 1's \t 1000 points\n "
				+ "\t\tFour 1's \t 2000 points\n "
				+ "\t\tFive 1's \t 4000 points\n "
				+ "\t\tSix 1's \t 8000 points\n \n "
				+ "\t\tThree 2's \t 200 points\n "
				+ "\t\tFour 2's \t 400 points\n "
				+ "\t\tFive 2's \t 800 points\n "
				+ "\t\tSix 2's \t 1600 points\n \n "
				+ "\t\tThree 3's \t 300 points\n "
				+ "\t\tFour 3's \t 600 points\n "
				+ "\t\tFive 3's \t 1200 points\n "
				+ "\t\tSix 3's \t 2400 points\n \n "
				+ "\t\tThree 4's \t 400 points\n "
				+ "\t\tFour 4's \t 800 points\n "
				+ "\t\tFive 4's \t 1600 points\n "
				+ "\t\tSix 4's \t 3200 points\n \n "
				+ "\t\tOne 5 \t 50  points\n "
				+ "\t\tThree 5's \t 500 points\n "
				+ "\t\tFour 5's \t 1000 points\n "
				+ "\t\tFive 5's \t 2000 points\n "
				+ "\t\tSix 5's \t 4000 points\n \n "
				+ "\t\tThree 6's \t 600 points\n "
				+ "\t\tFour 6's \t 1200 points\n "
				+ "\t\tFive 6's \t 2400 points\n "
				+ "\t\tSix 6's \t 4800 points\n\n"
				+ "(*)The player loses his/her points if in the dice they roll, no dice of value 1 or 5 are rolled, and if in the dice that are rolled, no triples of any value are rolled.\n\n"
				+ "(**)For a player to be able to hold, that player must have first amassed a minimum of 1000 points. From this point on this player can hold, if so desired, and let the next player exercise their roll.\n\n"
				+ "(***)A roll of 1, 2, 3, 4, 5, 6 on the dice is a 1000 points\n"; 
	}//end viewRules()
	
	//we created this to prevent errors in our windwow
	@SuppressWarnings("serial")
	private class InvalidScoreException extends Exception{
		public InvalidScoreException(){
			super();
		}
	}
	
	//we created this to prevent errors in our windwow
	@SuppressWarnings("serial")
	private class InvalidNumOfPlayersException extends Exception{
		public InvalidNumOfPlayersException(){
			super();
		}
	}
	
	/**
	 * Function to return game winning score set by the players
	 * @return Game winning score
	 */
	public static int getWinningScore(){
		return gameWinningScore;
	}
	
	/**
	 * Function to return number of players set by the players
	 * @return Number of players
	 */
	public static int getNumberOfPlayers(){
		return numberOfPlayers;
	}
}
