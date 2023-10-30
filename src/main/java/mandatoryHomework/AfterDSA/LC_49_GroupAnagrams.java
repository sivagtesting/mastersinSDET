package mandatoryHomework.AfterDSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LC_49_GroupAnagrams {
	
	/*
		PseudoCode:
			Initialize a List<List<String>> varaible output
			Add the first string from the input string array strs
			iterate over the input array with starting index = 1 end index lenght of the array
			    Select the word at index1 and select the word at index0 from the first list and send to isAnagram method
			    if true then add it to the list at index 0
			    if false then iterate over the List of list and get word at index 0 and send it to the isAnagram method
			        if true then add it to the current list
			        if false then repeat the same.
			
			
			
			isAnagram(String word1, String word2)
			add each char to a hashmap of word1 with char as key and freq as value
			add each char of word2 to another hashmap with char as key and freq as value
			return map1.equals(map2);
	 * 
	 * 
	 */
	
	
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> output = new ArrayList<List<String>>();
		List<String> firstAnagramGroup = new ArrayList<String>();
		firstAnagramGroup.add(strs[0]);
		output.add(firstAnagramGroup);
		for (int i = 1; i < strs.length; i++) {
			if (strs[i].length() == output.get(0).get(0).length() && isAnagram(strs[i], output.get(0).get(0)))
				output.get(0).add(strs[i]);
			else if (output.size() == 1)
				output.add(new ArrayList<String>(Arrays.asList(strs[i])));
			else {
				boolean flag = true;
				for (int j = 1; j < output.size(); j++) {
					if (strs[i].length() == output.get(j).get(0).length() && isAnagram(strs[i], output.get(j).get(0))) {
						output.get(j).add(strs[i]);
						flag = false;
						break;
					}
				}
				if (flag)
					output.add(new ArrayList<String>(Arrays.asList(strs[i])));

			}
		}
		return output;
	}

	public boolean isAnagram(String word1, String word2) {
		if (word1.length() == 0 && word2.length() == 0)
			return true;
		else {
			Map<Character, Integer> map1 = new HashMap<Character, Integer>();
			Map<Character, Integer> map2 = new HashMap<Character, Integer>();
			for (int i = 0; i < word1.length(); i++) {
				map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0) + 1);
				map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0) + 1);
			}
			return map1.equals(map2);
		}
	}
	
	@Test
	public void test1() {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> result = new ArrayList<List<String>>();
		result.add(new ArrayList<String>(Arrays.asList("bat")));
		result.add(new ArrayList<String>(Arrays.asList("nat", "tan")));
		result.add(new ArrayList<String>(Arrays.asList("ate", "eat", "tea")));
		Assert.assertEquals(groupAnagrams(strs), result);
	}

	@Test
	public void test2() {
		String[] strs = { "" };
		List<List<String>> result = new ArrayList<List<String>>();
		result.add(new ArrayList<String>(Arrays.asList("")));
		Assert.assertEquals(groupAnagrams(strs), result);
	}

	@Test
	public void test3() {
		String[] strs = { "a" };
		List<List<String>> result = new ArrayList<List<String>>();
		result.add(new ArrayList<String>(Arrays.asList("a")));
		Assert.assertEquals(groupAnagrams(strs), result);
	}

}
