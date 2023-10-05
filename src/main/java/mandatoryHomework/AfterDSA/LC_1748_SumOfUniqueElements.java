package mandatoryHomework.AfterDSA;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LC_1748_SumOfUniqueElements {
		/*
		 * https://leetcode.com/problems/sum-of-unique-elements/description/
		 * 
		 	PseudoCode: Brute Force
				intialize a boolean flag = true;
				intialize a integer sum = 0;
				using nested for loop iterate over the array - index i
				    inside loop iterate iterate thru remaining elements - index j
				        reset boolean to true;
				        check if element at index i is matching with other element
				            if yes then update flag as false;
				        outside inner for loop check if flag is true
				            if yes then add the element at index1 to sum and reset flag to false
				return sum
				
			PseudoCode: Using HashMap:
				initialize a HashMap of type Integer, Integer
				iterate over the input array
				    add each element from array as key and its occurence as value
				iterate over the map keyset
				    check if value of key eq 1
				        if yes then add to sum
				
				return sum
		 * 
		 */
	// Time Complexity: O(N)
	// Space Complexity: O(N)
	public int sumOfUnique(int[] nums) {
		int sum = 0;
		Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();

		// adds the frequency of the each element to the map value
		for (int i : nums)
			numsMap.put(i, numsMap.getOrDefault(i, 0) + 1);

		// iterate over the key set of map and checks the value of map is 1 then adds
		// that value
		for (int i : numsMap.keySet()) {
			if (numsMap.get(i) == 1)
				sum += i;
		}
		return sum;
	}

	@Test
	public void test1() {
		int[] nums = { 1, 2, 3, 2 };
		int output = 4;
		Assert.assertEquals(sumOfUnique(nums), output);
	}

	@Test
	public void test2() {
		int[] nums = { 1, 1, 1, 1, 1 };
		int output = 0;
		Assert.assertEquals(sumOfUnique(nums), output);
	}

	@Test
	public void test3() {
		int[] nums = { 1, 2, 3, 4, 5 };
		int output = 15;
		Assert.assertEquals(sumOfUnique(nums), output);
	}
}
