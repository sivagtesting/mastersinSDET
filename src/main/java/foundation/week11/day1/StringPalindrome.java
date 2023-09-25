package foundation.week11.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringPalindrome {
	public boolean isValidPalindrome(String s) {
		if(s.length()==1)
			return true;
		else if(s.length()<1)
			return false;
		else {
			int start = 0, end = s.length()-1;
			String temp = s.toLowerCase();
			while(start<end) {
				if(temp.charAt(start) == temp.charAt(end)) {
					start++;
					end--;
					continue;
				} else
					return false;
					
			}
				return true;	
		}
		
	}
	
	public boolean isValidPalindrome_ExpandFromCenter(String s) {
		
		int length = s.length();
		if(length<1)
			return false;
		else {
		int left = (length/2)-1;
		int right = length%2==0 ? length/2 : (length/2)+1;
		String temp = s.toLowerCase();
		while(left>=0) {
			if(temp.charAt(left)!=temp.charAt(right))
				return false;
			left--;
			right++;
		}
		return true;
		}
	}
	
	@Test
	public void test1() {
		String s= "Radar";
		boolean output = true;
		Assert.assertEquals(isValidPalindrome(s), output);
		Assert.assertEquals(isValidPalindrome_ExpandFromCenter(s), output);
	}
	
	@Test
	public void test2() {
		String s= "s";
		boolean output = true;
		Assert.assertEquals(isValidPalindrome(s), output);
		Assert.assertEquals(isValidPalindrome_ExpandFromCenter(s), output);
	}
	
	@Test
	public void test3() {
		String s= "S";
		boolean output = true;
		Assert.assertEquals(isValidPalindrome(s), output);
		Assert.assertEquals(isValidPalindrome_ExpandFromCenter(s), output);
	}
	
	@Test
	public void test4() {
		String s= "";
		boolean output = false;
		Assert.assertEquals(isValidPalindrome(s), output);
		Assert.assertEquals(isValidPalindrome_ExpandFromCenter(s), output);
	}

}
