package model;


import java.util.List;
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
	

}
