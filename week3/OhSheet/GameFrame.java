import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
 * Class to implement game frame this class will hold the actual game window
 * 
 * 
 * @author CSE360 Spring 2016 Team 44: 
 * 				      Fernando Avalos,
 * 		    		       Maria Castro,
 * 		    	   	       Patricia Evans,
 * 		    		       Anthony Gonzalez,
 * 		    		       Ivan Soledad.
 * @version April 29, 2016
 * 
 */


public class GameFrame extends JFrame
{
	
	private Game newGame;
	private boolean gameFinished = false;
	private int roll[];
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	//creates a gameFrame application to run our program
	// in try catch block to prevent errors
	public static void main(String[] args) 
	{
		
		EventQueue.invokeLater(new Runnable()
		{
			
			public void run() 
			{
				
				try 
				{
					
					GameFrame frame = new GameFrame(newGameFrame.getWinningScore(), newGameFrame.getNumberOfPlayers());
					frame.setVisible(true);
					
				} 
				catch (Exception e) 
				{
					
					e.printStackTrace();
					
				}
				
			}
			
		});
		
	}
	

	/**
	 * Create the frame.
	 */
	//creates game object , and allows the game to run
	public GameFrame(int gameWinningScore, int numberOfPlayers)
	{
		
		//create needed objects for constructor
		roll = new int[1];
		String[] playerNames = new String[numberOfPlayers];
		playerNames = this.getPlayerNames();
		this.newGame = new Game(numberOfPlayers, gameWinningScore, playerNames);
		
		//create panels for game start window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//create label for player score
		JLabel lblPlayerScore = new JLabel("Player Score: " + newGame.getCurrentPlayer().getOverallScore());
		lblPlayerScore.setToolTipText("your overall score");
		lblPlayerScore.setForeground(new Color(153, 51, 255));
		lblPlayerScore.setFont(new Font("Javanese Text", Font.BOLD, 14));
		lblPlayerScore.setBounds(50, 72, 149, 40);
		contentPane.add(lblPlayerScore);
		
		//create label for player score
		JLabel lblTurnScore = new JLabel("Turn Score: " + newGame.getCurrentPlayer().getOverallScore());
		lblTurnScore.setToolTipText("points earned this turn");
		lblTurnScore.setForeground(new Color(153, 51, 255));
		lblTurnScore.setFont(new Font("Javanese Text", Font.BOLD, 14));
		lblTurnScore.setBounds(50, 123, 149, 40);
		contentPane.add(lblTurnScore);
		
		//create label for player score
		JLabel lblCurrentPlayer = new JLabel(newGame.getCurrentPlayer().getName());
		lblCurrentPlayer.setToolTipText("your name");
		lblCurrentPlayer.setForeground(new Color(153, 51, 255));
		lblCurrentPlayer.setFont(new Font("Sitka Small", Font.BOLD, 15));
		lblCurrentPlayer.setBounds(50, 11, 222, 50);
		contentPane.add(lblCurrentPlayer);
		
		//create hold button and assign action
		JButton btnHold = new JButton("Hold");
		btnHold.setForeground(new Color(153, 51, 255));
		btnHold.setToolTipText("hold your points");
		
		btnHold.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e)
			{
				
				if(!(newGame.hold()))//action not allowed
				{
					
					JOptionPane.showMessageDialog(null, "Cannot hold. Keep rolling!");
				
				}
			
				lblCurrentPlayer.setText(newGame.getCurrentPlayer().getName());
				lblTurnScore.setText("Turn Score: " + newGame.getTurnScore());
				lblPlayerScore.setText("Player Score: " + newGame.getTotalScore());
				
			}
			
		});
		
		
		btnHold.setBounds(260, 106, 122, 42);
		contentPane.add(btnHold);
		
		//create button for view rules and assign action
		JButton btnViewRules = new JButton("View Rules");
		btnViewRules.setForeground(new Color(153, 51, 255));
		btnViewRules.setToolTipText("view the game rules");
		
		btnViewRules.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent arg0)
			{
				
				//Creating and setting Test format
				JTextArea rulesArea = new JTextArea(newGameFrame.viewRules(), 35, 75);
				rulesArea.setLineWrap(true);
				rulesArea.setWrapStyleWord(true);
				rulesArea.setEditable(false);
				
				//Setting text into a scroll pane
				JScrollPane scrollRules = new JScrollPane(rulesArea);
				
				//Displaying rules information
				JOptionPane.showMessageDialog(null, scrollRules, "Rules", JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		});
		
		//create roll button and action action listener
		JButton btnRoll = new JButton("Roll");
		btnRoll.setForeground(new Color(153, 51, 255));
		btnRoll.setToolTipText("roll your dice");
		
		btnRoll.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent arg0)
			{
				
				try 
				{
					
					gameFinished = newGame.gameRoll();	//Roll the players dice and check if game finished
					roll = newGame.getCurrentPlayer().getRoll(); //obtains the player's roll
					
					String tempStr = "";
					
					//Prints out the players roll
					if(roll != null)
					{	
						
						for(int index = 0; index < roll.length; index++)
						{
							
							tempStr += roll[index] + " ";
							
						}
						
						//print the player name and what they rolled
						JOptionPane.showMessageDialog(null, newGame.getCurrentPlayer().getName() + " rolled " + tempStr);
				
					}	
				} 
				catch(IOException exception)
				{
					
					//do nothing
					
				}
				
				//If the game is finished, close the application
				//else, update the GUI
				if(gameFinished)
				{
					
					JOptionPane.showMessageDialog(null, newGame.getCurrentPlayer().getName() + " has won!\n" + "With a scroe of " + (newGame.getCurrentPlayer().getOverallScore() + newGame.getCurrentPlayer().getTempScore()) + "!\n" + "Congradulations!");
					System.exit(0);
					
				}
				else 
				{
					
					lblCurrentPlayer.setText(newGame.getCurrentPlayer().getName());
					lblTurnScore.setText("Turn Score: " + newGame.getTurnScore());
					lblPlayerScore.setText("Player Score: " + newGame.getTotalScore());
				
				}
				
			}
			
		});
		
		//set params for buttons
		
		btnRoll.setBounds(260, 36, 122, 42);
		contentPane.add(btnRoll);

		btnViewRules.setBounds(75, 197, 135, 30);
		contentPane.add(btnViewRules);
		
		//create button for scoreboard
		JButton btnViewScoreboard = new JButton("View Scoreboard");
		btnViewScoreboard.setForeground(new Color(153, 51, 255));
		btnViewScoreboard.setToolTipText("view the current players scores");
		
		btnViewScoreboard.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e)
			{
				
				JTextArea scoreArea = new JTextArea(newGame.getStats(), 35, 35);
				JScrollPane scrollBoard = new JScrollPane(scoreArea);
				JOptionPane.showMessageDialog(null, scrollBoard, "Scoreboard", JOptionPane.INFORMATION_MESSAGE);
		
			}
			
		});
		
		btnViewScoreboard.setBounds(216, 197, 135, 30);
		contentPane.add(btnViewScoreboard);
		
	}
	
	//get player name, from user and store
	private String[] getPlayerNames() 
	{
		
		String[] playerNames = new String[newGameFrame.getNumberOfPlayers()];
		
		for(int index = 0; index < newGameFrame.getNumberOfPlayers(); index++) 
		{
			
			playerNames[index] = JOptionPane.showInputDialog("Enter name of player " + (index + 1));
			
		}
		
		return playerNames;
		
	}
	
}
