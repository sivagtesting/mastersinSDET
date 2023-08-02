package foundation.week1.day1;

import org.junit.Assert;
import org.junit.Test;

public class ClassWork1 {
	
	public static boolean containsDuplicate(int[] nums) {
		for (int i = 0; i < nums.length-1; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if(nums[i]==nums[j])
					return true;
			}
		}
		return false;
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(true, containsDuplicate(new int[] {1,2,3,1}));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(true, containsDuplicate(new int[] {1,1,3,3}));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(false, containsDuplicate(new int[] {1,2,3,4}));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(true, containsDuplicate(new int[] {1,2,3,3}));
	}

}
