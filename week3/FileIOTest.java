import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*; 
import java.io.*;

public class FileIOTest
{
	
	//Test 1: Testing readFile to read a file that does not exist.
	//Test 2: Testing readFile to append to a file that doesn not exist. 
	@Test
	public void testReadFile()
	{
		
		/*Test 1 trying to read file that doesn't exist*/
		try
		{
			
			FileIO.readFile("null.txt");
			
		}
		
		catch(FileNotFoundException e)
		{
			
			System.out.println("test 1 passed");
			
		}
		 
		/*Test 2 trying to read file that does exist*/
		ArrayList<String> list =  new ArrayList<String>();
		String str="";
		
		try 
		{
		
			FileIO.appendIntToFile("fileB.txt", "hello");
			list = FileIO.readFile("fileB.txt");
			
		}
		
		catch(FileNotFoundException e)
		{
		
			System.out.println("test failed");
		
		}
		
		catch(IOException e)
		{ 
			
			System.out.println("test failed");
		
		}
	
		str = list.get(0);
		
		int result = str.compareTo("hello");
		
		assertTrue(result == 0);
		
	}

	//Testing appendIntToFile if appending to file is functional.
	@Test
	public void testAppendIntToFile()
	{
	
		try
		{
	
			FileIO.appendIntToFile("fileB.txt", "hello");
	
		}
	
		catch(IOException e)
		{
	
			fail("exception was thrown");
	
		}
		
	}
	
}
