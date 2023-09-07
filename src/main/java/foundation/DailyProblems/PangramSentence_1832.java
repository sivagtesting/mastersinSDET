package foundation.DailyProblems;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class PangramSentence_1832 {
	
	/*
	 * https://leetcode.com/problems/check-if-the-sentence-is-pangram/description/
	 * 
	 * 
		Test Data enumeration:
			i -> false
			theskyisup -> false
			abcdefghijklmnopqrstuvwxyz -> true
			thequickbrownfoxjumpsoverthelazydog -> true
			
		PseudoCode:
			intialize array of integers with size 26 -> referring to english alphabets
			iterate over the input sentence upto length
			inside loop using charAt get each char
			    a -> add in position 0 and so on z = 26
			    at each poisiton before adding just increment the exisiting value
			using another for loop iterate over the alphabets array
			check value of each index 
			if any value is ==0
			then return false
			else true
			
		Time Complexity:
			O[n]
	 * 
	 */
	
	public static boolean checkIfPangram(String sentence) {
        int[] alphabets = new int[26];       

        for(int i=0; i<sentence.length(); i++){
            alphabets[sentence.charAt(i) - 'a'] = alphabets[sentence.charAt(i) - 'a'] + 1;
        }
        for(int i=0; i<alphabets.length; i++){
            if(alphabets[i]==0)
                return false;
        }
        return true;
    }
	
	public static boolean checkIfPangramApproach2(String sentence) {
		Set<Character> alphabet = new HashSet<>();
		for (int i = 0; i < sentence.length(); i++) {
			alphabet.add(sentence.charAt(i));
		}
		return alphabet.size()==26;
	}
	
	@Test
	public void test1() {
		String sentence = "i";
		Assert.assertEquals(false, checkIfPangram(sentence));
		Assert.assertEquals(false, checkIfPangramApproach2(sentence));
	}
	
	@Test
	public void test2() {
		String sentence = "theskyisup";
		Assert.assertEquals(false, checkIfPangram(sentence));
		Assert.assertEquals(false, checkIfPangramApproach2(sentence));
	}
	
	@Test
	public void test3() {
		String sentence = "abcdefghijklmnopqrstuvwxyz";
		Assert.assertEquals(true, checkIfPangram(sentence));
		Assert.assertEquals(true, checkIfPangramApproach2(sentence));
	}
	
	@Test
	public void test4() {
		String sentence = "thequickbrownfoxjumpsoverthelazydog";
		Assert.assertEquals(true, checkIfPangram(sentence));
		Assert.assertEquals(true, checkIfPangramApproach2(sentence));
	}

}
