package foundation.DailyProblems;

import org.junit.Test;
import org.testng.Assert;

public class HeightChecker_1051 {

	/*
	 * https://leetcode.com/problems/height-checker/description/
	 * 
	 * TestData Enumeration:
			6:46 pm
			{1,1,2,3,4,1,5} -> 1
			{1} -> 0
			{1,1,1,2,2,3,3,4,4,5,5,5,10} -> 0
			{5,4,2,3,1} -> 5
			6:47pm
			
		PseudoCode:
			intialize a integer variable counter = 0
			intialize a new array and using clone() clone the input array
			sort the cloned array
			compare input array and sorted cloned array elements
			if there is a mis-match
			then increment counter
			return counter
			6:52
			7:00pm
			
			coding started at 6:52
	 * 
	 */
	
	public int heightChecker(int[] heights) {
	        int[] tempHeight = heights.clone();
	        int counter = 0;
	        for(int i=0; i<tempHeight.length-1; i++){
	        	for(int j=i+1; j<tempHeight.length; j++){
	        		if(tempHeight[i]>tempHeight[j]) {
	        			tempHeight[i] = tempHeight[i] + tempHeight[j];
		        		tempHeight[j] = tempHeight[i] - tempHeight[j];
		        		tempHeight[i] = tempHeight[i] - tempHeight[j];
	        		}
	        	}
	        }	        
	        for(int i=0; i<heights.length; i++){
	            if(heights[i]!=tempHeight[i])
	                counter++;
	        }
	        return counter;
	}
	
	@Test
	public void test1() {
		int[] heights = {5,1,2,3,4};
		int output = 5;
		Assert.assertEquals(output, heightChecker(heights));
	}
	
	@Test
	public void test2() {
		int[] heights = {1,2,1,2,1,1,1,2,1};
		int output = 4;
		Assert.assertEquals(output, heightChecker(heights));
	}
	
	@Test
	public void test3() {
		int[] heights = {1,1,1,2,2,3,3,4,4,5,5,5,10};
		int output = 0;
		Assert.assertEquals(output, heightChecker(heights));
	}
	
	@Test
	public void test4() {
		int[] heights = {1,1,2,3,5,4};
		int output = 2;
		Assert.assertEquals(output, heightChecker(heights));
	}
	
	@Test
	public void test5() {
		int[] heights = {1};
		int output = 0;
		Assert.assertEquals(output, heightChecker(heights));
	}
}

