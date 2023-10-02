package foundation.DailyProblems;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

public class AlternatingDigitSum_2544 {
	
	/*
	 * https://leetcode.com/problems/alternating-digit-sum/
	 * 
	 * PsuedoCode:
	 * Step1: Initialize a integer sum
	 * Step2: Convert the given input number to string
	 * Step3: Convert the string to character array
	 * Step4: Iterate over the character array from Step2
	 * Step5: if the index is odd then subtract the integer value of the current index to the previous value
	 * Step6: print the output value 
	 * 
	 * 
	 */
	
	public static int alternatingDigitSum(int n) {
		String num = String.valueOf(n);
		int sum=0;
		char[] charArray = num.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if(i%2==0)
				sum = sum + (charArray[i] - '0');
			else
				sum = sum - (charArray[i] - '0');
		}
		return sum;
	}
		
	@Test
	public void test1() {
		Assert.assertEquals(4, alternatingDigitSum(521));
		String name = "";
		name.replaceFirst("9", "6");
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(1, alternatingDigitSum(111));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(0, alternatingDigitSum(886996));
	}

}
