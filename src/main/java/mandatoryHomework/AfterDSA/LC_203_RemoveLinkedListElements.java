package mandatoryHomework.AfterDSA;

import org.testng.annotations.Test;

import foundation.week13.MyLinkedList;

public class LC_203_RemoveLinkedListElements {
	
	/*
	 * https://leetcode.com/problems/remove-linked-list-elements/
	 * 
	 */
	
	@Test
	public void testRemoveAll() {
		MyLinkedList learnList = new MyLinkedList();
		int[] input = {6,6,6,1,2,6,3,4,5,6};
		learnList.addAll(input);
//		learnList.removeAll(6);
		learnList.removeAll_optimised(6);
		System.out.println(learnList);
		
	}

}
