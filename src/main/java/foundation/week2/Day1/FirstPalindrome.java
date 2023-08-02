package foundation.week2.Day1;

import org.junit.Assert;
import org.junit.Test;

public class FirstPalindrome {

	/*
	 * https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
	 * description/
	 * 
	 * PseudoCode:
	 * Step1: Initialize a empty String  'newWord'
	 * 
	 */

	public static String firstPalindrome(String[] words) {
		String newWord = "";
		for (int i = 0; i < words.length; i++) {
			for (int j = words[i].length() - 1; j >= 0; j--) {
				newWord = newWord + words[i].charAt(j);
			}
			if (newWord.equals(words[i]))
				return newWord.toString();
			newWord = "";
		}
		return newWord.toString();
	}

	@Test
	public void test1() {
		Assert.assertEquals("ada", firstPalindrome(new String[] { "abc", "car", "ada", "racecar", "cool" }));
	}

	@Test
	public void test2() {
		Assert.assertEquals("racecar", firstPalindrome(new String[] { "notapalindrome", "racecar" }));
	}

	@Test
	public void test3() {
		Assert.assertEquals("", firstPalindrome(new String[] { "def", "ghi" }));
	}

}
