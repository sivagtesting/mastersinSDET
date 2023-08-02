package foundation.week1.HomeWork;

import org.junit.Assert;
import org.junit.Test;

public class Problem11Palindrom {
	
	public static boolean isPalindrome(int x) {
		int reversedNum = 0;
		int temp = x;
		while(temp>0) {
			reversedNum = (reversedNum * 10) + (temp % 10);
			temp = temp/10;
		}
		if(x==reversedNum)
			return true;
		else
			return false;
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(true, isPalindrome(121));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(false, isPalindrome(-121));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(true, isPalindrome(1));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(true, isPalindrome(1221));
	}

}
