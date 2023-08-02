package foundation.sdetEntrance;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Question3 {

	public static void main(String[] args) {
		String word = "date";
		String word1 = "apple";
		Question3 obj = new Question3();
		obj.addingIntoSet(word);
		obj.addingIntoSet(word1);
	}

	public void addingIntoSet(String inpWord) {
		Set<String> allWords = new LinkedHashSet<String>(Arrays.asList("apple", "banana", "cherry"));
		if (allWords.add(inpWord))
			System.out.println("Word was added to the set");
		else
			System.out.println("Word already exists in the set");
	}

}
