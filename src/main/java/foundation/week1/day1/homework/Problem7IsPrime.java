package foundation.week1.day1.homework;

import org.junit.Assert;
import org.junit.Test;

public class Problem7IsPrime {
	
	public static boolean isPrime(int num) {
		if(num==2)
			return true;
		else if(num>2) {
			for(int i=2;i<num/2;i++) {
				if(num%i==0)
					return false;
			}
			return true;
		}
		return false;
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(true, isPrime(2));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(true, isPrime(3));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(false, isPrime(1));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(false, isPrime(81));
	}
	
	@Test
	public void test5() {
		Assert.assertEquals(true, isPrime(257));
	}
	
}
