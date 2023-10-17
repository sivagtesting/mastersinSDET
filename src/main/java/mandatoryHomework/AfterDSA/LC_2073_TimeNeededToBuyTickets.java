package mandatoryHomework.AfterDSA;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LC_2073_TimeNeededToBuyTickets {

	/*
	 * https://leetcode.com/problems/time-needed-to-buy-tickets/description/
	 * 
	 	PseudoCode:
	 		initialize int counter = 0
	 		do the following using while until tickets[k] becomes zero
	 			using for loop iterate over the input tickets array
	 				check if the element at current index ne 0
	 					if yes then increment counter & update the element at the current index as value of element - 1
	 				check if element at index k eq 0
	 					if yes then return counter;
	 		outside the while loop return the counter;
	 * 
	 */
	
	
	// TimeComplexity: O(nLogN)
	// SpaceComplexity: O(1)
	public int timeRequiredToBuy(int[] tickets, int k) {
		int count = 0;
		while (tickets[k] > 0) {
			for (int i = 0; i < tickets.length; i++) {
				if (tickets[i] != 0) {
					count++;
					tickets[i] = tickets[i] - 1;
				}
				if (tickets[k] == 0)
					return count;
			}
		}
		return count;
	}
	
	@Test
	public void test1() {
		int[] tickets = {2,3,2};
		int k = 2;
		int timeRequired = 6;
		Assert.assertEquals(timeRequiredToBuy(tickets, k), timeRequired);
	}
	
	@Test
	public void test2() {
		int[] tickets = {5,1,1,1};
		int k = 0;
		int timeRequired = 8;
		Assert.assertEquals(timeRequiredToBuy(tickets, k), timeRequired);
	}
	
	
}
