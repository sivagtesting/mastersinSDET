package foundation.week10.day2;

import org.junit.Test;
import org.testng.Assert;

public class MaxSumOfConsecutiveElements {
	
	/*
	 * Given an array of Integers and a number k.
	 * Return the highest sum of any k consecutive elements in the array.
	 * 
	 * Input Array: {1,5,2,3,7,1}
	 * Target (k): 3
	 * Output: 12
	 * Explanation: sum of 2,3,7 is the max
	 * 
	 */
	
	
	public int returnMaxSumTwoPointersApproach(int[] nums, int target) {
		int pOne = 0, pTwo = 1;
		int max = Integer.MIN_VALUE;
		while (pOne < nums.length - target) {
			int tempMax = nums[pOne];
			while (pTwo < pOne + target) {
				tempMax += nums[pTwo];
				pTwo++;
			}
			if (tempMax > max) {
				max = tempMax;
				pOne++;
				pTwo = pOne + 1;
			} else {
				pOne++;
				pTwo = pOne + 1;
			}
		}
		return max;
	}
	
	@Test
	public void test1() {
		int[] nums = {1,5,2,3,7,1,2,3};
		int target = 3;
		int output = 12;
		Assert.assertEquals(output, returnMaxSumTwoPointersApproach(nums, target));
		//Assert.assertEquals(output, returnMaxSumSlidingWindowApproach(nums, target));
	}
	
	public int returnMaxSumSlidingWindowApproach(int[] nums, int k) {
		// 1. one pointer should work
		int max = Integer.MIN_VALUE, pointer = 0, currentSum = 0;
		// not needed second pointer as this is balanced traversal ,right = k-1;
		// 2. Do the required operation till k index
		while (pointer < k)
			currentSum += nums[pointer++];
		// 3. continue the operation for rest of the array
		while (pointer < nums.length) {
			max = Math.max(currentSum, max);
//			currentSum += nums[pointer] - nums[pointer - target];
			
			currentSum += nums[pointer];
			currentSum -= nums[pointer++-k];

//			to ease out the understanding of the sliding window pointer movement use the above code instead of

//			currentSum += nums[pointer] - nums[pointer++-k];
			pointer++;
		}
		return Math.max(currentSum, max);
	}

}
