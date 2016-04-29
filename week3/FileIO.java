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
 * @version April 27, 2016
 * 
 */
public class FileIO 
{
	
	/**
	 * 
	 * 	
	 * @throws FileNotFoundException						
	 * @param fileName String
	 * @return list ArrayList<String> 
	 */
	//do not omit file extension for parameter, returns arraylist of file contents
	// reads a file line by line and returns arraylist of contents
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
	 *   
	 * 	
	 * @throws IOException						
	 * @param fileName String
	 * 	  lineToWrite String
	 */
	//do not omit file extension for parameter, appends line to the file if doesnt exist it creates it
	// wrte a line to a file
	public static void appendIntToFile(String fileName, String lineToWrite) throws IOException
	{
		
		FileWriter file = new FileWriter(fileName,true);
		
		file.write(lineToWrite + "\n");
		
		file.close();
		
	}
	
	/**
	 * 
	 * 	
	 * @throws FileNotFoundException						
	 * @param none 
	 * @return winners String
	 */
	//open file of past winners, return contents in string
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
