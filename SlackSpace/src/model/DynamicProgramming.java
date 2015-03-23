package model;

public class DynamicProgramming {
static long startTime = System.nanoTime();
	// For array index i, it holds the optimal solution as computed
		// up to i words. Base case: optimalSlackSpace[0] = 0 where
		// 0 words are included
		
		public static Integer[][] optimalSlackSpace;

		public static Integer[][] minSlackSpaceDP(String[] words, int maxCharInLine) {
			// initialize array of optimal solution to the size of words
			// use Integer object instead of primitive int because
			// it allows for "null" values
			
			// initialize array indices [] [] with number of words
			optimalSlackSpace = new Integer[words.length][words.length];
			for (int i = 0; i < words.length; i++) {
				for (int j = 0; j < words.length; j ++) {
					optimalSlackSpace[i][j] = -1; //will equal infinity
				}
			}
			// base case
			optimalSlackSpace[0][0] = words[0].length();
			
			int[] lastWord = new int[words.length];
			lastWord[0] = words.length - 1;
			
			//first row of table
			for (int i = 1; i < words.length; i++) {
				optimalSlackSpace[0][i] = optimalSlackSpace[0][i-1] + words[i].length();
			}
			
			//remaining rows
			for (int i = 1; i < words.length; i++) {
				int k = i;
				optimalSlackSpace[i][k] = optimalSlackSpace[1][k] - optimalSlackSpace[1][i-1];
				//while you can add more words to a line
				while (k <= words.length - 2 && 
						(maxCharInLine - optimalSlackSpace[i][k] - (k - i)) > 0) {
					k++;
					optimalSlackSpace[i][k] = optimalSlackSpace[0][k] - optimalSlackSpace[0][i-1];
				}
				lastWord[i] = k;
			}
			
			//Finding the sum of squares for valid entries in table
			for (int i = 0; i < words.length; i++) {
				for (int j = i; j <= lastWord[i]; j++) {
					optimalSlackSpace[i][j] = maxCharInLine - optimalSlackSpace[i][j] - (j-i);
					if (optimalSlackSpace[i][j] < 0) {
						optimalSlackSpace[i][j] = 1000000; //Infinity
					} else {
						optimalSlackSpace[i][j] = optimalSlackSpace[i][j] * optimalSlackSpace[i][j];
					}
				}
			}
			
			//entries still at 0 are invalid, make them infinity
			for (int i = 0; i < words.length; i++) {
				for (int j = 0; j < words.length; j++) {
					if (optimalSlackSpace[i][j] < 0) {
						optimalSlackSpace[i][j] = 1000000;
					}
				}
			}
			long endTime = System.nanoTime();
			System.out.println("Dynamic Programming takes: "+ (endTime-startTime) + " milliseconds.");
			return optimalSlackSpace;
		}
	}
