package foundation.DailyProblems;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MinAdditionToMakeValidString_2645 {

	/*
	 * https://leetcode.com/problems/minimum-additions-to-make-valid-string/
	 * description/
	 * 
	 */

	public int addMinimum(String word) {
		if (word.length() == 1)
			return 2;
		else if (word.length() == 2) {
			if (word.charAt(0) == 'a') {
				if (word.charAt(1) == 'b' || word.charAt(1) == 'c')
					return 1;
				else if (word.charAt(1) == 'a')
					return 4;
			} else if (word.charAt(0) == 'b') {
				if (word.charAt(1) == 'c')
					return 1;
				else
					return 4;
			} else
				return 4;
		} else {
			int counter = 0;
			for (int i = 0; i < word.length(); i++) {
				if (i == 0) {
					if (word.charAt(i) == 'a') {
						if (word.charAt(i + 1) == 'b' && word.charAt(i + 2) == 'c')
							i = 2;
						else if (word.charAt(i + 1) == 'b') {
							counter++;
							i = 1;
						} else if (word.charAt(i + 1) == 'c') {
							counter++;
							i = 1;
						} else {
							counter += 2;
						}
					} else if (word.charAt(i) == 'b') {
						if (word.charAt(i + 1) == 'c') {
							counter++;
							i = i + 1;
						} else
							counter += 2;
					} else
						counter += 2;
				} else if (i == word.length() - 1) {
					if (word.charAt(i) == 'a')
						counter += 2;
					else if (word.charAt(i) == 'b') {
						if (word.charAt(i - 1) == 'a')
							counter++;
						else
							counter += 2;
					} else {
						if (word.charAt(i - 1) == 'b' && word.charAt(i - 2) == 'a')
							continue;
						else if (word.charAt(i - 1) == 'b')
							counter++;
						else
							counter += 2;
					}
				} else if (i == word.length() - 2) {
					if (word.charAt(i) == 'a') {
						if (word.charAt(i + 1) == 'b') {
							counter++;
							i += 1;
						} else if (word.charAt(i + 1) == 'c') {
							counter++;
							i += 1;
						} else {
							counter += 2;
						}
					} else if (word.charAt(i) == 'b') {
						if (word.charAt(i + 1) == 'c') {
							counter++;
							i += 1;
						} else
							counter += 2;
					} else {
						if (word.charAt(i - 1) == 'b' && word.charAt(i - 2) == 'a')
							continue;
						else if (word.charAt(i - 1) == 'b')
							counter++;
						else
							counter += 2;
					}

				} else {
					if (word.charAt(i) == 'a') {
						if (word.charAt(i + 1) == 'b' && word.charAt(i + 2) == 'c')
							i += 2;
						else if (word.charAt(i + 1) == 'b') {
							counter++;
							i += 1;
						} else if (word.charAt(i + 1) == 'c') {
							counter++;
							i += 1;
						} else
							counter += 2;
					} else if (word.charAt(i) == 'b') {
						if (word.charAt(i - 1) == 'a' && word.charAt(i + 1) == 'c')
							i += 2;
						else if (word.charAt(i - 1) == 'a')
							counter++;
						else if (word.charAt(i + 1) == 'c') {
							counter++;
							i += 1;
						} else {
							counter += 2;
						}
					} else {
						if (word.charAt(i - 1) == 'b' && word.charAt(i - 2) == 'a')
							continue;
						else if (word.charAt(i - 1) == 'b')
							counter++;
						else
							counter += 2;
					}
				}
			}
			return counter;
		}
		return 0;
	}

	@Test
	public void test1() {
		String word = "a";
		int output = 2;
		Assert.assertEquals(output, addMinimum(word));
	}

	@Test
	public void test2() {
		String word = "abc";
		int output = 0;
		Assert.assertEquals(output, addMinimum(word));
	}

	@Test
	public void test3() {
		String word = "ab";
		int output = 1;
		Assert.assertEquals(output, addMinimum(word));
	}

	@Test
	public void test4() {
		String word = "aca";
		int output = 3;
		Assert.assertEquals(output, addMinimum(word));
	}
	
	/*
	 * 
	 * 	TestData Enumeration:
	 * 		cb -> 4
			cba -> 6
			cca -> 6
			cbc -> 3
			aaaabb -> 9
			Program logic understanding is wrong hence deriving pesudo code for the above test data
			
		PseudoCode:
			8.43
			check if length of word == 1 then return 2
					if no check if length of word == 2 then do the following
					check if charAt(0) = 'a' 
					if yes
						then check if charAt(i+1) = 'b' or 'c'
						if yes then return 1
					if no
						then check if charAt(i) = 'b'
					if yes 
						then check charAt(i+1)= 'c'
						if yes then return 1
						if no return 4
					if no
						then return 4
			else
				initialize counter = 0;
				using for iterate over the input word until length()
				when i=0
					check if chartAt(i) = 'a'
		if yes
			then check if charAt(i+1) = 'b' && charAt(i+2) =='c'
			if yes update i=3
			if no check if charAt(i+1) = 'b'
				if yes then increment counter, update i=2
				if no then increment counter, update i=2
		if no
			then check if charAt(i) = 'b'
				if yes then check if charAt(i+1) = 'c'
					if yes then increment counter and update i=2
					if no then update counter = 2
				if no increment counter = 2
	else if(i=word.length()-1)
		check if word.charAt(i)== 'a'
		if yes then counter +=2;
		if no then check if charAt(i) = 'b'
			if yes then check if charAt(i-1) = 'a'
				if yes then counter +=1;
				if no then counter+=2;
		if no then check if charAt(i-1) = 'b' && charAt(i-2) = 'a'
				if yes then continue
				if no then check if charAt(i-1) = 'b' 
					if yes then increment counter;
					if no then increment counter +=2;
		
	else
		checkif charAt(i) = 'a'
		if yes then check if charAt(i+1) = 'b' && charAt(i+2) =='c'
				if yes update i=i+3
				if no check if charAt(i+1) = 'b'
					if yes increment counter & i+=2
					if no then increment counter +=2; 
		if no then check if charAt(i) = 'b'
				if yes then check if charAt(i-1) = 'a' & charat(i+1) = 'c'
					if yes i=i+2
				if no check if charAt(i-1) = 'a'
					if yes then icrement counter
					if no check if char(i+1) = 'c'
						if yes then increment counter & update i+=2
						if no then increment coutner +=2 
				if no then
					then check if charAt(i-1) = 'b' && charAt(i-2) = 'a'
						if yes then continue
						if no then check if charAt(i-1) = 'b'
							if yes then increment counter 
							if no then increment counter +=2
	 * 
	 */

}
