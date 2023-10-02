package foundation.DailyProblems;

import org.junit.Test;
import org.testng.Assert;

public class CanPlaceFlowers_605 {
	
	/*
	 * https://leetcode.com/problems/can-place-flowers/description/
	 * 
	 * 
	 */

	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		if (flowerbed.length == 1) {
			if (flowerbed[0] == 0) {
				flowerbed[0] = 1;
				n--;
			}
		} else {
			for (int i = 1; i < flowerbed.length; i++) {
				if (i == 0) {
					if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
						flowerbed[i] = 1;
						n--;
					}
				} else if (i == flowerbed.length - 1) {
					if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
						flowerbed[i] = 1;
						n--;
					}
				} else {
					if (flowerbed[i] == 0) {
						if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
							n--;
							flowerbed[i] = 1;
						}

					}
				}
			}
		}

		return n <= 0;
	}

	@Test
	public void test1() {
		Assert.assertEquals(true, canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 1));
	}

	@Test
	public void test2() {
		Assert.assertEquals(true, canPlaceFlowers(new int[] { 0 }, 1));
	}

	@Test
	public void test3() {
		Assert.assertEquals(false, canPlaceFlowers(new int[] { 1 }, 1));
	}

	@Test
	public void test4() {
		Assert.assertEquals(true, canPlaceFlowers(new int[] { 1, 0, 0, 1, 0, 0 }, 1));
	}

}
