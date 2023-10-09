package mandatoryHomework.AfterDSA;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class LC_1_TwoSum {
	
	/*
	 * https://leetcode.com/problems/two-sum/description/
	 */
	
	 public int[] twoSum(int[] nums, int target) {
	        Map<Integer, Integer> number = new HashMap<Integer, Integer>();
	        for(int i=0; i<nums.length; i++){
	            if(number.containsKey(target - nums[i]))
	                return new int[] {(int) number.get(target - nums[i]), i};
	            else
	                number.put(nums[i], i);
	        }
	        return new int[] {0,0};
	    }
	 
	 @Test

}
