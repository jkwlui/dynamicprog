package model;

public class Main {

	
	public static void main(String[] args) {
		
		String[] words = {"A", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
		String[] words2 = {"A", "green", "cat"};
		int maxCharInLine = 10;
		int solution = Naive.minSlackSpace(words2, maxCharInLine);
		System.out.println(solution);
	}

}
