package foundation.week1.day2;

import org.junit.Assert;
import org.junit.Test;

public class CountOfMatchesInTournament_1688 {
	public static int getNumberOfMatches(int n) {
		int matchCount = 0;
		int teamCount = n;
		while (teamCount > 1) {
			if (teamCount % 2 == 0) {
				matchCount = matchCount + teamCount / 2;
				teamCount = teamCount / 2;
			} else {
				matchCount = matchCount + (teamCount - 1) / 2;
				teamCount = ((teamCount - 1) / 2) + 1;
			}
		}
		return matchCount;
	}

	@Test
	public void test1() {
		Assert.assertEquals(6, getNumberOfMatches(7));
	}

	@Test
	public void test2() {
		Assert.assertEquals(9, getNumberOfMatches(10));
	}

	@Test
	public void test3() {
		Assert.assertEquals(1, getNumberOfMatches(2));
	}
}
