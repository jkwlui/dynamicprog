package model;


import java.util.List;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class Utilities {
	
	public static int charsInLine(String[] words) {
		int numChars = 0;
		for (int i = 0; i < words.length; i++) {
			numChars += words[i].length(); 
			numChars++; // put 1 space after a word
		}
		numChars--;  // minus 1 space at the end of line
		return numChars;
	}
	
	public static int[] getWordLens(String[] words) {
		int[] wordLens = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			wordLens[i] = words[i].length();
		}
		return wordLens;
	}
	
	public static String[] getWordsFromFile(String filename) {
		List<String> lines = new ArrayList<String>();
		try {
			FileReader fileReader = new FileReader(filename);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				lines.add(line.trim());
			}
			bufferedReader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines.toArray(new String[lines.size()]);
	}
	
	public static void getRandomTextFromFile(String[] dictionary, int numWords) {
		
		// generate i = numWords random numbers from 0 to sizeOf(dictionary)
		Random generator = new Random();
		
		ArrayList<Integer> randomIndices = new ArrayList<Integer>();
		
		for (int i = 0; i < numWords; i++) {
			randomIndices.add(generator.nextInt(dictionary.length));
		}

		List<String> randomWords = new ArrayList<String>();
		
		for (int index : randomIndices) {
			randomWords.add(dictionary[index]);
		}
		
		String[] wordsArray = randomWords.toArray(new String[randomWords.size()]);
		
		Integer[][] slackTable = DynamicProgramming.minSlackSpaceDP(wordsArray, 40);
		
		SolutionExtractor.printPretty(wordsArray, slackTable);
		
	}
	

}
