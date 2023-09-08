package package4_Searching_and_Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class P1_Permute_Two_Arrays {

	public static boolean isPossible(long a[], long b[], int n, long k) {
		// Sorting a[] in ascending order
		Arrays.sort(a);

		Arrays.sort(b);
		reverseArray(b);

		for (int i = 0; i < n; i++) {
			if (a[i] + b[i] < k) {
				return false;
			}
		}

		return true;

	}

	private static void reverseArray(long[] arr) {
		int start = 0;
		int end = arr.length - 1;

		while (start < end) {
			long temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
