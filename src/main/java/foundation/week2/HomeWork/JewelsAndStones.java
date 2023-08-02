package foundation.week2.HomeWork;

import org.junit.Assert;
import org.junit.Test;

public class JewelsAndStones {
	
	/*
	 * https://leetcode.com/problems/jewels-and-stones/description/
	 * 
	 * 	PseudoCode:
	 * 		Step1: initialize a variable counter = 0
	 * 		Step2: iterate through the length of input stones string
	 * 		Step3: inside loop take each char starting from first index using charAt() method
	 * 		Step4: check whether the char in current index is available in jewels using indexOf() method
	 * 		Step5: if indexOf() method returns value >=0 then increment the counter
	 * 		Step6: return the counter
	 * 
	 * 
	 */
	
	public static int jewelCount(String jewels, String stones) {
		int counter = 0;
		for(int i=0;i<stones.length();i++) {
			if(jewels.indexOf(stones.charAt(i))>=0)
				counter++;
		}
		return counter;
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(3, jewelCount("aA", "aAAbbbb"));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(0, jewelCount("z", "ZZ"));
	}

}
