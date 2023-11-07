package mandatoryHomework.redo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LC_557_ReverseWordsInString3 {
	
	
	/*
	 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
	 * 
	 	PseudoCode:
			Split the sentence based on space
			initialize a string builder
			    iterate over the string array
			        if size of string builder is gt 0 then append space
			        iterate over the lenght of each word start index as length of word
			            append each char to the string builder
			return string builder
	 * 
	 */
	
//	Time Complexity: O(N*M)
//	Space Complexity: O(N)
	public String reverseWords(String s) {
		StringBuilder result = new StringBuilder(s.length());
		String[] words = s.split(" ");
		for (String word : words) {
			if (result.length() > 0)
				result.append(" ");
			for (int i = word.length() - 1; i >= 0; i--)
				result.append(word.charAt(i));
		}
		return result.toString();
	}
	
	@Test
	public void test1() {
		String s = "Let's take LeetCode contest";
		String result = "s'teL ekat edoCteeL tsetnoc";
		Assert.assertEquals(reverseWords(s), result);
	}
	
	@Test
	public void test2() {
		String s = "God Ding";
		String result = "doG gniD";
		Assert.assertEquals(reverseWords(s), result);
	}
	
	@Test
	public void test3() {
		String s = "";
		String result = "";
		Assert.assertEquals(reverseWords(s), result);
	}

}
