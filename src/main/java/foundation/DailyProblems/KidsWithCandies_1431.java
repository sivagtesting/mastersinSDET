package foundation.DailyProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class KidsWithCandies_1431 {
	
	/*
	 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/
	 * 
	 * 	
	 * TestData Enumeration: 	
			[2,3,5,1,3], 3 -> true, true, true, true
			[5], 1 -> true
			[1,1], 2 -> true
			[2,1], 1 -> true, true
		
		PseudoCode:
			initialize int maxNoOfCandy = Integer.minValue
			initialize a result array of size equal to candies.
			iterate over the array until candies.length
			check if the element at current index is > maxNoOfCandy
			if yes, then update maxNoOfCandy = current eleemtn
			
			iterate over the input candy array
			check if element at current index + extraCandies is >= maxNoOfCandy
			if yes then add true to result list
			if no then add false to result list
	 * 
	 * 
	 */
	
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

		int maxNoOfCandy = Integer.MIN_VALUE;
		List<Boolean> result = new ArrayList<Boolean>();
		for (int noOfCandy : candies) {
			if (noOfCandy > maxNoOfCandy)
				maxNoOfCandy = noOfCandy;
		}
		// System.out.println(maxNoOfCandy);

		for (int noOfCandy : candies) {
			if((noOfCandy+extraCandies) >= maxNoOfCandy)
				result.add(true);
			else
				result.add(false);
		}
		return result;
	}
	
	@Test
	public void test1() {
		int[] candies = {2,3,5,1,3};
		int extraCandies = 3;
		Boolean[] tempOut = {true, true, true, false, true};
		List<Boolean> output = new ArrayList<Boolean>(Arrays.asList(tempOut));
		Assert.assertEquals(output, kidsWithCandies(candies, extraCandies));
	}
	
	@Test
	public void test2() {
		int[] candies = {5};
		int extraCandies = 1;
		Boolean[] tempOut = {true};
		List<Boolean> output = new ArrayList<Boolean>(Arrays.asList(tempOut));
		Assert.assertEquals(output, kidsWithCandies(candies, extraCandies));
	}
	
	@Test
	public void test3() {
		int[] candies = {0,10};
		int extraCandies = 1;
		Boolean[] tempOut = {false, true};
		List<Boolean> output = new ArrayList<Boolean>(Arrays.asList(tempOut));
		Assert.assertEquals(output, kidsWithCandies(candies, extraCandies));
	}
	
	@Test
	public void test4() {
		int[] candies = {2,1};
		int extraCandies = 1;
		Boolean[] tempOut = {true, true};
		List<Boolean> output = new ArrayList<Boolean>(Arrays.asList(tempOut));
		Assert.assertEquals(output, kidsWithCandies(candies, extraCandies));
	}
}


