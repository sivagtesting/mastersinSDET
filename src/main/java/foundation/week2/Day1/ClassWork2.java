package foundation.week2.Day1;

public class ClassWork2 {
	
	/*			https://leetcode.com/problems/shuffle-string/description/
	 * 	
	 * You are given a string s and an integer array indices of the same length. The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.

					Return the shuffled string.
					Example 1:
				Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
				Output: "leetcode"
				Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.

	 * 				Example 2:
				Input: s = "abc", indices = [0,1,2]
				Output: "abc"
				Explanation: After shuffling, each character remains in its position.
	 * 
	 * 
	 */
	
	public static boolean countVowels(String s) {
		
		String a = s.substring(0,s.length()/2);
		String b = s.substring(s.length()/2);
		int aCount = 0, bCount = 0;
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i)=='a'||a.charAt(i)=='e'||a.charAt(i)=='i')
				aCount++;
			if(b.charAt(i)=='a'||b.charAt(i)=='e'||b.charAt(i)=='i')
				bCount++;
		}
		return aCount==bCount;
	}

}
