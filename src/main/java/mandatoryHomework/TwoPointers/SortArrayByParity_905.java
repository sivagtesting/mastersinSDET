package mandatoryHomework.TwoPointers;

public class SortArrayByParity_905 {
	
	/*
	 * https://leetcode.com/problems/sort-array-by-parity/description/
	 * 
	 * PseudoCode:
	 * 		initialize p1=0, p2=1;
			repeate the following steps using while until p2< nums.length
			check if nums[p1] %2 ==0
			
			if no then check nums[p2] %2 ==0
			    if yes then swap, increment p1 & p2
			    if no then increment p2
			if yes then increment p1 & p2
	 * 
	 * 
	 */

	
	public int[] sortArrayByParity(int[] nums) {
		int start = 0, end = 1;
		while (end < nums.length) {
			if (nums[start] % 2 == 0) {
				start++;
				end++;
			} else {
				if (nums[end] % 2 == 0) {
					nums[start] = nums[start] + nums[end];
					nums[end] = nums[start] - nums[end];
					nums[start] = nums[start] - nums[end];
				} else {
					end++;
				}
			}
		}
		return nums;
	}
}
