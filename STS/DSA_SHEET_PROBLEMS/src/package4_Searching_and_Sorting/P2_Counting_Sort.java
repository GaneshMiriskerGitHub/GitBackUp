package package4_Searching_and_Sorting;

import java.util.Arrays;

public class P2_Counting_Sort {
	
	public static void countingSort(int[] arr) {
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			max = Math.max(max, arr[i]);
		}
		
		System.out.println("maximum element is :"+max);
		
		int[] count = new int[max+1];
		
		System.out.println(Arrays.toString(count));
		for(int i=0;i<arr.length;i++) {
			count[arr[i]]++;
		}
		System.out.println(Arrays.toString(count));
		
		int j=0;
		for(int i=0;i<count.length;i++) {
			while(count[i] >  0) {
				arr[j] = i;
				j++;
				count[i]--;
			}
		}
		
		System.out.println(Arrays.toString(arr));
		
	}
	

	public static void main(String[] args) {
		
		int[] arr = {5,4,1,3,2};
		
		countingSort(arr);
		
	}

}
