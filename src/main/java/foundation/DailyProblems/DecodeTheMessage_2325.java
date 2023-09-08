package foundation.DailyProblems;

import java.util.HashMap;
import java.util.Map;
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
        Map<Character,Character> chiperKey = new HashMap<Character, Character>();
        key = key.replaceAll(" ", "");
        char c = 'a';
        for (int i = 0; i < key.length(); i++) {
        	if(!chiperKey.containsKey(key.charAt(i)))
        		chiperKey.put(key.charAt(i), c++);
		}
        for(int i=0; i<message.length(); i++){
            if(chiperKey.containsKey(message.charAt(i)))
            	decodedMsg.append(chiperKey.get(message.charAt(i)));
            else 
            	decodedMsg.append(" ");
        }
        return decodedMsg.toString();
    }
	
	public static String decodeMessageBruteForceApproach(String key, String message) {
		StringBuilder alphabets = new StringBuilder(26);
		StringBuilder decodedMsg = new StringBuilder(message.length());
		String temp = key.replaceAll(" ", "");
		for (int i = 0; i < temp.length(); i++) {
			if(!alphabets.toString().contains(temp.charAt(i)+""))
				alphabets.append(temp.charAt(i));
		}
		for (int i = 0; i < message.length(); i++) {
			if(alphabets.toString().contains(message.charAt(i)+""))
					decodedMsg.append((char) (97 + alphabets.indexOf(message.charAt(i)+"")));
			else
				decodedMsg.append(" ");
		}
		return decodedMsg.toString();
	}
	
	@Test
	public void test1() {
		String key = "the quick brown fox jumps over the lazy dog";
		String message = "vkbs bs t suepuv";
		String output = "this is a secret";
		Assert.assertEquals(output, decodeMessage(key, message));
		Assert.assertEquals(output, decodeMessageBruteForceApproach(key, message));
	}
	
	@Test
	public void test2() {
		String key = "abcdefghijklmno pqrs tuvwxyz";
		String message = "i love my country";
		String output = "i love my country";
		Assert.assertEquals(output, decodeMessage(key, message));
		Assert.assertEquals(output, decodeMessageBruteForceApproach(key, message));
	}
	
	@Test
	public void test3() {
		String key = "zyxwvutsrqponmlkjihgfedcba";
		String message = "r olev";
		String output = "i love";
		Assert.assertEquals(output, decodeMessage(key, message));
		Assert.assertEquals(output, decodeMessageBruteForceApproach(key, message));
	}

}
