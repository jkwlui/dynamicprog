package model;
public class Main {

	
	public static void main(String[] args) {
		// get words from file:
		String[] words3 = Utilities.getWordsFromFile("words.txt");
		String[] mobydick = Utilities.getWordsFromFile("mobydick.txt");
		
		int maxCharInLine = 38;
		int solution = Naive.minSlackSpace(mobydick, maxCharInLine);
		System.out.println(solution);
	}

}
