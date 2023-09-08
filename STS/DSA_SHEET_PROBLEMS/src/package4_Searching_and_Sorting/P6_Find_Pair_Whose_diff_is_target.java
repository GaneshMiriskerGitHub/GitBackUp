package package4_Searching_and_Sorting;

import java.util.Arrays;

public class P6_Find_Pair_Whose_diff_is_target { // same two pinter technique, i know this already ,
	    // you can refer to https://www.youtube.com/watch?v=XGrXiVi7Ces
	
	public static void printIndexes(int[] arr, int target) {
		
		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));
		
		int i=0;
		int j=1;
		
		while(i<arr.length && j<arr.length) {
			if(arr[j]-arr[i] == target) {
				System.out.println(arr[i]+" , "+arr[j]);
				return;
			}
			if(arr[j]-arr[i] < target) {
				j++;
			}else {
				i++;
			}
		}
		
		
		
	}

	public static void main(String[] args) {
		
		int arr[] = {5, 20, 3, 2, 50, 80}; 
		int n = 15;
		
		printIndexes(arr, n);

	}

}
