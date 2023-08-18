package foundation.DailyProblems;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SpyNumber {
	
	/*
	 * Find if no is Spy Number - A number whose sum of the digits is equal to the product of its digits is called Spy number.
	 * 
	 * Example: 132
	 * 	Sum of Digits = 1 + 3 + 2 = 6
	 * 	Product of digits = 1 * 3 * 2 = 6
	 * Hence 132 is a spy number
	 * 
	 * Test data enumeration:
	 *  132 -> true
	 *  1 -> true
	 *  102 -> false
	 *  1124 -> true
	 *  
	 *  PseudoCode:
	 *  Step1: Initialize product = 1, sum = 0, remainder = 0
	 *  Step2: Repeat the following steps until num>0
	 *  	Step2.1: remainder = num%10;
	 *  	Step2.2: num = num/10;
	 *  	Step2.3: product = product * remainder;
	 *  	Step2.4: sum = sum + remainder;
	 *  Step3: return product==sum;
	 *  
	 *  
	 */
	
	public static boolean isSpyNumber(int num) {
		int product = 1, sum = 0, remainder = 0;
		while (num > 0) {
			remainder = num % 10;
			num = num / 10;
			product = product * remainder;
			sum = sum + remainder;
		}
		return product == sum;
	}
	
	@Test
	public void test1() {
		Assert.assertTrue(isSpyNumber(132));
	}
	
	@Test
	public void test2() {
		Assert.assertTrue(isSpyNumber(1));
	}
	
	@Test
	public void test3() {
		Assert.assertFalse(isSpyNumber(102));
	}
	
	@Test
	public void test4() {
		Assert.assertTrue(isSpyNumber(1124));
	}

}
