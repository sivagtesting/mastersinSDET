package mandatoryHomework.AfterDSA;

import java.util.Stack;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LC_682_BaseBallGame {
	/*
	 * https://leetcode.com/problems/baseball-game/description/
	 * 
	 		PseudoCode:
	 			initialize stack of integers ops
				iterate over the operations array
				check if the element is integer
				    if yes then push to ops
				    if no then check if the char is 'C'
				        If yes then pop ops
				        if no then check if the char is 'D'
				            If yes then peek from ops and multiply by two and push to ops
				            if no then do the following
				                initialize a temp integer
				                pop from ops and assign to temp
				                add top element from stack to temp, push temp and the sum
				check if size of ops is 0 then return 0
				else iterate with the size of stack and pop each element and add to sum variable
				return sum
	 */
	
//	TimeComplexity: O(N)
//	SpaceComplexity: O(N)
	
	public int calPoints(String[] operations) {
		Stack<Integer> ops = new Stack<Integer>();
		int sum = 0, temp = 0, tempSum = 0;
		for (int i = 0; i < operations.length; i++) {
			switch (operations[i]) {
			case "C":
				ops.pop();
				break;
			case "D":
				ops.push(ops.peek() * 2);
				break;
			case "+":
				temp = ops.pop();
				tempSum = temp + ops.peek();
				ops.push(temp);
				ops.push(tempSum);
				break;
			default:
				ops.push(Integer.parseInt(operations[i]));
				break;
			}
			/*
			 * if(operations[i].equals("C")){ ops.pop(); } else
			 * if(operations[i].equals("D")) { ops.push(ops.peek()*2); } else
			 * if(operations[i].equals("+")) { temp = ops.pop(); tempSum = temp +
			 * ops.peek(); ops.push(temp); ops.push(tempSum); } else {
			 * ops.push(Integer.parseInt(operations[i])); }
			 */
		}
		if (ops.empty())
			return 0;
		for (int i : ops)
			sum += i;
		return sum;
	}
	
	@Test
	public void test1() {
		String[] s = {"5","2","C","D","+"};
		int result = 30;
		Assert.assertEquals(calPoints(s), result);
	}
	
	@Test
	public void test2() {
		String[] s = {"5","-2","4","C","D","9","+","+"};
		int result = 27;
		Assert.assertEquals(calPoints(s), result);
	}
	
	@Test
	public void test3() {
		String[] s = {"1","C"};
		int result = 0;
		Assert.assertEquals(calPoints(s), result);
	}

}
