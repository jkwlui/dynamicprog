package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Memoized {
	
	// For array index i, it holds the optimal solution as computed
	// up to i words. Base case: optimalSlackSpace[0] = 0 where
	// 0 words are included
	
	public static Integer[] optimalSlackSpace;
	public static ArrayList Breaks;

	public static int minSlackSpaceMemoized(String[] words, int maxCharInLine) {
		long startTime = System.nanoTime();
		// initialize array of optimal solution to the size of words
		// use Integer object instead of primitive int because
		// it allows for "null" values
		
		// initialize array indices 0..n where n is the number of words
		optimalSlackSpace = new Integer[words.length + 1];
		// base case: optimal slack space of 0 words = 0
		optimalSlackSpace[0] = 0;
		//saves word on which each line breaks
		Breaks = new ArrayList(words.length+1);
		
		// populate optimalSlackSpace from i = 1..n
		for (int i = 1; i <= words.length; i++) {
			// initialize min slack space to maximum value of Integer (infty)
			int min = Integer.MAX_VALUE;
			// add 1 word to word on this line and find slack spaces:
			for (int j = i - 1; j >= 0; j--) {
				String[] wordsInLine = Arrays.copyOfRange(words, j, i);

				int charsInLine = Utilities.charsInLine(wordsInLine);
				
				if (charsInLine > maxCharInLine)
					Breaks.add(i);
				
				int slackSpace = (int) (Math.pow(maxCharInLine - charsInLine, 2))
						+ optimalSlackSpace[j];
				
				if (slackSpace < min)
					min = slackSpace;
				
			}
			
			optimalSlackSpace[i] = min;
		}
		long endTime = System.nanoTime();
		System.out.println("Memoized took " + (endTime - startTime) + " milliseconds");
		return optimalSlackSpace[words.length];
	}
	
	public static ArrayList GetBreaks() {
		return Breaks;
	}
}
