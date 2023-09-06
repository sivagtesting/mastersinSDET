package foundation.DailyProblems;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AccronymOfWords_2828 {
	
	/*
	 * https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words/submissions/
	 * 
	 * TestData Enumeration:
			words = ["alice","bob","charlie"], s = "abc" -> true
			words = ["a","b"], s = "ab" -> true
			words = ["aa"], s = "a" -> true;
			words = ["alice","bob","charlie"], s = "a" -> false
			words = ["alice","bob","charlie"], s = "cab" -> false
			
		PseudoCode:
			intiate a string accronym
			if lenght of s and size of words do not match return false
			if matches then using for loop iterate through th words array
			using charAt() get the first letter and append it to the accronym
			return true if accronym is equal to s;
	 * 
	 */

	public boolean isAcronym(List<String> words, String s) {
		if (s.length() == words.size()) {
			StringBuilder accronym = new StringBuilder(s.length());
			for (int i = 0; i < words.size(); i++) {
				accronym.append(words.get(i).charAt(0));
			}
			return accronym.toString().equals(s);
		} else
			return false;
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(true, isAcronym(Arrays.asList(new String[] {"alice","bob","charlie"}), "abc"));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(true, isAcronym(Arrays.asList(new String[] {"a","b"}), "ab"));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(true, isAcronym(Arrays.asList(new String[] {"aa"}), "a"));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(false, isAcronym(Arrays.asList(new String[] {"alice","bob","charlie"}), "a"));
	}
	
	@Test
	public void test5() {
		Assert.assertEquals(false, isAcronym(Arrays.asList(new String[] {"alice","bob","charlie"}), "cab"));
	}

}
