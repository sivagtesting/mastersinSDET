package mandatoryHomework.redo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LC_242_ValidAnagram {
	
	/*
	 * https://leetcode.com/problems/valid-anagram/description/
	 * 
	 	PseudoCode:
	 		if the length of two strings are ne then return false
			initialize a ascii integer array of size 26
			iterate over the input string
			    convert the char at current index of string s based on ascii table and increment that index
			    convert the char at current index of string t based on ascii table and decrement that index
			
			iterate over the input string
			    onvert the char at current index of string s based on ascii table and check if the value of tat index is 0
			    if not return false
			return true;
	 * 
	 */
	
	//Time Complexity: O(N)
	//Time Complexity: O(1)
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] ascii = new int[26];
		for (int i = 0; i < s.length(); i++) {
			ascii[s.charAt(i) - 'a']++;
			ascii[t.charAt(i) - 'a']--;
		}

		for (int i = 0; i < s.length(); i++) {
			if (ascii[s.charAt(i) - 'a'] != 0)
				return false;
		}
		return true;
	}
	
	@Test
	public void test1() {
		String s = "anagram";
		String t = "nagaram";
		boolean result = true;
		Assert.assertEquals(isAnagram(s, t), result);
	}
	
	@Test
	public void test2() {
		String s = "rat";
		String t = "car";
		boolean result = false;
		Assert.assertEquals(isAnagram(s, t), result);
	}

}
