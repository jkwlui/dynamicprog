package model;
public class Main {

	
	public static void main(String[] args) {
		// get words from file:
		String[] words3 = Utilities.getWordsFromFile("words.txt");
		String[] mobydick = Utilities.getWordsFromFile("mobydick.txt");
		
		int maxCharInLine = 38;
		
//		int naiveOptimalSquaredSlackSpaces = Naive.minSlackSpace(words3, maxCharInLine);
		// Naive version takes too long to compute Moby Dick
		
		int memoizedOptimalSquaredSlackSpaces = Memoized.minSlackSpaceMemoized(mobydick, maxCharInLine);
		
		System.out.println("Cost of optimal solution (memoized): " + memoizedOptimalSquaredSlackSpaces);
		
		Integer[][] dynamicProgrammingSlackTable = DynamicProgramming.minSlackSpaceDP(mobydick, maxCharInLine);
/*		// printing slack table
		for (int i = 0; i < mobydick.length; i++) {
			for (int j = 0; j < mobydick.length; j++) {
				int value = dynamicProgrammingSlackTable[i][j];
				if (value == Integer.MAX_VALUE) {
					System.out.print("X ");
				} else {
					System.out.print(value + " ");
				}
				
			}
			System.out.println();
		}
		
*/		
		int dynamicProgrammingOptimalCost = SolutionExtractor.printPretty(mobydick, dynamicProgrammingSlackTable);
		
		System.out.println("Cost of optimal solution (dynamic programming): " + dynamicProgrammingOptimalCost);
		
		String[] dictionary = Utilities.getWordsFromFile("american.txt");
		
		Utilities.getRandomTextFromFile(dictionary, 50);
		

		
		
	}

}
