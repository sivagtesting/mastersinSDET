package foundation.DailyProblems;

import org.junit.Assert;
import org.junit.Test;

public class ProductSign {
	public static int getProductSign(int[] nums) {
		int product = 1;
		for (int i = 0; i < nums.length; i++)
			product = product * nums[i];
		if (product > 0)
			return 1;
		else if (product < 0)
			return -1;
		else
			return 0;
	}

	@Test
	public void test1() {
		Assert.assertEquals(1, getProductSign(new int[] { 1, 2, 3, 4 }));
	}

	@Test
	public void test2() {
		Assert.assertEquals(1, getProductSign(new int[] { 1, 2, 3, -4, -8, 3 }));
	}

	@Test
	public void test3() {
		Assert.assertEquals(1, getProductSign(new int[] { -1, -2, -3, 4, 6, -7 }));
	}

	@Test
	public void test4() {
		Assert.assertEquals(-1, getProductSign(new int[] { -1, 2, 3, 4, 5 }));
	}

	@Test
	public void test5() {
		Assert.assertEquals(-1, getProductSign(new int[] { 2, 3, 4, -1 }));
	}

	@Test
	public void test6() {
		Assert.assertEquals(0, getProductSign(new int[] { 2, 3, 4, -1, 0 }));
	}

}
