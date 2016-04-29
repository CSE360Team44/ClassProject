package a;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*; 
import java.io.*;

public class FileIOTest
{
	@Test
	public void testReadFile()
	{
		
		/*test 1 trying to read file that doestn exist*/
		try
		{
			FileIO.readFile("null.txt");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("test 1 passed");
		}
		 
		
		/*test 2 trying to read file that does exist*/
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
