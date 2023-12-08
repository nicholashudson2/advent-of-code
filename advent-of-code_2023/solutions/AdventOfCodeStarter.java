package advent_of_code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

public class AdventOfCodeStarter {

	
	private static Logger _logger = System.getLogger("TestLogger");
	public static void main(String[] args)
	{
		String filePath = "C:\\Users\\ni.hudson\\eclipse-workspace\\advent_of_code\\src\\advent_of_code\\day_four_input.txt";
		File file = new File(filePath);
		if(file.exists())
		{
			try
			{			
				FileReader reader = new FileReader(file);
				BufferedReader input = new BufferedReader(reader);
				String pairOfElves = input.readLine();
				
				int fullyOverlappingElfPairs = 0;
				
				while (pairOfElves != null)
				{
					String[] elfRanges = pairOfElves.split(",");
					String[] firstElf = elfRanges[0].split("-");
					String[] secondElf = elfRanges[1].split("-");
					
					if (isOneRangeContainedByOther(Integer.parseInt(firstElf[0]), Integer.parseInt(firstElf[1]), Integer.parseInt(secondElf[0]), Integer.parseInt(secondElf[1])))
						fullyOverlappingElfPairs++;
					
					pairOfElves = input.readLine();
				}
				
				input.close();
				System.out.println(fullyOverlappingElfPairs);
			}
			catch (Exception e)
			{
				_logger.log(Level.WARNING, e.getStackTrace());
			}
		}
	}
	
	private static boolean isOneRangeContainedByOther(int rangeAStart, int rangeAEnd, int rangeBStart, int rangeBEnd)
	{
		if((rangeAStart <= rangeBStart && rangeAEnd <= rangeBEnd) || (rangeBStart <= rangeAStart && rangeBEnd <= rangeAEnd))
			return true;
		return false;
	}
}
