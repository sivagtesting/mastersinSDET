package mandatoryHomework.AfterDSA;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MajorityElement_169 {
	
	/*
	 * https://leetcode.com/problems/majority-element/description/
	 * 
	 	PseudoCode - HashMap:
			Initialize a hashmap Integer,Integer
			Iterate over the input array, add each element in the array to the map with occurence of the element as value
			iterate over the hashmap, check each key's value, return the value which is more gt n/2
	 * 
	 */
	
	// TimeComplexity: O(N) SpaceComplexity: O(N)
	public int majorityElement(int[] nums) {
		int occurence = nums.length / 2;
		Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();

		for (int num : nums) {
			numsMap.put(num, numsMap.getOrDefault(num, 0) + 1);
		}
		for (Integer i : numsMap.keySet()) {
			if (numsMap.get(i) > occurence)
				return i;
		}
		return 0;
	}

	// Considering 0-9 elements only
	// TimeComplexity: O(N) SpaceComplexity: O(N)
	public int majorityElement_ASCIIArray(int[] nums) {
		int[] tempArray = new int[10];
		int occurence = nums.length / 2;
		for (int i = 0; i < nums.length; i++)
			tempArray[nums[i]] = tempArray[nums[i]] + 1;
		for (int i = 0; i < tempArray.length; i++) {
			if (tempArray[i] > occurence)
				return i;
		}
		return 0;
	}

	@Test
	public void test1() {
		int[] nums = { 3, 2, 3 };
		int output = 3;
		Assert.assertEquals(majorityElement(nums), output);
		Assert.assertEquals(majorityElement_ASCIIArray(nums), output);
	}

	@Test
	public void test2() {
		int[] nums = { 3, 7, 7, 7, 3, 7, 5, 5, 7, 7 };
		int output = 7;
		Assert.assertEquals(majorityElement(nums), output);
		Assert.assertEquals(majorityElement_ASCIIArray(nums), output);
	}

}
