package mandatoryHomework.AfterDSA;

import java.util.HashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LC_1684_ConsistentStrings {
	
	/*
	 * https://leetcode.com/problems/count-the-number-of-consistent-strings/description/
	 	PseudoCode - Using HashSet
			Initialize a HashSet of Characters allowedSet
			initialize a integer count = 0
			iterate over the words array
			    Initialize a HashSet of Characters eachWordSet
			    inside the loop iterate over the length of each element from words array
			        add each char to eachWordSet
			    outside inner loop check if all chars in eachWordSet is available in allowedSet
			        if yes then increment count
			return count;
	 * 
	 */
	
	public int countConsistentStrings(String allowed, String[] words) {
		Set<Character> allowedSet = new HashSet<Character>();
		int count = 0;
		boolean flag = true;

		
		for (int i = 0; i < allowed.length(); i++)
			allowedSet.add(allowed.charAt(i));
		 
		for (String eachWord : words) {
			for (int i = 0; i < eachWord.length(); i++) {
				if(allowedSet.add(eachWord.charAt(i))) {
					allowedSet.remove(eachWord.charAt(i));
					flag = false;
					break;
				}
			}
			if (flag)
				count++;
			else flag = true;
		}

		return count;
	}

	@Test
	public void test1() {
		String allowed = "ab";
		String[] words = { "ad", "bd", "aaab", "baa", "badab" };
		int output = 2;
		Assert.assertEquals(countConsistentStrings(allowed, words), output);
	}

	@Test
	public void test2() {
		String allowed = "abc";
		String[] words = { "a", "b", "c", "ab", "ac", "bc", "abc" };
		int output = 7;
		Assert.assertEquals(countConsistentStrings(allowed, words), output);
	}

	@Test
	public void test3() {
		String allowed = "cad";
		String[] words = { "cc", "acd", "b", "ba", "bac", "bad", "ac", "d" };
		int output = 4;
		Assert.assertEquals(countConsistentStrings(allowed, words), output);
	}

}
