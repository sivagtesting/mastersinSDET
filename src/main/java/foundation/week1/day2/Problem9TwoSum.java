package foundation.week1.day2;

import org.junit.Assert;
import org.junit.Test;

public class Problem9TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		int[] output = new int[2];
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]+nums[j]==target) {
					output[0] = i;
					output[1] = j;
				}
					
			}
		}
		return output;
	}
	
	@Test
	public void test1() {
		Assert.assertArrayEquals(new int[] {0,3}, twoSum(new int[]  {1,2,6,4}, 5));
	}
	
	@Test
	public void test2() {
		Assert.assertArrayEquals(new int[] {2,3}, twoSum(new int[] {1,6,7,8}, 15));
	}
	
	@Test
	public void test3() {
		Assert.assertArrayEquals(new int[] {0,1}, twoSum(new int[] {1,0,2,4,6,10}, 1));
	}
	
	@Test
	public void test4() {
		Assert.assertArrayEquals(new int[] {2,3}, twoSum(new int[] {1,0,4,-1}, 3));
		
	}
}
