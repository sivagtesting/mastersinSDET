package foundation.DailyProblems;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AccronymOfWords {

	public boolean isAcronym(List<String> words, String s) {
		if (s.length() == words.size()) {
			StringBuilder accronym = new StringBuilder(s.length());
			for (int i = 0; i < words.size(); i++) {
				accronym.append(words.get(i).charAt(0));
			}
			return accronym.toString().equals(s);
		} else
			return false;
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(true, isAcronym(Arrays.asList(new String[] {"alice","bob","charlie"}), "abc"));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(true, isAcronym(Arrays.asList(new String[] {"a","b"}), "ab"));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(true, isAcronym(Arrays.asList(new String[] {"aa"}), "a"));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(false, isAcronym(Arrays.asList(new String[] {"alice","bob","charlie"}), "a"));
	}
	
	@Test
	public void test5() {
		Assert.assertEquals(false, isAcronym(Arrays.asList(new String[] {"alice","bob","charlie"}), "cab"));
	}

}
