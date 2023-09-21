package mandatoryHomework.TwoPointers;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberOfSubArrays_1343 {
	
	/*
	 * https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/
	 * 
	 * initialize integer counter =0, end =0, sum=0;
	 * repeat the following steps using while unti end>k
	 * 		sum += arr[k];
	 * check if sum/k>=threshold
	 * 		if yes then increment counter;
	 * repeat the following steps using while unti end<arr.length
	 * 		add arr[end] to sum and subtract arr[end-k]
	 * 		check if sum/k>=threshold
	 * 		if yes then increment counter;
	 * return counter;
	 * 
	 * TimeComplexity: O[N]
	 * 
	 */
	
	public int numOfSubarrays(int[] arr, int k, int threshold) {
		int counter = 0, end = 0, sum = 0;
		while (end < k)
			sum += arr[end++];
		if (sum / k >= threshold)
			counter++;
		while (end < arr.length) {
			sum += arr[end] - arr[end - k];
			end++;
			if (sum / k >= threshold)
				counter++;
		}
		return counter;
	}
	
	@Test
	public void test1() {
		int[] arr = {11,13,17,23,29,31,7,5,2,3};
		int k = 3;
		int threshold = 5;
		int output = 6;
		Assert.assertEquals(output, numOfSubarrays(arr, k, threshold));
	}
	
	@Test
	public void test2() {
		int[] arr = {1};
		int k = 1;
		int threshold = 0;
		int output = 1;
		Assert.assertEquals(output, numOfSubarrays(arr, k, threshold));
	}
	
	@Test
	public void test3() {
		int[] arr = {2};
		int k = 1;
		int threshold = 3;
		int output = 0;
		Assert.assertEquals(output, numOfSubarrays(arr, k, threshold));
	}
	
	@Test
	public void test4() {
		int[] arr = {2,5,8,1,2,3};
		int k = 2;
		int threshold = 5;
		int output = 1;
		Assert.assertEquals(output, numOfSubarrays(arr, k, threshold));
	}

}
