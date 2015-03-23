package model;
public class Main {

	
	public static void main(String[] args) {
		// get words from file:
		String[] words3 = Utilities.getWordsFromFile("words.txt");
		//String[] mobydick = Utilities.getWordsFromFile("mobydick.txt");
		
		int maxCharInLine = 38;
		int[] SolnArray = new int[words3.length*maxCharInLine];
		for (int i = 0; i < (words3.length*maxCharInLine); i++) {
			SolnArray[i] = -1;
		}
		int solution = Naive.minSlackSpace(words3, maxCharInLine);
		int solution2 = Memoized.minSlackSpaceMemoized(words3, maxCharInLine);
		int solution3 = DynamicProgramming.minSlackSpaceDP(words3, maxCharInLine);
		System.out.println(solution);
		System.out.println(solution2);
		System.out.println(solution3);
		System.out.println(Memoized.GetBreaks());
		
		String textOutput = SolutionExtractor.ToText(words3, solution2);
		System.out.println(textOutput);
	}

}
