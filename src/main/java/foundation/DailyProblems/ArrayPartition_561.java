package foundation.DailyProblems;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayPartition_561 {
	
	/*
	 * https://leetcode.com/problems/array-partition/description/
	 * 
	 	PseudoCode:
			initialize integer variable sum
			Sort the input array
			iterate over the array until the length of Array
			sum the elements at odd index(which will be the minimum of the pairs)
			return the sum
	 
	 * 
	 */
	
	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
        int sum = 0;
        for(int i=0; i<nums.length; i=i+2)
            sum += nums[i];
        return sum;
	}
	
	@Test
	public void test1() {
		int[] nums = {1,4,3,2};
		int output = 4;
		Assert.assertEquals(arrayPairSum(nums), output);
	}
	
	@Test
	public void test2() {
		int[] nums = {6,2,6,5,1,2};
		int output = 9;
		Assert.assertEquals(arrayPairSum(nums), output);
	}
	
	@Test
	public void test3() {
		int[] nums = {1,4,3,2,2,5,8,9};
		int output = 15;
		Assert.assertEquals(arrayPairSum(nums), output);
	}

}
