package foundation.week1.day1.homework;

import org.junit.Assert;
import org.junit.Test;

public class Problem4 {
	/*
	 * 4. Given a sorted character array and a target character, 
				find the next biggest character in the array. 
					Example:
						char[] cha = {‘b’, ‘d’ , ‘h’}; char k = ‘e’ 
						Output -> h
	 * 
	 */
	
	public static char nextBigChar(char[] inpCharArr, char k) {
		for (int i = 0; i < inpCharArr.length; i++) {
			if(inpCharArr[i]>k)
				return inpCharArr[i];
		}
		return '0';
	}
	
	@Test
	public void test1() {
		Assert.assertEquals('f', nextBigChar(new char[] {'a','b','c','f'}, 'e'));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals('d', nextBigChar(new char[] {'a','b','d', 'z'}, 'c'));
	}
}
