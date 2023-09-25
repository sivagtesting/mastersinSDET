package foundation.week10.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.testng.Assert;

public class SummaryRange_228 {
	
	/*
	 * Using Two Pointer Algo
	 * 
	 * 
	 * 
	 */
	
	public List<String> summaryRanges(int[] nums) {
		List<String> output = new ArrayList<String>();
		if (nums.length == 0)
			return output;
		else if (nums.length == 1) {
			output.add(nums[0] + "");
			return output;
		} else {
			int pointerOne = 0, pointerTwo = 1;
			while (pointerOne < nums.length - 1 && pointerTwo < nums.length - 1) {
				int temp = nums[pointerOne];
				if (nums[pointerTwo] - nums[pointerOne] == 1) {
					pointerTwo++;
					pointerOne++;
				} else if (temp == nums[pointerOne]) {
					output.add(temp + "");
					pointerOne++;
					pointerTwo++;
				} else {
					output.add(temp + "->" + nums[pointerOne++]);
					pointerTwo++;
				}
			}
			return output;
		}
	}
	
	@Test
	public void test1() {
		int[] nums = {0,1,2,4,5,7};
		String[] temp = {"0->2", "4->5", "7"};
		List<String> output = Arrays.asList(temp);
		Assert.assertEquals(output, summaryRanges(nums));
	}
}

