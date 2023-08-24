package foundation.DailyProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.devtools.v113.input.Input;

public class SetMisMatch {
	/*
	 * https://leetcode.com/problems/set-mismatch/description/
	 * 
	 * TestData Enumeration: 
	 * 1. {1,2,2,4} -> {2,3} 
	 * 2. {1,2,3,3} -> {3,4} 
	 * 3. {0,0,2,3} -> {0,1} 
	 * 4. {1,1,3,4} -> {1,2}
	 * 5. {1,3,3,4}
	 * 6. {2,3,4,4} -> 
	 * 7. {1,5,3,2,2,7,6,4,8,9} -> {1,2,2,3,4,5,6,7,8,9}
	 * 
	 * PseudoCode: 
	 * Step1: Iterated over the input array using for 
	 * Step2: if index is zero then check whether the current element is 1 else return {nums[0],1}
	 * Step3: for rest of the index check whether the difference between the current
	 * element and previouse element is 1 
	 * 		Step3.1: if no then return {currentElement, previousElement+1}
	 * 
	 * PseudoCode:
	 * Step1: Sort the inputarray nums using two for loop
	 * Step2: initiate a output array of lenght 2
	 * Step3: check if the element at index 0 == 1
	 * 		Step3.1: if no then add outputArray[1] = 1
	 * Step4: check if the element at index nums.length-1 == nums.length
	 * 		Step4: if no then add outputArray[1] = 1
	 * Step5: iterate from 1 to nums.length-2
	 * 		Step5.1: check if the difference between the previous element and the current eleemnt is 1
	 * 		Step5.2: if no then add outputArray[1] = previous element+1
	 * 		Step5.3: if yes then check if the difference between the current element and the next eleemnt is 1
	 * Step6: for finding the element at outputArray[0] we have to check if the difference between two conseucting element are 0 then add that element
	 * 
	 * Writing Code in Leet Code:
	 * 
	 */
	
	public int[] findErrorNumsBruteForce(int[] nums) {
		//Running time in leetcode 876 ms
		
		int[] opArray = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if(nums[i]>nums[j]) {
					nums[i] = nums[i] + nums[j];
					nums[j] = nums[i] - nums[j];
					nums[i] = nums[i] - nums[j];
				}
			}
		}
		
		//Finding Missing Number
		
		if(nums[0]!=1) 
			opArray[1] = 1;
		else if(nums[nums.length-1]!=nums.length)
			opArray[1] = nums.length;
		else {
			for (int i = 1; i < nums.length; i++) {
				if(Math.abs(nums[i]-nums[i-1])!=1 && nums[i]-nums[i-1]!=0) {
					opArray[1] = nums[i-1]+1;
					break;
				}
			}
		}
		
		//Finding the number that is duplicate
		for (int i = 1; i < nums.length; i++) {
			if(nums[i]-nums[i-1]==0) {
				opArray[0] = nums[i];
				break;
			}
		}
		return opArray;
	}
	
	@Test
	public void test1() {
		Assert.assertArrayEquals(new int[] {2,3},	findErrorNumsBruteForce(new int[] {1,2,2,4}));
		Assert.assertArrayEquals(new int[] {2,3},	findErrorNumsUsingMap(new int[] {1,2,2,4}));
		Assert.assertArrayEquals(new int[] {2,3},	findErrorNumsUsingSet(new int[] {1,2,2,4}));
	}
	
	@Test
	public void test2() {
		Assert.assertArrayEquals(new int[] {39,55},	findErrorNumsBruteForce(new int[] {37,62,43,27,12,66,36,18,39,54,61,65,47,32,23,2,46,8,4,24,29,38,63,39,25,11,45,28,44,52,15,30,21,7,57,49,1,59,58,14,9,40,3,42,56,31,20,41,22,50,13,33,6,10,16,64,53,51,19,17,48,26,34,60,35,5}));
		Assert.assertArrayEquals(new int[] {39,55},	findErrorNumsUsingMap(new int[] {37,62,43,27,12,66,36,18,39,54,61,65,47,32,23,2,46,8,4,24,29,38,63,39,25,11,45,28,44,52,15,30,21,7,57,49,1,59,58,14,9,40,3,42,56,31,20,41,22,50,13,33,6,10,16,64,53,51,19,17,48,26,34,60,35,5}));
		Assert.assertArrayEquals(new int[] {39,55},	findErrorNumsUsingSet(new int[] {37,62,43,27,12,66,36,18,39,54,61,65,47,32,23,2,46,8,4,24,29,38,63,39,25,11,45,28,44,52,15,30,21,7,57,49,1,59,58,14,9,40,3,42,56,31,20,41,22,50,13,33,6,10,16,64,53,51,19,17,48,26,34,60,35,5}));
	}
	
	public int[] findErrorNumsUsingMap(int[] nums) {
		//Running time in leetcode 12 ms
		int[] opArray = new int[2];
		//finding duplicate number
		Map<Integer, Integer> inpNumsMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (inpNumsMap.containsKey(nums[i])) {
				inpNumsMap.put(nums[i], inpNumsMap.get(nums[i] + 1));
				opArray[0] = nums[i];
			} else
				inpNumsMap.put(nums[i], 1);
		}
		
		// finding the missing number
		for (int i = 1; i <= nums.length; i++) {
			if(!inpNumsMap.containsKey(i))
				opArray[1] = i;
		}

		return opArray;
	}
	
	public int[] findErrorNumsUsingSet(int[] nums) {
		//Running time in leetcode 9 ms
		int[] opArray = new int[2];
		
		//finding duplicate Num
		Set<Integer> inpNums = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if(!inpNums.add(nums[i]))
				opArray[0] = nums[i];
		}
		
		//finding missing num
		for (int i = 1; i <= nums.length; i++) {
			if(!inpNums.contains(i)) {
				opArray[1] = i;
				break;
			}
		}
		return opArray;
	}
	
	public int[] findErrorNumsUsingHashKeyArray(int[] nums) {
		return null;
	}

}
