package model;

import java.util.Vector;

public class SolutionExtractor {
	
	public static void ToText(String[] args, Integer[][] solution3) {
		
		int numWords = args.length;
		int[] Cost = new int[args.length+1];
		
		int breaks[] = new int[args.length];
		
		Cost[0] = 0;
		for (int i = 0; i < numWords; i++) {
			Cost[i+1] = Integer.MAX_VALUE; //infinity
			int k = i;
			
			/*
			 * cost of arranging k words in the text + 
			 * slack of words from kth word to ith word on a single line
			 */
			int T = Cost[k] + solution3[k][i];
			
			if (T < Cost[i+1]) {
				//if cost of arranging k words in the text + 
				//slack of words from kth word to ith word on a single line 
				//smaller than previous costs
				
				Cost[i+1] = T;
				breaks[i] = k;
			}
			while (k >= 1 && T < Integer.MAX_VALUE) {
				//find min k such that cost of arranging k words + 
				//slack from kth word to ith word decreases 
				k--;
				T = Cost[k] + solution3[k][i];
				if (T < Cost[i+1]) {
					Cost[i+1] = T;
					breaks[i] = k;
				}
			}
		}
		
		//determine the first word on each line
		
		//initilize list of indices of first word on each line
		Vector<Integer> firstWordInd = new Vector<Integer>();
		//add first word index of last line if all words used
		firstWordInd.add(0, breaks[numWords- 1]);
		int i = breaks[numWords- 1] - 1;
		while (i >= 0) {
			//backtrack to find first word on lines
			firstWordInd.add(0, breaks[i]);
			i = breaks[i] - 1;
		}
		
		int prevInd = 0;
		for (int firstInd : firstWordInd) {
			//firstInd = firstWordInd.elementAt(i);
			//print words from prevInd to firstind -1 in a single line
			for (int j = prevInd; j < firstInd; j++) {
				System.out.print(args[j]);
				System.out.print(' ');
			}
			System.out.println();
			prevInd = firstInd;
		}
		
		for (int r = prevInd; r < args.length; r++) {
			System.out.print(args[r]);
			System.out.print(' ');
		}
		
	}
}
