package model;

import java.util.List;
import java.util.Random;

public class RandomText {

	static StringBuilder sb = new StringBuilder();
	static Random random = new Random();
	
	public static String ConstructText(int n, List String) {
		
		for (int i = 0; i < String.size(); i ++) {
			Object c = String.get(random.nextInt(String.size()));
			sb.append(c);
		}
		String output = sb.toString();
		return output;
	}
}
