package mandatoryHomework.AfterDSA;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LC_83_RemoveDuplicatesFromSortedList {

	/*
	 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
	 * 
	 */
	
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode currentHead = head;
		while (currentHead.next != null) {
			if (currentHead.val == currentHead.next.val) {
				currentHead.next = currentHead.next.next;
			} else
				currentHead = currentHead.next;
		}
		return head;
	}
	
	@Test
	public void test1() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(3);
		Assert.assertEquals(deleteDuplicates(head), head);		
	}
}
