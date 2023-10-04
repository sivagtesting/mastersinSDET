package mandatoryHomework.AfterDSA;

import java.util.HashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LC_888_FairCandySwap {
	
	/*
	 * https://leetcode.com/problems/fair-candy-swap/description/
	 * 
	 */
	
	//Time Complexity: O(N+M)
	//Space Complexity: O(N+M)
	public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
		int alice = 0, bob = 0;
		Set<Integer> aliceSet = new HashSet<Integer>();
		Set<Integer> bobSet = new HashSet<Integer>();
		for (int i : aliceSizes) {
			alice += i;
			aliceSet.add(i);
		}

		for (int i : bobSizes) {
			bob += i;
			bobSet.add(i);
		}
		int equalCandyNum = (alice + bob) / 2;
		for (int i : aliceSet) {
			if (bobSet.contains(i + (equalCandyNum - alice)))
				return new int[] { i, i + (equalCandyNum - alice) };
		}
		return new int[] {};
	}
	
	@Test
	public void test1() {
		int[] aliceSizes = {1,1};
		int[] bobSizes = {2,2};
		int[] output = {1,2};
		Assert.assertEquals(fairCandySwap(aliceSizes, bobSizes), output);
	}
	
	@Test
	public void test2() {
		int[] aliceSizes = {1,2};
		int[] bobSizes = {2,3};
		int[] output = {1,2};
		Assert.assertEquals(fairCandySwap(aliceSizes, bobSizes), output);
	}
	
	@Test
	public void test3() {
		int[] aliceSizes = {2};
		int[] bobSizes = {1,3};
		int[] output = {2,3};
		Assert.assertEquals(fairCandySwap(aliceSizes, bobSizes), output);
	}

}
