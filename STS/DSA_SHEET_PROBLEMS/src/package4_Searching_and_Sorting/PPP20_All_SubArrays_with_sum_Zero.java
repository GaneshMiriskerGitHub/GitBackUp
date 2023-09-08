package package4_Searching_and_Sorting;

import java.util.Arrays;

public class PPP20_All_SubArrays_with_sum_Zero {
	
	public static void printAllSubArraysWithZeroSum(int[] arr) {
		
		int[] prefix = new int[arr.length];
		prefix[0] = arr[0];
		for(int i=1;i<arr.length;i++) {
			prefix[i] = prefix[i-1]+arr[i];
		}
		
		
	}

	public static void main(String[] args) {
		
		int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
		
		printAllSubArraysWithZeroSum(arr);

	

}
