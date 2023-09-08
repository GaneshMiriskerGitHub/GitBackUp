package package4_Searching_and_Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P7_Majority_Element_Exists_or_not {

	// brute force
	public static void findMajority(int[] arr) {  // O(n*n)
		
		int count = 0 ;
		int max_count = 0;
		int max_freq_element = -1;
		for(int i=0;i<arr.length;i++) {
			int currElement = arr[i];
			
			for(int j=0;j<arr.length;j++) {
				if(currElement == arr[j]) count++;
			}
			
			if(count > max_count) {
				max_count = count;
				max_freq_element = currElement;
			}
			count = 0;
		}
		
		if(max_count >= arr.length/2) {
			System.out.println("Element with maximum count is : "+max_freq_element);
			System.out.println("Frequency of the element is : "+max_count);
		}else {
			System.out.println("Majority Element does not exists");
		}
	}
	
	// Optimised little bit
	public static void findMajorityOptimised(int[] arr) {
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int ele: arr) map.put(ele, map.getOrDefault(ele, 0)+1);
		
		List<Map.Entry<Integer, Integer>> list = new ArrayList(map.entrySet());
		
		Collections.sort(list, Map.Entry.comparingByValue(Comparator.reverseOrder()));
		
		if(list.get(0).getValue() >= arr.length/2) {
			System.out.println(list.get(0));
		}else {
			System.out.println("Element does not exists");
		}
	}

	public static void findMajorityOptimisedMore(int [] arr) {  // O(n logn)
		
		Arrays.sort(arr);
		
		int currCount = 0;
		int currElement = arr[0];
		int max_count = currCount;
		int max_count_element = -1;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == currElement) {
				currCount++;
			}else {
				if(currCount > max_count) {
					max_count  = currCount;
					max_count_element = currElement;
				}
				currElement = arr[i];
				currCount = 0;
			}
		}
		
		System.out.println(max_count);
		System.out.println(max_count_element);
		
	}
	
	public static void main(String[] args) {

		int arr[] = { 1, 1, 2, 7, 3, 5, 1 };
		int n = arr.length;

		// Function calling
//		findMajority(arr);
		
//		findMajorityOptimised(arr);
		
		findMajorityOptimisedMore(arr);

	}

}
