package foundation.week1.HomeWork;

import org.junit.Assert;
import org.junit.Test;

public class AddDigits_258 {
	
	/*
	 * https://leetcode.com/problems/add-digits/description/
	 * 
	 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
					Example 1:
					Input: num = 38
					Output: 2
					Explanation: The process is
					38 --> 3 + 8 --> 11
					11 --> 1 + 1 --> 2 
					Since 2 has only one digit, return it.
	 * 
	 */
	
	
	public static int addDigits(int num) {
		int temp, temp1 = 0;
		int sum=0;
		if(num<10)
			return num;
		else {
			temp = num;
			while(temp>9) {
				temp1 = temp;
				while(temp1>0) {
					sum = sum + temp1%10;
					temp1 = temp1/10;
				}
				temp = sum;
				sum = 0;
			}
		}
		return temp;
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(2, addDigits(38));
	}

}
