package foundation.week1.day1;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

public class ClassWork {
	public static int findOccurence(int[] nums, int x) {
		int count=0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]==x)
				count++;
			else if(nums[i]>x)
				break;
		}
		if(count>0)
			return count;
		else
			return -1;
	}
	
	@Test //positive
	public void test() {
		Assert.assertEquals(4, findOccurence(new int[] {1, 1, 2, 2, 2, 2, 3}, 2));
	}
	
	@Test//last element (edge)
	public void test1() {
		Assert.assertEquals(1, findOccurence(new int[] {1, 1, 2, 2, 2, 2, 3}, 3));
	}
	
	@Test//negative
	public void test2() {
		Assert.assertEquals(-1, findOccurence(new int[] {1, 1, 2, 2, 2, 2, 3}, 4));
	}
}
