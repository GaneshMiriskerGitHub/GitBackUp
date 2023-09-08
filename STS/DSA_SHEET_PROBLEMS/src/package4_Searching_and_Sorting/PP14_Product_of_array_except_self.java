package package4_Searching_and_Sorting;

import java.util.Arrays;

public class PP14_Product_of_array_except_self { // bokka le idi easy ey , i coded it by myself
	
	public static void productArray(int[] arr) {
		
		int[] prefixProd = new int[arr.length];  // left prod array
		prefixProd[0] = arr[0];
		for(int i=1;i<arr.length;i++ ) {
			prefixProd[i] = prefixProd[i-1]*arr[i]; 
		}
		
		int[] suffixProd = new int[arr.length];  // right prod array
		suffixProd[arr.length-1] = arr[arr.length-1];
		for(int i=arr.length-2;i>=0;i--) {
			suffixProd[i] = suffixProd[i+1]*arr[i];
		}
		
		int[] prod = new int[arr.length];
		prod[0] = suffixProd[1];
		prod[arr.length-1] = prefixProd[arr.length-2];
		for(int i=1;i<=arr.length-2;i++) {
			prod[i] = suffixProd[i+1] * prefixProd[i-1];
		}
		
		System.out.println(Arrays.toString(prod));
		
	}
	

	public static void main(String[] args) {
		
		int[] arr  = {10, 3, 5, 6, 2};
		
		productArray(arr);

	}

}
