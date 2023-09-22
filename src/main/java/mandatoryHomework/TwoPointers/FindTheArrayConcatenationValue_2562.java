package mandatoryHomework.TwoPointers;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FindTheArrayConcatenationValue_2562 {
	
	/*
	 * https://leetcode.com/problems/find-the-array-concatenation-value/description/
	 * 
	 * 
		TestData Enumeration:
			nums [1000] -> 1000
			nums [1,2,1] -> 13
			nums [1,2,2,1] -> 33
			
		PseudoCode: 10.31
			intialize integer start = 0, end = nums.length-1, concatenation = 0;
			check if nums.length == 1
			    if yes then return nums[1]
			else check if nums.length is even
			    if yes then do following
			        while(start<end)
			            get the element at index start and index end and append it to a temp string
			            set concatenation += parse the tempString into integer
			    return concatenation
			    if no then do the following
			        while(start<=end) 
			            get the element at index start and index end and append it to a temp string
			            set concatenation += parse the tempString into integer
			            if(start==end)
			                get the element at index start &  append it to a temp string
			                set concatenation += parse the tempString into integer
			        return concatenation;
			        10.38
	 * 
	 */

	//TimeComplexity O[N/2]
	public long findTheArrayConcVal(int[] nums) {
		int start = 0, end = nums.length - 1, concatenation = 0;
		StringBuilder sb = new StringBuilder();
		if (nums.length == 1)
			return nums[0];
		else if (nums.length % 2 == 0) {
			while (start < end) {
				sb.append(nums[start] + "" + nums[end]);
				concatenation += Integer.parseInt(sb.toString());
				sb.setLength(0);
				start++;
				end--;
			}
			return concatenation;
		} else {
			while (start <= end) {
				if (start == end)
					concatenation += nums[start];
				else {
					sb.append(nums[start] + "" + nums[end]);
					concatenation += Integer.parseInt(sb.toString());
					sb.setLength(0);
				}
				start++;
				end--;
			}
			return concatenation;
		}
	}
	
	public long findTheArrayConcVal_WithoutString(int[] nums) {
		int start = 0, end = nums.length - 1, concatenation = 0;
		int position = 1, temp = 0;
		if (nums.length == 1)
			return nums[0];
		else {
			while (start <= end) {
				if (start == end)
					concatenation += nums[start];
				else {
					temp = nums[end];
					while(temp!=0) {
						temp /= 10;
						position *= 10;
						
					}
					concatenation += (nums[start] * position) + nums[end];
					position=1;
				}
				start++;
				end--;
			}
			return concatenation;
		}
	}
	
	@Test
	public void test1() {
		int[] nums = {1000};
		int output = 1000;
		Assert.assertEquals(output, findTheArrayConcVal(nums));
	}
	
	@Test
	public void test2() {
		int[] nums = {1,2,1};
		int output = 13;
		Assert.assertEquals(output, findTheArrayConcVal(nums));
	}
	
	@Test
	public void test3() {
		int[] nums = {1,2,2,1};
		int output = 33;
		//Assert.assertEquals(output, findTheArrayConcVal(nums));
		Assert.assertEquals(output, findTheArrayConcVal_WithoutString(nums));
	}
	
	@Test
	public void test4() {
		int[] nums = {1,2,2000,100}; //1100, 22000
		int output = 23100;
		//Assert.assertEquals(output, findTheArrayConcVal(nums));
		Assert.assertEquals(output, findTheArrayConcVal_WithoutString(nums));
	}

}
