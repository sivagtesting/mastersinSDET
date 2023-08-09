package foundation.DailyProblems;

import org.junit.Assert;
import org.junit.Test;

public class ShortestDistanceToChar {

	/*
	 * Input: s = "loveleetcode", c = "e" Output: [3,2,1,0,1,0,0,1,2,2,1,0]
	 * 
	 */

	public static int[] getShortDistanceToChar(String s, char c) {
		int closestIndexOnRight = 0;
		int closestIndexOnLeft = 0;
		int[] answer = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (!(s.charAt(i) == c)) {
				if (s.indexOf(c, i) > 0) {
					closestIndexOnRight = Math.abs(i - s.indexOf(c, i));
					if(s.indexOf(c)<i) {
					for (int j = i - 1; j >= 0; j--) {
						if (s.charAt(j) == c) {
							closestIndexOnLeft = Math.abs(i - j);
							break;
						}
					}
					}
					if (closestIndexOnRight < closestIndexOnLeft && closestIndexOnRight != 0
							&& closestIndexOnLeft != 0) {
						answer[i] = closestIndexOnRight;
						closestIndexOnLeft = 0;
						closestIndexOnRight = 0;
					} else if (closestIndexOnRight > closestIndexOnLeft && closestIndexOnRight != 0
							&& closestIndexOnLeft != 0) {
						answer[i] = closestIndexOnLeft;
						closestIndexOnLeft = 0;
						closestIndexOnRight = 0;
					} else if (closestIndexOnLeft == 0) {
						answer[i] = closestIndexOnRight;
						closestIndexOnRight = 0;
					} else if (closestIndexOnRight == closestIndexOnLeft ) {
						answer[i] = closestIndexOnRight;
						closestIndexOnLeft = 0;
						closestIndexOnRight = 0;
					}
				} else {
					for (int j = i - 1; j >= 0; j--) {
						if (s.charAt(j) == c) {
							answer[i] = Math.abs(i - j);
							break;
						}
					}
				}
			}
		}
		return answer;
	}

	@Test
	public void test1() {
		Assert.assertArrayEquals(new int[] {3,2,1,0,1,0,0,1,2,2,1,0}, getShortDistanceToChar("loveleetcode", 'e'));
	}

}
