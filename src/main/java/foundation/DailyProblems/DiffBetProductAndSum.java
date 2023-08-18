package foundation.DailyProblems;

import org.junit.Assert;
import org.junit.Test;

public class DiffBetProductAndSum {
	public static int getDifferenceBetProductAndSumOfDigits(int input) {
		int product = 1, sum = 0, remainder = 0;
		if (input > 0) {
			while (input > 0) {
				remainder = input % 10;
				sum = sum + remainder;
				product = product * remainder;
				input = input / 10;
			}
			return product - sum;
		} else
			return 0;
	}

	@Test
	public void test1() {
		Assert.assertEquals(5, getDifferenceBetProductAndSumOfDigits(322));
	}

	@Test
	public void test2() {
		Assert.assertEquals(0, getDifferenceBetProductAndSumOfDigits(0));
	}

	@Test
	public void test3() {
		Assert.assertEquals(0, getDifferenceBetProductAndSumOfDigits(1));
	}

	@Test
	public void test4() {
		Assert.assertEquals(-2, getDifferenceBetProductAndSumOfDigits(101));
	}

}
