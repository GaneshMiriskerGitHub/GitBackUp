package package4_Searching_and_Sorting;

import java.util.Arrays;

public class P8_Count_Tripplets_With_Smaller_Sum {
	
	public static void countTriplets(int[] arr, int sum ) {
		
		Arrays.sort(arr);
		
		for(int i=0;i<arr.length-2;i++) {
			
			int j=i+1;
			int k = arr.length-1;
			
			while(j<k) {
				if(arr[j]+arr[k] <= sum-arr[i]) {
					System.out.println(arr[i]+", "+arr[j]+", "+arr[k]);
					k--;
				}else if(arr[j]+arr[k] > sum-arr[i]) {
					k--;
				}else {
					k--;
				}
			
		}
	}

	public static void main(String[] args) {
		
		int[] arr = {5, 1, 3, 4, 7};
		
		int sum = 12;
        countTriplets(arr, sum);

	}

}
