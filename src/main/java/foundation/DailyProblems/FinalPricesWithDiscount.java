package foundation.DailyProblems;

import org.junit.Assert;
import org.junit.Test;

public class FinalPricesWithDiscount {
	
	/*
	 * https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/
	 * 
	 * TestData Enumeration:
				{100} -> {100}
				{9,10} -> {9,10}
				{9,10,11,12,9,3} -> {6,1,2,9,3,6,3}
				{9,10,13,14,15} -> {9,10,13,14,15}
				
		PseudoCode:
			Step1: initialize discount price
			Step2: check if length of inputArray is 1 if yes then return the same array
			Step3: if no, repeat the following steps
			Step4: iterate using for loop - assign discountPrice = value at current index
			Step5: using nested for loop with starting index greater than i
			    step5.1: check if value at current index is lessthan or equal to discuOUtPrice 
			    Step5.2: if yes then update Discount price with prices[i] - price[j] and break the second loop
			    Step5.3: add it to the ouputPrices array
			Step6: return the array;
	 * 
	 */
	
	public static int[] finalPrices(int[] prices) {
		if (prices.length == 1)
			return prices;
		else {
			int discountPrice;
			int[] opPrices = new int[prices.length];
			for (int i = 0; i < prices.length; i++) {
				discountPrice = prices[i];
				for (int j = i + 1; j < prices.length; j++) {
					if (prices[i] >= prices[j] && discountPrice > (prices[i] - prices[j])) {
						discountPrice = prices[i] - prices[j];
						break;
					}
				}
				opPrices[i] = discountPrice;
			}
			return opPrices;
		}
	}
	
	@Test
	public void test1() {
		Assert.assertArrayEquals(new int[] {9,10}, finalPrices(new int[] {9,10}));
	}
	
	@Test
	public void test2() {
		Assert.assertArrayEquals(new int[] {100}, finalPrices(new int[] {100}));
	}
	
	@Test
	public void test3() {
		Assert.assertArrayEquals(new int[] {0,1,2,3,6,3}, finalPrices(new int[] {9,10,11,12,9,3}));
	}
	
	@Test
	public void test4() {
		Assert.assertArrayEquals(new int[] {9,10,13,14,15}, finalPrices(new int[] {9,10,13,14,15}));
	}

}
