package mandatoryHomework.AfterDSA;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WinnerOfBowlingGame_2660 {
	/*
	 * https://leetcode.com/problems/determine-the-winner-of-a-bowling-game/description/
	 * 
	 	PseudoCode:
			7.38
			intialize player1Score =0, player2Score=0
			check the lenght of player1
			    if it is less than 2 then call determineWinner method
			    else
			        add the first two elements of player1 to palyer1Score varaible
			        add the first two elements of player2 to palyer2Score varaible
			        do the following using for until index<player1.length start index = 2
			            check if element at index (currentindex-1, currentindex-2 ==10)
			                if yes then add player1Score with current element*2
			                if no then add player1Score with current element
			            do the same for player2
			        outside the loop call determinWInner
			
			determinwinner:
			compare the two scores if palyer1 score is greater then return 1
			else fi player2 score is gt then return 2
			else return 0
			7.48
	 * 
	 */
	
	public int isWinner(int[] player1, int[] player2) {
			int player1Score = 0, player2Score = 0;
			for (int i = 0; i < player1.length; i++) {
				if(i == 1 && player1[i - 1] == 10)
					player1Score += 2 * player1[i];
				else if(i>=2 && (player1[i - 1] == 10 || player1[i - 2] == 10))
					player1Score += 2 * player1[i];
				else
					player1Score += player1[i];
				
				if(i == 1 && player2[i - 1] == 10)
					player2Score += 2 * player2[i];
				else if(i>=2 && (player2[i - 1] == 10 || player2[i - 2] == 10))
					player2Score += 2 * player2[i];
				else
					player2Score += player2[i];
				}
			if(player1Score==player2Score)
				return 0;
			else
				return (player1Score>player2Score) ? 1 : 2;
			}
	
	@Test
	public void test1() {
		int[] player1 = {4,10,7,9};
		int[] player2 = {6,5,2,3};
		int output = 1;
		Assert.assertEquals(isWinner(player1, player2), output);
	}
	
	@Test
	public void test2() {
		int[] player1 = {3,5,7,6};
		int[] player2 = {8,10,10,2};
		int output = 2;
		Assert.assertEquals(isWinner(player1, player2), output);
	}
	
	@Test
	public void test3() {
		int[] player1 = {2,3};
		int[] player2 = {4,1};
		int output = 0;
		Assert.assertEquals(isWinner(player1, player2), output);
	}
	
}
