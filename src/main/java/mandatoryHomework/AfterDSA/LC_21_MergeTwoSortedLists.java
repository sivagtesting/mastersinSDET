package mandatoryHomework.AfterDSA;

import org.testng.annotations.Test;

public class LC_21_MergeTwoSortedLists {
	
	/*
	 * https://leetcode.com/problems/merge-two-sorted-lists/
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
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

		ListNode mergedNode = null;
		while (list1 != null || list2 != null) {
			while (list1 == null && list2 != null) {
				mergedNode = list2;
				break;
			}
			while (list2 == null && list1 != null) {
				mergedNode = list1;
				break;
			}
			while (list1 != null && list2 != null) {
				if (list1.val < list2.val) {
					if(mergedNode==null)
						mergedNode = new ListNode(list1.val);
					else {
						mergedNode.next = new ListNode(list1.val);
						mergedNode = mergedNode.next;
					}
					list1 = list1.next;
				} else if (list1.val > list2.val) {
					if(mergedNode==null)
						mergedNode = new ListNode(list2.val);
					else {
						mergedNode.next = new ListNode(list2.val);
						mergedNode = mergedNode.next;
					}
					
					list2 = list2.next;
				} else {
					if(mergedNode==null) {
						mergedNode = new ListNode(list1.val);
						mergedNode.next = new ListNode(list2.val);
						mergedNode = mergedNode.next;
					}
					else {
						mergedNode.next = new ListNode(list1.val);
						mergedNode.next.next = new ListNode(list2.val);
						mergedNode = mergedNode.next.next;
					}
					list1 = list1.next;
					list2 = list2.next;
				}
			}

		}
		return mergedNode;
	}
	
	@Test
	public void test1() {
		ListNode list1 = new ListNode();
		list1.val = 1;
		list1.next = new ListNode(2);
		list1.next.next = new ListNode(4);
		ListNode list2 = new ListNode();
		list2.val = 1;
		list2.next = new ListNode(3);
		list2.next.next = new ListNode(4);
		mergeTwoLists(list1, list2);	
	}

}
