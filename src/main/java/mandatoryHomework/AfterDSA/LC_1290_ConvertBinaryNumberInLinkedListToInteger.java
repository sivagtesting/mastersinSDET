package mandatoryHomework.AfterDSA;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LC_1290_ConvertBinaryNumberInLinkedListToInteger {

	/*
	 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/
	 * 
	 	TestData Enumeration:
	 		[1,1,0,1,1,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1] -> 907087873
	 	
	 	PseudoCode:
	 		Initialize a integer variable decimalValue
			Iterate over the linked list
			    inside loop get each element of linked list and set decimalValue = (decimalValue * 2) + eachElement of linked list (eachBinaryDigit)
			
			return decimal value
	 * 
	 */
	
	public int getDecimalValue(ListNode head) {
		int decimalValue = 0;
		ListNode currentHead = head;
		while (currentHead != null) {
			decimalValue = decimalValue * 2 + currentHead.val;
			currentHead = currentHead.next;
		}
		return decimalValue;
	}
	
	@Test
	public void test1() {
		ListNode head = new ListNode(1, new ListNode(0, new ListNode(1)));
		int decimalValue = 5;
		Assert.assertEquals(getDecimalValue(head), decimalValue);
	}
	
	@Test
	public void test2() {
		ListNode head = new ListNode(0);
		int decimalValue = 0;
		Assert.assertEquals(getDecimalValue(head), decimalValue);
	}
}
