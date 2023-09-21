package foundation.DailyProblems;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ShuffleString_1528 {
	
	/*
	 * https://leetcode.com/problems/shuffle-string/description/
	 * 
	 * s = "codeleet", indices = [4,5,6,7,0,2,1,3]
	 * from the above example, char at index 0 = 'c' - which has to be moved to position idices[0] which is 4
	 * hence
	 *		c should be moved to 4// [0,1,2,3,c,5,6,7]
	 *		o should be moved to 5// [0,1,2,3,c,o,6,7]
	 *		d should be moved to 6// [0,1,2,3,c,o,d,7]
	 *		e should be moved to 7// [0,1,2,3,c,o,d,e]
	 *		and so on
	 *
	 * codeleet -> lodeceet
	 * 
	 */
	
	public String restoreString(String s, int[] indices) {
        StringBuilder sb = new StringBuilder(s);
        for(int i=0;i<indices.length;i++)
        	sb.setCharAt(indices[i], s.charAt(i));
        return sb.toString();
    }
	
	@Test
	public void test1() {
		String s = "codeleet";
		int[] indices = {4,5,6,7,0,2,1,3};
		String output = "leetcode";
		Assert.assertEquals(output, restoreString(s, indices));
	}
	
	@Test
	public void test2() {
		String s = "bharatmaha";
		int[] indices = {4,5,6,7,8,9,0,1,2,3};
		String output = "mahabharat";
		Assert.assertEquals(output, restoreString(s, indices));
	}

}
