package foundation.week2.HomeWork;

import java.util.TreeSet;

import org.junit.Test;

public class SecondLargestDigitInString {
	
	public static int secondHighest(String s) {
        String s1 = s.replaceAll("[a-z]","");
        TreeSet<Integer> uniqueDigits = new TreeSet<Integer>();
        if(s1.length()<=1)
            return -1;
        else {
        for(int i=0;i<s1.length();i++){
            uniqueDigits.add(((int) s1.charAt(i))-((int)'0'));
        }
        int size=1;
        for(int s2:uniqueDigits){
            if(size==2)
            return s2;
            size++;
        }
        }
        return -1;
    }
	
	@Test
	public void test1() {
		System.out.println(secondHighest("dfa12321afd"));
	}
	
	@Test
	public void test2() {
		System.out.println(secondHighest("abc1111"));
	}

}
