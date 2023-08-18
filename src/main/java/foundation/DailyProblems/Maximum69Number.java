package foundation.DailyProblems;

import org.junit.Test;
import org.testng.Assert;

public class Maximum69Number {
	/*
	 * https://leetcode.com/problems/maximum-69-number/description/
	 * 
	 * TestDataEnumeration:
			6 -> 9
			9 -> 9
			6669 -> 9669
			9999 -> 9999
			
		PseudoCode:
			Step1: Convert the given integer to String
			Step2: replace the first occurence of 6 to 9
			Step3: convert the string to integer and return
	 * 
	 * 
	 */
	
	public static int maximum69Number(int num) {
		return Integer.parseInt(String.valueOf(num).replaceFirst("6", "9"));
	}
	
	public static int maximum69Number2(int num) {
		int temp = num, remainder = 0, count = 0, sum = 0, tempCount=0;
		while (temp > 0) {
			remainder = temp % 10;
			temp = temp / 10;
			count++;
			if (remainder == 6) {
				sum = 3;
				tempCount = count;
				while (tempCount > 1) {
					sum = sum * 10;
					tempCount -- ;
				}
			}
		}
		return num + sum;
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(9, maximum69Number(6));
		Assert.assertEquals(9, maximum69Number2(6));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(9969, maximum69Number(9669));
		Assert.assertEquals(9969, maximum69Number2(9669));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(9669, maximum69Number(6669));
		Assert.assertEquals(9669, maximum69Number2(6669));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(9, maximum69Number(9));
		Assert.assertEquals(9, maximum69Number2(9));
	}
	
	@Test
	public void test5() {
		Assert.assertEquals(9999, maximum69Number(9999));
		Assert.assertEquals(9999, maximum69Number2(9999));
	}

}
