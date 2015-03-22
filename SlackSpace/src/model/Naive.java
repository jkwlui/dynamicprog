package model;

import java.util.Arrays;

public class Naive {

	public static int minSlackSpace(String[] words, int maxCharInLine) {
		// base case: if words is empty, slack space = 0
		int numWords = words.length;
		if (numWords == 0)
			return 0;
		// initialize min to 1 larger than number of characters for all words
		int min = 100000000;
		int j = numWords;
		while (true) {
			j--;
			if (j < 0)
				break;
			// partition words list into words to be considered in this line
			String[] wordsInLine = Arrays.copyOfRange(words, j, numWords);
			// get num. of characters for this line
			int charsInLine = Utilities.charsInLine(wordsInLine);
			// partition words list into words to be considered in next line
			String[] remainingWords = Arrays.copyOfRange(words, 0, j);
			
			// if current line characters exceeds the maximum allowed for a line
			// break out of loop and produce the minimum value
			if (charsInLine > maxCharInLine)
				break;
			
			// recursively find the total slack space given that current line
			// consists of words used in this line
			int slackSpace = (int) (Math.pow(maxCharInLine - charsInLine, 2) + minSlackSpace(remainingWords, maxCharInLine));
			// update the minimum slack space if slack space from this line
			// is smaller than the minimum
			if (slackSpace < min) {
				min = slackSpace;
			}
		}

		return min;
	}
	
	

}
