package mandatoryHomework.AfterDSA;

import java.util.Stack;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LC_844_BackspaceStringCompare {

	/*
	 * https://leetcode.com/problems/backspace-string-compare/description/
	 * 
			
		4.57
		Test Data Enumeration:
			a#, # -> true
			ab#, ba# -> false
			ab, ab -> true
			ab##, cd##-> true
			4.58	
		PseudoCode: 4.59
			Initialize two stack variable stackS, stackT of chars
			iterate over length of s and add each char to the stackS
			    if char at current index is # then pop the top element from stackS
			    if char at current index is # and stack is empty then increment
			    else push to stackS
			iterate over length of t and add each char to the stackT
			    if char at current index is # then pop the top element from stackT
			    if char at current index is # and stack is empty then increment
			    else push to stackT
			if size of two stacks are zero then return false
			else check if size 2 stacks ne then return false
			else check if all elements in stack are equal then return true;
			5.03
	 * 
	 */
	
	/* Approach: Using Stack DS
	 * Time Complexity: O(m+n)
	 * Space Complexity: O(m+n)
	 */
	public boolean backspaceCompare(String s, String t) {
		Stack<Character> stackS = new Stack<Character>();
		Stack<Character> stackT = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '#' && !(stackS.empty()))
				stackS.pop();
			else if (c != '#')
				stackS.push(c);
		}
		for (char c : t.toCharArray()) {
			if (c == '#' && !(stackT.empty()))
				stackT.pop();
			else if (c != '#')
				stackT.push(c);
		}
		if (stackS.empty() && stackT.empty())
			return true;
		else if (stackS.size() != stackT.size())
			return false;
		else {
			for (int i = 0; i < stackS.size(); i++) {
				if (stackS.get(i) != stackT.get(i))
					return false;
			}
			return true;
		}
	}
	
	@Test
	public void test1() {
		String s = "a#";
		String t = "#";
		boolean result = true;
		Assert.assertEquals(backspaceCompare(s, t), result);
	}
	
	@Test
	public void test2() {
		String s = "ab#";
		String t = "ba#";
		boolean result = false;
		Assert.assertEquals(backspaceCompare(s, t), result);
	}
	
	@Test
	public void test3() {
		String s = "ab";
		String t = "ab";
		boolean result = true;
		Assert.assertEquals(backspaceCompare(s, t), result);
	}
	
	@Test
	public void test4() {
		String s = "ab##";
		String t = "c#d#";
		boolean result = true;
		Assert.assertEquals(backspaceCompare(s, t), result);
	}
}
