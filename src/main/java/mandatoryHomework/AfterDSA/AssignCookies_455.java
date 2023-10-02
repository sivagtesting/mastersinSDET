package mandatoryHomework.AfterDSA;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssignCookies_455 {
	
	/*
	 * https://leetcode.com/problems/assign-cookies/description/
	 * 
	 * 
	 * 
	 */

	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int start = 0, end = 0, output = 0;
		while (start < g.length && end < s.length) {
			// if(start==g.length || end==s.length)
			// break;
			if (g[start] <= s[end]) {
				output++;
				start++;
				end++;
			} else
				end++;

		}
		return output;
	}
	
	@Test
	public void test1() {
		int[] greed = {1,2,3};
		int[] cookie = {1,1};
		int output = 1;
		Assert.assertEquals(findContentChildren(greed, cookie), output);
	}
	
	@Test
	public void test2() {
		int[] greed = {1,2};
		int[] cookie = {1,2,3};
		int output = 2;
		Assert.assertEquals(findContentChildren(greed, cookie), output);
	}

}
