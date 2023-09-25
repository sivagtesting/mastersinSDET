package foundation.week11.day2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ConsecutiveOnesFromBinaryArray_485 {
	
	/*
	 * https://leetcode.com/problems/max-consecutive-ones/description/
	 * 
	 * PsuedoCode by Natraaj:
	 * 	1. Initialise left and right
        2. increase right till 1
        3. if number is zero, calculate the window of right-left and reset right and left as current index
	 * 
	 */
	
	public int findMaxConsecutiveOnes_natraajPseudo(int[] nums) {
		return 0;
	}
	
	public int findMaxConsecutiveOnes(int[] nums) {

		if (nums.length == 1)
			return (nums[0] == 1) ? 1 : 0;
		else {
			int left = 0, right = 0, max = 0;
			while (right < nums.length) { //O[N]
				if (right == nums.length - 1) {
					if (nums[right] == 1) {
						if ((right - left) + 1 > max)
							max = (right - left) + 1;
					}
					right++;
				} else {
					if (nums[right] == 0) {
						if (right - left > max)
							max = right - left;

						right++;
						left = right;
					} else
						right++;
				}
			}
			return max;
		}
	}
	
	@Test
	public void test1() {
		int[] nums = {1,1,0,1,1,1};
		int output = 3;
		Assert.assertEquals(findMaxConsecutiveOnes(nums), output);
	}
	
	@Test
	public void test2() {
		int[] nums = {0,0};
		int output = 0;
		Assert.assertEquals(findMaxConsecutiveOnes(nums), output);
	}
	
	@Test
	public void test3() {
		int[] nums = {0};
		int output = 0;
		Assert.assertEquals(findMaxConsecutiveOnes(nums), output);
	}
	
	@Test
	public void test4() {
		int[] nums = {1,0};
		int output = 1;
		Assert.assertEquals(findMaxConsecutiveOnes(nums), output);
	}

}
