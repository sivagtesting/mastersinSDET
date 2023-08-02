package foundation.week2.Day2;

import org.junit.Assert;
import org.junit.Test;

public class LengthOfLastWord {
	
	public static int lengthOfLastWord(String s) {
		return s.trim().length()-s.lastIndexOf(" ")-1;
	}
	
	@Test
	public void test1() {
		Assert.assertEquals(5, lengthOfLastWord("world"));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(5, lengthOfLastWord("Hello world"));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(4, lengthOfLastWord("   fly me   to   the moon  "));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(6, lengthOfLastWord("luffy is still joyboy"));
	}
}
