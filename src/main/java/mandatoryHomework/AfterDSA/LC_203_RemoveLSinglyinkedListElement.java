package mandatoryHomework.AfterDSA;

public class LC_203_RemoveLSinglyinkedListElement {

	/*
	 * https://leetcode.com/problems/remove-linked-list-elements/
	 * 
	 */
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	 
	
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return head;
		ListNode currentNode = head;
		while (currentNode.val == val)
			currentNode = currentNode.next;
		while (currentNode != null) {
			if (currentNode.next.val == val)
				currentNode.next = currentNode.next.next;
			currentNode = currentNode.next;
		}
		return head;
	}
	
}
