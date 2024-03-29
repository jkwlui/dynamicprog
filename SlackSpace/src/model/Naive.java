package model;

import java.util.Arrays;

public class Naive {
	static long startTime = System.nanoTime();
	public static int minSlackSpace(String[] words, int maxCharInLine) {
		long startTime = System.nanoTime();
		// base case: if words is empty, slack space = 0
		int numWords = words.length;
		if (numWords == 0)
			return 0;
		// initialize min to MAX_VALUE of integer
		int min = Integer.MAX_VALUE;
		int j = numWords;
		while (true) {
			j--;
			if (j < 0)
				break;
			// partition words list into words to be considered in this line
			String[] wordsInLine = (String[]) Arrays.copyOfRange(words, j, numWords);
			// get num. of characters for this line
			int charsInLine = Utilities.charsInLine(wordsInLine);
			// partition words list into words to be considered in next line
			String[] remainingWords = (String[]) Arrays.copyOfRange(words, 0, j);
			
			// if current line characters exceeds the maximum allowed for a line
			// break out of loop and produce the minimum value
			if (charsInLine > maxCharInLine)
				break;
			
			// recursively find the total slack space given that current line
			// consists of words used in this line
			int slackSpace = (int) (Math.pow(maxCharInLine - charsInLine, 2)) + minSlackSpace(remainingWords, maxCharInLine);
			// update the minimum slack space if slack space from this line
			// is smaller than the minimum
			if (slackSpace < min) {
				min = slackSpace;
			}
		}
		long endTime = System.nanoTime();
		System.out.println("Naive took " + (endTime - startTime) + " milliseconds");
		return min;
	}
}
