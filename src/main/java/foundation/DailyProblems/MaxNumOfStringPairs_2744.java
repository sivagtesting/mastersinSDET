package foundation.DailyProblems;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MaxNumOfStringPairs_2744 {

	/*
	 * https://leetcode.com/problems/find-maximum-number-of-string-pairs/description/
	 * 
	 * test data enumeration:
			9.08
			words = ["cd","ac","dc","ca","zz"] -> 2
			words = ["cd","ac"] -> 0
			words = ["cd"] -> 0
			words = ["cd","dc"] -> 1
			9.09
			
		PseudoCode: 9.10
			
			check if the size of words is = 1
			then return 0
			else do the following
			intialize integer counter = 0;
			iterate over the words array upto length-1
			iterate over the words array start index = i+1 until words.length
			intialize stringbuilder and assign words[j]
			verify if words[i].equals(sb.reverse())
			if yes increment coutner
			
			return counter;
			9.14
			code started at 9.14
	 * 
	 * 
	 */
	
	public int maximumNumberOfStringPairs(String[] words) {
		if (words.length == 1)
			return 0;
		else {
			int counter = 0;
			for (int i = 0; i < words.length - 1; i++) {
				for (int j = i + 1; j < words.length; j++) {
					StringBuilder sb = new StringBuilder(words[j]);
					if (words[i].equals(sb.reverse().toString()))
						counter++;
				}
			}
			return counter;
		}
	}
	
	@Test
	public void test1() {
		String[] words = {"cd","ac","dc","ca","zz"};
		int counter = 2;
		Assert.assertEquals(counter, maximumNumberOfStringPairs(words));
	}
	
	@Test
	public void test2() {
		String[] words = {"cd","ac"};
		int counter = 0;
		Assert.assertEquals(counter, maximumNumberOfStringPairs(words));
	}
	
	@Test
	public void test3() {
		String[] words = {"cd"};
		int counter = 0;
		Assert.assertEquals(counter, maximumNumberOfStringPairs(words));
	}
	
	@Test
	public void test4() {
		String[] words = {"cd", "dc"};
		int counter = 1;
		Assert.assertEquals(counter, maximumNumberOfStringPairs(words));
	}
	
}
