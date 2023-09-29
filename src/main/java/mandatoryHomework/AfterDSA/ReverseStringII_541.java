package mandatoryHomework.AfterDSA;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReverseStringII_541 {
	
	/*
	 * https://leetcode.com/problems/reverse-string-ii/description/
	 * 
	 * PseudoCode:
	 		intialize left=0, right=k
			copy the input string s to string builder variable sb
			do the following while right<=s.length && left<s.length-k
			while left<right
			set temp = character at index left
			set character at left index to character at right index
			set char at right index to temp
			increment left
			decrement right
			
			outside inner while loop
			set left = 2*k
			check if (s.length - left) >= k
			if yes right = left + k-1
			else if  (s.length - left) < k
			if yes right = length-1
	 * 
	 */

	public String reverseStr(String s, int k) {
		int left = 0, right = k - 1;
		int inpStringLen = s.length();
		if (inpStringLen < k) {
            StringBuilder sb = new StringBuilder(s);
                int p1 = 0;
				int p2 = inpStringLen-1;
				while (p1 < p2) {
					char temp = sb.charAt(p1);
					sb.setCharAt(p1, s.charAt(p2));
					sb.setCharAt(p2, temp);
					p1++;
					p2--;
				}
                return sb.toString();
        } else {
			StringBuilder sb = new StringBuilder(s);
			while (left < inpStringLen && right < inpStringLen) {
				int p1 = left;
				int p2 = right;
				while (p1 < p2) {
					char temp = sb.charAt(p1);
					sb.setCharAt(p1, s.charAt(p2));
					sb.setCharAt(p2, temp);
					p1++;
					p2--;
				}
				left += 2 * k;
				if (inpStringLen - left >= k)
					right = left + k - 1;
				else
					right = inpStringLen - 1;
			}
			return sb.toString();
		}
	}
	
	@Test
	public void test1() {
		String s = "abcdefg";
		int k = 2;
		String output = "bacdfeg";
		Assert.assertEquals(output, reverseStr(s, k));
	}
	
	@Test
	public void test2() {
		String s = "abcdefgh";
		int k = 3;
		String output = "cbadefhg";
		Assert.assertEquals(output, reverseStr(s, k));
	}
	
	@Test
	public void test3() {
		String s = "abcdefghij";
		int k = 3;
		String output = "cbadefihgj";
		Assert.assertEquals(output, reverseStr(s, k));
	}
	
	@Test
	public void test4() {
		String s = "abcde";
		int k = 7;
		String output = "edcba";
		Assert.assertEquals(output, reverseStr(s, k));
	}

}
