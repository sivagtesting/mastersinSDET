package foundation.DailyProblems;

import org.junit.Assert;
import org.junit.Test;


public class TruncateSentence {
	/*
	 * https://leetcode.com/problems/truncate-sentence/description/
	 * 
	 * TestData Enumeration:
			Hi, 1 -> Hi
			Hi , 1 -> Hi
			Hello word,1 -> Hello
			The fox has four legs, 3 -> The fox has
			The fox has four legs, 5 -> The fox has four legs
	 * 
	 * PseudoCode:
			Step1: check if k=1 -> then return substring of input s based on " "
			Step2: if no then repeat the following steps
			Step3: split the input string based on space
			Step4: iterate over the string array from step3 upto k
			Step5: create a string inside for loop
			Step6: return the string;
	 * 
	 */
	
	public static String truncateSentence(String s, int k) {
		String op = "";
		if (k == 1) {
			if (s.indexOf(" ") < 0)
				return s;
			else
				return s.substring(0, s.indexOf(" "));
		} else {
			String[] sInp = s.split(" ");
			for (int i = 0; i < k; i++) {
				op = op + " " + sInp[i];
			}
			return op.trim();
		}
	}
	
	@Test
	public void test1() {
		Assert.assertEquals("Hi", truncateSentence("Hi", 1));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals("Hi", truncateSentence("Hi ", 1));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals("Hello", truncateSentence("Hello word", 1));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals("The fox has", truncateSentence("The fox has four legs", 3));
	}
	
	@Test
	public void test5() {
		Assert.assertEquals("The fox has four legs", truncateSentence("The fox has four legs", 5));
	}

}
