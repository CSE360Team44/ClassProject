import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Class to read and write winning player names from each game played to a file.  
 * 
 * @author CSE360 Spring 2016 Team 44: Fernando Avalos,
 * 		    		       Maria Castro,
 * 		    	   	       Patricia Evans,
 * 		    		       Anthony Gonzalez,
 * 		    		       Ivan Soledad.
 * @version April 29, 2016
 * 
 */
public class FileIO 
{
	
	/**
	 * readFile - Reads a file line by line and returns arraylist of contents
	 * 
	 * @throws FileNotFoundException						
	 * @param fileName String contains the file name needed to be read
	 * @return list ArrayList<String> contains the contents of the file, a list of winners. 
	 */
	//do not omit file extension for parameter, returns arraylist of file contents
	public static ArrayList<String> readFile(String fileName) throws FileNotFoundException
	{
		
		ArrayList<String> list = new ArrayList<String>();//to hold each line in file
	
		Scanner in1 = new Scanner(new FileReader(fileName));//scaner to read file
		
		while(in1.hasNext())//loop to get all inputs into arraylist
		{
			
			list.add(in1.nextLine());
			
		}
		
		in1.close();
		
		return list;
		
	}
	
	/**
	 * appendIntToFile - Method will write a winner's name to the file on a new line.
	 * 			Will append the line to the file to keep track of game 
	 * 			history. 
	 * 	
	 * @throws IOException						
	 * @param fileName String contains the file name to write. 
	 * 	  lineToWrite String contains the String that is to be written in the file. 
	 */
	//do not omit file extension for parameter, appends line to the file if doesnt exist it creates it.
	public static void appendIntToFile(String fileName, String lineToWrite) throws IOException
	{
		
		FileWriter file = new FileWriter(fileName,true);
		
		file.write(lineToWrite + "\n");
		
		file.close();
		
	}
	
	/**
	 * getHistory - Method to open the file of all past winners. Will add
	 * 			the most recent winner on a new line to the file 
	 * 			by appending the winner's name to String winners. 
	 * 	
	 * @throws FileNotFoundException						
	 * @param none 
	 * @return winners String contains the winners from all games played.
	 */
	public static String getHistory() throws FileNotFoundException
	{
		
		String winners = "";
		
		ArrayList<String> arrayOfWinners =  FileIO.readFile("History.txt");
		
		//loop comnbine each line read by file into q string
		for(int index = 0; index < arrayOfWinners.size(); index++)
		{
			
			winners += arrayOfWinners.get(index) + "\n";	
			
		}
		
		return winners;
		
	}
	
}
