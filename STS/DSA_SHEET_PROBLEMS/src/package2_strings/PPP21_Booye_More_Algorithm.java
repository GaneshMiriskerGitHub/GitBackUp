package package2_strings;

import java.util.HashMap;

public class PPP21_Booye_More_Algorithm {
	
	

	private static void shiftTable(String pattern, HashMap<Character, Integer> mapP) {
		int m = pattern.length();
		mapP = new HashMap<>();

		for (int i = 0; i < m; i++) {
			char ch = pattern.charAt(i);
			int maxShift = Math.max(1, m - i - 1);
			mapP.put(ch, maxShift);
		}
	}

	private static int search(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		
		HashMap<Character, Integer> mapP = new HashMap<>();;
		shiftTable(pattern, mapP);

		int numOfSkips;
		for (int i = 0; i <= n - m; i++) {
			numOfSkips = 0;
			for (int j = m - 1; j >= 0; j--) {
				if (pattern.charAt(j) != text.charAt(i + j)) {
					if (mapP.containsKey(text.charAt(i + j))) {
						numOfSkips = mapP.get(text.charAt(i + j));
						break;
					} else {
						numOfSkips = n;
						break;
					}
				}
			}
			if (numOfSkips == 0) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		String pattern = "example";
		String text = "This is an example text.";

		int index = search(text, pattern);
		if (index != -1) {
			System.out.println("Pattern found at index: " + index);
		} else {
			System.out.println("Pattern not found.");
		}
	}

}
