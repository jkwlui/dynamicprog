package model;
public class Main {

	
	public static void main(String[] args) {
		// get words from file:
		String[] words3 = Utilities.getWordsFromFile("words.txt");
		String[] mobydick = Utilities.getWordsFromFile("mobydick.txt");
		String[] TenWords = Utilities.getWordsFromFile("10words.txt");
		String[] TwentyWords = Utilities.getWordsFromFile("20words.txt");
		String[] ThirtyWords = Utilities.getWordsFromFile("30words.txt");
		String[] FourtyWords = Utilities.getWordsFromFile("40words.txt");
		String[] FiftyWords = Utilities.getWordsFromFile("50words.txt");
		
		int maxCharInLine = 38;
		
		int naiveOptimalSquaredSlackSpaces = Naive.minSlackSpace(ThirtyWords, maxCharInLine);
		// Naive version takes too long to compute Moby Dick, and anything past 30 words
		
	//	int memoizedOptimalSquaredSlackSpaces = Memoized.minSlackSpaceMemoized(FiftyWords, maxCharInLine);
		
	//	Integer[][] dynamicProgrammingSlackTable = DynamicProgramming.minSlackSpaceDP(FiftyWords, maxCharInLine);
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
	//	int dynamicProgrammingOptimalCost = SolutionExtractor.printPretty(FiftyWords, dynamicProgrammingSlackTable);
		
	//	System.out.println("Cost of optimal solution (Dynamic Programming): " + dynamicProgrammingOptimalCost);
	//	System.out.println("Cost of optimal solution (Memoized): " + memoizedOptimalSquaredSlackSpaces);
		System.out.println("Cost of optimal solution (Naive): " + naiveOptimalSquaredSlackSpaces);
		
	//	String[] dictionary = Utilities.getWordsFromFile("american.txt");
		
	//	Utilities.getRandomTextFromFile(dictionary, 50);
		

		
		
	}

}
