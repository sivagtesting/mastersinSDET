package foundation.DailyProblems;

import org.junit.Assert;
import org.junit.Test;

public class ChessBoard_1812 {
	
	/*
	 * 
	 * https://leetcode.com/problems/determine-color-of-a-chessboard-square/description/
	 * PseudoCode:
	 * 
	 * Step1: from the given input string ascii value of the char at index '0' and subtract the value with 96
	 * Step2: get the integer value of the char at index '1'
	 * Step3: Check if the first asccii value of first char is odd
	 * 		Step3.1: if int value of the second char is Odd then return false else return true
	 * Step4: Check if the first ascci value of first char is even
	 * 		Step4.1: if the int value of second char is odd then return true else return false
	 * 
	 * 
	 */
	
	public boolean squareIsWhite(String coordinates) {
        if((coordinates.charAt(0)-96)%2==0) {
			if(coordinates.charAt(1)%2==0)
				return false;
			else
				return true;
		} else {
			if(coordinates.charAt(1)%2==0)
				return true;
			else
				return false;
		}
        
    }
	
	@Test
	public void test1() {
		Assert.assertEquals(false, squareIsWhite("a1"));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(true, squareIsWhite("b1"));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(true, squareIsWhite("h7"));
	}

}
