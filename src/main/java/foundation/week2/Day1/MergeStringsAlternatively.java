package foundation.week2.Day1;

import org.junit.Assert;
import org.junit.Test;

public class MergeStringsAlternatively {

	/*
	 * https://leetcode.com/problems/merge-strings-alternately/description/
	 * 
	 * PseudoCode:
	 * 
	 * Step1: Initialize a new emptyString 'mergedString'
	 * Step2: Initialize a integer 'length'
	 * Step3: find the length of longer word from input words and store in variable from step2
	 * Step4: iterate using for loop with length found in step3
	 * Step5: inside for loop start appending each Character from both words alternatively using charAt() method
	 * 			Step5.1: ensure that the current index is always less than the length of the input words
	 * Step6: return the mergedString
	 *
	 */

	public static String mergeAlternately(String word1, String word2) {
		String mergedString = "";
		int length;
		length = (word1.length() >= word2.length()) ? word1.length() : word2.length();
		
		for (int i = 0; i < length; i++) {
			if (i < word1.length())
				mergedString = mergedString + word1.charAt(i);
			if (i < word2.length())
				mergedString = mergedString + word2.charAt(i);
		}
		return mergedString.toString();
	}

	@Test
	public void test1() {
		Assert.assertEquals("apbqcr", mergeAlternately("abc", "pqr"));
	}

	@Test
	public void test2() {
		Assert.assertEquals("apbqrs", mergeAlternately("ab", "pqrs"));
	}

	@Test
	public void test3() {
		Assert.assertEquals("apbqcd", mergeAlternately("abcd", "pq"));
	}

}
