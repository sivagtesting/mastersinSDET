package foundation.week1.day1.homework;

import org.junit.Assert;
import org.junit.Test;

public class Problem6MajoritElement {

	public static int majorityElement(int[] nums) {
		String uniqueDigits = "";
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (uniqueDigits.indexOf(String.valueOf(nums[i])) < 0)
				uniqueDigits = uniqueDigits + nums[i] + ",";
		}
		uniqueDigits = uniqueDigits.substring(0, uniqueDigits.length() - 1);
		String[] eachDigit = uniqueDigits.split(",");
		for (int i = 0; i < eachDigit.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (Integer.parseInt(eachDigit[i])==nums[j])
					count++;
			}
			if (count > (nums.length / 2))
				return Integer.parseInt(eachDigit[i]);
		}
		return 0;
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(1, majorityElement(new int[] {-1,1,1,1,2,1}));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(1, majorityElement(new int[] {1,1,1,1}));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(1, majorityElement(new int[] {1,1,2,2,2,2,1,3,1,1,1}));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(3, majorityElement(new int[] {1,3,3}));
	}

}
