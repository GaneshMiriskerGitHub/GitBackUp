package package4_Searching_and_Sorting;

import java.util.Collections;

public class PPP22_Minimum_Pages_Alocation { // learning:-  https://www.youtube.com/watch?v=BSihvQCh9-I
						                     // coding  :-  https://www.geeksforgeeks.org/allocate-minimum-number-pages/

	public static int maxOf(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(arr[i], max);
		}
		return max;
	}
	public static int sumOf(int[] arr) {
		int sum = 0; 
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
		return sum;
	}
	
	public static boolean isFeasible(int[] arr, int k, int res) {
		int students = 1;
		int currSum = 0;
		for(int i=0;i<arr.length;i++) {
			currSum+=arr[i];
			if(currSum > res) {
				students++;
				currSum = arr[i];
			}
		}
		return students <= k;
	}

	public static void printMinimumNumberOfAllocations(int[] arr, int k) {

		int min = maxOf(arr);
		int max = sumOf(arr);
		
		int res = 0;
		while(min <= max) {
			int mid = (min+max)/2;
			
			if(isFeasible(arr, k, mid)) {
				res = mid;
				max = mid-1;
			}else {
				min = mid+1;
			}
		}

		System.out.println(res);
	}

	public static void main(String[] args) {

		int N = 4;
		int[] A = { 12, 34, 67, 90 };
		int M = 2;

		printMinimumNumberOfAllocations(A, M);

	}

}
