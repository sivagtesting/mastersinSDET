package mandatoryHomework.AfterDSA;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LC_1021_RemoveOuterMostParentheses {

	/*
	 * https://leetcode.com/problems/remove-outermost-parentheses/description/
	 * 
	 	PseudoCode:
	 		Intialize a counter variable = 0
			initialize left =0, right =0
			initialize a string builder output
			do the following using while until right lt input string length
			    check the char at current index right is '('
			        if yes then increment counter and increment right
			        if no then decrement counter and increment right
			        check if counter eq 0 if yes then add all the char betweeen left and right (exclusive) and increment left = right
			
			return the string builder
	 */
	
	/* Approach: Two Pointers
	 * Time Complexity: O(N)
	 * Space Complexity: O(N-2)
	 */
	public String removeOuterParentheses(String s) {
		int counter = 0, left = 0, right = 0;
		StringBuilder output = new StringBuilder();
		while (right < s.length()) {
			if (s.charAt(right) == '(') {
				counter++;
				right++;
			} else {
				counter--;
				right++;
			}
			if (counter == 0) {
				for (int i = left + 1; i < right - 1; i++) {
					output.append(s.charAt(i));
				}
				left = right;
			}
		}
		return output.toString();
	}
	
	@Test
	public void test1() {
		String s = "(()())(())";
		String result = "()()()";
		Assert.assertEquals(removeOuterParentheses(s), result);
	}
	
	@Test
	public void test2() {
		String s = "(()())(())(()(()))";
		String result = "()()()()(())";
		Assert.assertEquals(removeOuterParentheses(s), result);
	}
	
	@Test
	public void test3() {
		String s = "()()";
		String result = "";
		Assert.assertEquals(removeOuterParentheses(s), result);
	}
}
