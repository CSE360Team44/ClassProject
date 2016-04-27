package a;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.Scanner;

/*
 * note 
 * 
 * any funciton that uses readFile must throw FileNotFoundException
 * 
 * any functuon that uses writeLineToFile must throw IOExceptiom
 * 
 * do not omit file extensions, Example use "file1.txt" not "file1" as paramiters
 * 
 * these methods are assuming the files you will use are in your project directory not you src directory
 * exapmle if your procect name it Test, these files are in /Test/.
 * 
 * */

public class Test 
{
	//do not omit file extension for paramiter, returns arraylist of file contents
	public static ArrayList<String> readFile(String fileName) throws FileNotFoundException
	{
		ArrayList<String> list = new ArrayList<String>();//to hold each line in file
	
		Scanner in1 = new Scanner(new FileReader(fileName));//scaner to read file
		
		while(in1.hasNext())
			list.add(in1.nextLine());
		
		
		in1.close();
		
		return list;
	}
	
	//do not omit file extension for paramiter, appends line to the file if doesnt exist it creates it
	public static void writeLineToFile(String fileName, String lineToWrite) throws IOException
	{
		
		
			FileWriter file = new FileWriter(fileName,true);
		
		
			file.write(lineToWrite);
		
			file.close();
		
		
	}
	
	
	
	
	
}
