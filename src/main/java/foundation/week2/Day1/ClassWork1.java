package foundation.week2.Day1;

import org.junit.Assert;
import org.junit.Test;

public class ClassWork1 {
	
	/*			https://leetcode.com/problems/valid-palindrome/
	 * 			125. Valid Palindrome
	 * 
	 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

					Given a string s, return true if it is a palindrome, or false otherwise.
					
					Example 1:
					Input: s = "A man, a plan, a canal: Panama"
					Output: true
					Explanation: "amanaplanacanalpanama" is a palindrome.

					
					Example 2:
					Input: s = "race a car"
					Output: false
					Explanation: "raceacar" is not a palindrome.

					Example 3:
					Input: s = " "
					Output: true
					Explanation: s is an empty string "" after removing non-alphanumeric characters.
					Since an empty string reads the same forward and backward, it is a palindrome.
	 * 
	 * 
	 */
	
	public static boolean isValidPalindrome(String s) {
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		String s1 = "";
		for (int i = s.length() - 1; i >= 0; i--)
			s1 = s1 + s.charAt(i);
		return s.equals(s1);
	}

	@Test
	public void test() {
		Assert.assertEquals(true, isValidPalindrome("A man, a plan, a canal: Panama"));
	}

	@Test
	public void test1() {
		Assert.assertEquals(true, isValidPalindrome(" "));
	}

	@Test
	public void test2() {
		Assert.assertEquals(false, isValidPalindrome("race a car"));
	}
}
