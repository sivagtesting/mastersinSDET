package foundation.DailyProblems;

import java.util.HashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LC_217_ContainsDuplicate {
	
	/*
	 	https://leetcode.com/problems/contains-duplicate/description/
	 * 
	 */
	
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> uniqueIntegers = new HashSet<Integer>();
        for(int i: nums){
            if(!uniqueIntegers.add(i)) return true;
        }
        return false;
	}
	
	@Test
	public void test1() {
		int[] nums = {1,2,3,1};
		boolean output = true;
		Assert.assertEquals(containsDuplicate(nums), output);
	}
	
	@Test
	public void test2() {
		int[] nums = {1,2,3,4};
		boolean output = false;
		Assert.assertEquals(containsDuplicate(nums), output);
	}
	
	@Test
	public void test3() {
		int[] nums = {1,1,1,3,3,4,3,2,4,2};
		boolean output = true;
		Assert.assertEquals(containsDuplicate(nums), output);
	}

}
