package mandatoryHomework.AfterDSA;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class JewelsAndStones_LC_771 {
	
	/*
	 * https://leetcode.com/problems/jewels-and-stones/description/
	 * 
	 * 	PseudoCode:
	 * 		Step1: initialize a variable counter = 0
	 * 		Step2: iterate through the length of input stones string
	 * 		Step3: inside loop take each char starting from first index using charAt() method
	 * 		Step4: check whether the char in current index is available in jewels using indexOf() method
	 * 		Step5: if indexOf() method returns value >=0 then increment the counter
	 * 		Step6: return the counter
	 * 
	 * 
	 */
	
	public static int jewelCount(String jewels, String stones) {
		int counter = 0;
		for(int i=0;i<stones.length();i++) {
			if(jewels.indexOf(stones.charAt(i))>=0)
				counter++;
		}
		return counter;
	}
	
	/*
	 	PseudoCode - hashMap:
		 	initialize a integer variable count = 0
			Initialize a hashmap of type Char, Integer
			iterate over the length of stones
			add each char as key and its occurence as value
			iterate over the length of jewels
			get value of each char of jewels from map and add to counter
			return counter;
	 * 
	 */
	
	// Time Complexity: O(N+M)
	// Space Complexity: O(M)
	public static int jewelCount_HashMap(String jewels, String stones) {
		int count =0;
        Map<Character,Integer> stonesMap = new HashMap<Character,Integer>();
        for(int i=0; i<stones.length(); i++)
            stonesMap.put(stones.charAt(i), stonesMap.getOrDefault(stones.charAt(i), 0)+1);
        for(int i=0; i<jewels.length(); i++) {
            if(stonesMap.containsKey(jewels.charAt(i)))
                    count += stonesMap.get(jewels.charAt(i));
        }           
        return count;
	}
	
	/*
	 PseudoCode - AsciiArray:
		intialize and integer count = 0
		initialize an integer array of size 52
		iterate using for start index =0 end index eq stones.length()
		convert each char as integer as follows a =0, A = 25 and so on
		using above index increment the value to find the frequency of each char
		
		iterate using for start index =0 end index eq jewels.length()
		convert each char to integer as follows a = 0, A =26 and so on
		retrieve the value from above frequencyArray and add to count
		
		return count
	 * 
	 */
	
	// Time Complexity: O(N+M)
	// Space Complexity: O(1)
	public static int jewelCount_frequencyArray(String jewels, String stones) {
		int count =0;
        int[] freqArray = new int[52];
        for(char c: stones.toCharArray()){
            if(c>96)
                freqArray[c-'a']++;
            else
                freqArray[c-39]++;
        }
        for(char c: jewels.toCharArray()) {
            if(c>96)
                count += freqArray[c-'a'];
            else
                count += freqArray[c-39];
        }
        return count;
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(3, jewelCount("aA", "aAAbbbb"));
		Assert.assertEquals(3, jewelCount_HashMap("aA", "aAAbbbb"));
		Assert.assertEquals(3, jewelCount_frequencyArray("aA", "aAAbbbb"));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(0, jewelCount("z", "ZZ"));
		Assert.assertEquals(0, jewelCount_HashMap("z", "ZZ"));
		Assert.assertEquals(0, jewelCount_frequencyArray("z", "ZZ"));
	}

}
