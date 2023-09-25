package foundation.week11.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SmallestSubsequentArray {
	
	/*
	 * Given an array of positive integers, find the smallest subsequence array length whoese sum of elements is greater
	 * than a given number k
	 * 
	 * Input: arr = {1,2,3,4,5} K=10
	 * Output: 3 
	 * 
	 * TestData: 
	 * {1,2,0,0,1}, 1 -> 1
	 * {1,2,0,0,1}, 1 -> 1 
	 * 
	 * 
	 * PseudoCode: 
	 * assign min as integer.maxvalue
	 * initialise start =0, end= 1
	 * using nested for loop with start index as 0 and end index <length-1
	 * using for loop start index  = i+1; until end <s.length
	 * add each element with element at index i
	 * after adding each element check if the sum>k
	 * if yes then check if i+j < min then assing min = i+j & break
	 * if no then continue
	 * 
	 * 
	 * 
	 */
	
	public int smallestSubsequentArray(int[] arr, int k) {
		int min = Integer.MAX_VALUE;
		int sum = 0;
		
		for(int i=0; i<arr.length-1; i++) {
			sum = arr[i];
			if(sum>k) {
				if(min>i)
					min = 1;
			} else {
				for (int j = i+1; j < arr.length; j++) {
					sum += arr[j];
					if(sum>k) {
						if(min>j-i)
							min = j-i;
						break;
					}
				}
			}
		}
		
		return min;
	}
	
	// Two Pointers - Grow and Shrink Concept
	public int smallestSubsequentArray_GrowAndShrinkConcept(int[] arr, int k) {
		/*
		 * intialize left =0, right=0, currentSum =0, windowSize =Integer.MAX_VALUE;
		 * do the following using while until right<arr.length
		 * currentSum += arr[left]
		 * do the following using while until currentSum>k
		 * Check if windowSize is greater than right-left +1
		 * 		if yes then set windowSize = right-left +1;
		 * 
		 * update currentSum -= arr[left];
		 * increment left;
		 * 
		 * outside inner loop right++
		 * 
		 * return windowSize
		 */
		
		int left = 0, right = 0, currentSum = 0, windowSize = Integer.MAX_VALUE;
		while(right<arr.length) {
			currentSum += arr[right];
			while(currentSum>k) {
				windowSize = (windowSize > (right-left) + 1) ? (right-left) + 1 : windowSize;
				
				currentSum -= arr[left++];
			}
			right++;
		}
		return windowSize;
		
	}
	
	@Test
	public void test1() {
		int[] input = {1,2,3,4,5};
		int k = 10;
		int output = 3;
//		Assert.assertEquals(smallestSubsequentArray(input, k), output);
		Assert.assertEquals(smallestSubsequentArray_GrowAndShrinkConcept(input, k), output);
	}
	
	@Test
	public void test2() {
		int[] input = {1,2,0,0,1};
		int k = 1;
		int output = 1;
//		Assert.assertEquals(smallestSubsequentArray(input, k), output);
		Assert.assertEquals(smallestSubsequentArray_GrowAndShrinkConcept(input, k), output);
	}

}
