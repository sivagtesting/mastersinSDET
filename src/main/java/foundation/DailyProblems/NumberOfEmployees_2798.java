package foundation.DailyProblems;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberOfEmployees_2798 {
	
	/*
	 * https://leetcode.com/problems/number-of-employees-who-met-the-target/description/
	 * 
	 * 
	 * 	TestData Enumeration:
			[5,1,4,2,2], 3 -> 2
			[5], 3 -> 1
			[5], 5 -> 1
			[0,0,0,0,0], 1 -> 0
			
			
		PsuedoCode:
			initialize a counter variable
			iterate over the hours array until length
			check element at current index is >= target
			if yes increment counter
			
			return counter
	 * 
	 * 
	 */
	
	public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
		int counter = 0;
		for (int i : hours) {
			if (i >= target)
				counter++;
		}
		return counter;
	}
	
	@Test
	public void test1() {
		int[] hours = {5,1,4,2,2};
		int target = 3;
		int count = 2;
		Assert.assertEquals(count, numberOfEmployeesWhoMetTarget(hours, target));
	}
	
	@Test
	public void test2() {
		int[] hours = {5};
		int target = 3;
		int count = 1;
		Assert.assertEquals(count, numberOfEmployeesWhoMetTarget(hours, target));
	}
	
	@Test
	public void test3() {
		int[] hours = {5};
		int target = 5;
		int count = 1;
		Assert.assertEquals(count, numberOfEmployeesWhoMetTarget(hours, target));
	}
	
	@Test
	public void test4() {
		int[] hours = {0,0,0,0,0};
		int target = 1;
		int count = 0;
		Assert.assertEquals(count, numberOfEmployeesWhoMetTarget(hours, target));
	}

}
