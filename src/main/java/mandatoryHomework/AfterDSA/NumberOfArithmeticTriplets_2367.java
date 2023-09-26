package mandatoryHomework.AfterDSA;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberOfArithmeticTriplets_2367 {

	public int arithmeticTriplets(int[] nums, int diff) {
		int start = 0, tempCounter = 0, counter = 0;
		while (start < nums.length - 1) {
			int end = start + 1;
			while (end < nums.length) {
				if (nums[end] - nums[start] == diff)
					tempCounter++;
				end++;
			}
			if (tempCounter >= 3) {
				counter++;
				tempCounter = 0;
			} else
				tempCounter = 0;
			start++;
		}
		return counter;
	}
	
	public int arithmeticTriplets_Hint(int[] nums, int diff) {
		int start = 0, counter = 0;
		Set<Integer> numSet = new HashSet<Integer>();
		for(int i: nums) {
			numSet.add(i);
		}
		while(start<nums.length-3) {
				if(numSet.contains(nums[start]+diff) && numSet.contains(nums[start]+(2*diff))) {
					counter++;
				}
				start++;
		}
		
		
		return counter;
	}
	
	@Test
	public void test1() {
		int[] nums = {0,1,4,6,7,10};
		int diff = 3;
		int output = 2;
		//Assert.assertEquals(output, arithmeticTriplets(nums, diff));
		Assert.assertEquals(output, arithmeticTriplets_Hint(nums, diff));
	}
}
