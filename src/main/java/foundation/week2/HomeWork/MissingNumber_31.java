package foundation.week2.HomeWork;

import org.junit.Assert;
import org.junit.Test;

public class MissingNumber_31 {
	/*
	 * https://leetcode.com/problems/missing-number/description/
	 * 		31. Missing Number Problem
		PseudoCode:
				Step1: Initialize a new integer array 'nums2'
					Step1.1: Size of array in above step should be 1 more than input array 'nums'
				Step2: Iterate over the input array nums using for loop
				Step3: inside the loop, get each value from input array 'nums' and use this as index for num2
				Step4: for each index for nums2 update value as 1; such that the missing number index will have zero by default
				Step5: Itereate over the nums2 array
				Step6: check value at each index is equal to zero then return the index valuem
	 * 
	 */
	public static int missingNumber(int[] nums) {
		int[] nums2 = new int[nums.length+1];
		for (int i = 0; i < nums.length; i++) {
			nums2[nums[i]] = 1;
		}
		for (int i = 0; i < nums2.length; i++) {
			if(nums2[i]==0)
				return i;
		}
		return 0;
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(2, missingNumber(new int[] {3,0,1}));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(2, missingNumber(new int[] {0,1}));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(8, missingNumber(new int[] {9,6,4,2,3,5,7,0,1}));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(9, missingNumber(new int[] {8,6,4,2,3,5,7,0,1}));
	}
}
