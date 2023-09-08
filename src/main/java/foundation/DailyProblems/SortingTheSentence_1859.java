package foundation.DailyProblems;

import org.junit.Test;
import org.testng.Assert;

public class SortingTheSentence_1859 {

	/*
	 * 
	 * 
	 * TestData Enumeration:
8.06
			s = "is2 sentence4 This1 a3" -> This is a sentence
			s = "I1 am2" -> I am
			s = "am2 I1" -> I am
			s = "ninE9 eight8 seven7 one1 Six6 FIVE5 two2 four4 three3" -> One two three four FIVE Six seven eight ninE
			8.07
		PseudoCode:
			8.07
			initialize a char array of size 9
			initialize a string 
			convert the given sentence to char array
			iterate over the array
			input the each word in the current index to char array at index dervied from last character
			iterate over the char array and append to the output string removing the digit
	 * 
	 * Complexity of the program:
	 * 
	 * 
	 */

	public static String sortSentence(String s) {
		StringBuilder sb = new StringBuilder(s.replaceAll(".d", "").length());
		String[] tempWords = new String[9];
		String[] words = s.split(" ");
		for (int i = 0; i < words.length; i++) {
			tempWords[Character.getNumericValue(words[i].charAt(words[i].length() - 1))-1] = words[i];
		}
		for (int i = 0; i < tempWords.length; i++) {
			if (tempWords[i] != null)
				sb.append(tempWords[i]);
		}

		return sb.toString().replaceAll("\\d", " ").trim();
	}
	
	@Test
	public void test1() {
		String s = "is2 sentence4 This1 a3";
		String output = "This is a sentence";
		Assert.assertEquals(output, sortSentence(s));
	}
	
	@Test
	public void test2() {
		String s = "I1 am2";
		String output = "I am";
		Assert.assertEquals(output, sortSentence(s));
	}
	
	@Test
	public void test3() {
		String s = "am2 I1";
		String output = "I am";
		Assert.assertEquals(output, sortSentence(s));
	}
	
	@Test
	public void test4() {
		String s = "ninE9 eight8 seven7 one1 Six6 FIVE5 two2 four4 three3";
		String output = "one two three four FIVE Six seven eight ninE";
		Assert.assertEquals(output, sortSentence(s));
	}

}
