package foundation.week1.HomeWork;

import org.junit.Assert;
import org.junit.Test;

public class AddDigits {
	
	/*
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
		if(num<10)
			return num;
		else {
			int temp = num;
			int tempSum = num;
			int sum = 0;
			while(tempSum>10) {
				int quotient=1, remainder;
				while(quotient>0) {
					quotient = temp/10;
					remainder = temp%10;
					sum = sum + remainder;
				}
				temp = tempSum;
				tempSum = sum;
			}
			return tempSum;
		}
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(2, addDigits(38));
	}
	
	public static void main(String[] args) {
			System.out.println("381/10 = "+381/10);
			System.out.println("381%10 = "+381%10);
			System.out.println("38/10 = "+38/10);
			System.out.println("38%10 = "+38%10);
			System.out.println("3/10 = "+3/10);
			System.out.println("3%10 = "+3%10);
		
	}

}
