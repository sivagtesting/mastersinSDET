package foundation.week11.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SentencePalindrome {
	
	//Twopointers - expand from Center
	
	/*
	 * TestData Enumeration:
	 * I luv India - {true, false, false}
	 * mama - {true}
	 * abc abcba abcdcba - {false, true, true}
	 * 
	 * PseudoCode:
	 * Split the input string based on space
	 * intialize a booelan array of size based on the String array from step1
	 * iterate over the String array and pass each string to isValidPalindrome
	 * if true then add to the index position boolean array;
	 * 
	 * to find whether string is palindrome
	 * initialize left integer length/2 -1 to  012345
	 * intialize right index based on lenght of string
	 * 		if length is odd length/2+1
	 * 		if lenght is even length/2
	 * then do the following untile left>=0
	 * inside loop check if each char at both idnex is mathc else return false
	 * return true;
	 * 
	 */
	
	public boolean[] isWordsArePalindrome(String input) {
		String[] eachWord = input.split(" ");
		boolean[] output = new boolean[eachWord.length];
		for (int i = 0; i < eachWord.length; i++) {
			output[i] = isValidPalindrome(eachWord[i]);
		}
		return output;
	}
	
	public boolean isValidPalindrome(String eachWord) {
		String temp = eachWord.toLowerCase();
		int length = eachWord.length();
		int left = (length/2)-1;
		int right = length%2==0 ? (length/2):(length/2)+1;
		while(left>=0) {
			if(temp.charAt(left)!=temp.charAt(right))
				return false;
			left--;
			right++;
		}
		return true;
	}
	
	@Test
	public void test1() {
		String input = "abc abcba abcdcba";
		boolean[] output = {false, true, true};
		Assert.assertEquals(isWordsArePalindrome(input), output);
	}
	
	@Test
	public void test2() {
		String input = "I luv India";
		boolean[] output = {true, false, false};
		Assert.assertEquals(isWordsArePalindrome(input), output);
	}
	
	@Test
	public void test3() {
		String input = "maam";
		boolean[] output = {true};
		Assert.assertEquals(isWordsArePalindrome(input), output);
	}
}
