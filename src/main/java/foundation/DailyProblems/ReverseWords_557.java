package foundation.DailyProblems;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReverseWords_557 {
	
	/*
	 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
	 * 
	 * 			5.07:
		test data enumeration:
				I love india -> i evol aidni
				test -> tset
				test1 OutPuT -> 1tset TuPtuO
				5.09
				
		PseudoCode:
				5.09
				check if s.length ==1 
				if yes then return s
				if no then
				Initialize a stringbuilder sb variable of length s.length
				check if space is available in the input string
				if no then using for loop starting index = s.length-1 until 0
				append each char at current index to sb
				if yes repeat the following steps
				split the input s based on " "
				iterate over the string array from above step step until its length
				using nested loop iterate using for with start index as the length of current string-1 until 0
				using charat method append to each character to sb
				when i==string.length()-1 append a space
				
				return sb.
				5.12
				
				5.16 code
	 * 
	 */
	
	public String reverseWords(String s) {
		if (s.length() == 1)
			return s;
		else {
			StringBuilder sb = new StringBuilder(s.length());
			if (s.indexOf(" ") < 0) {
				for (int i = s.length() - 1; i >= 0; i--)
					sb.append(s.charAt(i));
				return sb.toString();
			} else {
				String[] tempS = s.split(" ");
				for (int i = 0; i < tempS.length; i++) {
					for (int j = tempS[i].length() - 1; j >= 0; j--) {
						sb.append(tempS[i].charAt(j));
						if (j == 0 && i!=tempS.length-1)
							sb.append(" ");
					}
				}
			}
			return sb.toString();
		}

	}
	
	@Test
	public void test1() {
		String s = "Let's take LeetCode contest";
		String output = "s'teL ekat edoCteeL tsetnoc";
		Assert.assertEquals(output, reverseWords(s));
	}
	
	@Test
	public void test2() {
		String s = "I love india";
		String output = "I evol aidni";
		Assert.assertEquals(output, reverseWords(s));
	}
	
	@Test
	public void test3() {
		String s = "test";
		String output = "tset";
		Assert.assertEquals(output, reverseWords(s));
	}
	
	@Test
	public void test4() {
		String s = "test1 OutPuT";
		String output = "1tset TuPtuO";
		Assert.assertEquals(output, reverseWords(s));
	}

}
