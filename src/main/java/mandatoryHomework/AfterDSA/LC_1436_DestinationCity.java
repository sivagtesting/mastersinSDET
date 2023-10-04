package mandatoryHomework.AfterDSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LC_1436_DestinationCity {

	/*
	 * https://leetcode.com/problems/destination-city/description/
	 * 
	 	PseudoCode:
			Initialize a hashmap String, String
			add each list of strings as key and value to the map
			iterate over the map and check if each value is a key in the map
			if key not found return the value

	 * 
	 */
	
	//Time Complexity: O(N)
	//Space Complexity: O(N)
	public String destCity(List<List<String>> paths) {
		Map<String, String> pathMap = new HashMap<String, String>();
		for (List<String> lst : paths)
			pathMap.put(lst.get(0), lst.get(1));
		for (String s : pathMap.values()) {
			if (!pathMap.containsKey(s))
				return s;
		}
		return "";
	}
	
	@Test
	public void test1() {
		List<List<String>> paths = new ArrayList<>();
		paths.add(Arrays.asList("London","New York"));
		paths.add(Arrays.asList("New York","Lima"));
		paths.add(Arrays.asList("Lima","Sao Paulo"));
		String destination = "Sao Paulo";
		Assert.assertEquals(destCity(paths), destination);
	}
	
	@Test
	public void test2() {
		List<List<String>> paths = new ArrayList<>();
		paths.add(Arrays.asList("B","C"));
		paths.add(Arrays.asList("D","B"));
		paths.add(Arrays.asList("C","A"));
		String destination = "A";
		Assert.assertEquals(destCity(paths), destination);
	}
}
