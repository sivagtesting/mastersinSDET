package foundation.week1.HomeWork;

import org.junit.Assert;
import org.junit.Test;

public class FindingXplusOneCount {
	
	
	/*
	 * Question:4
	 * Given an integer array arr, count how many elements x there are, 
			   such that x + 1 is also in arr. 
			   If there are duplicates in arr, count them separately.
			   
			   example 1: input = [1, 2, 3]
						  output = 2
						explanation: when x is 1, we see x+1 (2) is present in input
									 when x is 2, we see x+1 (3) is present in input
									 when x is 3, we see x+1 (4) is not present in input
									so no of presence of x+1 is 2
			   example 2: input = [1, 1, 3, 3, 5, 5, 7, 7]
						  output = 0
						  explanation: no occurence of x+1 for x
						  
			   example 3: input = [1, 1, 2]
						  output = 2
						  explanation: when x is 1, we see x+1 (2) is present in input
									   when x is 1, we see x+1 (2) is present in input
									   when x is 2, we see x+1 (3) is not present in input
	 */
	
	
	/*
	 * Pseudo Code :
	 * 
	 * initialize a count variable
	 * iterate through the input array in a nested for loop
	 * add one to the value in index i and compare it with rest of the elements in the array
	 * if it matches then increase the counter
	 * once the loop is completed return the counter.
	 */
	
	public static int findCount(int[] inpArray) {
		int count = 0;
		for (int i = 0; i < inpArray.length; i++) {
			for (int j = 0; j < inpArray.length; j++) {
				if (inpArray[i] + 1 == inpArray[j])
					count++;
			}
		}
		return count;

	}
	
	@Test
	public void test1() {
		Assert.assertEquals(2, findCount(new int[] {1, 2, 3}));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(0, findCount(new int[] {1, 1, 3, 3, 5, 5, 7, 7}));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(2, findCount(new int[] {1, 1, 2}));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(5, findCount(new int[] {1, 2, 2, 3, 0}));
	}

}
