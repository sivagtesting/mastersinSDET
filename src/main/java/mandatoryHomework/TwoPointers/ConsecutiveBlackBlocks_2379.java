package mandatoryHomework.TwoPointers;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ConsecutiveBlackBlocks_2379 {
	
	/*
	 * https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
	 * 
	 * PseudoCode:
 			check if size of blocks is less than k if yes then return 0
			else do the following
			initialize integer right=0 count =k, int min = integer.maxvalue
			do the following using while until right<k
			    check if the char at current index is 'w'
			    if yes then increment count
			increment right
			
			check if count==0
			if yes return 0
			if no then assign the to max value
			
			do the following until  right<block.length
			check the char at position right-k is w 
			if yes decremet counter
			check the char at position right is w 
			if yes then increment counter
			check against count against min and assing the value to min
			retunr min
	 * 
	 */
	
	public int minimumRecolors(String blocks, int k) {
		if (blocks.length() < k)
			return 0; //exiting if k is greater than no of char in blocks
		else {
			int right = 0, count = 0, min = Integer.MAX_VALUE;
			while (right < k) {		//calculating value for Initial window
				if (blocks.charAt(right) == 'W')
					count++;
				right++;
			}
			if (count == 0) //expected consecutive chars present in intial window then exiting program by returning 0
				return 0;
			else
				min = Math.min(min, count);
			while (right < blocks.length()) { //finding no of consecutive chars based on remaining characters
				if (blocks.charAt(right - k) == 'W')
					count--;
				if (blocks.charAt(right) == 'W')
					count++;
				min = Math.min(min, count);
				if(min==0)
					return min; //exiting if consecutive chars is already present in input string
				right++;
			}
			return min;
		}
	}
	
	@Test
	public void test1() {
		String blocks = "WBBWWBBWBW";
		int k = 7;
		int output = 3;
		Assert.assertEquals(minimumRecolors(blocks, k), output);
	}
	
	@Test
	public void test2() {
		String blocks = "WBWBBBW";
		int k = 2;
		int output = 0;
		Assert.assertEquals(minimumRecolors(blocks, k), output);
	}

}
