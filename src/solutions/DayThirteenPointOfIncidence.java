package solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

public class DayThirteenPointOfIncidence 
{
	private static Logger _logger = System.getLogger("TestLogger");
	public static void main(String[] args)
	{
		String filePath = "C:\\dev\\fun-projects\\advent-of-code-2023\\src\\inputs\\day_two_input.txt";
		File file = new File(filePath);
		if(file.exists())
		{
			try
			{			
				FileReader reader = new FileReader(file);
				BufferedReader input = new BufferedReader(reader);
				String line = input.readLine();
				
				int result = 0;
				
				while (line != null)
				{
					// Solution here
					
					
					line = input.readLine();
				}
				
				input.close();
				System.out.println(result);
			}
			catch (Exception e)
			{
				_logger.log(Level.WARNING, e.getStackTrace());
			}
		}
	}
}
