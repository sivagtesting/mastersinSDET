package foundation.week11.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IntegerPalindrome {
	
	public boolean integerPalindromeString(int num) {
		StringBuilder sb = new StringBuilder(String.valueOf(num));
		int length = sb.length();
		int left = (length/2)-1;
		int right = length%2==0 ? length/2 : (length/2)+1;
		while(left>=0) {
			if(sb.charAt(left)!=sb.charAt(right))
				return false;
			left--;
			right++;
		}
		return true;
	}
	
	public boolean integerPalindrome(int num) {
		int tempNum = num;
		int output = 0;
		while(tempNum>0) {
			output = (output * 10) + tempNum%10;
			tempNum = tempNum/10;
		}
		return output == num;
	}
	
	@Test
	public void test1() {
		int num= 12321;
		boolean output = true;
		Assert.assertEquals(integerPalindromeString(num), output);
		Assert.assertEquals(integerPalindrome(num), output);
	}
	
	@Test
	public void test2() {
		int num= 2;
		boolean output = true;
		Assert.assertEquals(integerPalindromeString(num), output);
		Assert.assertEquals(integerPalindrome(num), output);
	}
	
	@Test
	public void test3() {
		int num= 121;
		boolean output = true;
		Assert.assertEquals(integerPalindromeString(num), output);
		Assert.assertEquals(integerPalindrome(num), output);
	}
	
	@Test
	public void test4() {
		int num= 122;
		boolean output = false;
		Assert.assertEquals(integerPalindromeString(num), output);
		Assert.assertEquals(integerPalindrome(num), output);
	}

}
