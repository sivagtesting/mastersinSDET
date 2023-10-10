package mandatoryHomework.AfterDSA;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LC_1128_NumberOfEquivalentDominoPairs {
	
	/*
	 * https://leetcode.com/problems/number-of-equivalent-domino-pairs/description/
	 * 
		PseudoCode:
			initialize counter = 0
			iterate using for with starting index as 0 and end index lt dominoes.length-1
			create a inner loop with start index as i+1 and end index lt dominoes.length
			    starting from first index compare with remaing elements
			    if mathces then increment count
			    repeat the same for remaining element until length -1 is reached
			return count
	 * 
	 */
	
	public int numEquivDominoPairs(int[][] dominoes) {
		int counter = 0;
		for (int i = 0; i < dominoes.length - 1; i++) {
			for (int j = i + 1; j < dominoes.length; j++) {
				if (dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1])
					counter++;
				else if (dominoes[i][0] == dominoes[j][1] && dominoes[i][1] == dominoes[j][0])
					counter++;
			}
		}
		return counter;
	}
	
	@Test
	public void test1() {
		int[][] dominos = {{1,2},{2,1},{3,4},{5,6}};
		int output = 1;
		Assert.assertEquals(numEquivDominoPairs(dominos), output);
	}
	
	@Test
	public void test2() {
		int[][] dominos = {{1,2},{1,2},{1,1},{1,2},{2,2}};
		int output = 3;
		Assert.assertEquals(numEquivDominoPairs(dominos), output);
	}

}
