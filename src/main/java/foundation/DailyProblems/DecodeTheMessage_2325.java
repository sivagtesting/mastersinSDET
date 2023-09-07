package foundation.DailyProblems;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import org.testng.Assert;

public class DecodeTheMessage_2325 {
	
	/*
	 * https://leetcode.com/problems/decode-the-message/description/
	 * 
	 * testdata enumeration
			key = "abcdefghijklmno pqrs tuvwxyz"
			message = "I love my country"
			output = "I love my country"
			
			key = "zyxwvutsrqponmlkjihgfedcba"
			message = "r olev"
			output = "i love"
			
			key = "the quick brown fox jumps over the lazy dog"
			message = "vkbs bs t suepuv"
			output = "this is a secret"
			
			5.33 minutes
			
		PseudoCode:
			intialize a string builder object;
			initialize a map with char as key and int as value
			remove all spaces from key using replaceAll()
			initialize a set of characters and input all the char from key in the same order(order of insertion should be kept)
			iterate over the set from previouse step using foreach
			inside for loop
			    input the char at current index as key to the the map and value as '97' and increment value at each iteration by adding to i
			    while inputing just check if the element already available using contains key
			    if yes then continue else input with 97 + i
			    if the char at current index is not alphabet then continue else perform the above steps(97<= <=123)
			using another for loop iterate over the length of message
			if current value is not alphabet then append space to the string
			else build the using value of the char at current index and build the string
			convert the integer to char.
			
			Time Complexity = O[n] (n -> being the size of the message)
	 * 
	 * 
	 * 
	 */
	
	
	public static String decodeMessage(String key, String message) {

        StringBuilder decodedMsg = new StringBuilder(message.length());
        Map<Character,Integer> chiperKey = new HashMap<Character, Integer>();
        Set<Character> chiperKeyUnqiueChars = new LinkedHashSet<Character>();
        key = key.replaceAll(" ", "");
        for(int i=0; i<key.length(); i++){
            chiperKeyUnqiueChars.add(key.charAt(i));
        }
        int i = 0;
        for(char c: chiperKeyUnqiueChars){
            chiperKey.put(c,97+i);
            i++;
        }
        for(int j=0; j<message.length(); j++){
            if(message.charAt(j)<97 || message.charAt(j)>123)
                decodedMsg.append(" ");
            else {
            	decodedMsg.append((char) chiperKey.get(message.charAt(j)).intValue());
            }
        }
        return decodedMsg.toString();
    }
	
	@Test
	public void test1() {
		String key = "the quick brown fox jumps over the lazy dog";
		String message = "vkbs bs t suepuv";
		String output = "this is a secret";
		Assert.assertEquals(output, decodeMessage(key, message));
	}
	
	@Test
	public void test2() {
		String key = "abcdefghijklmno pqrs tuvwxyz";
		String message = "i love my country";
		String output = "i love my country";
		Assert.assertEquals(output, decodeMessage(key, message));
	}
	
	@Test
	public void test3() {
		String key = "zyxwvutsrqponmlkjihgfedcba";
		String message = "r olev";
		String output = "i love";
		Assert.assertEquals(output, decodeMessage(key, message));
	}

}
