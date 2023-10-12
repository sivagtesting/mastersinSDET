package mandatoryHomework.AfterDSA;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LC_160_IntersectionOfTwoLinkedLists {

	/*
	 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
	 * 
	 */
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode commonNode = null;
		ListNode aNode = headA;
		ListNode bNode = headB;
		while (aNode != null) {
			while (bNode != null) {
				if (aNode == bNode) {
					commonNode = aNode;
					return commonNode;
				}
				bNode = bNode.next;
			}
			bNode = headB;
			aNode = aNode.next;
		}
		return commonNode;
	}
	
	@Test
	public void test1() {
		ListNode headA = new ListNode(4);
		headA.next = new ListNode(1);
		headA.next.next = new ListNode(8);
		headA.next.next.next = new ListNode(4);
		headA.next.next.next.next = new ListNode(5);
		ListNode headB = new ListNode(5);
		headB.next = new ListNode(6);
		headB.next.next = new ListNode(1);
		headB.next.next.next = headA.next.next;
		headB.next.next.next.next = headA.next.next.next;
		headB.next.next.next.next.next = headA.next.next.next.next;
		Assert.assertEquals(getIntersectionNode(headA, headB), headA.next.next);
	}
	
}
