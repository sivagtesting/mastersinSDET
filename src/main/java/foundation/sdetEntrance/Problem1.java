package foundation.sdetEntrance;

public class Problem1 {

	public static void main(String[] args) {

		System.out.println("There are " + findWordCount() + " words in the given sentence");
	}

	public static int findWordCount() {
		String sentence = "The quick brown fox jumps over the lazy dog.";
		String[] split = sentence.split(" ");
		return split.length;
	}

}
