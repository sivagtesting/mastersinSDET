package foundation.week1.day2;

import org.junit.Assert;
import org.junit.Test;

public class Problem8PowerOfTwo {

	public static boolean powerOf2(int n) {
		while (n % 2 == 0)
			n = n / 2;
		return (n == 1);
	}

	@Test
	public void test1() {
		Assert.assertEquals(true, powerOf2(1));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(false, powerOf2(1037));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(true, powerOf2(2048));
	}

}
