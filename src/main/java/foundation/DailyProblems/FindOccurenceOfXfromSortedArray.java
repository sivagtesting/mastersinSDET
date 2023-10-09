package foundation.DailyProblems;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FindOccurenceOfXfromSortedArray {
	
	/*
	 *  Given a sorted array arr[] and a number x, write a function that counts the occurrences of x in arr[].
			arr[] = {1, 1, 2, 2, 2, 2, 3}   x = 2
			output = 4
	 */
	
	public int findx(int[] arr, int x) {
		int[] ascii = new int[arr.length-1];
		for(int i=0; i<arr.length; i++)
			ascii[arr[i]]++;
		return ascii[x];
	}
	
	@Test
	public void test1() {
		int[] arr = {1, 1, 2, 2, 2, 2, 3};
		int x = 2;
		int output = 4;
		Assert.assertEquals(findx(arr, x), output);
	}
	
	@Test
	public void test2() {
		int[] arr = {1, 1, 2, 2, 2, 2, 3};
		int x = 3;
		int output = 1;
		Assert.assertEquals(findx(arr, x), output);
	}

}
