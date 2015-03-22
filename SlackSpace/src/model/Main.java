package model;
public class Main {

	
	public static void main(String[] args) {
		// get words from file:
		String[] words3 = Utilities.getWordsFromFile("words.txt");
		
		int maxCharInLine = 5;
		int solution = Naive.minSlackSpace(words3, maxCharInLine);
		System.out.println(solution);
	}

}
