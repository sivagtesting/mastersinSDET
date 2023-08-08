package foundation.DailyProblems;

import org.junit.Test;
import org.testng.Assert;

public class ThreeDivisors {

	public static boolean isHavingThreeDivisors(int n) {
		int counter = 2;
		if (n > 3) {
			for (int i = 2; i <= n / 2; i++) {
				if (n % i == 0)
					counter++;
				if (counter > 3)
					return false;
			}
			if (counter == 3)
				return true;
			else
				return false;
		} else
			return false;
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(false, isHavingThreeDivisors(1));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(false, isHavingThreeDivisors(2));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(false, isHavingThreeDivisors(3));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(true, isHavingThreeDivisors(4));
	}
	
	@Test
	public void test5() {
		Assert.assertEquals(false, isHavingThreeDivisors(5));
	}
	
	@Test
	public void test6() {
		Assert.assertEquals(false, isHavingThreeDivisors(10));
	}

}
