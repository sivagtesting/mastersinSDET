package foundation.DailyProblems;

import org.junit.Test;
import org.testng.Assert;

public class BalancedString_1221 {
	
	/*
	 * https://leetcode.com/problems/split-a-string-in-balanced-strings/description/
	 * 
		Test Data enumeration:
			1. "RRLL" -> 1
			2. "RLRLRL" -> 3
			3. "RL" -> 1
			4. "RLRLRRLL" -> 3
			
		PseudoCode:
			initialize three integers counter=0 rCount=0, lCount=0;
			iterate using for until s.length
			check if char at current index == R
			if yes increment rcount
			if no increment lcount
			check if rCount==lCount
			if yes, then increment counter, reset rCount & lCount =0;
			if no then continue
			return counter
	 * 
	 */
	
	public static int balancedStringSplit(String s) {
        int counter=0, lCount = 0, rCount = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='R')
                rCount++;
            else
                lCount++;
            if(rCount==lCount){
                counter++;
                rCount = 0;
                lCount = 0;
            }
        }
        return counter;
    }
	
	@Test
	public void test1() {
		String s ="RRLL";
		int counter = 1;
		Assert.assertEquals(counter, balancedStringSplit(s));
	}
	
	@Test
	public void test2() {
		String s ="RLRLRL";
		int counter = 3;
		Assert.assertEquals(counter, balancedStringSplit(s));
	}
	
	@Test
	public void test3() {
		String s ="RL";
		int counter = 1;
		Assert.assertEquals(counter, balancedStringSplit(s));
	}
	
	@Test
	public void test4() {
		String s ="RLRLRRLL";
		int counter = 3;
		Assert.assertEquals(counter, balancedStringSplit(s));
	}

}
