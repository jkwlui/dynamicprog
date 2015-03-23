package model;

import java.util.Vector;

public class SolutionExtractor {
	
	public static int printPretty(String[] words, Integer[][] slackTable) {
		
		// like Memoized version: initialize array of costs for 
		// the slack space of including the first x words
		int[] optimalSlackSpace = new int[words.length + 1];
		
		// initialize array of the indices of the last words on each line
		int[] lastWords = new int[words.length];
		
		// base case: 0 slack space for 0 words to pretty print
		optimalSlackSpace[0] = 0;
		
		for (int i = 0; i < words.length; i++) {
			optimalSlackSpace[i + 1] = 1000000;

			int k = i;
			
			int current = optimalSlackSpace[k] + slackTable[k][i];
			
			if (current < optimalSlackSpace[i + 1]) {
				optimalSlackSpace[i + 1] = current;
				lastWords[i] = k;
			}
			
			while (k >= 1 && current < 1000000) {
				k--;
				current = optimalSlackSpace[k] + slackTable[k][i];
				if (current < optimalSlackSpace[i+1]) {
					optimalSlackSpace[i+1] = current;
					lastWords[i] = k;
				}
			}
			
		}
		// use a Vector to in order to prepend indices  
		Vector<Integer> newLineIndex = new Vector<Integer>(); 
		// starting from the last line:
		newLineIndex.add(0, lastWords[words.length - 1]);
		int i = lastWords[words.length - 1] - 1;
		for (; i >= 0; i = lastWords[i] - 1) {
			newLineIndex.add(0, lastWords[i]);
		}
		
		int wordPointer = 0;
		
		for (int firstWord : newLineIndex) {
			for (int k = wordPointer; k < firstWord; k++) {
				System.out.print(words[k] + ' ');
			}
			System.out.println();
			wordPointer = firstWord;
		}
		
		// last line:
		for (int j = wordPointer; j < words.length; j++) {
			System.out.print(words[j] + " ");
		
		}
		System.out.println();
		
		return optimalSlackSpace[words.length];
		
	}
}
