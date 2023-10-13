package mandatoryHomework.AfterDSA;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LC_819_MostCommonWord {
	
	/*
	 * https://leetcode.com/problems/most-common-word/description/
	 * 
	 	PseudoCode:
			Convert the given input paragraph to lower case using string.toLowerCase();
			remove all special characters except space using regex "[^a-z0-9\\s]"
			split the converted string based on space and store in string[]
			check if size of string[] is less than 2
			    if yes return the word
			    if no then do the following
			Initialize a map with String as key and Integer as value
			iterate over the string array and add each element as key and their occurence as value
			
			iterate over the banned array and remove each of the word from the map
			initialize integer max = Integer.MIN_VALUE
			iterate over the mapvalues and find MAX among the maps value set
			iterate over the keyset and compare with value of each key with max
			    if matches return key;
	 * 
	 */
	
	public String mostCommonWord(String paragraph, String[] banned) {
		// paragraph = paragraph.toLowerCase();
		// paragraph = paragraph.replaceAll("[^a-z0-9\\s]","");
		paragraph = converToGoodString(paragraph.toLowerCase());

		String[] eachWord = paragraph.split(" ");
		if (eachWord.length < 2)
			return eachWord[0];
		else {
			Map<String, Integer> eachWordFrequency = new HashMap<String, Integer>();
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < eachWord.length; i++)
				eachWordFrequency.put(eachWord[i], eachWordFrequency.getOrDefault(eachWord[i], 0) + 1);
			for (int i = 0; i < banned.length; i++)
				eachWordFrequency.remove(banned[i]);
			eachWordFrequency.remove(" ");
			for (int i : eachWordFrequency.values()) {
				max = (max < i) ? i : max;
			}
			for (String s : eachWordFrequency.keySet()) {
				if (eachWordFrequency.get(s) == max)
					return s;
			}
			return "";
		}
	}

	public String converToGoodString(String paragraph) {
		paragraph = paragraph.replace("!", " ");
		paragraph = paragraph.replace("?", " ");
		paragraph = paragraph.replace("'", " ");
		paragraph = paragraph.replace(";", " ");
		paragraph = paragraph.replace(".", " ");
		paragraph = paragraph.replace(",", " ");
		paragraph = paragraph.replace("  ", " ");
		System.out.println(paragraph);
		return paragraph;
	}
	
	@Test
	public void test1() {
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = {"hit"};
		String result = "ball";
		Assert.assertEquals(mostCommonWord(paragraph, banned), result);
	}
	
	@Test
	public void test2() {
		String paragraph = "a.";
		String[] banned = {};
		String result = "a";
		Assert.assertEquals(mostCommonWord(paragraph, banned), result);
	}
	
	@Test
	public void test3() {
		String paragraph = "a, a, a, a, b,b,b,c, c";
		String[] banned = {"a"};
		String result = "b";
		Assert.assertEquals(mostCommonWord(paragraph, banned), result);
	}

}
