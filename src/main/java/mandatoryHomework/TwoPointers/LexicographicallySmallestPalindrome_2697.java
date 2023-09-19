package mandatoryHomework.TwoPointers;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LexicographicallySmallestPalindrome_2697 {
	/*
	 * 
	 * https://leetcode.com/problems/lexicographically-smallest-palindrome/description/
	 * 
	 * TestData Enumeration:
			egcfe -> efcfe
			a -> a
			aba -> aba
			abb -> aba
			10.36
		PseudoCode:
			10.36
			initiate twpointers left =0 , right = s.length()-1
			repeat the following code using while until left<right
			check character at index left & right are equal
			if yes -> increment left and decrement right
			if no -> check which character is less, replace the character and increment left and decrement right
			return the the string once the while loop ended.
			10.40
	 * 
	 */
	
	public String makeSmallestPalindrome(String s) {
		if (s.length() < 2)
			return s;
		else {
			int left = 0, right = s.length() - 1;
			StringBuilder sb = new StringBuilder(s);
			while (left < right) {
				if (sb.charAt(left) == sb.charAt(right)) {
					left++;
					right--;
				} else {
					if (sb.charAt(left) < sb.charAt(right)) {
						sb.setCharAt(right, sb.charAt(left));
						left++;
						right--;
					} else {
						sb.setCharAt(left, sb.charAt(right));
						left++;
						right--;
					}
				}
			}
			return sb.toString();
		}
	}
	
	@Test
	public void test1() {
		String s = "egcfe";
		String output = "efcfe";
		Assert.assertEquals(output, makeSmallestPalindrome(s));
	}
	
	@Test
	public void test2() {
		String s = "a";
		String output = "a";
		Assert.assertEquals(output, makeSmallestPalindrome(s));
	}
	
	@Test
	public void test3() {
		String s = "aba";
		String output = "aba";
		Assert.assertEquals(output, makeSmallestPalindrome(s));
	}
	
	@Test
	public void test4() {
		String s = "abb";
		String output = "aba";
		Assert.assertEquals(output, makeSmallestPalindrome(s));
	}
	
	@Test
	public void test5() {
		String s = "abcd";
		String output = "abba";
		Assert.assertEquals(output, makeSmallestPalindrome(s));
	}

}
