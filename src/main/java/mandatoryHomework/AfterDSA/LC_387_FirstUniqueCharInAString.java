package mandatoryHomework.AfterDSA;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LC_387_FirstUniqueCharInAString {

	/*
	 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
	 * 
	 	TestData:
			abab -> -1
			ababc -> 4
			abbbbcccddd -> 0	
	 	PseudoCode:
	 		Initialize two int left =0, right=0;
			using while iterate until left<s.length-1
			    using while iterate until right<s.length()
			        compare char at index left with all the remaining char from s using right index
			            if there is no match return the char at index left
			            right++;
			        left++;
	 */
	
	public int firstUniqChar(String s) {
        if(s.length()<2)
            return 0;
        Map<Character, Integer> frequency = new LinkedHashMap<Character, Integer>();
        int length = s.length();
        for(int i=0; i<length; i++)
            frequency.put(s.charAt(i), frequency.getOrDefault(s.charAt(i),0)+1);
        for(char c: frequency.keySet()){
            if(frequency.get(c)==1)
                return s.indexOf(c);
        }
            return -1;
    }
	
	@Test
	public void test1() {
		String s = "leetcode";
		int result = 0;
		Assert.assertEquals(firstUniqChar(s), result);
	}
	
	@Test
	public void test2() {
		String s = "loveleetcode";
		int result = 2;
		Assert.assertEquals(firstUniqChar(s), result);
	}
	
	@Test
	public void test3() {
		String s = "aabb";
		int result = -1;
		Assert.assertEquals(firstUniqChar(s), result);
	}
	
	@Test
	public void test4() {
		String s = "abab";
		int result = -1;
		Assert.assertEquals(firstUniqChar(s), result);
	}
}
