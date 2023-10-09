package foundation.DailyProblems;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FindNextBiggestChar {
	
	/*
	 * 
	 	Given a sorted character array and a target character, 
		find the next biggest character in the array.
		
		TestData Enumeration
			1) {a,a,b,b,c,c,d,e,f,g}, c -> d
			2) {a,b,m,z}, c -> m
			3) {a to z}, y -> z
			
		PseudoCode:
		iterate using for from 0 to arr.length
		if of char at current index is gt than target char then return arr[index]
	 */
	
	public char getNextBigChar(char[] arr, char target) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>target)
				return arr[i];
		}
		return target;
	}
	
	@Test
	public void test1() {
		char[] arr = {'a','a','b','b','c','c','d','e','f','g'};
		char target = 'c';
		char output = 'd';
		Assert.assertEquals(getNextBigChar(arr, target), output);
	}
	
	@Test
	public void test2() {
		char[] arr = {'a','b','m','z'};
		char target = 'c';
		char output = 'm';
		Assert.assertEquals(getNextBigChar(arr, target), output);
	}
	
	@Test
	public void test3() {
		char[] arr = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		char target = 'y';
		char output = 'z';
		Assert.assertEquals(getNextBigChar(arr, target), output);
	}
	

}
