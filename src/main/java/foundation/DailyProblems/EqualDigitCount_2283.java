package foundation.DailyProblems;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EqualDigitCount_2283 {
	
	/*
	 * https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/description/
	 * 
	 * 
	 * 7.59
				Understanding
				8.01
				
		Test Data Enumeration:
				num = 1210 -> true
				num = 0 -> false
				num = 1 -> fasle
				num = 10 -> true
				8.04
				
		PseudoCode: 8.5
				intialize intNoOfOccurence = 0
				initialize boolean flag = false;
				iterate using for, until s.length();
				intNoOfOccurence = s.length() - s.replaceAll("i", "").length();
				check if intNoOfOccurence==(int)s.charAt(i))
				if yes then update boolean = true;
				if no then update return false;
				
				return boolean;
				8.13
				
				coding: 8.14
	 */
	
	public boolean digitCount(String num) {
		int intNoOfOccurence = 0;
		boolean flag = false;
		for (int i = 0; i < num.length(); i++) {
			intNoOfOccurence = num.length() - num.replaceAll(i + "", "").length();

			if (intNoOfOccurence == Character.getNumericValue(num.charAt(i)))
				flag = true;
			else
				return false;
		}
		return flag;
	}

	@Test
	public void test1() {
		String num = "1210";
		boolean result = true;
		Assert.assertEquals(result, digitCount(num));
	}

	@Test
	public void test2() {
		String num = "0";
		boolean result = false;
		Assert.assertEquals(result, digitCount(num));
	}

	@Test
	public void test3() {
		String num = "1";
		boolean result = false;
		Assert.assertEquals(result, digitCount(num));
	}

}
