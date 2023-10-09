package foundation.DailyProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LC_1207_UniqueNumberOfOccurences {
	
	/*
	 * https://leetcode.com/problems/unique-number-of-occurrences/description/
	 	PseudoCode:
	 	
	 * 
	 */
	
	public boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> occurence = new HashMap<Integer, Integer>();
		for (int i : arr)
			occurence.put(i, occurence.getOrDefault(i, 0) + 1);
		Set<Integer> uniqueOccurence = new HashSet<Integer>();
		for (int i : occurence.values()) {
			if (!uniqueOccurence.add(i))
				return false;
		}
		return true;
	}

	@Test
	public void test1() {
		int[] arr = { 1, 2, 2, 1, 1, 3 };
		boolean output = true;
		Assert.assertEquals(uniqueOccurrences(arr), output);
	}

	@Test
	public void test2() {
		int[] arr = { 1, 2 };
		boolean output = false;
		Assert.assertEquals(uniqueOccurrences(arr), output);
	}

	@Test
	public void test3() {
		int[] arr = { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 };
		boolean output = true;
		Assert.assertEquals(uniqueOccurrences(arr), output);
	}

}
