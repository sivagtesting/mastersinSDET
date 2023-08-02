package foundation.week1.day2;

import org.junit.Test;

public class ClassWork3 {

	public static int numberOfMatches(int n) {

		int teams, matches = 0, totalMatch = 0;
		teams = n;
		while (teams > 1) {
			if (teams % 2 == 0) {
				matches = teams / 2;
				teams = teams / 2;
				totalMatch = totalMatch + matches;
			} else {
				matches = (teams - 1) / 2;
				teams = (teams - 1) / 2 + 1;
				totalMatch = totalMatch + matches;
			}
		}
		return totalMatch;
	}

	@Test
	public void test1() {
		System.out.println(numberOfMatches(7));
	}

}
