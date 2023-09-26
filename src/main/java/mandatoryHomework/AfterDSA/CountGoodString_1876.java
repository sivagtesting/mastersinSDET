package mandatoryHomework.AfterDSA;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.testng.Assert;

public class CountGoodString_1876 {
	
	/*
	 * https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/description/
	 */
	
	
	public int countGoodSubStrings_TwoPointerOptimization(String s) {
		if (s.length() < 3)
			return 0;
		else {
			int counter = 0, pOne = 0, pTwo = 0;
			Set<Character> charSet = new HashSet<Character>();
			while (pTwo < s.length()) {
				while (!charSet.add(s.charAt(pTwo))) {
					charSet.remove(s.charAt(pOne));
					pOne++;
				}
				pTwo++;
				if (charSet.size() == 3) {
					counter++;
					charSet.remove(s.charAt(pOne++));
				}
			}
			return counter;
		}
	}

	public int countGoodSubstrings(String s) {
		if (s.length() < 3)
			return 0;
		else {
			int counter = 0, pOne = 0, pTwo = 3;
			while (pTwo <= s.length()) {
				if(pOne==s.length()-3) {
					if (isAllCharsAreUnique(s.substring(pOne)))
						counter++;
					pOne++;
					pTwo++;
				} else {
				if (isAllCharsAreUnique(s.substring(pOne, pTwo)))
					counter++;
				pOne++;
				pTwo++;
			}
			}
			return counter;
		}

	}

	public boolean isAllCharsAreUnique(String inp) {
		Set<Character> charSet = new HashSet<Character>();
		for (char each : inp.toCharArray()) {
			if (charSet.add(each))
				continue;
			else
				return false;
		}
		return charSet.size() == 3;

	}
	
	@Test
	public void test1() {
		String s = "xyzzaz";
		int output = 1;
		Assert.assertEquals(output, countGoodSubstrings(s));
		Assert.assertEquals(output, countGoodSubStrings_TwoPointerOptimization(s));
	}
	
	//aababcabc
	
	@Test
	public void test2() {
		String s = "owuxoelszb";
		int output = 8;
		Assert.assertEquals(output, countGoodSubstrings(s));
		Assert.assertEquals(output, countGoodSubStrings_TwoPointerOptimization(s));
	}
	
	@Test
	public void test3() {
		String s = "aababcabc";
		int output = 4;
		Assert.assertEquals(output, countGoodSubstrings(s));
		Assert.assertEquals(output, countGoodSubStrings_TwoPointerOptimization(s));
	}
	
	
	/*
	 * 
	 * TestData Enumeration:
"a" -> 0
"abc" -> 1
"aaa" -> 0
"abcedfghijklmno" -> 

PseudoCode: 
5.01
if size of input string s is less than 3 then return 0 else do the following

intialize two integers pOne=0 and pTwo =2, counter=0;
initialize a stringbuilder sb of size 3;
perform the following using while untile pTwo<s.length();
get the substring of s with starting and ending index as pOne and pTwo;
append it to the sb
send the sb to a method that return true if all char's are unique
if yes then increment counter

return counter;

method to find all char are uniuque in substring()
using for each add each char to the Character set
return set.size()==3;
5.07
5.08 dry run: 

Code:
	 */
	
	/*
	 * TwoPointer - PseudoCode:
	 * 
	 * 
	 * 
	 * 
	 */

}
