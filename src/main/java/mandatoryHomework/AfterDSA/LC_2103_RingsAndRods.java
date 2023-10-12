package mandatoryHomework.AfterDSA;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LC_2103_RingsAndRods {

	/*
	 * https://leetcode.com/problems/rings-and-rods/
	 * 
	 	Testdata Enumeration:
	 		R0G0B0R1G1B1R2G2B2 ... R9G9B9 -> 10
	 	PsedoCode:
			Initialize boolean[] rCount of size 10
			initialize a counter=0
			iterate over the rings string
			 get the numeric value of the char at odd index
			    take the previous char to odd index, if it is 'R' then update R[numeric value of the char at odd index] as true
			    repeat the same for 'G' & 'B'
			iterate using for loop start index =0, end index = 9
			    if rCount[i] && gCount[i] && bCount[i] == true then increment counter
			return the counter;
	 */
	
	public int countPoints(String rings) {
		boolean[] rCount = new boolean[10];
		boolean[] gCount = new boolean[10];
		boolean[] bCount = new boolean[10];
		int counter = 0;
		for (int i = 1; i < rings.length(); i += 2) {
			if (rings.charAt(i - 1) == 'R')
				rCount[Character.getNumericValue(rings.charAt(i))] = true;
			else if (rings.charAt(i - 1) == 'G')
				gCount[Character.getNumericValue(rings.charAt(i))] = true;
			else
				bCount[Character.getNumericValue(rings.charAt(i))] = true;
		}
		for (int i = 0; i < 10; i++) {
			if (rCount[i] == true && gCount[i] == true && bCount[i] == true)
				counter++;
		}
		return counter;
	}
	
	@Test
	public void test1() {
		String rings = "R0G0B0R1G1B1R2G2B2R3G3B3R4G4B4R5G5B5R6G6B6R7G7B7R8G8B8R9G9B9";
		int result = 10;
		Assert.assertEquals(countPoints(rings), result);
	}
	
	@Test
	public void test2() {
		String rings = "B0B6G0R6R0R6G9";
		int result = 1;
		Assert.assertEquals(countPoints(rings), result);
	}
	
	@Test
	public void test3() {
		String rings = "R0G1B2";
		int result = 0;
		Assert.assertEquals(countPoints(rings), result);
	}
}
