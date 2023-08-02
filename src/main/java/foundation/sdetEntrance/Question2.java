package foundation.sdetEntrance;

public class Question2 {

	public static void main(String[] args) {
		int[] arrNum = { 10, 20, 30, 40, 50, 60 };
		System.out.println("Average of all the array elements is: " + averageOfArrayElements(arrNum));
	}

	public static int averageOfArrayElements(int[] inpArray) {
		int sum = 0;
		for (int i : inpArray) {
			sum = sum + i;
		}
		return sum / inpArray.length;
	}
}
