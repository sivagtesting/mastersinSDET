package foundation.week1.day1;

import org.junit.Assert;
import org.junit.Test;

public class ClassWork2 {

	public static int findCompletedRows(int coins) {
		int completeRows = 0;
		int remainingCoins = coins;
		if (coins != 0) {
			if (coins > 1) {
				for (int i = 1; i <= coins; i++) {
					remainingCoins = remainingCoins - i;
					if (remainingCoins < 0)
						return i - 1;
				}
			} else
				return 1;
		}

		return completeRows;
	}
	
	//Solution2
	public static int arrangingCoins(int n) {
		int counter=0;
		for (int i = 1; i <= n; i++) {
			if(n-i>=0)
				counter++;
			n=n-i;
		}
		return counter;
	}

	@Test
	public void test1() {
		Assert.assertEquals(2, arrangingCoins(5));
	}

	@Test
	public void test2() {
		Assert.assertEquals(4, arrangingCoins(10));
	}

	@Test
	public void test3() {
		Assert.assertEquals(1, arrangingCoins(1));
	}

	@Test
	public void test4() {
		Assert.assertEquals(0, arrangingCoins(0));
	}
}
