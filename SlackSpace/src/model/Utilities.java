package model;

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
	

}
