package mandatoryHomework.AfterDSA;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LC_283_MoveZeros {
	
	/*
	 * https://leetcode.com/problems/move-zeroes/description/
	 * 
	 */
	
	public int[] moveZeroes(int[] nums) {
		int pointer1 = 0, pointer2 = pointer1 + 1;
		while (pointer1 < nums.length && pointer2 < nums.length) {
			if (nums[pointer1] == 0) {
				if (nums[pointer2] != 0) {
					nums[pointer1] = nums[pointer2];
					nums[pointer2] = 0;
				} else
					pointer2++;
			} else {
				pointer1++;
				pointer2++;
			}
		}
		return nums;
	}

	@Test
	public void test1() {
		int[] nums = { 0, 1, 0, 3, 12 };
		int[] output = { 1, 3, 12, 0, 0 };
		Assert.assertEquals(moveZeroes(nums), output);

	}

	@Test
	public void test2() {
		int[] nums = { 0 };
		int[] output = { 0 };
		Assert.assertEquals(moveZeroes(nums), output);

	}

}
