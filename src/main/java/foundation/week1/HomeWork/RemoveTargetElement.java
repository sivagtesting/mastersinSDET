package foundation.week1.HomeWork;

import org.junit.Assert;
import org.junit.Test;

public class RemoveTargetElement {
	
	public static String removingTarget(int[] inputArray, int target) {
		String outPut="";
		for (int i = 0; i < inputArray.length; i++) {
			if(inputArray[i]!=target)
				outPut = outPut + inputArray[i] + ",";
		}
		return outPut.toString();
	}
	
	@Test
	public void test() {
		System.out.println(removingTarget(new int[] {2, 3, 3, 4, 5}, 3));
		Assert.assertEquals("2,4,5,", removingTarget(new int[] {2, 3, 3, 4, 5}, 3));
	}
	
	@Test
	public void test1() {
		System.out.println(removingTarget(new int[] {2, 2}, 2));
		Assert.assertEquals("", removingTarget(new int[] {2,2}, 2));
	}

}
