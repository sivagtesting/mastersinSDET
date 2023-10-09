package foundation.DailyProblems;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LC_441_ArrangeCoins {
	
	/*
	 * https://leetcode.com/problems/arranging-coins/description/
	 * 
	 */
	
	public int arrangeCoins_firsApproach(int n) {
		int counter=0;
		for (int i = 1; i <= n; i++) {
			if(n-i>=0)
				counter++;
			n=n-i;
		}
		return counter;        
    }
	
	public int arrangeCoins(int n) {
        int i=1, count = 0;
        while(i<=n) {
            n = n-i;
            count++;
            i++;
        }
        return count;
    }
	
	@Test
	public void test1() {
		int n = 5;
		int output = 2;
		Assert.assertEquals(arrangeCoins(n), output);
		Assert.assertEquals(arrangeCoins_firsApproach(n), output);
	}
	
	@Test
	public void test2() {
		int n = 5;
		int output = 2;
		Assert.assertEquals(arrangeCoins(n), output);
		Assert.assertEquals(arrangeCoins_firsApproach(n), output);
	}

}
