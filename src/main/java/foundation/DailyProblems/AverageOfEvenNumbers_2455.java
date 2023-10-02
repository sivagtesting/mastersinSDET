package foundation.DailyProblems;

import org.junit.Assert;
import org.junit.Test;

public class AverageOfEvenNumbers_2455 {
	
	public static int getAverageOfEvenNumberDivisibleBy3(int[] nums) {
		int counter = 0, sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]%2==0) {
				if(nums[i]%3==0) {
					sum = sum + nums[i];
					counter++;
				}
			}
		}
		if(counter==0)
			return 0;
		else
			return sum/counter;
	}
	
	public static int getAverageOfEvenNumberDivisibleBy3_optimised(int[] nums) {
		int counter = 0, sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]%6==0) {
				sum += nums[i];
				counter++;
			}
		}
		if(counter==0)
			return 0;
		else
			return sum/counter;
	}
	
	@Test
	public void test1() {
		int[] nums = {1,3,7,8,6,9,12};
		Assert.assertEquals(9, getAverageOfEvenNumberDivisibleBy3(nums));
		Assert.assertEquals(9, getAverageOfEvenNumberDivisibleBy3_optimised(nums));
	}
	
	@Test
	public void test2() {
		int[] nums = {6,12,18,24};
		Assert.assertEquals(15, getAverageOfEvenNumberDivisibleBy3(nums));
		Assert.assertEquals(15, getAverageOfEvenNumberDivisibleBy3_optimised(nums));
	}
	
	@Test
	public void test3() {
		int[] nums = {1,2,4,8,10};
		Assert.assertEquals(0, getAverageOfEvenNumberDivisibleBy3(nums));
		Assert.assertEquals(0, getAverageOfEvenNumberDivisibleBy3_optimised(nums));
	}
	
	
	public void test4() {
		int[] nums = {};
		Assert.assertEquals(9, getAverageOfEvenNumberDivisibleBy3(nums));
		Assert.assertEquals(9, getAverageOfEvenNumberDivisibleBy3_optimised(nums));
	}

}

