package foundation.week10.day1;

import org.junit.Assert;
import org.junit.Test;

public class ReverseAStringWithTwoPointers {
	
	public String reverseStringConventionalWay(String word) {
		StringBuilder sb = new StringBuilder(word.length());		
		for (int i = word.length()-1; i >=0; i--) {
			sb.append(word.charAt(i)); 
			System.out.println("I am being executed");
			}
			return sb.toString();
		}
	
	@Test
	public void test1() {
		String word = "hellow";
		String output = "wolleh";
		Assert.assertEquals(output, reverseStringConventionalWay(word));
		//Assert.assertEquals(output, reverseCharArrayWithTwoPointerApproach(word));
	}
	
	@Test
	public void test2() {
		char[] word = {'h','e','l','l','o','w'};
		char[] output = {'w','o','l','l','e','h'};
		Assert.assertArrayEquals(output, reverseCharArrayWithTwoPointerApproach(word));
	}
	
	public char[] reverseCharArrayWithTwoPointerApproach(char[] word) {
		int leftIndex = 0;
		int rightIndex = word.length-1;
		//length = 6
		//h e l l o w
		//0 1 2 3 4 5
		
		while(leftIndex<rightIndex) {
			char temp = word[leftIndex];
			word[leftIndex] = word[rightIndex];
			word[rightIndex] = temp;
			leftIndex++;
			rightIndex--;
			System.out.println("I am being executed - Two Pointers");
		}
		
		
		return word;
	}

}
