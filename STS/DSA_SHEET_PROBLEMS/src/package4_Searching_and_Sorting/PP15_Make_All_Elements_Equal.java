package package4_Searching_and_Sorting;

import java.util.Arrays;

public class PP15_Make_All_Elements_Equal { // https://www.youtube.com/watch?v=Wo168YDPwzk
	
	public static void printNumberOfOperations(int[] arr) {
		
		Arrays.sort(arr);
		
		int s=0;
		int e=arr.length-1;
		
		int noOfOperations = 0;
		
		while(s<=e) {
			noOfOperations = noOfOperations + (arr[e]-arr[s]);
			e--;
			s++;
		}
		
		System.out.println(noOfOperations);
	}

	public static void main(String[] args) {
		
		int[] arr = {4, 6};
		
		printNumberOfOperations(arr);

	}

}
