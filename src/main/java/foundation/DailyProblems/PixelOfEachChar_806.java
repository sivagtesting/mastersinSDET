package foundation.DailyProblems;

import org.junit.Assert;
import org.testng.annotations.Test;

public class PixelOfEachChar_806 {
	
	/*
	 * https://leetcode.com/problems/number-of-lines-to-write-string/description/
	 * 
	 	PseudoCode:
			11.15
			intialize a integer pixel=0, counter=0;
			iterate the following steps using for untile s.length
			convert the char at current index ascciValue a=0, b=1 and so on
			check if pixel>100
			check if i = s.length-1
			if yes, then add result[1] = pixel;
			if yes then decrement i and negate the pixel value of charAt current index from pixel integer and increment counter & reset piexl
			if no then add pixel value of current index to pixel
			check if piexel<100
			pixel = pixel + widths[s.charAt(i)-'a'];
			check if pixel ==100
			if yes increment counter;
			check if i = s.length-1
			if yes, result[1] = pixel;
			pixel =0;
			i = i-1
			
			result[0] = counter;
			
			return result;
			
			11.29
	 * 
	 */
	
	public static int[] numberOfLines(int[] widths, String s) {
		int pixel = 0, counter = 0;
		int[] result = new int[2];
		for (int i = 0; i < s.length(); i++) {
			pixel += widths[s.charAt(i) - 'a'];
			if (pixel > 100) {
				counter++;
				pixel = 0;
				i = i - 1;
			} else if (pixel == 100) {
				counter++;
				if (i == s.length() - 1) {
					result[0] = counter;
					result[1] = pixel;
					return result;
				}
				pixel = 0;
			}
			if (i == s.length() - 1) {
				result[0] = ++counter;
				result[1] = pixel;
			}
		}
		return result;
	}
	
	@Test
	public void test1() {
		int[] widths = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
		String s = "abcdefghijklmnopqrstuvwxyz";
		int[] result = {3,60};
		Assert.assertArrayEquals(result, numberOfLines(widths, s));
	}
	
	@Test
	public void test2() {
		int[] widths = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
		String s = "bbbcccdddaaa";
		int[] result = {2,4};
		Assert.assertArrayEquals(result, numberOfLines(widths, s));
	}
	
	@Test
	public void test3() {
		int[] widths = {3,4,10,4,8,7,3,3,4,9,8,2,9,6,2,8,4,9,9,10,2,4,9,10,8,2};
		String s = "mqblbtpvicqhbrejb";
		int[] result = {1,100};
		Assert.assertArrayEquals(result, numberOfLines(widths, s));
	}

}
