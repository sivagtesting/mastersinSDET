package foundation.DailyProblems;

import org.junit.Test;
import org.testng.Assert;

public class FaultyKeyBoard_2810 {
	
	/*
	 * 
	 * https://leetcode.com/problems/faulty-keyboard/description/
	 * 
			12.09
			TestData Enumeration:
					s = "a" -> a
					s = "ai" -> a
					s = "abi" -> ba
					s = "ab" -> ab
					12.12
			
			PseudoCode:
					check if length of s is lessthan 2
					if yes return s
					if no then repeat the following steps
					intialize a string builder of size size of string after removing all i's from s
					iterate until the length of s
					check if the character at current index is i
					if no then append to sb
					if yes then reverse sb;
					return sb.toString;
					12.18 - completed psuedo coding started
					12.32
	 */

	
	public String finalString(String s) {
		if (s.length() < 2)
			return s;
		else if (s.indexOf('i') < 0)
			return s;
		else {
			StringBuilder sb = new StringBuilder(s.replaceAll("i", "").length());
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'i')
					sb.reverse();
				else
					sb.append(s.charAt(i));
			}
			return sb.toString();
		}
	}
	
	@Test
	public void test1() {
		String s = "aiwib";
		String output = "wab";
		Assert.assertEquals(output, finalString(s));
	}
	
	@Test
	public void test2() {
		String s = "a";
		String output = "a";
		Assert.assertEquals(output, finalString(s));
	}
	
	@Test
	public void test3() {
		String s = "ai";
		String output = "a";
		Assert.assertEquals(output, finalString(s));
	}
	
	@Test
	public void test4() {
		String s = "abi";
		String output = "ba";
		Assert.assertEquals(output, finalString(s));
	}
	
	@Test
	public void test5() {
		String s = "ab";
		String output = "ab";
		Assert.assertEquals(output, finalString(s));
	}
}
