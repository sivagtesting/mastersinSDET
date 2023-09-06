package foundation.DailyProblems;

import static org.testng.Assert.assertEquals;

import org.junit.Test;
import org.testng.Assert;

public class MaxNumOfWords_2114 {
	/*
	 * https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/description/
	 * 
	 * TestDataEnumeration:
			sentences = ["please wait", "continue to fight", "continue to win"] -> 3
			sentences = ["a b"] -> 2
			["a"] -> 1
		
		PsuedoCode:
			initialize noOFWord = 0;
			iterate over the input sentences
			find the noOfwords by spliting the current sentneces based on space
			find the lenght of the string array from above step and updte noOfWord
			while updating check if the current lenght is greater than already foound noOfword
			return noOfWord
	 * 
	 */
	
	public static int mostWordsFound(String[] sentences) {
        int noOfWords = 0;
        for(int i=0; i<sentences.length; i++){
            if(sentences[i].split(" ").length>noOfWords)
                noOfWords = sentences[i].split(" ").length;
        }
        return noOfWords;
    }
	
	@Test
	public void test1() {
		Assert.assertEquals(3, mostWordsFound(new String[] {"please wait", "continue to fight", "continue to win"}));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(2, mostWordsFound(new String[] {"a b"}));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(1, mostWordsFound(new String[] {"a"}));
	}

}
