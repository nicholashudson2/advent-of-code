package solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//--- Day 1: Trebuchet?! ---
//Something is wrong with global snow production, and you've been selected to take a look. 
//The Elves have even given you a map; on it, they've used stars to mark the top fifty locations 
//that are likely to be having problems.
//
//You've been doing this long enough to know that to restore snow operations, 
//you need to check all fifty stars by December 25th.
//
//Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent 
//calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants one star. 
//Good luck!
//
//You try to ask why they can't just use a weather machine ("not powerful enough") and where 
//they're even sending you ("the sky") and why your map looks mostly blank ("you sure ask a 
//lot of questions") and hang on did you just say the sky ("of course, where do you think 
//snow comes from") when you realize that the Elves are already loading you into a trebuchet 
//("please hold still, we need to strap you in").
//
//As they're making the final adjustments, they discover that their calibration document 
//(your puzzle input) has been amended by a very young Elf who was apparently just excited 
//to show off her art skills. Consequently, the Elves are having trouble reading the values 
//on the document.
//
//The newly-improved calibration document consists of lines of text; each line originally 
//contained a specific calibration value that the Elves now need to recover. On each line, 
//the calibration value can be found by combining the first digit and the last digit (in 
//that order) to form a single two-digit number.
//
//For example:
//
//1abc2
//pqr3stu8vwx
//a1b2c3d4e5f
//treb7uchet
//In this example, the calibration values of these four lines are 12, 38, 15, and 77. 
//Adding these together produces 142.
//
//Consider your entire calibration document. What is the sum of all of the calibration values?

public class DayOneTrebuchet {

	
	private static Logger _logger = System.getLogger("TestLogger");
	private static Integer sumOfCalibrationValues = 0;
	public static void main(String[] args)
	{
		String filePath = "C:\\dev\\fun-projects\\advent-of-code-2023\\src\\inputs\\day_one_input.txt";
		File file = new File(filePath);
		if(file.exists())
		{
			try
			{	
				FileReader reader = new FileReader(file);
				BufferedReader input = new BufferedReader(reader);
				String line = input.readLine();
				
				int counter = 0;
				Pattern pattern = Pattern.compile("\\d");
				Matcher matcher = pattern.matcher(replaceWordsWithNumbers(line));
				
				
				while (line != null)
				{
					if(counter == 0)
					{
						extractCalibrationValues(matcher);
					}
					else
					{						
						extractCalibrationValues(matcher.reset(replaceWordsWithNumbers(line)));
					}
					line = input.readLine();
					counter++;
				}
				
				input.close();
				System.out.println(sumOfCalibrationValues);
			}
			catch (Exception e)
			{
				_logger.log(Level.WARNING, e.getStackTrace());
			}
		}
	}
	
	private static void extractCalibrationValues(Matcher matcher)
	{
		ArrayList<Integer> results = new ArrayList<>();
		
		while (matcher.find())
		{
			results.add(Integer.valueOf(matcher.group()));
		}
		StringBuilder builder = new StringBuilder();
		builder.append(results.get(0));
		builder.append(results.get(results.size() - 1));
		sumOfCalibrationValues += Integer.parseInt(builder.toString());
	}
	
	private static String replaceWordsWithNumbers(String input)
	{
		String result = 
				input.replaceAll("one", "o1e")
					 .replaceAll("two", "t2o")
					 .replaceAll("three", "thr3e")
					 .replaceAll("four", "fo4r")
				 	 .replaceAll("five", "fi5e")
				 	 .replaceAll("six", "s6x")
				 	 .replaceAll("seven", "se7en")
				 	 .replaceAll("eight", "ei8ht")
				 	 .replaceAll("nine", "ni9e");
		return result;
	}
}
