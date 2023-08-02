package foundation.week1.HomeWork;

import org.junit.Assert;
import org.junit.Test;

public class BestTimeToBuyAndSellStock {
	public static int maxProfit(int[] prices) {
		int buyPrice, sellPrice, buyIndex = 0, sellIndex = 0;
		buyPrice = Integer.MAX_VALUE;
		sellPrice = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length - 1; i++) {
			if (buyPrice > prices[i]) {
				buyPrice = prices[i];
				buyIndex = i;
			}
		}
		for (int i = buyIndex+1; i < prices.length; i++) {
			if (sellPrice < prices[i]) {
				sellPrice = prices[i];
				sellIndex = i;
			}
		}
		if (buyPrice < sellPrice && buyIndex < sellIndex)
			return sellPrice - buyPrice;
		else
			return 0;
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(5, maxProfit(new int[] {7,1,5,3,6,4}));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(0, maxProfit(new int[] {7,6,4,3,1}));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(1, maxProfit(new int[] {2,1,2,0,1}));
	}

	@Test
	public void test4() {
		Assert.assertEquals(2, maxProfit(new int[] {2,1,2,1,0,1,2}));
	}

	@Test
	public void test5() {
		Assert.assertEquals(4, maxProfit(new int[] {3,2,6,5,0,3}));
	}
}
