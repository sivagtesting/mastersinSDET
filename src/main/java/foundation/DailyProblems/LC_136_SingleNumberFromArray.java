package foundation.DailyProblems;

import java.util.HashSet;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LC_136_SingleNumberFromArray {

	/*
	 * https://leetcode.com/problems/single-number/description/
	 * 
	 * 
	 */
	
	public int singleNumber(int[] nums) {
		HashSet<Integer> numSet = new HashSet<Integer>();
		// int uniqueNum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (!numSet.add(nums[i]))
				numSet.remove(nums[i]);
		}
		/*
		 * for(int i: numSet) return i; return 0;
		 */
		return numSet.iterator().next();
	}
	
	@Test
	public void test1() {
		int[] nums = {2,2,1};
		int output = 1;
		Assert.assertEquals(singleNumber(nums), output);
	}
	
	@Test
	public void test2() {
		int[] nums = {4,1,2,1,2};
		int output = 4;
		Assert.assertEquals(singleNumber(nums), output);
	}
	
	@Test
	public void test3() {
		int[] nums = {1};
		int output = 1;
		Assert.assertEquals(singleNumber(nums), output);
	}
}
