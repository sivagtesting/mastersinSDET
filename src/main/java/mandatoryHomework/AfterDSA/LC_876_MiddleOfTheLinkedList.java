package mandatoryHomework.AfterDSA;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LC_876_MiddleOfTheLinkedList {

	/*
	 * https://leetcode.com/problems/middle-of-the-linked-list/description/
	 */
	
	public ListNode middleNode(ListNode head) {
		int count = 0;
		ListNode currentNode = head;
		while (currentNode != null) {
			count++;
			currentNode = currentNode.next;
		}
		if (count < 2)
			return head;
		int count2 = 0;
		currentNode = head;
		while (currentNode != null) {
			count2++;
			currentNode = currentNode.next;
			if (count2 == (count / 2))
				return currentNode;
		}

		return null;
	}
	
	@Test
	public void test1() {
		// {1,2,3,4,5}
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		// output list node for comparison
		/*
		 * ListNode output = new ListNode(3); output.next = new ListNode(4);
		 * output.next.next = new ListNode(5);
		 */
		
		Assert.assertEquals(middleNode(head), head.next.next);
	}
}
