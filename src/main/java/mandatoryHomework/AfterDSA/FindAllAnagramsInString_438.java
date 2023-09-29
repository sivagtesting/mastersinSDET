package mandatoryHomework.AfterDSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FindAllAnagramsInString_438 {

	/*
	 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
	 * 
	 * PseudoCode: initialize a list of integer var output initialise two maps of
	 * char and int pmap and smap add all char of p to pmap. and first p.lenght char
	 * of s to smap initialize int left = 0, right = p.lenght()-1 check if size of
	 * both map is equal if yes then check each char occurence of key in pmap is
	 * same as smap if yes then add left to list do following until right<p.length-1
	 * remove char at left index and add char from right if of size of both maps are
	 * equal then check if each char occurrence of pamp is same as smap if yes then
	 * add left to list if no then increment right
	 * 
	 * return list
	 * 
	 */
	// Time Complexity: O(N)
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> output = new ArrayList<Integer>();
		if (p.length() > s.length()) //exiting program if no of chars in 'p' is gt 's'
			return output;
		else {
			int left = 0, right = 0;
			Map<Character, Integer> pmap = new HashMap<Character, Integer>();
			Map<Character, Integer> smap = new HashMap<Character, Integer>();
			
			//deriving initial window
			while (right < p.length()) {
				pmap.put(p.charAt(right), pmap.getOrDefault(p.charAt(right), 0) + 1); //map for comaprison
				smap.put(s.charAt(right), smap.getOrDefault(s.charAt(right), 0) + 1); //initial window
				right++;
			}
			
			int window = pmap.size();
			//comparing the initial chars are anagram of 'p'
			if (smap.size() == window) {
				boolean flag = true;
				if (!pmap.equals(smap))
					flag = false;
				if (flag)
					output.add(left);
			}
			
			//Sliding window - Static
			while (right < s.length()) {
				//removing element from sliding window at left index
				if (smap.get(s.charAt(left)) > 1) {
					smap.put(s.charAt(left), smap.get(s.charAt(left)) - 1);
					left++;
				} else
					smap.remove(s.charAt(left++));
				
				//adding element to sliding window from right index
				smap.put(s.charAt(right), smap.getOrDefault(s.charAt(right), 0) + 1);
				
				//verifying whether current substring is Anagram ex: knee == keen
				if (smap.size() == window) {
					boolean flag = true;
					if (!pmap.equals(smap))
						flag = false;
					if (flag)
						output.add(left);
				}
				right++;
			}
			return output;
		}
	}

	@Test
	public void test1() {
		String s = "cbaebabacd";
		String p = "abc";
		int[] out = { 0, 6 };
		List<Integer> output = new ArrayList<Integer>();
		for (int i : out)
			output.add(i);
		Assert.assertEquals(output, findAnagrams(s, p));
	}

	@Test
	public void test2() {
		String s = "abab";
		String p = "ab";
		int[] out = { 0, 1, 2 };
		List<Integer> output = new ArrayList<Integer>();
		for (int i : out)
			output.add(i);
		Assert.assertEquals(output, findAnagrams(s, p));
	}

}
