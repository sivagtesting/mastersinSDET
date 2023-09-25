package foundation.week11.day2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class KandaneAlgorithm {

	/*
	 * Given an integer array nums, find the contiguous
	 * subarray(containing at least one positive number)
	 * which has the largest sum and return its sum.
	 * 
	 * A subarray is a contiguous part of an array.
	 * 
	 * Input: {-2,1,-3,4,-1,2,1,-5,4}
	 * 
	 * Output: 6 (subarray [4,-1,2,1])
	 * 
	 * PseudoCode:
	 * initialize max =0, currentMax = 0, index =0;
	 * do the following using while until index< nums.length
	 * set currentMax = currentMax + element in the current index
	 * check if currentMax lt zero
	 * 		if yes then set currentMax = 0
	 * set max = maximum of max & currentMax
	 * increment index
	 * 
	 * return max
	 * 
	 */
	
	public int findMaxUsingKadane(int[] nums) {
		int max = 0, currentMax = 0, index = 0;
		while(index<nums.length) {
			currentMax += nums[index++];
			if(currentMax<0)
				currentMax = 0;
			max = Math.max(max, currentMax);
		}
		return max;
	}
	
	@Test
	public void test1() {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int output = 6;
		Assert.assertEquals(findMaxUsingKadane(nums), output);
	}
	
	@Test
	public void test2() {
		int[] nums = {-2,1,-3};
		int output = 1;
		Assert.assertEquals(findMaxUsingKadane(nums), output);
	}
}
