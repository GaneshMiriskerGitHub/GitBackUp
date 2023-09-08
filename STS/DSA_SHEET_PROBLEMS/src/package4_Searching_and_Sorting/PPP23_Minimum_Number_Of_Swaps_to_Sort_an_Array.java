package package4_Searching_and_Sorting;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PPP23_Minimum_Number_Of_Swaps_to_Sort_an_Array {

	public static void printMinSwaps(int[] arr) {
		Map<String, String> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
		}
		
		// sort the map based on keyValues
		Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
		
		map.entrySet().stream()
				.sorted(Comparator.comparing(Map.Entry::getKey))
				.forEach(entry -> sortedMap.put(entry.getKey(), entry.getValue()));
		
		
				
				
		
	}

	public static void main(String[] args) {
		
		int[] arr = {1, 5, 4, 3, 2};
		
		printMinSwaps(arr);

	}

}
