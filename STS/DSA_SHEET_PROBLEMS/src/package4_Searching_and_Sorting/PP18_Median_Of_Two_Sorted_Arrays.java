package package4_Searching_and_Sorting;

import java.util.Arrays;

public class PP18_Median_Of_Two_Sorted_Arrays {

	public static void main(String[] args) {
		
		int[] a = {-5, 3, 6, 12, 15};
		int[] b = {-12, -10, -6, -3, 4, 10};
		
		int[] arr = new int[a.length+b.length];
		
		System.arraycopy(a, 0, arr, 0, a.length);
		System.arraycopy(b, 0, arr, a.length, b.length);
		
		Arrays.sort(arr);
		int n = arr.length;
		int median = 0;
		if(n%2 == 0) {
			int m = n/2;
			int leftElement = arr[m];
			int rightElement = arr[m+1];
			
			median = (leftElement + rightElement ) / 2;
		}else {
			int m = n/2;
			median = arr[m];
		}
		
		System.out.println(median);

	}

}
