package mandatoryHomework.AfterDSA;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LongestNiceSubString_1763 {
	
	/*
	 * https://leetcode.com/problems/longest-nice-substring/submissions/
	 * 
	 * TestData Enumeration:
			s = abcdefgh -> ""
			s = ABCDE   -> ""
			s = abBcCdefDEFA -> abBcCdefDEFA
			s= aabBcdefDEFghiGHI -> defDEFghiGHI	
	 * 
	 * PseudoCode:
	 * 		intialize int max =0;
			intialize capitalChar hashset
			intialize smallChar hashSet
			intialize a hash map with Integer and String as value
			iterate over the input string until i<s.length-1
			in nested for loop iterate over the array with start index s.length()-1 end index >i
			get the substring using i,j
			add each char from the subString to smallChar and CaptialChar sets based on asccii values
			outside inner forloop check whether the current substring is nice substring

	 * 
	 */
	
	public String longestNiceSubstring(String s) {
		int start=0, end=0, max=Integer.MIN_VALUE;
		StringBuilder sb = new StringBuilder();
		Set<Character> smallChars = new HashSet<Character>();
		Set<Character> capitalChars = new HashSet<Character>();
		Map<Integer, String> maxSubstring = new HashMap<>();
			while(start<s.length()-1) {
				/*
				 * smallChars.clear(); capitalChars.clear();
				 */
				end = s.length();
				while(end>start+1 && max<(s.length()-start)) {
					smallChars.clear();
					capitalChars.clear();
					if(end==s.length()) {
						sb.setLength(0);
						sb.append(s.substring(start));
						for(char c: sb.toString().toCharArray()) {
							if(c<97)
								capitalChars.add(c);
							else
								smallChars.add(c);
						}
					} else {
						sb.setLength(0);
						sb.append(s.substring(start, end));
						for(char c: sb.toString().toCharArray()) {
							if(c<97)
								capitalChars.add(c);
							else
								smallChars.add(c);
						}
					}
					
					if(smallChars.size()==capitalChars.size() && max<sb.toString().length()) {
						if(isNiceSubstring(smallChars, capitalChars)) {
							if(max<sb.toString().length()) {
								max = sb.toString().length();
								maxSubstring.put(max, sb.toString());
							}
						}
					}
					end--;
				}
				start++;
			}
			return maxSubstring.getOrDefault(max, "");
		
	}
	
	public boolean isNiceSubstring(Set<Character> smallChars, Set<Character> capitalChars) {
		for (char c : smallChars) {
			char temp = (char) (c-32);
			if(capitalChars.contains(temp))
					continue;
			else
				return false;
		}
		return true;
	}
	
	@Test
	public void test1() {
		String s = "abBcCdefDEFA";
		String output = "abBcCdefDEFA";
		Assert.assertEquals(output, longestNiceSubstring(s));
	}
	
	@Test
	public void test2() {
		String s = "YazaAay";
		String output = "aAa";
		Assert.assertEquals(output, longestNiceSubstring(s));
	}
	
	@Test
	public void test3() {
		String s = "a";
		String output = "";
		Assert.assertEquals(output, longestNiceSubstring(s));
	}
	
	@Test
	public void test4() {
		String s = "abcd";
		String output = "";
		Assert.assertEquals(output, longestNiceSubstring(s));
	}
	
	@Test
	public void test5() {
		String s = "zUXxizubXNKAUGXTjmAXkpzNZMnRBgddDUAWPUa";
		String output = "ddD";
		Assert.assertEquals(longestNiceSubstring(s), output);
	}

}
